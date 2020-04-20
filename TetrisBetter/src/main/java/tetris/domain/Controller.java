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
    
    public Controller(Logic logic){
        this.logic = logic;
    }

    public void handle(KeyEvent event) {
        switch (event.getCode()) {
            case RIGHT:
//                logic.moveRight();
                    System.out.println("Right");
                break;
            case DOWN:
//                logic.moveDown();
                System.out.println("DownPrint");
                break;
            case LEFT:
//                logic.moveLeft();
                System.out.println("Left");
                break;
            case UP:
//                logic.rotate();
                System.out.println("Up");
                break;
            default:
                break;
        }
    }
}
