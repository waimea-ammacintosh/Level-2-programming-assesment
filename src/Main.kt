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

val NUMBOXES = (15..25).random()
val EMPTY = "---"
val SILVER = "Silver".grey()
val GOLD = "Gold".yellow()

fun main() {
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
    val player1 = getName("Player One, What is your name?")
    println()
    println("Welcome to OLD GOLD $player1")
    println()
    val player2 = getName("Player Two, What is your name?")
    println()
    println("Welcome to OLD GOLD $player2")
    println()
    val numCoins = getCoins("There are $NUMBOXES boxes. How many Coins do you want to play with (5-15)?")

    val box = setupGrid()
    showGrid(box)


}

fun getName(prompt: String): String {
    var userInput: String

    while (true) {
        print(prompt)

        userInput = readln()
        if (userInput.isNotBlank()) break

    }
    return userInput
}

fun showGrid(grid: List<String>) {
    val divider = "+--------".repeat(grid.size) + "+"

    println()
    println("OLD GOLD")
    println(divider)
    for ((i, box) in grid.withIndex()) {
        print("|" + " ${box.padEnd(6)} ")
    }

    println("|")

    println(divider)
}

fun setupGrid(): MutableList<String> {
    val grid = mutableListOf<String>()
    for (i in 1..NUMBOXES) grid.add(EMPTY)
    for (num in 1..numCoins) {
        grid.add(SILVER)
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
        }
    }
    return intValue!!
}

