/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.ui;

import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
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
    private Line line;
    private Rectangle a;
    private Rectangle b;
    private Rectangle c;
    private Rectangle d;
    
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
        task = new TimerTask() {
            @Override
            public void run() {
                logic.run();
                updateGameScreen();
//                gamePane = logic.getPaneFromStage();
                gameScene.setOnKeyPressed(
                event -> {
                    controller.handle(event);
                });
            }
        };
        
        //JavaFX
        menuPane = new BorderPane();
        newGame = new Button("Start a new game");
        menuElements = new GridPane();
        title = new Label("TETRIS");
        music = new Label("Music");
        clarinet = new Button("Clarinet");
        piano = new Button("Piano");
        trumpet = new Button("Trumpet");
        stopPlaying = new Button("Stop playing");
        musicButtons = new VBox();
        backToMenu = new Button("Back to menu");
        line = new Line(600, 0, 600, 300);
        
        
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
        
        
        
        
        //FIRST TEST GAME SCREEN
//        gamePane = new Pane();
//        Text text = new Text("fdss");
//        text.setX(0);
//        
//        Rectangle rect = new Rectangle(24, 24);
//        rect.setX(75);
//        rect.setY(50);
//        rect.setFill(Color.HOTPINK);
//        gamePane.getChildren().add(rect);
////        gamePane.getChildren().add(backToMenu);
//        gamePane.getChildren().add(line);
        gamePane = new Pane();
        gamePane.getChildren().add(new Rectangle(25, 25, 24, 24));
        gameScene = new Scene(gamePane, 500, 500);
        
        gameScene.setOnKeyPressed(
                event -> {
                    controller.handle(event);
                });
        
        
        menuScene = new Scene(menuPane, 500, 500);
        
        //Set button actions
        newGame.setOnAction((event) -> {
            timer.schedule(task, 0, 100);
//            gamePane = logic.getPaneFromStage();
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
    
    public Logic getLogic() {
        return this.logic;
    }
    
    private void updateGameScreen() {
        gamePane.getChildren().clear();
        char[][] grid = logic.getGridFromStage();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '#') {
                    Rectangle rect = new Rectangle(j * 25, i * 25, 24, 24);
                    rect.setId("" + i + ";" + j);
                    if (!gamePane.getChildren().contains(rect)) {
                        System.out.println("Yes");
                        gamePane.getChildren().add(rect);
                    }
                }
            }
        }
    }
}
