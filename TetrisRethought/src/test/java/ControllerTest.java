import javafx.scene.shape.Rectangle;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tetris.domain.Controller;
import tetris.domain.Form;
import tetris.domain.Tetris;


public class ControllerTest {
    Tetris tetris;
    Controller controller;
    Form form;
    Rectangle rectangle;

    @Before
    public void setUp() {
        this.tetris = new Tetris();
        this.controller = new Controller(tetris.move, tetris.size, tetris.xmax, tetris.ymax);
        this.rectangle = new Rectangle(tetris.size - 1, tetris.size - 1);
    }

    @Test
    public void rightForm(){
        for (int i = 0; i < 100; i++){
            this.form = controller.makeRect();
            if (form.getName().equals("j")){
                //Add this.form.a.getX() == ... to the tests
                assertTrue(this.form.getName().equals("j"));
            }
            else if (form.getName().equals("l")){
                assertTrue(this.form.getName().equals("l"));
            }
            else if (form.getName().equals("o")){
                assertTrue(this.form.getName().equals("o"));
            }
            else if (form.getName().equals("s")){
                assertTrue(this.form.getName().equals("s"));
            }
            else if (form.getName().equals("t")){
                assertTrue(this.form.getName().equals("t"));
            }
            else if (form.getName().equals("z")){
                assertTrue(this.form.getName().equals("z"));
            }
            else if (form.getName().equals("i")){
                assertTrue(this.form.getName().equals("i"));
            }
        }
    }
    
    @Test
    public void moveLeftTest(){
        
    }
    
    @Test
    public void moveRightTest(){
        
    }
}