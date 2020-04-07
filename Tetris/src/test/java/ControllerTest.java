import javafx.scene.shape.Rectangle;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tetris.domain.Controller;
import static tetris.domain.Controller.SIZE;
import static tetris.domain.Controller.makeRect;
import static tetris.domain.Controller.xmax;
import tetris.domain.Form;

public class ControllerTest {
    Form form;
    Rectangle rectangle;
    
    public ControllerTest() {
    
    }

    @Before
    public void setUp() {
        this.rectangle = new Rectangle(SIZE - 1, SIZE - 1);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void rightForm(){
        this.form = makeRect();
        assertTrue(this.form.a == this.rectangle);
    }
}