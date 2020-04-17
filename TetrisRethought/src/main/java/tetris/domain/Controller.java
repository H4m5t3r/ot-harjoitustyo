
package tetris.domain;

import javafx.scene.shape.Rectangle;

public class Controller {
    int move;
    int size;
    int xmax;
    int ymax;
    
    public Controller(int move, int size, int xmax, int ymax) {
        this.move = move;
        this.size = size;
        this.xmax = xmax;
        this.ymax = ymax;
    }
    
    
    public void moveRight(Form form, int[][] mesh) {
        if (form.a.getX() + move <= xmax - size && form.b.getX() + move <= xmax - size
                    && form.c.getX() + move <= xmax - size && form.d.getX() + move <= xmax - size) {
            int movea = mesh[((int) form.a.getX() / size) + 1][((int) form.a.getY() / size)];
            int moveb = mesh[((int) form.b.getX() / size) + 1][((int) form.b.getY() / size)];
            int movec = mesh[((int) form.c.getX() / size) + 1][((int) form.c.getY() / size)];
            int moved = mesh[((int) form.d.getX() / size) + 1][((int) form.d.getY() / size)];
            if (movea == 0 && movea == moveb && moveb == movec && movec == moved) {
                form.a.setX(form.a.getX() + move);
                form.b.setX(form.b.getX() + move);
                form.c.setX(form.c.getX() + move);
                form.d.setX(form.d.getX() + move);
            }
        }
    }
    
    
    public void moveLeft(Form form, int[][] mesh) {
        if (form.a.getX() - move >= 0 && form.b.getX() - move >= 0 && form.c.getX() - move >= 0
                    && form.d.getX() - move >= 0) {
            int movea = mesh[((int) form.a.getX() / size) - 1][((int) form.a.getY() / size)];
            int moveb = mesh[((int) form.b.getX() / size) - 1][((int) form.b.getY() / size)];
            int movec = mesh[((int) form.c.getX() / size) - 1][((int) form.c.getY() / size)];
            int moved = mesh[((int) form.d.getX() / size) - 1][((int) form.d.getY() / size)];
            if (movea == 0 && movea == moveb && moveb == movec && movec == moved) {
                form.a.setX(form.a.getX() - move);
                form.b.setX(form.b.getX() - move);
                form.c.setX(form.c.getX() - move);
                form.d.setX(form.d.getX() - move);
            }
        }
    }
    
    
    public Form makeRect() { 
        int block = (int) (Math.random() * 100);
        String name = "";
        Rectangle a = new Rectangle(size - 1, size - 1), b = new Rectangle(size - 1, size - 1), c = new Rectangle(size - 1, size - 1), d = new Rectangle(size - 1, size - 1);
        if (block < 15) { 
            j(a, b, c, d, name);
        } else if (block < 30) { 
            l(a, b, c, d, name);
        } else if (block < 45) { 
            o(a, b, c, d, name);
        } else if (block < 60) { 
            s(a, b, c, d, name);
        } else if (block < 75) { 
            t(a, b, c, d, name);
        } else if (block < 90) { 
            z(a, b, c, d, name);
        } else { 
            i(a, b, c, d, name);
        }
        return new Form(a, b, c, d, name);
    }
    
    //All sub methods for makeRect()
    public void j(Rectangle a, Rectangle b, Rectangle c, Rectangle d, String name) {
        a.setX(xmax / 2 - size);
        b.setX(xmax / 2 - size);
        b.setY(size);
        c.setX(xmax / 2);
        c.setY(size);
        d.setX(xmax / 2 + size);
        d.setY(size);
        name = "j";
    }
    
    public void l(Rectangle a, Rectangle b, Rectangle c, Rectangle d, String name) {
        a.setX(xmax / 2 + size);
        b.setX(xmax / 2 - size);
        b.setY(size);
        c.setX(xmax / 2);
        c.setY(size);
        d.setX(xmax / 2 + size);
        d.setY(size);
        name = "l";
    }
    
    public void o(Rectangle a, Rectangle b, Rectangle c, Rectangle d, String name) {
        a.setX(xmax / 2 - size);
        b.setX(xmax / 2);
        c.setX(xmax / 2 - size);
        c.setY(size);
        d.setX(xmax / 2);
        d.setY(size);
        name = "o";
    }
    
    public void s(Rectangle a, Rectangle b, Rectangle c, Rectangle d, String name) {
        a.setX(xmax / 2 + size);
        b.setX(xmax / 2);
        c.setX(xmax / 2);
        c.setY(size);
        d.setX(xmax / 2 - size);
        d.setY(size);
        name = "s";
    }
    
    public void t(Rectangle a, Rectangle b, Rectangle c, Rectangle d, String name) {
        a.setX(xmax / 2 - size);
        b.setX(xmax / 2);
        c.setX(xmax / 2);
        c.setY(size);
        d.setX(xmax / 2 + size);
        name = "t";
    }
    
    public void z(Rectangle a, Rectangle b, Rectangle c, Rectangle d, String name) {
        a.setX(xmax / 2 + size);
        b.setX(xmax / 2);
        c.setX(xmax / 2 + size);
        c.setY(size);
        d.setX(xmax / 2 + size + size);
        d.setY(size);
        name = "z";
    }
    
    public void i(Rectangle a, Rectangle b, Rectangle c, Rectangle d, String name) {
        a.setX(xmax / 2 - size - size);
        b.setX(xmax / 2 - size);
        c.setX(xmax / 2);
        d.setX(xmax / 2 + size);
        name = "i";
    }
    
    //Assisting methods for rotating the polygons in Tetris with moveTurn()
    public void moveTurnJ(Form form, int f, Rectangle a, Rectangle b, Rectangle c, Rectangle d, Tetris tetris) {
        if (f == 1 && tetris.cB(a, 1, -1) && tetris.cB(c, -1, -1) && tetris.cB(d, -2, -2)) {
            moveJCase1(form, tetris);
        } else if (f == 2 && tetris.cB(a, -1, -1) && tetris.cB(c, -1, 1) && tetris.cB(d, -2, 2)) {
            moveJCase2(form, tetris);
        } else if (f == 3 && tetris.cB(a, -1, 1) && tetris.cB(c, 1, 1) && tetris.cB(d, 2, 2)) {
            moveJCase3(form, tetris);
        } else if (f == 4 && tetris.cB(a, 1, 1) && tetris.cB(c, 1, -1) && tetris.cB(d, 2, -2)) {
            moveJCase4(form, tetris);
        }
    }
    
    public void moveTurnL(Form form, int f, Rectangle a, Rectangle b, Rectangle c, Rectangle d, Tetris tetris) {
        if (f == 1 && tetris.cB(a, 1, -1) && tetris.cB(c, 1, 1) && tetris.cB(b, 2, 2)) {
            moveLCase1(form, tetris);
        } else if (f == 2 && tetris.cB(a, -1, -1) && tetris.cB(b, 2, -2) && tetris.cB(c, 1, -1)) {
            moveLCase2(form, tetris);
        } else if (f == 3 && tetris.cB(a, -1, 1) && tetris.cB(c, -1, -1) && tetris.cB(b, -2, -2)) {
            moveLCase3(form, tetris);
        } else if (f == 4 && tetris.cB(a, 1, 1) && tetris.cB(b, -2, 2) && tetris.cB(c, -1, 1)) {
            moveLCase4(form, tetris);
        }
    }
    
    public void moveTurnS(Form form, int f, Rectangle a, Rectangle b, Rectangle c, Rectangle d, Tetris tetris) {
        if (f == 1 && tetris.cB(a, -1, -1) && tetris.cB(c, -1, 1) && tetris.cB(d, 0, 2)) {
            moveSCase1(form, tetris);
        } else if (f == 2 && tetris.cB(a, 1, 1) && tetris.cB(c, 1, -1) && tetris.cB(d, 0, -2)) {
            moveSCase2(form, tetris);
        } else if (f == 3 && tetris.cB(a, -1, -1) && tetris.cB(c, -1, 1) && tetris.cB(d, 0, 2)) {
            moveSCase3(form, tetris);
        } else if (f == 4 && tetris.cB(a, 1, 1) && tetris.cB(c, 1, -1) && tetris.cB(d, 0, -2)) {
            moveSCase4(form, tetris);
        }
    }
    
    public void moveTurnT(Form form, int f, Rectangle a, Rectangle b, Rectangle c, Rectangle d, Tetris tetris) {
        if (f == 1 && tetris.cB(a, 1, 1) && tetris.cB(d, -1, -1) && tetris.cB(c, -1, 1)) {
            moveTCase1(form, tetris);
        } else if (f == 2 && tetris.cB(a, 1, -1) && tetris.cB(d, -1, 1) && tetris.cB(c, 1, 1)) {
            moveTCase2(form, tetris);
        } else if (f == 3 && tetris.cB(a, -1, -1) && tetris.cB(d, 1, 1) && tetris.cB(c, 1, -1)) {
            moveTCase3(form, tetris);
        } else if (f == 4 && tetris.cB(a, -1, 1) && tetris.cB(d, 1, -1) && tetris.cB(c, -1, -1)) {
            moveTCase4(form, tetris);
        }
    }
    
    public void moveTurnZ(Form form, int f, Rectangle a, Rectangle b, Rectangle c, Rectangle d, Tetris tetris) {
        if (f == 1 && tetris.cB(b, 1, 1) && tetris.cB(c, -1, 1) && tetris.cB(d, -2, 0)) {
            moveZCase1(form, tetris);
        } else if (f == 2 && tetris.cB(b, -1, -1) && tetris.cB(c, 1, -1) && tetris.cB(d, 2, 0)) {
            moveZCase2(form, tetris);
        } else if (f == 3 && tetris.cB(b, 1, 1) && tetris.cB(c, -1, 1) && tetris.cB(d, -2, 0)) {
            moveZCase3(form, tetris);
        } else if (f == 4 && tetris.cB(b, -1, -1) && tetris.cB(c, 1, -1) && tetris.cB(d, 2, 0)) {
            moveZCase4(form, tetris);
        }
    }
    
    public void moveTurnI(Form form, int f, Rectangle a, Rectangle b, Rectangle c, Rectangle d, Tetris tetris) {
        if (f == 1 && tetris.cB(a, 2, 2) && tetris.cB(b, 1, 1) && tetris.cB(d, -1, -1)) {
            moveICase1(form, tetris);
        } else if (f == 2 && tetris.cB(a, -2, -2) && tetris.cB(b, -1, -1) && tetris.cB(d, 1, 1)) {
            moveICase2(form, tetris);
        } else if (f == 3 && tetris.cB(a, 2, 2) && tetris.cB(b, 1, 1) && tetris.cB(d, -1, -1)) {
            moveICase3(form, tetris);
        } else if (f == 4 && tetris.cB(a, -2, -2) && tetris.cB(b, -1, -1) && tetris.cB(d, 1, 1)) {
            moveICase4(form, tetris);
        }
    }
    
    
    //Sub methods for the assisting methods above
    //j
    public void moveJCase1(Form form, Tetris tetris) {
        tetris.moveRight(form.a);
        tetris.moveDown(form.a);
        tetris.moveDown(form.c);
        tetris.moveLeft(form.c);
        tetris.moveDown(form.d);
        tetris.moveDown(form.d);
        tetris.moveLeft(form.d);
        tetris.moveLeft(form.d);
        form.changeForm();
    }
    public void moveJCase2(Form form, Tetris tetris) {
        tetris.moveDown(form.a);
        tetris.moveLeft(form.a);
        tetris.moveLeft(form.c);
        tetris.moveUp(form.c);
        tetris.moveLeft(form.d);
        tetris.moveLeft(form.d);
        tetris.moveUp(form.d);
        tetris.moveUp(form.d);
        form.changeForm();
    }
    public void moveJCase3(Form form, Tetris tetris) {
        tetris.moveLeft(form.a);
        tetris.moveUp(form.a);
        tetris.moveUp(form.c);
        tetris.moveRight(form.c);
        tetris.moveUp(form.d);
        tetris.moveUp(form.d);
        tetris.moveRight(form.d);
        tetris.moveRight(form.d);
        form.changeForm();
    }
    public void moveJCase4(Form form, Tetris tetris) {
        tetris.moveUp(form.a);
        tetris.moveRight(form.a);
        tetris.moveRight(form.c);
        tetris.moveDown(form.c);
        tetris.moveRight(form.d);
        tetris.moveRight(form.d);
        tetris.moveDown(form.d);
        tetris.moveDown(form.d);
        form.changeForm();
    }
    //l
    public void moveLCase1(Form form, Tetris tetris) {
        tetris.moveRight(form.a);
        tetris.moveDown(form.a);
        tetris.moveUp(form.c);
        tetris.moveRight(form.c);
        tetris.moveUp(form.b);
        tetris.moveUp(form.b);
        tetris.moveRight(form.b);
        tetris.moveRight(form.b);
        form.changeForm();
    }
    public void moveLCase2(Form form, Tetris tetris) {
        tetris.moveDown(form.a);
        tetris.moveLeft(form.a);
        tetris.moveRight(form.b);
        tetris.moveRight(form.b);
        tetris.moveDown(form.b);
        tetris.moveDown(form.b);
        tetris.moveRight(form.c);
        tetris.moveDown(form.c);
        form.changeForm();
    }
    public void moveLCase3(Form form, Tetris tetris) {
        tetris.moveLeft(form.a);
        tetris.moveUp(form.a);
        tetris.moveDown(form.c);
        tetris.moveLeft(form.c);
        tetris.moveDown(form.b);
        tetris.moveDown(form.b);
        tetris.moveLeft(form.b);
        tetris.moveLeft(form.b);
        form.changeForm();
    }
    public void moveLCase4(Form form, Tetris tetris) {
        tetris.moveUp(form.a);
        tetris.moveRight(form.a);
        tetris.moveLeft(form.b);
        tetris.moveLeft(form.b);
        tetris.moveUp(form.b);
        tetris.moveUp(form.b);
        tetris.moveLeft(form.c);
        tetris.moveUp(form.c);
        form.changeForm();
    }
    //s
    public void moveSCase1(Form form, Tetris tetris) {
        tetris.moveDown(form.a);
        tetris.moveLeft(form.a);
        tetris.moveLeft(form.c);
        tetris.moveUp(form.c);
        tetris.moveUp(form.d);
        tetris.moveUp(form.d);
        form.changeForm();
    }
    public void moveSCase2(Form form, Tetris tetris) {
        tetris.moveUp(form.a);
        tetris.moveRight(form.a);
        tetris.moveRight(form.c);
        tetris.moveDown(form.c);
        tetris.moveDown(form.d);
        tetris.moveDown(form.d);
        form.changeForm();
    }
    public void moveSCase3(Form form, Tetris tetris) {
        tetris.moveDown(form.a);
        tetris.moveLeft(form.a);
        tetris.moveLeft(form.c);
        tetris.moveUp(form.c);
        tetris.moveUp(form.d);
        tetris.moveUp(form.d);
        form.changeForm();
    }
    public void moveSCase4(Form form, Tetris tetris) {
        tetris.moveUp(form.a);
        tetris.moveRight(form.a);
        tetris.moveRight(form.c);
        tetris.moveDown(form.c);
        tetris.moveDown(form.d);
        tetris.moveDown(form.d);
        form.changeForm();
    }
    //t
    public void moveTCase1(Form form, Tetris tetris) {
        tetris.moveUp(form.a);
        tetris.moveRight(form.a);
        tetris.moveDown(form.d);
        tetris.moveLeft(form.d);
        tetris.moveLeft(form.c);
        tetris.moveUp(form.c);
        form.changeForm();
    }
    public void moveTCase2(Form form, Tetris tetris) {
        tetris.moveRight(form.a);
        tetris.moveDown(form.a);
        tetris.moveLeft(form.d);
        tetris.moveUp(form.d);
        tetris.moveUp(form.c);
        tetris.moveRight(form.c);
    }
    public void moveTCase3(Form form, Tetris tetris) {
        tetris.moveDown(form.a);
        tetris.moveLeft(form.a);
        tetris.moveUp(form.d);
        tetris.moveRight(form.d);
        tetris.moveRight(form.c);
        tetris.moveDown(form.c);
        form.changeForm();
    }
    public void moveTCase4(Form form, Tetris tetris) {
        tetris.moveLeft(form.a);
        tetris.moveUp(form.a);
        tetris.moveRight(form.d);
        tetris.moveDown(form.d);
        tetris.moveDown(form.c);
        tetris.moveLeft(form.c);
        form.changeForm();
    }
    //z
    public void moveZCase1(Form form, Tetris tetris) {
        tetris.moveUp(form.b);
        tetris.moveRight(form.b);
        tetris.moveLeft(form.c);
        tetris.moveUp(form.c);
        tetris.moveLeft(form.d);
        tetris.moveLeft(form.d);
        form.changeForm();
    }
    public void moveZCase2(Form form, Tetris tetris) {
        tetris.moveDown(form.b);
        tetris.moveLeft(form.b);
        tetris.moveRight(form.c);
        tetris.moveDown(form.c);
        tetris.moveRight(form.d);
        tetris.moveRight(form.d);
        form.changeForm();
    }
    public void moveZCase3(Form form, Tetris tetris) {
        tetris.moveUp(form.b);
        tetris.moveRight(form.b);
        tetris.moveLeft(form.c);
        tetris.moveUp(form.c);
        tetris.moveLeft(form.d);
        tetris.moveLeft(form.d);
        form.changeForm();
    }
    public void moveZCase4(Form form, Tetris tetris) {
        tetris.moveDown(form.b);
        tetris.moveLeft(form.b);
        tetris.moveRight(form.c);
        tetris.moveDown(form.c);
        tetris.moveRight(form.d);
        tetris.moveRight(form.d);
        form.changeForm();
    }
    //i
    public void moveICase1(Form form, Tetris tetris) {
        tetris.moveUp(form.a);
        tetris.moveUp(form.a);
        tetris.moveRight(form.a);
        tetris.moveRight(form.a);
        tetris.moveUp(form.b);
        tetris.moveRight(form.b);
        tetris.moveDown(form.d);
        tetris.moveLeft(form.d);
        form.changeForm();
    }
    public void moveICase2(Form form, Tetris tetris) {
        tetris.moveDown(form.a);
        tetris.moveDown(form.a);
        tetris.moveLeft(form.a);
        tetris.moveLeft(form.a);
        tetris.moveDown(form.b);
        tetris.moveLeft(form.b);
        tetris.moveUp(form.d);
        tetris.moveRight(form.d);
        form.changeForm();
    }
    public void moveICase3(Form form, Tetris tetris) {
        tetris.moveUp(form.a);
        tetris.moveUp(form.a);
        tetris.moveRight(form.a);
        tetris.moveRight(form.a);
        tetris.moveUp(form.b);
        tetris.moveRight(form.b);
        tetris.moveDown(form.d);
        tetris.moveLeft(form.d);
        form.changeForm();
    }
    public void moveICase4(Form form, Tetris tetris) {
        tetris.moveDown(form.a);
        tetris.moveDown(form.a);
        tetris.moveLeft(form.a);
        tetris.moveLeft(form.a);
        tetris.moveDown(form.b);
        tetris.moveLeft(form.b);
        tetris.moveUp(form.d);
        tetris.moveRight(form.d);
        form.changeForm();
    }
}
