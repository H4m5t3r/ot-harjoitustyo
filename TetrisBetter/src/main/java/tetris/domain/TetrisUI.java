/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.domain;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author taleiko
 */
public class TetrisUI extends Application {
    //JavaFX
    private Scene menuScene;
    private BorderPane menuPane;
    private GridPane menuElements;
    private Label title;
    private Label music;
    private Button newGame;
    private Button eightBit;
    private Button piano;
    private Button trumpet;
    private VBox musicButtons;
    
    private Scene gameScene;
    private Pane gamePane;
    
    //Game logic
    Logic logic;
    

    @Override
    public void init() {
        //JavaFX
        menuPane = new BorderPane();
        newGame = new Button("Start a new game");
        menuElements = new GridPane();
        title = new Label("TETRIS");
        music = new Label("Music");
        eightBit = new Button("8-bit");
        piano = new Button("Piano");
        trumpet = new Button("Trumpet");
        musicButtons = new VBox();
        
        //Dependencies
        logic = new Logic();
    }
    
    @Override
    public void start(Stage ikkuna) throws Exception {
        //The menu
        menuElements.add(newGame, 2, 3);
        menuElements.add(title, 2, 1);
        musicButtons.getChildren().add(music);
        musicButtons.getChildren().add(eightBit);
        musicButtons.getChildren().add(piano);
        musicButtons.getChildren().add(trumpet);
        
        menuElements.add(musicButtons, 2, 2);
        
        menuPane.setCenter(menuElements);
        
        
        
        
        //The game screen
        gamePane = new Pane();
        Text text = new Text("fdss");
        text.setX(0);
        
        Rectangle rect = new Rectangle(24, 24);
        rect.setX(40);
        rect.setY(20);
        gamePane.getChildren().add(rect);
        gameScene = new Scene(gamePane, 500, 500);
        
        
        
        menuScene = new Scene(menuPane, 500, 500);
        
        newGame.setOnAction((event) -> {
            ikkuna.setScene(gameScene);
        });
        
        ikkuna.setScene(menuScene);
        ikkuna.show();
    }
    
    @Override
    public void stop() {
        System.out.println("Game closing");
    }
    
    public static void main(String[] args) {
        launch(TetrisUI.class);
    }
}
