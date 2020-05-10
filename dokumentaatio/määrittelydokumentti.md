# Specifications

## The purpose of this program
In this program the user can play the classic video game Tetris. Before the game begins the player has the option to change the background image and the music that is playing (or mute it).

## Features
* [x] The menu screen
* [x] The game screen
* [x] Music
* [x] Backgrounds

## The user interface
The program consists of two views:
* the menu screen
* the game screen.

![model](https://github.com/H4m5t3r/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/interface.png)

### The menu screen
The menu screen features a list of the backgrounds available and a list of the audio files that can be set to play during the game. All the options appear as buttons that can be pressed.

The player can begin the game by pressing the "New game" button.

### The game screen
When the game begins the game window will appear with the chosen background. On the right of the game area there will be a score counter. The player moves the falling polygons with the arrow keys. More information can be found in the [user manual](https://github.com/H4m5t3r/ot-harjoitustyo/blob/master/dokumentaatio/User%20manual.md#the-game).

## Game logic (Tetris explained)
When the game is started polygons made from squares start falling down from the top of the screen and the player has to move the blocks around while they are still "in the air" and try to complete rows. When a whole row is filled with blocks they disappear and free up space for more. If the game field is filled up with blocks to the point that part of a polygon is above the allowed game area the game ends.

## The backgrounds
The backgrounds will be simple single-colored images. The main focus here is to have different options to choose from and potential for expansion. The available background color options are
* white
* blue
* green
* red

## Music
The different music options will all be variations of the Russian folk song that the game is associated with. The available options are
* clarinet version
* piano version
* trumpet version

## Potential expansions
* Saving high scores
* Adding more music and backgrounds
