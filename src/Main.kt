/**
 * =====================================================================
 * Programming Project for NCEA Level 2, Standard 91896
 * ---------------------------------------------------------------------
 * Project Name:   OLD GOLD
 * Project Author: Aaron Macintosh
 * GitHub Repo:    https://github.com/waimea-ammacintosh/Level-2-programming-assesment
 * ---------------------------------------------------------------------
 * Notes:
 * This is a two-player game, played on a one-dimensional grid with coins,
 * where the aim is to win by being the player who removes the gold coin.
 * =====================================================================
 */



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
    println("1. You can move one coin LEFT as many squares as you want, as long as it does not pass through or land on another coin.")
    println("2. Take a the coin on the end (Leftmost) square. You can only do this move if there is a coin in the last square.")

    println("Now, we shall commence!")


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