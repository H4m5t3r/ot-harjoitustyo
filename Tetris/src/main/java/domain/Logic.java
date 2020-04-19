/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import javafx.stage.Stage;

/**
 *
 * @author taleiko
 */
public class Logic implements Runnable {
    
    private int dropCounter;
    private int dropCounterIncrement = 5; //vi droppar int blocket varje "tick"
    private Tetramino current;
    private Stage stage;

    @Override
    public void run() {
        if (current == null) {
            current = createRandomTetramino();
        }
        if (dropCounter == 0) {
            current.y++;
            if (stage.collidesWith(current)) {
                current.y--;
                stage.placeTetramino(current);
                current = null;
            }
            dropCounter += dropCounterIncrement;
        } else {
            dropCounter--;
        }
    }
    
    public void moveLeft() {
        current.x++;
        if (stage.collidesWith(current)) {
            current.x--;
        }
    }
    
    void moveRight() {
        current.x--;
        if (stage.collidesWith(current)) {
            current.x++;
        }
    }
    
    public void moveDown() {
        current.y++;
        if (stage.collidesWith(current)) {
            current.y--;
        } else {
            dropCounter += dropCounterIncrement;
        }
    }

    private Tetramino createRandomTetramino() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    void rotate() {
        current.rotate();
        while (stage.collidesWith(current)) {
            current.rotate();
        }
    }
    
}
