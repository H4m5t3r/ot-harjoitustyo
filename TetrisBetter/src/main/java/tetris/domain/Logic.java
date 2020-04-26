
package tetris.domain;

import tetris.domain.Tetramino.Shape;
import static tetris.domain.Tetramino.Shape.I;
import static tetris.domain.Tetramino.Shape.J;
import static tetris.domain.Tetramino.Shape.L;
import static tetris.domain.Tetramino.Shape.O;
import static tetris.domain.Tetramino.Shape.S;
import static tetris.domain.Tetramino.Shape.T;
import static tetris.domain.Tetramino.Shape.Z;


public class Logic implements Runnable {
    
    private int dropCounter;
    private int dropCounterIncrement = 5; //we drop the block every "tick"
    private Tetramino current;
    private Stage stage;
    
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
//                System.out.println("Collide");
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
    
    public void moveLeft() {
        current.x--;
        if (stage.collidesWith(current)) {
            current.x++;
        }
    }
    
    void moveRight() {
        current.x++;
        if (stage.collidesWith(current)) {
            current.x--;
        }
    }
    
    public void moveDown() {
        current.y++;
        if (stage.collidesWith(current)) {
            current.y--;
        } else {
            dropCounter = dropCounterIncrement;
        }
    }

    //Creates a new tetramino and gives it its starting coordinates
    private Tetramino createRandomTetramino() {
        Shape randomShape = createRandomEnum();
        return new Tetramino(9, 0, randomShape);
    }

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
    
    void rotate() {
        current.rotate();
        while (stage.collidesWith(current)) {
            current.rotate();
        }
    }
    
    
    public char[][] getGridFromStage() {
        if (current == null) {
            return this.stage.getBlockGrid();
        }
            char[][] tempGrid = new char[28][20];
            char[][] stageGrid = this.stage.getBlockGrid();
            for (int i = 0; i < stageGrid.length; i++) {
                for (int j = 0; j < stageGrid[0].length; j++) {
                    tempGrid[i][j] = stageGrid[i][j];
                }
            }
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
}
