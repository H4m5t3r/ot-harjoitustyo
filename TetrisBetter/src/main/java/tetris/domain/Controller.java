/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.domain;

import javafx.scene.input.KeyEvent;

/**
 *
 * @author taleiko
 */
public class Controller {

    private Logic logic;

    public void handle(KeyEvent event) {
        switch (event.getCode()) {
            case RIGHT:
                logic.moveRight(); //copy pom & import - t waffe
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
