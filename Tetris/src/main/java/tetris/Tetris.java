
package tetris;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Tetris extends Application {
    
    //Variables
    public static final int MOVE = 25;
    public static final int SIZE = 25;
    public static final int XMAX = 12;
    public static final int YMAX = 24;
    public static int[][] MESH = new int [XMAX/SIZE][YMAX/SIZE];
    private static Pane groupe = new Pane();
    private static Form object;
    private static Scene scene = new Scene(groupe, XMAX + 150, YMAX);
    public static int score = 0;
    public static int top = 0;
    private static boolean game = true;
    private static Form nextObj = controller.makeRect();
    private static int linesNo = 0;
    
    //creating a scene and starting the game
    
    
    @Override
    public void start(Stage ikkuna) throws Exception {
        ikkuna.setTitle("Tetris");
        for (int[] a: MESH){
            Arrays.fill(a, 0);
        }
        
        //Score and level text
        Line line = new Line(XMAX, 0, XMAX, YMAX);
        Text scoretext = new Text("Score: ");
        scoretext.setStyle("-fx-font: 20 arials;");
        scoretext.setY(50);
        scoretext.setX(XMAX + 5);
        Text level = new Text("Lines: ");
        level.setStyle("-fx-font: 20 arials;");
        level.setY(100);
        level.setX(XMAX + 5);
        level.setFill(Color.GREEN);
        groupe.getChildren().addAll(scoretext, line, level);
        
        //Creating the first block and the stage
        Form a = nextObj;
        groupe.getChildren().addAll(a.a, a.b, a.c, a.d);
        moveOnKeyPress(a);
        object = a;
        nextObj = controller.makeRect();
        ikkuna.setScene(scene);
        ikkuna.setTitle("TETRIS");
        ikkuna.show();
        
        //Timer
        Timer fall = new Timer();
        TimerTask task = new TimerTask(){
            public void run(){
                Platform.runLater(new Runnable(){
                    public void run(){
                        if (object.a.getY() == 0 || object.b.getY() == 0  || object.c.getY() == 0  || object.d.getY() == 0){
                            top++;
                        }
                        else{
                                top = 0;
                        }
                        if (top == 2){
                            //GAME OVER
                            Text over = new Text("GAME OVER");
                            over.setFill(Color.RED);
                            over.setStyle("-fx-font: 70 arial;");
                            over.setY(250);
                            over.setX(10);
                            groupe.getChildren().add(over);
                            game = false;
                        }
                        
                        //Exit
                        if (top == 15){
                            System.exit(0);
                        }
                        if (game){
                            MoveDown(object);
                            scoreText("Score: " + Integer.toString(score));
                        }
                }
                });
            }
        };
        fall.schedule(task, 0, 300);
    }
    
    private void moveOnKeyPressed(Form form){
        scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
            public void handle(KeyEvent event){
                switch (event.getCode()) {
                    case RIGHT:
                        controller.MoveRight(form);
                        break;
                    case DOWN:
                        MoveDown(form); //**
                        break;
                    case LEFT:
                        controller.MoveLeft(form);
                        break;
                    case UP:
                        MoveTurn(form); //**
                        break;
                    default:
                        break;
                }
            }
        });
    }
    
    private void MoveTurn(Form form){
        int f = form.form;
        Rectangle a = form.a;
        Rectangle b = form.b;
        Rectangle c = form.c;
        Rectangle d = form.d;
        switch (form.getName()){
            case "j":
                if (f == 1 && cB(a, 1, -1) && cB(c, -1, -1) && cB(d, -2, -2)){
                    
                }
        }
    }
    
    private boolean cB(Rectangle rect, int x, int y){
        boolean yb = false;
        boolean xb = false;
        if (x >= 0){
            xb = rect.getX() + x*MOVE <= XMAX - SIZE;
        }
        if (x < 0){
            xb = rect.getX() + x*MOVE >= 0;
        }
        if (y >= 0){
            yb = rect.getY() + y*MOVE > 0;
        }
        if (y < 0){
            yb = rect.getY() + y*MOVE < YMAX;
        }
        return xb && MESH[((int)rect.getX()/SIZE)+x][((int)rect.getY()/SIZE)-y] == 0;
    }

    //creating the scene and start the game
    public static void main(String[] args) {
        launch(Tetris.class);
    }
}