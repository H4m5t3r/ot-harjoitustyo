# Description of the program's architecture

The program consists of two packages (three if you count the package where the main class is located, but it does not do anything else than launching the UI): tetris.ui and tetris.domain. tetris.ui contains the graphical user interface that creates classes from the tetris.domain package when it is launched.

#### Package diagram
![package diagram](https://github.com/H4m5t3r/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/Package%20diagram.png)

The UI creates 3 classes: Controller, MusicPlayer and Logic.

## Controller
The controller class takes input from the user during the game and calls methods from the logic class.

## MusicPlayer
The music class is used by the UI to start playing audio files located in the project folder. The class contains two methods: playMusic() and stopPlaying(). playMusic() takes the name of the file as input, which is passed from the UI.

## Logic
The Logic contains methods that are related to running the game. It uses two classes:
* Tetramino (called "current") 
* Stage (called "stage")

One should note that the Stage class is not the same as the JavaFX class Stage.

The Logic class' methods:
* run() (makes the game progress)
* moveLeft() (moves the current tetramino to the left)
* moveRight() (moves the current tetramino to the right)
* moveDown() (moves the current tetramino down)
* createRandomTetramino()
* createRandomEnum()
* rotate()
* getGridFromStage() (used for passing the current situation to the UI where it is visualized)

The Logic class' most important part is the run() method. This is the method that the TimerTask in the UI calls and makes the game progress. When it is run it first checks if it should create a new tetramino. When a new tetramino is created the run() method checks if it already collides with the stage. If it does it means that the game has ended and the method setGameEnd() is called. It places an "e" character in the bottom left corner of the grid (inside the wall) and when updateGameScreen() is called in TetrisUI it notices this and displays the text "GAME OVER". While the game is not over it continues normally. If the dropCounter (used for determining whether it is time for the tetramino to fall down) is 0 the method checks if the tetramino can be moved down using stage.collidesWith(current). If not, then stage.placeTetramino() is called (merges the tetramino with the grid) and stage.removeRowsCheck() checks if any rows are full.

```
public void run() {
    if (current == null) {
        current = createRandomTetramino();
        if (stage.collidesWith(current)) {
            stage.setGameEnd();
        }
    }
    if (dropCounter == 0) {
        current.y++;
        if (stage.collidesWith(current)) {
            current.y--;
            stage.placeTetramino(current);
            stage.removeRowsCheck();
            current = null;
        }
        dropCounter += dropCounterIncrement;
    } else {
        dropCounter--;
    }
}
```

#### Sequence diagram for createRandomTetramino()
![Sequence diagram for createRandomTetramino()](https://github.com/H4m5t3r/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/createRandomTetramino.png)

#### Sequence diagram for collidesWith(current)
Here the program runs a collision check. In this case the tetramino does not collide with the stage and a false value is returned.

![Sequence diagram for collidesWith(current)](https://github.com/H4m5t3r/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/collidesWith(current).png)

#### Sequence diagram for placeTetramino(current)
The stage gets a two-dimensional collision check array from the current tetramino and puts "#" characters in the block grid in the corresponding coordinates when it notices a "#" character in the collision check array.

![Sequence diagram for placeTetramino(current)](https://github.com/H4m5t3r/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/placeTetramino(current).png)

#### Sequence diagram for removeRowsCheck()
In this case the mremoveRowsCheck() method notices that one row should be removed and removeRow(y) is called for that y coordinate.

![Sequence diagram for removeRowsCheck()](https://github.com/H4m5t3r/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/removeRowsCheck().png)

#### Sequence diagram for the run() method in TetrisUI
**NOTE: The whole sequence diagram is what the run() method in TetrisUI does. The run() method that is called in the sequence diagram is the logic class' run() method being called. Here the calls in the logic class' run() have been left out because they were already visualized and can be found in the piece of code prior to the pictures. This sequence diagram focuses on what the UI class does.**

![Sequence diagram for UIrun()()](https://github.com/H4m5t3r/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/UIrun().png)


### Tetramino
A Tetramino is a class used to describe the falling polygons. It contains a Shape (an Enum) that describes what shape it has, an integer called rotation and its x and y coordinate. There are 7 different shapes. The class has 3 public methods:

* getCollisionCheck()
* rotateCollisionCheck()
* rotate()

getCollisionCheck() uses the Shape class' method getDefaultCollisionCheck() (explained further down) to get the tetramino's default position and then rotates the character grid according to the rotation integer. This integer describes how many times it should be rotated from the default position. When the player presses the UP arrow key the Controller class calls the current teramino's rotate() method. The integer starts with 0 as its default value and when rotate() is called it increases the number by 1. If rotation is 3 the value is returned to 0 since the tetramino has 4 different rotations.

#### Shape
The Shape class has one method: getDefaultCollisionCheck(). It returns a 4 * 4 character grid that corresponds to the shape.

### Stage
The stage contains a two dimensional 20 * 28 character grid called blockGrid where "#" means that there is an object blocking the way (either a wall or a tetramino that has been merged with the grid) and " " means that a space is not occupied. The actual play area is the 12 * 24 area located in the upper center part of the grid. When the class is initialized it creates walls around the play area that prevent the falling tetraminos from moving outside of it. This is done by using the boolean method collidesWith(). Whenever a tetramino is moved the stage checks if the way is blocked by using the tetramino's cooridinates. It gets a 4 * 4 character grid from the Shape class using getCollisionCheck(), which contains a correctly rotated tetramino. collidesWith() then checks if any of the tetramino's blocks collide with the stage.
