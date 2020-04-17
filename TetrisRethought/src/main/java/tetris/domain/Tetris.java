
package tetris.domain;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;

public class Tetris {
    //The tetris variables
    public int move;
    public int size;
    public int xmax;
    public int ymax;
    public int[][] mesh;
    public int score;
    public int top;
    public boolean game;
    public int linesNo;
    
    //Creating the required classes
    public Controller controller;
    
    public Tetris() {
        move = 25;
        size = 25;
        xmax = this.size * 12;
        ymax = this.size * 24;
        mesh = new int[this.xmax / this.size][this.ymax / this.size];
        score = 0;
        top = 0;
        game = true;
        linesNo = 0;
        
        controller = new Controller(move, size, xmax, ymax);
    }
    //Test method to see if the test can initialize the class
    public void gameFalse() {
        this.game = false;
    }
    
    //Short move methods
    public void moveDown(Rectangle rect) {
        if (rect.getY() + move < ymax) {
            rect.setY(rect.getY() + move);
        }
    }
    
    public void moveRight(Rectangle rect) {
        if (rect.getX() + move <= xmax - size) {
            rect.setX(rect.getX() + move);
        }
    }
    
    public void moveLeft(Rectangle rect) {
        if (rect.getX() - move >= 0) {
            rect.setX(rect.getX() - move);
        }
    }
    
    public void moveUp(Rectangle rect) {
        if (rect.getY() - move > 0) {
            rect.setY(rect.getY() - move);
        }
    }
    
    public boolean moveA(Form form) {
        return (mesh[(int) form.a.getX() / size][((int) form.a.getY() / size) + 1] == 1);
    }
    
    public boolean moveB(Form form) {
        return (mesh[(int) form.b.getX() / size][((int) form.b.getY() / size) + 1] == 1);
    }

    public boolean moveC(Form form) {
        return (mesh[(int) form.c.getX() / size][((int) form.c.getY() / size) + 1] == 1);
    }

    public boolean moveD(Form form) {
        return (mesh[(int) form.d.getX() / size][((int) form.d.getY() / size) + 1] == 1);
    }
    
    
    //Longer methods that are divided into smaller parts
    public void moveTurn(Form form) {
        
    }
    
    public void moveDown(Form form) {
        
    }
}
