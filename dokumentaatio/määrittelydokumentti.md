# Specifications

## The purpose of this program
In this program the user can play the classic video game Tetris. Before the game begins the player has the option to change the background image and the music that is playing (or mute it).

**Progress**
* [x] The game screen
* [x] The menu screen
* [x] Music
* [ ] Backgrounds

Notes:

* The game and its menu is complete. The problem I have right now is to separate the user interface from the game logic. Currently the first block behaves correctly but after it gets to the bottom of the screen the polygons get stuck at the top of the screen and the console is flooded with error messages.
* The music class is still pretty messy. You can start the trumpet or piano melody but after you stop it starts to malfunction. I did not have enough time work on this since I spent most of my time trying to get the game to work properly outside the Tetris class.

## The user interface
The program consists of two views:
* the menu screen
* the game screen.

![model](https://github.com/H4m5t3r/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/interface.png)

### The menu screen
The menu screen features a list of the backgrounds available and a list of the soundtracks that can be set to play during the game. All the options appear as buttons that can be pressed.

The player can begin the game by pressing the "Start new game"-button.

### The game screen
When the game begins the game window will appear with the chosen background. On the right of the game area there will be a score counter and below it a button that makes the program return to the main menu. The player moves the falling polygons with the arrow keys.

## Game logic (Tetris explained)
When the game is started polygons made from squares start falling down from the top of the screen and the player has to move the blocks around while they are still "in the air" and try to for complete rows. When a whole row is filled with blocks they disappear and free up space for more. If the game field is filled up with blocks to the point that part of a polygon is above the allowed game area the game ends.

## The backgrounds
The backgrounds will be simple images with a Tetris theme. The main focus here is to have different options to choose from and potential for expansion. The planned background color options are
* blue
* green
* red

## Music
The different music options will all be variations of the Russian folk song that the game is associated with. The planned options are
* classic 8-bit music
* piano version
* trumpet version

## Potential expansions
* Saving high scores
* Adding more music and backgrounds