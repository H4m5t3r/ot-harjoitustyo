/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.main;

import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Application;
import tetris.domain.Logic;
import tetris.domain.Stage;
import tetris.ui.TetrisUI;

/**
 *
 * @author taleiko
 */
public class Main {
    
    public static void main(String[] args) {
        System.out.println("Hello");
        Application.launch(TetrisUI.class);
        
//        Logic logic = new Logic();
        //controllern ska tydligen vara kopplad till UIn? new Controller(logic);
//        logic.run(); //borde "run" med 100ms eller kortare paus emellan
    }
}