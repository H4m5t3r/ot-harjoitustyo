import javafx.scene.shape.Rectangle;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import tetris.domain.Form;

public class FormTest {

    Form form;
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
        form = new Form(a, b, c, d, "t");
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
}