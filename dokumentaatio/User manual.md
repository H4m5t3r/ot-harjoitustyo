# User manual
Start with downloading the [latest version](https://github.com/H4m5t3r/ot-harjoitustyo/releases/tag/loppupalautus), the audio files that are used for playing music as well as the background images. Make sure the audio files and the background images are placed in the same directory as the jar file.

## Starting the program
Once you have downloaded the program you can run it with the following command:
```
java -jar Tetris-v1.0.jar
```

## The menu
When the program starts the menu screen will be displayed. The user will have the option to make the program play music and to stop it. The music can be started by clicking one of the music alternatives and stopped by clicking the button that says "Stop playing". If a new music tune is started when another is already playing, then the one that is already playing will be stopped before the new one is started.

The user also has the option to change the color of the background. This can be done by clicking one of the color alternatives.

A new game can be started by clicking on "New game". Once the game is started the music and background can no longer be changed.

![menu](https://github.com/H4m5t3r/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/menu.png)

## The game
When a new game is started the player can use the left and right arrow keys to move the current tetramino left and right. The player can make it go down faster by pressing the down arrow key and rotate it with the up arrow key. When the down key is pressed it will also increase the player's score by one. When a row is filled the score will increase by 100. More info about how the game works can be found in the [program specifications](https://github.com/H4m5t3r/ot-harjoitustyo/blob/master/dokumentaatio/m%C3%A4%C3%A4rittelydokumentti.md#game-logic-tetris-explained).

![game](https://github.com/H4m5t3r/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/game.png)