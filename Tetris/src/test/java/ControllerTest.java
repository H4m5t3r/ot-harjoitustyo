import javafx.scene.shape.Rectangle;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import domain.Controller;
import static domain.Controller.SIZE;
import static domain.Controller.makeRect;
import static domain.Controller.xmax;
import domain.Tetramino;

public class ControllerTest {
    Tetramino form;
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