# Plan for Testing the Program

The test plan lays out the actions and data I will use to test the functionality of my program.

Terminology:

- **VALID** data values are those that the program expects
- **BOUNDARY** data values are at the limits of the valid range
- **INVALID** data values are those that the program should reject

---

## Coin input

Test to check if the user can input a valid amount of coins to play with, within the set boundaries (5-15). Test if other invalid data is not allowed by program.

### Test Data To Use: 4,5,15,16,(blank), thh

Using these values will allow me to check if my boundaries (5 and 15) still work, and it will allow me to see if how the program will handle a number out of range, and how it will handle blanks/non-integers 

### Expected Test Result

When I input 5 and 15, my program should allow these values to pass fine. When I input 4,16,(blank), and thh, my program should ask me to input a number between 5 and 15.

---

## Grid set-up

This is to check if my grid will set up right every time i set up my game

### Test Data To Use

I will run the program multiple times, making sure the grid displays the right amount of coins as the user inputs,
and i will use different numbers of coins each time

### Expected Test Result

My program should consistently display the right amount of coins every time

---

## Turn Change

This is to test if the current player is changing between 1 and 2.

### Test Data To Use

i will take a few turns to check if it always tells me who's turn it is

### Expected Test Result

My program should always show swap between player 1 and 2 every time, with no exceptions

---

## Take a coin

This is to test if taking a coin works in all allowed situations

### Test Data To Use

I will take a coin when there is a silver coin there, a gold coin there, and will try to take one when there is no coin there.

### Expected Test Result

when the silver coin is taken, the coin should disappear, and the game should continue, when i take the gold coin, the game should end, and when i take no coin, it should tell me i cant take a coin

---

## Game end

THis is a test to make sure that the game ends and displays the right winner

### Test Data To Use

i will run the game multiple times to make sure it works every time

### Expected Test Result

when player 1 takes the gold coin, it should say player one wins and when player 2 takes the gold coin, it should say player2 wins.

---

## Player moves

THis is a test to make sure that when a player moves or takes a coin, it moves the coin teh right amount or takes the right coin

### Test Data To Use

i will do three different moves, and take three different coins to make sure it works every time. 
i will also try to input some invalid moves, like (blank), 5, and b. i will also try to take a coin when you can not and move a coin that isnt there.

### Expected Test Result

the coin should always move the specified amount, and when the coin is taken, the last coin only is taken. when i input the invalid inputs, 
it should try tell me to try do a valid move

---
