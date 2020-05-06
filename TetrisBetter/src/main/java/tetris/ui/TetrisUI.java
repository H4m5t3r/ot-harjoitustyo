package tetris.ui;

import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import tetris.domain.Controller;
import tetris.domain.Logic;
import tetris.domain.Music;

/**
 * The Java application containing the GUI.
 * 
 * @author taleiko
 */
public class TetrisUI extends Application {
    //JavaFX
    private Scene menuScene;
    private Pane menuPane;
    private GridPane menuElements;
    private Label title;
    private Label music;
    private Label backgroundLabel;
    private Button newGame;
    private Button clarinet;
    private Button piano;
    private Button trumpet;
    private Button stopPlaying;
    private VBox musicButtons;
    private VBox backgroundButtons;
    private Button white;
    private Button blue;
    private Button green;
    private Button red;
    private String backgroundFile;
    
    private Scene gameScene;
    private Pane gamePane;
    private Text scoreText1;
    private Text scoreText2;
    
    private ImageView iv;
    private Image background;
    private Line line;
    
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
        menuPane = new Pane();
        newGame = new Button("New game");
        newGame.setPrefWidth(115);
        menuElements = new GridPane();
        title = new Label("TETRIS");
        title.setStyle("-fx-font: 32 arial;");
        music = new Label("        Music");
        
        clarinet = new Button("Clarinet");
        piano = new Button("Piano");
        trumpet = new Button("Trumpet");
        stopPlaying = new Button("Stop playing");
        musicButtons = new VBox();
        
        clarinet.setPrefWidth(100);
        piano.setPrefWidth(100);
        trumpet.setPrefWidth(100);
        stopPlaying.setPrefWidth(100);
        
        backgroundLabel = new Label("Background");
        white = new Button("White");
        blue = new Button("Blue");
        green = new Button("Green");
        red = new Button("Red");
        
        white.setPrefWidth(80);
        blue.setPrefWidth(80);
        green.setPrefWidth(80);
        red.setPrefWidth(80);
        backgroundButtons = new VBox();
        
        iv = new ImageView();
        backgroundFile = "file:WhiteBackground.png";
        scoreText1 = new Text(320, 300, "Score:");
        scoreText1.setStyle("-fx-font: 32 arial;");
        scoreText2 = new Text(320, 340, "" + logic.getScoreFromStage());
        scoreText2.setStyle("-fx-font: 32 arial;");
        line = new Line(300, 0, 300, 600);
    }
    
    @Override
    public void start(Stage window) throws Exception {
        //The menu
        menuElements.add(newGame, 2, 3);
        menuElements.add(title, 2, 1);
        musicButtons.getChildren().addAll(music, clarinet, piano, trumpet, stopPlaying);
        
        backgroundButtons.getChildren().addAll(backgroundLabel, white, blue, green, red);
        
        menuElements.add(musicButtons, 1, 2);
        menuElements.add(backgroundButtons, 3, 2);
        
        menuElements.setLayoutX(145);
        menuElements.setLayoutY(150);
        menuPane.getChildren().add(menuElements);
        
        gameScene = new Scene(gamePane, 25 * 12 * 2, 25 * 24);
        
        gameScene.setOnKeyPressed((event) -> {
            controller.handle(event);
        });
        
        menuScene = new Scene(menuPane, 25 * 12 * 2, 25 * 24);
        
        //Set button actions
        newGame.setOnAction((event) -> {
            timer.schedule(task, 0, 100);
            window.setScene(gameScene);
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
        
        white.setOnAction((event) -> {
            backgroundFile = "file:WhiteBackground.png";
            iv.setImage(background);
            updateMenuScreen(menuPane);
        });
        
        blue.setOnAction((event) -> {
            backgroundFile = "file:BlueBackground.png";
            iv.setImage(background);
            updateMenuScreen(menuPane);
        });
        
        green.setOnAction((event) -> {
            backgroundFile = "file:GreenBackground.png";
            iv.setImage(background);
            updateMenuScreen(menuPane);
        });
        
        red.setOnAction((event) -> {
            backgroundFile = "file:RedBackground.png";
            iv.setImage(background);
            updateMenuScreen(menuPane);
        });
        
        window.setScene(menuScene);
        window.show();
    }
    
    @Override
    public void stop() {
        System.exit(0);
    }
    
    //Updated the menu screen when the background buttons are pressed
    private void updateMenuScreen(Pane menuPane) {
        menuPane.getChildren().clear();
        background = new Image(backgroundFile);
        iv.setImage(background);
        menuPane.getChildren().addAll(iv, menuElements);
    }
    
    //Updates the game pane so that the user can see what is happening
    private void updateGameScreen(Pane gamePane) {
        gamePane.getChildren().clear();
        
        background = new Image(backgroundFile);
        iv.setImage(background);
        gamePane.getChildren().add(iv);
        char[][] grid = logic.getGridFromStage();
        for (int i = 0; i < grid.length - 4; i++) {
            for (int j = 4; j < grid[0].length - 4; j++) {
                if (grid[i][j] == '#') {
                    Rectangle rect = new Rectangle((j - 4) * 25, i * 25, 24, 24);
                    gamePane.getChildren().add(rect);
                }
            }
        }
        scoreText2 = new Text(320, 340, "" + logic.getScoreFromStage());
        scoreText2.setStyle("-fx-font: 32 arial;");
        gamePane.getChildren().addAll(scoreText1, scoreText2, line);
    }
}
