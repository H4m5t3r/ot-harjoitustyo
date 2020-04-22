/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.domain;

import java.util.Timer;
import java.util.TimerTask;
import tetris.domain.Tetramino.Shape;
import static tetris.domain.Tetramino.Shape.I;
import static tetris.domain.Tetramino.Shape.J;
import static tetris.domain.Tetramino.Shape.L;
import static tetris.domain.Tetramino.Shape.O;
import static tetris.domain.Tetramino.Shape.S;
import static tetris.domain.Tetramino.Shape.T;
import static tetris.domain.Tetramino.Shape.Z;

/**
 *
 * @author taleiko
 */
public class Logic implements Runnable {
    
    private int dropCounter;
    private int dropCounterIncrement = 5; //we drop the block every "tick"
    private Tetramino current;
    private Stage stage;
    private Timer timer;
    private TimerTask timerTask;
    
    public Logic() {
        stage = new Stage();
        
    }

    
    @Override
    public void run() {
        if (current == null) {
            current = createRandomTetramino();
        }
        System.out.println(this.current.getX() + ", " + this.current.getY());
        if (dropCounter == 0) {
            current.y++;
            if (stage.collidesWith(current)) {
//                System.out.println("Collide");
                current.y--;
                stage.placeTetramino(current);
                stage.removeRowsCheck();
                current = null;
            }
            stage.printPlayArea();
            dropCounter += dropCounterIncrement;
        } else {
            dropCounter--;
        }
        
    }
    
    
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

    private Tetramino createRandomTetramino() {
        Shape randomShape = createRandomEnum();
        return new Tetramino(9, 1, randomShape);
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
    
}
