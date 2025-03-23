Project "Lab 6 (chance-it-multi-start)"
------------------------------------------------------------------------
This project simulates a Chance It game in Java, featuring various players with different strategies for rolling dice and competing against each other. The game uses a set of classes to model dice, players, and different gameplay rules.
Author: Amina Hajiyeva
------------------------------------------------------------------------

Classes Overview
  Die: Simulates a standard die, with a method to roll and get a random outcome.
  Dice: Manages multiple dice rolls and the total score.
  Player: The base class for players in the game.
  PlayerMinimumOpponent: A player who rolls until they get a minimum   score.
  PlayerMinimumSeven: A player who rolls until they reach a minimum score of 7.
  PlayerRollFourTimes: A player who rolls the dice exactly four times.
  PlayerRollThreeTimes: A player who rolls the dice exactly three times.
  PlayerRollUntilPrimeNumber: A player who rolls until they get a prime number as the result.
  ChanceItGame: The main class that manages the game, controlling the flow of turns and checking the winner.

Features
- Multiple types of players, each with unique strategies for rolling dice.
- A Die class that simulates a 6-sided die roll.
- A ChanceItGame class that organizes the gameplay and determines the winner based on each player’s strategy.
- Players roll the dice under different conditions, such as rolling until a minimum score is reached, rolling a specific number of     times, or rolling until a prime number appears.
