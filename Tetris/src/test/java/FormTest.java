import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import domain.Tetramino;

public class FormTest {

    Tetramino form;
    Rectangle a;
    Rectangle b;
    Rectangle c;
    Rectangle d;
    
    @Before
    public void setUp(){
        a = new Rectangle();
        b = new Rectangle();
        c = new Rectangle();
        d = new Rectangle();
    }
    
    //Checks that the polygons are in the right "mode" after they are rotated
    @Test
    public void rightFormAfterFormChange(){
        form = new Tetramino(a, b, c, d, "t");
        assertTrue(form.form == 1);
        form.changeForm();
        assertTrue(form.form == 2);
        form.changeForm();
        assertTrue(form.form == 3);
        form.changeForm();
        assertTrue(form.form == 4);
        form.changeForm();
        assertTrue(form.form == 1);
    }
    
    @Test
    public void rightColor(){
        form = new Tetramino(a, b, c, d, "j");
        assertTrue(form.getColor() == Color.SLATEGRAY);
        form = new Tetramino(a, b, c, d, "l");
        assertTrue(form.getColor() == Color.DARKGOLDENROD);
        form = new Tetramino(a, b, c, d, "o");
        assertTrue(form.getColor() == Color.INDIANRED);
        form = new Tetramino(a, b, c, d, "s");
        assertTrue(form.getColor() == Color.FORESTGREEN);
        form = new Tetramino(a, b, c, d, "t");
        assertTrue(form.getColor() == Color.CADETBLUE);
        form = new Tetramino(a, b, c, d, "z");
        assertTrue(form.getColor() == Color.HOTPINK);
        form = new Tetramino(a, b, c, d, "i");
        assertTrue(form.getColor() == Color.SANDYBROWN);
    }
    
    @Test
    public void regularConstructorWorks(){
        form = new Tetramino(a, b, c, d);
        assertTrue(form.a == this.a);
        assertTrue(form.b == this.b);
        assertTrue(form.c == this.c);
        assertTrue(form.d == this.d);
    }
    
    @Test
    public void getNameWorks(){
        form = new Tetramino(a, b, c, d, "z");
        assertTrue(form.getName().equals("z"));
    }
}