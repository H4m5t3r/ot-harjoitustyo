
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
    
    //Boolean methods for the different parts of the pylygon
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
    
    //Boolean function that is used to check if the rectangles can be moved 
    //in moveTurn() without moving outside of the allowed area
    public boolean cB(Rectangle rect, int x, int y) {
        boolean xb = false;
        boolean yb = false;
        if (x >= 0) {
            xb = rect.getX() + x * move <= xmax - size;
        }
        if (x < 0) {
            xb = rect.getX() + x * move >= 0;
        }
        if (y >= 0) {
            yb = rect.getY() - y * move > 0;
        }
        if (y < 0) {
            yb = rect.getY() + y * move < ymax;
        }
        return xb && yb && mesh[((int) rect.getX() / size) + x][((int) rect.getY() / size) - y] == 0;
    }
    
    
    //Longer methods that are divided into smaller parts
    
    //Turns the polygon
    //"o" is not included since nothing needs to be done with it
    public void moveTurn(Form form) {
        int f = form.form;
        if (form.getName().equals("j")) {
            controller.moveTurnJ(form, f, form.a, form.b, form.c, form.d, this);
        } else if (form.getName().equals("l")) {
            controller.moveTurnL(form, f, form.a, form.b, form.c, form.d, this);
        } else if (form.getName().equals("s")) {
            controller.moveTurnS(form, f, form.a, form.b, form.c, form.d, this);
        } else if (form.getName().equals("t")) {
            controller.moveTurnT(form, f, form.a, form.b, form.c, form.d, this);
        } else if (form.getName().equals("z")) {
            controller.moveTurnZ(form, f, form.a, form.b, form.c, form.d, this);
        } else if (form.getName().equals("i")) {
            controller.moveTurnI(form, f, form.a, form.b, form.c, form.d, this);
        }
    }
    
    public void moveDown(Form form) {
        
    }
}
