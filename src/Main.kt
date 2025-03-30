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
    val player1 = getName("Player One, What is your name? ")
    println()
    println("Welcome to OLD GOLD $player1")
    println()
    val player2 = getName("Player Two, What is your name? ")
    println()
    println("Welcome to OLD GOLD $player2")
    println()
    //gets amount of coins to play with
    val playerCoinNum = getCoins("There are $NUMBOXES boxes. How many Coins do you want to play with (5-15)?")
// sets up grid and displays it
    val box = setupGrid(playerCoinNum)


    while (containsGold) {
        showGrid(box)
        askForActions()



    }


}

/**
 * gets users name and checks if there is an actual value there
 */
fun getName(prompt: String): String {
    var userInput: String

    while (true) {
        print(prompt)
//checks for user input and if it is not blank. if so, it will break from the loop,
// but it will continue looping if the user inputs nothing.
        userInput = readln()
        if (userInput.isNotBlank()) break

    }
    return userInput
}

/**
 * shows the grid every turn
 */
fun showGrid(grid: List<String>) {
    val divider = "+---".repeat(grid.size) + "+"
// prints out the grid by repeating the divider and printing the values in it and prints end lines.
    println()
    println("OLD GOLD")
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
                availableIndex.removeAt(indexNum)
                break
            }
        }
    }
    // sets up the gold coin
    while (true) {
        val goldIndexNum = (0..<NUMBOXES-1).random()
        if (availableIndex.contains(goldIndexNum) && grid[goldIndexNum].contains(EMPTY)) {
            grid.add(goldIndexNum, GOLD)
            grid.removeAt(goldIndexNum - 1)
            break
        }
    }
    return grid
}

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

fun checkLastBox (grid: List<String>): Boolean {
    if (grid.first() == EMPTY) {
         takeCoin = true
    }
    else {
         takeCoin = false
    }
    return takeCoin
}

fun checkMovableCoins (grid: List<String>): MutableList<Int> {
    val availableCoins = mutableListOf<Int>()
    for (i in grid) {
        if (i.contains(SILVER) or i.contains(GOLD)) {
            availableCoins.add(i.indexOf(i) + 1)
        }
    }
    return availableCoins
}

fun checkGoldCoin(grid: List<String>) {
    if (grid.contains(GOLD))  {
         containsGold = true
    }
    else {
         containsGold = false
    }
}

fun askForActions (){
    checkMovableCoins()
    checkLastBox()
    println("Do you want to:")
    println("[M]ove a coin" + availabelCoins)
    if checkLastBox () {
        println("[T]ake the last Coin")
    }

}