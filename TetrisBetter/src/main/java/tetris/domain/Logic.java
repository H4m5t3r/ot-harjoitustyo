
package tetris.domain;

import tetris.domain.Tetramino.Shape;
import static tetris.domain.Tetramino.Shape.I;
import static tetris.domain.Tetramino.Shape.J;
import static tetris.domain.Tetramino.Shape.L;
import static tetris.domain.Tetramino.Shape.O;
import static tetris.domain.Tetramino.Shape.S;
import static tetris.domain.Tetramino.Shape.T;
import static tetris.domain.Tetramino.Shape.Z;

/**
 * Contains the run() method that is used in TetrisUI to run the game and 
 * other methods that are important for the game to work correctly.
 */
public class Logic implements Runnable {
    
    private int dropCounter;
    private final int dropCounterIncrement = 5; //we drop the tetramino every "tick"
    private Tetramino current;
    private final Stage stage;
    
    public Logic() {
        stage = new Stage();
    }

    //REMOVE LINES USED FOR DEBUGGING IN THE FINAL VERSION
    @Override
    public void run() {
        if (current == null) {
            current = createRandomTetramino();
        }
//        System.out.println(this.current.getX() + ", " + this.current.getY());
        if (dropCounter == 0) {
            current.y++;
            if (stage.collidesWith(current)) {
                current.y--;
                stage.placeTetramino(current);
                stage.removeRowsCheck();
                current = null;
            }
//            stage.printPlayArea();
            dropCounter += dropCounterIncrement;
        } else {
            dropCounter--;
        }
        
    }
    
    //Methods used for moving the current tetramino.
    
/**
 * Moves the current tetramino one step to the left if it does not collide
 * with any blocks in the grid.
 * @see    stage.collidesWith(current)
 *
 */
    public void moveLeft() {
        current.x--;
        if (stage.collidesWith(current)) {
            current.x++;
        }
    }
/**
 * Moves the current tetramino one step to the right if it does not collide 
 * with any blocks in the grid.
 * @see    stage.collidesWith(current)
 */
    public void moveRight() {
        current.x++;
        if (stage.collidesWith(current)) {
            current.x--;
        }
    }
/**
 * Moves the current tetramino one step down if it does not collide with any 
 * blocks in the grid.
 * @see    stage.collidesWith(current)
 */
    public void moveDown() {
        current.y++;
        if (stage.collidesWith(current)) {
            current.y--;
        } else {
            dropCounter = dropCounterIncrement;
        }
    }

/**
 * Creates a new tetramino and gives it its starting coordinates.
 * @see    createRandomEnum()
 */
    //
    private Tetramino createRandomTetramino() {
        Shape randomShape = createRandomEnum();
        return new Tetramino(9, 0, randomShape);
    }

/**
 * Creates a random Enum which will determine what kind of shape a tetramino 
 * will have.
 */
    private Shape createRandomEnum() {
        int tetraminoShape = (int) (Math.random() * 100);
        if (tetraminoShape < 15) {
            return J;
        } else if (tetraminoShape < 30) {
            return L;
        } else if (tetraminoShape < 45) {
            return O;
        } else if (tetraminoShape < 60) {
            return S;
        } else if (tetraminoShape < 75) {
            return T;
        } else if (tetraminoShape < 90) {
            return Z;
        }
        return I;
    }
/**
 * Changes the tetramino's rotation status until the rotated version does not 
 * collide with any blocks in the grid.
 */
    void rotate() {
        current.rotate();
        while (stage.collidesWith(current)) {
            current.rotate();
        }
    }
    
/**
 * Used to pass the current state of the grid and the tetramino to TetrisUI.
 */
    public char[][] getGridFromStage() {
        if (current == null) {
            return this.stage.getBlockGrid();
        }
        //The stage's grid
        char[][] tempGrid = new char[28][20];
        char[][] stageGrid = this.stage.getBlockGrid();
        for (int i = 0; i < stageGrid.length; i++) {
            System.arraycopy(stageGrid[i], 0, tempGrid[i], 0, stageGrid[0].length);
        }
        //Adding the current tetramino to the grid since it is not merged yet
        char[][] tetr = current.getCollisionCheck();
        for (int i = 0; i < tetr.length; i++) {
            for (int j = 0; j < tetr[0].length; j++) {
                if (tetr[i][j] == '#') {
                    tempGrid[current.y + i][current.x + j] = tetr[i][j];
                }
            }
        }
        return tempGrid;
    }
    
    public Tetramino getCurrent() {
        return this.current;
    }
    
    public long getScoreFromStage() {
        return this.stage.getScore();
    }
    
    public void increaseStageScoreOnDown() {
        this.stage.increaseScore();
    }
}
