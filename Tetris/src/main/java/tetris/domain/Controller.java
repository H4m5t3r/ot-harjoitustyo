
package tetris.domain;

import javafx.scene.shape.Rectangle;

public class Controller {
    //getting numbers and MESH from Tetris class
    public static final int MOVE = Tetris.move;
    public static final int SIZE = Tetris.size;
    public static int xmax = Tetris.xmax;
    public static int ymax = Tetris.ymax;
    public static int[][] mesh = Tetris.mesh;
    
    //moving the polygons
    //RIGHT
    public static void moveRight(Form form) {
        if (form.a.getX() + MOVE <= xmax - SIZE && form.b.getX() + MOVE <= xmax - SIZE
                    && form.c.getX() + MOVE <= xmax - SIZE && form.d.getX() + MOVE <= xmax - SIZE) {
            int movea = mesh[((int) form.a.getX() / SIZE) + 1][((int) form.a.getY() / SIZE)];
            int moveb = mesh[((int) form.b.getX() / SIZE) + 1][((int) form.b.getY() / SIZE)];
            int movec = mesh[((int) form.c.getX() / SIZE) + 1][((int) form.c.getY() / SIZE)];
            int moved = mesh[((int) form.d.getX() / SIZE) + 1][((int) form.d.getY() / SIZE)];
                
            if (movea == 0 && movea == moveb && moveb == movec && movec == moved) {
                form.a.setX(form.a.getX() + MOVE);
                form.b.setX(form.b.getX() + MOVE);
                form.c.setX(form.c.getX() + MOVE);
                form.d.setX(form.d.getX() + MOVE);
            }
        }
    }
    
    //LEFT
    public static void moveLeft(Form form) {
        if (form.a.getX() - MOVE >= 0 && form.b.getX() - MOVE >= 0 && form.c.getX() - MOVE >= 0
                    && form.d.getX() - MOVE >= 0) {
            int movea = mesh[((int) form.a.getX() / SIZE) - 1][((int) form.a.getY() / SIZE)];
            int moveb = mesh[((int) form.b.getX() / SIZE) - 1][((int) form.b.getY() / SIZE)];
            int movec = mesh[((int) form.c.getX() / SIZE) - 1][((int) form.c.getY() / SIZE)];
            int moved = mesh[((int) form.d.getX() / SIZE) - 1][((int) form.d.getY() / SIZE)];
                
            if (movea == 0 && movea == moveb && moveb == movec && movec == moved) {
                form.a.setX(form.a.getX() - MOVE);
                form.b.setX(form.b.getX() - MOVE);
                form.c.setX(form.c.getX() - MOVE);
                form.d.setX(form.d.getX() - MOVE);
            }
        }
    }
    
    //creating polygons
    public static Form makeRect() {
        //random color for the polygons
        int block = (int) (Math.random() * 100);
        String name;
        
        Rectangle a = new Rectangle(SIZE - 1, SIZE - 1), 
                b = new Rectangle(SIZE - 1, SIZE - 1), 
                c = new Rectangle(SIZE - 1, SIZE - 1), 
                d = new Rectangle(SIZE - 1, SIZE - 1);
        
        if (block < 15) { 
            a.setX(xmax / 2 - SIZE);
            b.setX(xmax / 2 - SIZE);
            b.setY(SIZE);
            c.setX(xmax / 2);
            c.setY(SIZE);
            d.setX(xmax / 2 + SIZE);
            d.setY(SIZE);
            name = "j";
        } else if (block < 30) { 
            a.setX(xmax / 2 + SIZE);
            b.setX(xmax / 2 - SIZE);
            b.setY(SIZE);
            c.setX(xmax / 2);
            c.setY(SIZE);
            d.setX(xmax / 2 + SIZE);
            d.setY(SIZE);
            name = "l";
        } else if (block < 45) { 
            a.setX(xmax / 2 - SIZE);
            b.setX(xmax / 2);
            c.setX(xmax / 2 - SIZE);
            c.setY(SIZE);
            d.setX(xmax / 2);
            d.setY(SIZE);
            name = "o";
        } else if (block < 60) { 
            a.setX(xmax / 2 + SIZE);
            b.setX(xmax / 2);
            c.setX(xmax / 2);
            c.setY(SIZE);
            d.setX(xmax / 2 - SIZE);
            d.setY(SIZE);
            name = "s";
        } else if (block < 75) { 
            a.setX(xmax / 2 - SIZE);
            b.setX(xmax / 2);
            c.setX(xmax / 2);
            c.setY(SIZE);
            d.setX(xmax / 2 + SIZE);
            name = "t";
        } else if (block < 90) { 
            a.setX(xmax / 2 + SIZE);
            b.setX(xmax / 2);
            c.setX(xmax / 2 + SIZE);
            c.setY(SIZE);
            d.setX(xmax / 2 + SIZE + SIZE);
            d.setY(SIZE);
            name = "z";
        } else { 
            a.setX(xmax / 2 - SIZE - SIZE);
            b.setX(xmax / 2 - SIZE);
            c.setX(xmax / 2);
            d.setX(xmax / 2 + SIZE);
            name = "i";
        }
        
        return new Form(a, b, c, d, name);
    }
    
}
