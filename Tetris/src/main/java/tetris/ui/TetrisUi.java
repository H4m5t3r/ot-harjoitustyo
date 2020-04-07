
package tetris.ui;

import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import tetris.domain.Controller;
import tetris.domain.Form;
import tetris.domain.Music;
import tetris.domain.Tetris;

public class TetrisUi extends Application{
    //Menu
    private Music musicPlayer = new Music();
    private GridPane g = new GridPane();
    private Label title = new Label("TETRIS");
    private VBox background = new VBox();
    private VBox music = new VBox();
    private Button blue = new Button("Blue");
    private Button red = new Button("Red");
    private Button green = new Button("Green");
    private Button eightbit = new Button("8-bit");
    private Button piano = new Button("Piano");
    private Button trumpet = new Button("Trumpet");
    private Button stop = new Button("Stop");
    private Button newgame = new Button("Start new game");
    private Scene menuScene = new Scene(this.g, 500, 500);
    private Tetris tetris = new Tetris();
    
    //Tetris variables
    public static final int MOVE = 25;
    public static final int SIZE = 25;
    public static final int XMAX = SIZE * 12;
    public static final int YMAX = SIZE * 24;
    public static int[][] MESH = new int[XMAX / SIZE][YMAX / SIZE];
    public static Pane group = new Pane();
    public static Form object;
    public static Scene scene = new Scene(group, XMAX + 150, YMAX);
    public static int score = 0;
    public static int top = 0;
    private static boolean game = true;
    public static Form nextObj = Controller.makeRect();
    public static int linesNo = 0;
    private static Button backToMenu = new Button("Menu");
    
    public void start(Stage stage) throws Exception {
        stage.setTitle("Tetris");
        
        //Creating the menu
        this.g.add(title, 1, 0);
        
        background.getChildren().add(new Label("Background"));
        background.getChildren().add(blue);
        background.getChildren().add(red);
        background.getChildren().add(green);
        this.g.add(background, 0, 1);
        
        music.getChildren().add(new Label("Background"));
        music.getChildren().add(eightbit);
        music.getChildren().add(piano);
        music.getChildren().add(trumpet);
        music.getChildren().add(stop);
        this.g.add(music, 2, 1);
        
        piano.setOnAction((event) -> {
          musicPlayer.playMusic("TetrisPiano.wav");
      });
        
        trumpet.setOnAction((event) -> {
          musicPlayer.playMusic("TetrisTrumpet.wav");
      });
        
        stop.setOnAction((event) -> {
          musicPlayer.stopPlaying();
      });
        
        
        newgame.setOnAction((event) -> {
          stage.setScene(this.tetris.scene);
      });
        g.add(newgame, 1, 2);
        
        
        //Creating the game screen
        for (int[] a : MESH) {
            Arrays.fill(a, 0);
        }

        //Score and level text
        Line line = new Line(XMAX, 0, XMAX, YMAX);
        Text scoretext = new Text("Score: ");
        scoretext.setStyle("-fx-font: 20 arial;");
        scoretext.setY(50);
        scoretext.setX(XMAX + 5);
        Text level = new Text("Lines: ");
        level.setStyle("-fx-font: 20 arial;");
        level.setY(100);
        level.setX(XMAX + 5);
        level.setFill(Color.GREEN);
        
        group.getChildren().addAll(scoretext, line, level);

        //Creating the first block and the stage
        Form a = nextObj;
        group.getChildren().addAll(a.a, a.b, a.c, a.d);
        tetris.moveOnKeyPress(a);
        object = a;
        nextObj = Controller.makeRect();
        
        //Timer
        Timer fall = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                Platform.runLater(new Runnable() {
                    public void run() {
                        if (object.a.getY() == 0 || object.b.getY() == 0 || object.c.getY() == 0 || object.d.getY() == 0) {
                            top++;
                        } else {
                            top = 0;
                        }
                        if (top == 2) {
                            //GAME OVER
                            Text over = new Text("GAME OVER");
                            over.setFill(Color.RED);
                            over.setStyle("-fx-font: 70 arial;");
                            over.setY(250);
                            over.setX(10);
                            group.getChildren().add(over);
                            game = false;
                        }

                        //Exit
                        if (top == 15) {
                            System.exit(0);
                        }
                        if (game) {
                            tetris.moveDown(object);
                            scoretext.setText("Score: " + Integer.toString(score));
                            level.setText("Lines: " + Integer.toString(linesNo));
                        }
                    }
                });
            }
        };
        fall.schedule(task, 0, 300);
        
        
        stage.setScene(menuScene);
        stage.show();
    }
}
