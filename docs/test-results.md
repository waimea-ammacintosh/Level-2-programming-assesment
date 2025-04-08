# Results of Testing

The test results show the actual outcome of the testing, following the [Test Plan](test-plan.md)

---

## Coin input

Test to check if the user can input a valid amount of coins to play with, within the set boundaries (5-15). Test if other invalid data is not allowed by program.

### Test Data Used: 4,5,15,16,(blank), thh

Using these values will allow me to check if my boundaries (5 and 15) still work, and it will allow me to see if how the program will handle a number out of range, and how it will handle blanks/non-integers

### Test Result

![Coin input test](captures/CoinNum.gif)

The program worked as expected. When I entered the in bound numbers, it allowed it to pass, and it did not allow out of bound or non-integer inputs. 
This is what I expected to happen and my program easily handled the invalid errors

---

## Grid set-up

THis is a test to make sure that the grid is initially set up with the correct num of coins

### Test Data Used

I will run the program multiple times, making sure the grid displays the right amount of coins as the user inputs,
and I will use different numbers of coins each time.

### Test Result

![Grid setup](captures/GridSetup.gif)

every time the grid was set up, it was able to handle the right amount of coins, and add them randomly to the grid. This is what I expected to happen.

---

## Game end

This is a test to make sure that the game ends and displays the right winner

### Test Data Used

i will run the game multiple times to make sure displays the correct winner every time

### Test Result

![example.png](screenshots/example.png)

Comment on test result. Comment on test result. Comment on test result. Comment on test result. Comment on test result. Comment on test result.

---

## Turn Change

This is to test if the current player is changing between 1 and 2.

### Test Data To Use

i will take a few turns to check if it always tells me who's turn it is


### Test Result

![Turn Change](captures/TurnChange.gif)

every single time, after each player finished their turn, it consistently changes the player to the other player. This is what I expected to happen.

---

## Player moves

This is a test to make sure that when a player moves or takes a coin, it moves the coin the right amount or takes the right coin

### Test Data To Use

I will do three different moves, and take three different coins to make sure it works every time.
I will also try to input some invalid moves, like (blank), 5, and b. I will also try to take a coin when you can not and move a coin that isnt there.

### Test Result

![example.png](screenshots/example.png)

Comment on test result. Comment on test result. Comment on test result. Comment on test result. Comment on test result. Comment on test result.

---

## Take a coin

This is to test if taking a coin works in all allowed situations

### Test Data To Use

I will take a coin when there is a silver coin there, a gold coin there, and will try to take one when there is no coin there.

### Test Result

![TakeCoin](captures/TakeCoin.gif)

When I took a silver coin, the silver coin disappeared, and was replaced by an empty space, so the coin was taken. 
When I took the gold coin, the gold coin disappeared, and was replaced by an empty space, so the coin was taken.
When I tried to take a coin that wasn't there, it told me I could not take this coin.
All these results line up with what I expected to happen, and my program easily handled the unexpected, invalid inputs.

---