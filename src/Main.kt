/**
 * =====================================================================
 * Programming Project for NCEA Level 2, Standard 91896
 * ---------------------------------------------------------------------
 * Project Name:   OLD GOLD
 * Project Author: Aaron Macintosh
 * GitHub Repo:    https://github.com/waimea-ammacintosh/Level-2-programming-assesment
 * ---------------------------------------------------------------------
 * Notes:
 * This is a two-player game, played on a one-dimensional grid with gold and silver coins,
 * where the aim is to win by being the player who removes the gold coin.
 * =====================================================================
 */
// constants for the entire game
val NUMBOXES = (15..25).random()
const val EMPTY = " "
val SILVER = "S".grey()
val GOLD = "G".yellow()
var containsGold = true
var takeCoin = false

fun main() {
    //intro and instructions
    println("Welcome to...")
    println(" _____ _    ______   _____ _____ _    ______ \n" +
            "|  _  | |   |  _  \\ |  __ \\  _  | |   |  _  \\\n" +
            "| | | | |   | | | | | |  \\/ | | | |   | | | |\n" +
            "| | | | |   | | | | | | __| | | | |   | | | |\n" +
            "\\ \\_/ / |___| |/ /  | |_\\ \\ \\_/ / |___| |/ / \n" +
            " \\___/\\_____/___/    \\____/\\___/\\_____/___/  ")

    println()
    println()
    println()
    println("Old Gold is a game played about moving coins on a one-dimensional grid.")
    println()
    println("How to play:")
    println("The aim of the game is to be the person that gets the gold coin.")
    println("When it is your turn, you can do one of two moves:")
    println("1. You can move one coin LEFT as many squares as you want,")
    println("   as long as it does not pass through or land on another coin.")
    println("2. Take a the coin on the end (Leftmost) square. ")
    println("   You can only do this move if there is a coin in the last square.")
    println()
    println("Now, we shall commence!")
    println()
    //gets players names
    val player1 = getString("Player One, What is your name? ")
    println()
    println("Welcome to OLD GOLD $player1")
    println()
    val player2 = getString("Player Two, What is your name? ")
    println()
    println("Welcome to OLD GOLD $player2")
    println()
    //gets amount of coins to play with
    val playerCoinNum = getCoins("There are $NUMBOXES boxes. How many Coins do you want to play with (5-15)?")
    // sets up grid and displays it
    val grid = setupGrid(playerCoinNum)
    var currentPlayer = 1
    //main loop
    while (containsGold) {
        //shows the grid and checks for if there is a coin to take in last box
        showGrid(grid)
        checkLastBox(grid)
        //displays the corrrect player
        if(currentPlayer == 1) {
            println("$player1, Your Turn")
        }
        else {
            println("$player2, Your Turn")
        }
        //loop for getting the players move, and proceeding with the action
        while (true) {
            println("Do you want to:")
            val move = getString("[M]ove a coin " + if (takeCoin) "[T]ake coin " else "")
            when (move) {
                "T" ->
                    //check if there is a coin to take, it will take it
                    if (takeCoin) {
                        grid.removeAt(0)
                        grid.add(0, EMPTY)
                        break
                    }
                    //else it will display an error message, loop back to ask the user what they actually want to do for their turn.
                    else {
                        println("There is no coin to take!")
                        continue
                    }
                "M" ->
                    //checks with the user what coin is to move
                    while (true) {
                        println("What box contains the coin you wish to move? (select from " + 1..grid.size.toString() +")")
                        val selectedCoin = readln().toIntOrNull()
                        //Checks if the coin is available to move. if so, it asks how much it wants to move, and checks if that is an available length of movement.
                        // If so it moves the coin the specified amount
                        if (selectedCoin != null && grid[selectedCoin-1] != EMPTY && grid[selectedCoin-2] == EMPTY) {
                            val movingCoin = grid[selectedCoin-1]
                            moveCoin(grid, selectedCoin-1, movingCoin)
                            break
                        //else prints an error message and asks them to choose a different coin
                        } else {
                            println("There is no movable coin in that box")
                            continue
                        }
                    }
                else -> continue
            }
            break
        }
        //checks if gold coin is still in play
        checkGoldCoin(grid)
        //changes players
        if (currentPlayer == 1) {
            currentPlayer = 2
        }
        else {
            currentPlayer = 1
        }

    }
    //if the player is P2, then player 1 took the gold coin and then the player was changed before the loop restarted, so it says that player 1 won,
    // else player 2 won, and it says player 2 won.
    if (currentPlayer == 2) {
        println()
        println("$player1, You win!!!")
    }
    else {
        println()
        println("$player2, You win!!!")
    }

}

/**
 * gets users name and checks if there is an actual value there
 * gets a String from the user
 * returns the String in all uppercase, or tells them to retry if they do not enter anything
 */
fun getString(prompt: String): String {
    var userInput: String

    while (true) {
        print(prompt)
//checks for user input and if it is not blank. if so, it will break from the loop,
// but it will continue looping if the user inputs nothing.
        userInput = readln().uppercase()
        if (userInput.isNotBlank()) break

    }
    return userInput
}

/**
 * shows the grid every turn
 * takes in the main list
 * outputs a formatted version of the list to make it visually nice to the user
 *
 */
fun showGrid(grid: List<String>) {
    val divider = "+---".repeat(grid.size) + "+"
// prints out the grid by repeating the numbers on top and the divider and printing the values in it and prints end lines.
    println()
    println("OLD GOLD")
    for (i in grid.indices) print("  ${i + 1}".padEnd(4))
    println()
    println(divider)
    for (box in grid) {
        print("| $box ")
    }

    println("|")

    println(divider)
}

/**
 * sets up the grid at the start of the game.
 * also adds the right amount of coins.
 * takes in an Int as the amount of coins the user inputs, and adds them randomly in the grid
 * returns the main list for the game
 */
fun setupGrid(numCoins: Int): MutableList<String> {
    val grid = mutableListOf<String>()
    for (i in 1..NUMBOXES) grid.add(EMPTY)

    val availableIndex = mutableListOf<Int>()
    for (num in 0..<NUMBOXES) {
        availableIndex.add(num)
    }
// sets up the silver coins to the desired level
    for (num in 1..<numCoins) {
        while (true) {
            val indexNum = (0..<NUMBOXES-1).random()
            if (availableIndex.contains(indexNum) && grid[indexNum].contains(EMPTY)) {

                grid.add(indexNum, SILVER)
                grid.removeAt(indexNum+1)
                availableIndex.remove(indexNum)
                break
            }
        }
    }
    // sets up the gold coin
    while (true) {
        val goldIndexNum = (0..<NUMBOXES-1).random()
        if (availableIndex.contains(goldIndexNum) && grid[goldIndexNum].contains(EMPTY)) {
            grid.add(goldIndexNum, GOLD)
            grid.removeAt(goldIndexNum+1)
            break
        }
    }
    return grid
}

/**
 * gets the num of coins from user.
 * takes a string input from the user and returns it as an Int,
 * or if it is not a number, returns it as Null and repeats until a number between 5-15 is inputted.
 * if the number inputted is not within the specified range, it will not allow the number, and ask for another number.
 */
fun getCoins(prompt: String): Int {
    var intValue: Int?
    while (true) {
        print(prompt)
        val userInput = readln()
        intValue = userInput.toIntOrNull()
        if (intValue != null) {
            if (intValue in 5..15) break
            else {
                println("That's not a valid number.")
            }
        }
        else {
            println("That's not a valid number.")
        }
    }
    return intValue!!
}

/**
 * checks if there is a coin in the last spot to take.
 * it takes in the main list and checks if there is a coin in the last box to take.
 * returns either true if there is a coin there, else it returns false.
 */
fun checkLastBox (grid: List<String>): Boolean {
    //checks if the first grid contains no coin
    if (grid.first() == EMPTY) {
         takeCoin = false
    }
    //if there is a coin
    else {
         takeCoin = true
    }
    //returns either true or false depending on if there is a coin or not
    return takeCoin
}

/**
 * checks the grid to check if the gold coin is in play.
 * takes the main grid and checks if the gold coin is in the list
 * changes the value of contains gold to either true or false depending on if it contains it or not
 */
fun checkGoldCoin(grid: List<String>) {
    //checks if the gold coin is in the grid
    if (grid.contains(GOLD))  {
         containsGold = true
    }
    //if it is not
    else {
         containsGold = false
    }
}

/**
 * this function takes care of moving the coin from its previous spot to its new spot.
 * it takes the main grid, the index of the moving coin and the actual coin on the grid.
 * changes the main list to be updated to the new list with the moved coin
 */
fun moveCoin(grid:MutableList<String>, movingCoinIndex: Int, coin: String) {
    //loop to prevent invalid inputs
    while (true) {
        println("how many spaces do you want to move?")
        //takes the users input and changes it into an int or returns null if not an int
        val moveSpaces = readln().toIntOrNull()
        //checks if the move is valid through the function below
        if (isMoveValid(grid, moveSpaces, movingCoinIndex)) {
            //removes coin and adds it in its new place
            grid.removeAt(movingCoinIndex)
            grid.add(movingCoinIndex-moveSpaces!!, coin)
            //breaks from the loop
            break
        }
    }


}

/**
 * this function checks if the move the user is trying to preform
 * (as in if the amount of spaces they are moving is valid)
 * takes in the main grid, the amount of spaces the coin is going to move, and the starting index of the moving coin
 * returns false if it fails only one of the tests or true if all the tests are passed
 */
fun isMoveValid (grid: List<String>, moveSpaces: Int?, movingCoinIndex: Int): Boolean {
    //check if the input entered is a positive number
    if (moveSpaces == null) {
        println("The value you entered isn't valid.")
        return false
    }
    val coinDestination = movingCoinIndex - moveSpaces
    //check if the number of spaces moving is not off the end of the board
    if (coinDestination < 0 ) {
        println("The value you entered moves the coin off the board.")
        return false
    }
    //check if the new space is empty
    if (grid[coinDestination] != EMPTY) {
        println("The value you entered moves the coin onto another coin.")
        return false
    }
    //check if the new space does not contain any coins between it and the original space
    val slicedList = grid.subList(coinDestination, movingCoinIndex)
    if (!grid.subList(coinDestination, movingCoinIndex).contains(EMPTY)) {
        println("There is a coin in the way of that move.")
        return false
    }
    return true
}