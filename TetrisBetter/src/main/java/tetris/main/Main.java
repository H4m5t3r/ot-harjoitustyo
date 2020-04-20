/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.main;

import tetris.domain.Logic;
import tetris.domain.Music;
import tetris.ui.TetrisUI;

/**
 *
 * @author taleiko
 */
public class Main {
    
    public static void main(String[] args) {
        System.out.println("Hello");
        TetrisUI.main(args);
//        Logic logic = new Logic();
        //controllern ska tydligen vara kopplad till UIn? new Controller(logic);
//        logic.run(); //borde "run" med 100ms eller kortare paus emellan
    }
}