/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.ui;

import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import tetris.domain.Controller;
import tetris.domain.Logic;
import tetris.domain.Music;

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
    private Button clarinet;
    private Button piano;
    private Button trumpet;
    private Button stopPlaying;
    private VBox musicButtons;
    
    private Scene gameScene;
    private Pane gamePane;
    private Button backToMenu;
    
    //Game logic
    Logic logic;
    Controller controller;
    Music musicPlayer;

    private Timer timer;
    private TimerTask task;
    
    @Override
    public void init() {
        //Dependencies
        logic = new Logic();
        controller = new Controller(logic);
        musicPlayer = new Music();
        
        
        //Timer
        timer = new Timer();
        gamePane = new Pane();
        task = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    public void run() {
                        logic.run();
                        updateGameScreen(gamePane);
                        gameScene.setOnKeyPressed(
                        event -> {
                            controller.handle(event);
                        });
                    }
                });
            }
        };
        
        //JavaFX
        menuPane = new BorderPane();
        newGame = new Button("New game");
        menuElements = new GridPane();
        title = new Label("TETRIS");
        music = new Label("Music");
        clarinet = new Button("Clarinet");
        piano = new Button("Piano");
        trumpet = new Button("Trumpet");
        stopPlaying = new Button("Stop playing");
        musicButtons = new VBox();
        backToMenu = new Button("Back to menu");
//        line = new Line(600, 0, 600, 300);
    }
    
    @Override
    public void start(Stage window) throws Exception {
        //The menu
        menuElements.add(newGame, 2, 3);
        menuElements.add(title, 2, 1);
        musicButtons.getChildren().add(music);
        musicButtons.getChildren().add(clarinet);
        musicButtons.getChildren().add(piano);
        musicButtons.getChildren().add(trumpet);
        musicButtons.getChildren().add(stopPlaying);
        
        menuElements.add(musicButtons, 2, 2);
        
        menuPane.setCenter(menuElements);
        
        gamePane.getChildren().add(new Rectangle(25, 25, 24, 24));
        gameScene = new Scene(gamePane, 25 * 12, 25 * 24);
        
        gameScene.setOnKeyPressed(
                event -> {
                    controller.handle(event);
                });
        
        menuScene = new Scene(menuPane, 25 * 12, 25 * 24);
        
        //Set button actions
        newGame.setOnAction((event) -> {
            timer.schedule(task, 0, 100);
            window.setScene(gameScene);
        });
        
        backToMenu.setOnAction((event) -> {
            window.setScene(menuScene);
        });
        
        clarinet.setOnAction((event) -> {
            musicPlayer.playMusic("TetrisClarinet.wav");
        });
        
        piano.setOnAction((event) -> {
            musicPlayer.playMusic("TetrisPiano.wav");
        });
        
        trumpet.setOnAction((event) -> {
            musicPlayer.playMusic("TetrisTrumpet.wav");
        });
        
        stopPlaying.setOnAction((event) -> {
            musicPlayer.stopPlaying();
        });
        
        window.setScene(menuScene);
        window.show();
    }
    
    @Override
    public void stop() {
        System.out.println("Game closing");
    }
    
    //Updates the game pane so that the user can see what is happening
    private void updateGameScreen(Pane gamePane) {
        gamePane.getChildren().clear();
        char[][] grid = logic.getGridFromStage();
        for (int i = 0; i < grid.length - 4; i++) {
            for (int j = 4; j < grid[0].length - 4; j++) {
                if (grid[i][j] == '#') {
                    Rectangle rect = new Rectangle((j - 4) * 25, i * 25, 24, 24);
                    gamePane.getChildren().add(rect);
                }
            }
        }
    }
}
