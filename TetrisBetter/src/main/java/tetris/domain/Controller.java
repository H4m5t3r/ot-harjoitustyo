
package tetris.domain;

import javafx.scene.input.KeyEvent;

/**
 *
 * @author taleiko
 */

/**
 * This class takes input from the TetrisUI class and calls methods located in 
 * the logic class.
 */
public class Controller {

    private Logic logic;
    
    public Controller(Logic logic) {
        this.logic = logic;
    }

    public void handle(KeyEvent event) {
        switch (event.getCode()) {
            case RIGHT:
                logic.moveRight();
                break;
            case DOWN:
                logic.moveDown();
                break;
            case LEFT:
                logic.moveLeft();
                break;
            case UP:
                logic.rotate();
                break;
            default:
                break;
        }
    }
}
