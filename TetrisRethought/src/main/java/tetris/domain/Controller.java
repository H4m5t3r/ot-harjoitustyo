
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
    
    
    public void MoveRight(Form form, int[][] mesh) {
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
    
    
    public void MoveLeft(Form form, int[][] mesh) {
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
        Rectangle a = new Rectangle(size - 1, size - 1), b = new Rectangle(size - 1, size - 1), c = new Rectangle(size - 1, size - 1),
                    d = new Rectangle(size - 1, size - 1);
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
}
