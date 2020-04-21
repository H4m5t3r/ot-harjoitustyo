package tests;


import javafx.event.Event;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.robot.Robot;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import tetris.domain.Controller;
import tetris.domain.Logic;
import tetris.domain.Music;
import tetris.domain.Tetramino;
import tetris.domain.Tetramino.Shape;
import static tetris.domain.Tetramino.Shape.I;
import static tetris.domain.Tetramino.Shape.J;
import static tetris.domain.Tetramino.Shape.L;
import static tetris.domain.Tetramino.Shape.O;
import static tetris.domain.Tetramino.Shape.S;
import static tetris.domain.Tetramino.Shape.T;
import static tetris.domain.Tetramino.Shape.Z;
import javafx.scene.input.KeyEvent;


public class ControllerTest {
    private Controller controller;
    private Logic logic;

    @Before
    public void setUp() {
        logic = new Logic();
        controller = new Controller(logic);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void controllerTest() {
//        Robot rob = new Robot();
//        rob.keyPress(KeyCode.DOWN);
//        KeyEvent a = new KeyEvent();
    }
}
