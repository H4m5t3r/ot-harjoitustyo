package tetris.domain;

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
import static javafx.application.Application.launch;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class Tetris extends Application {

    //Variables
    public static final int MOVE = 25;
    public static final int SIZE = 25;
    public static final int XMAX = SIZE * 12;
    public static final int YMAX = SIZE * 24;
    public static int[][] mesh = new int[XMAX / SIZE][YMAX / SIZE];
    private static Pane group = new Pane();
    private static Form object;
    public Scene scene = new Scene(group, XMAX + 150, YMAX);
    public static int score = 0;
    public static int top = 0;
    private static boolean game = true;
    private static Form nextObj = Controller.makeRect();
    private static int linesNo = 0;
    private static Button backToMenu = new Button("Menu");
    
    //menu
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

    //creating a scene and starting the game
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Tetris");
        for (int[] a : mesh) {
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
        moveOnKeyPress(a);
        object = a;
        nextObj = Controller.makeRect();
        
        
        
        ////MENU
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
            stage.setScene(scene);
        });
        g.add(newgame, 1, 2);
        
        backToMenu.setOnAction((event) -> {
            stage.setScene(menuScene);
        });
        
        
        stage.setScene(menuScene);
        stage.show();

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
                            moveDown(object);
                            scoretext.setText("Score: " + Integer.toString(score));
                            level.setText("Lines: " + Integer.toString(linesNo));
                        }
                    }
                });
            }
        };
        fall.schedule(task, 0, 300);
    }

    public void moveOnKeyPress(Form form) {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case RIGHT:
                        Controller.moveRight(form);
                        break;
                    case DOWN:
                        moveDown(form); //**
                        break;
                    case LEFT:
                        Controller.moveLeft(form);
                        break;
                    case UP:
                        moveTurn(form); //**
                        break;
                    default:
                        break;
                }
            }
        });
    }

    private void moveTurn(Form form) {
        int f = form.form;
        Rectangle a = form.a;
        Rectangle b = form.b;
        Rectangle c = form.c;
        Rectangle d = form.d;
        switch (form.getName()) {
            case "j":
                if (f == 1 && cB(a, 1, -1) && cB(c, -1, -1) && cB(d, -2, -2)) {
                    moveRight(form.a);
                    moveDown(form.a);
                    moveDown(form.c);
                    moveLeft(form.c);
                    moveDown(form.d);
                    moveDown(form.d);
                    moveLeft(form.d);
                    moveLeft(form.d);
                    form.changeForm();
                    break;
                }
                if (f == 2 && cB(a, -1, -1) && cB(c, -1, 1) && cB(d, -2, 2)) {
                    moveDown(form.a);
                    moveLeft(form.a);
                    moveLeft(form.c);
                    moveUp(form.c);
                    moveLeft(form.d);
                    moveLeft(form.d);
                    moveUp(form.d);
                    moveUp(form.d);
                    form.changeForm();
                    break;
                }
                if (f == 3 && cB(a, -1, 1) && cB(c, 1, 1) && cB(d, 2, 2)) {
                    moveLeft(form.a);
                    moveUp(form.a);
                    moveUp(form.c);
                    moveRight(form.c);
                    moveUp(form.d);
                    moveUp(form.d);
                    moveRight(form.d);
                    moveRight(form.d);
                    form.changeForm();
                    break;
                }
                if (f == 4 && cB(a, 1, 1) && cB(c, 1, -1) && cB(d, 2, -2)) {
                    moveUp(form.a);
                    moveRight(form.a);
                    moveRight(form.c);
                    moveDown(form.c);
                    moveRight(form.d);
                    moveRight(form.d);
                    moveDown(form.d);
                    moveDown(form.d);
                    form.changeForm();
                    break;
                }
                break;
            case "l":
                if (f == 1 && cB(a, 1, -1) && cB(c, 1, 1) && cB(b, 2, 2)) {
                    moveRight(form.a);
                    moveDown(form.a);
                    moveUp(form.c);
                    moveRight(form.c);
                    moveUp(form.b);
                    moveUp(form.b);
                    moveRight(form.b);
                    moveRight(form.b);
                    form.changeForm();
                    break;
                }
                if (f == 2 && cB(a, -1, -1) && cB(b, 2, -2) && cB(c, 1, -1)) {
                    moveDown(form.a);
                    moveLeft(form.a);
                    moveRight(form.b);
                    moveRight(form.b);
                    moveDown(form.b);
                    moveDown(form.b);
                    moveRight(form.c);
                    moveDown(form.c);
                    form.changeForm();
                    break;
                }
                if (f == 3 && cB(a, -1, 1) && cB(c, -1, -1) && cB(b, -2, -2)) {
                    moveLeft(form.a);
                    moveUp(form.a);
                    moveDown(form.c);
                    moveLeft(form.c);
                    moveDown(form.b);
                    moveDown(form.b);
                    moveLeft(form.b);
                    moveLeft(form.b);
                    form.changeForm();
                    break;
                }
                if (f == 4 && cB(a, 1, 1) && cB(b, -2, 2) && cB(c, -1, 1)) {
                    moveUp(form.a);
                    moveRight(form.a);
                    moveLeft(form.b);
                    moveLeft(form.b);
                    moveUp(form.b);
                    moveUp(form.b);
                    moveLeft(form.c);
                    moveUp(form.c);
                    form.changeForm();
                    break;
                }
                break;
            case "o":
                break;
            case "s":
                if (f == 1 && cB(a, -1, -1) && cB(c, -1, 1) && cB(d, 0, 2)) {
                    moveDown(form.a);
                    moveLeft(form.a);
                    moveLeft(form.c);
                    moveUp(form.c);
                    moveUp(form.d);
                    moveUp(form.d);
                    form.changeForm();
                    break;
                }
                if (f == 2 && cB(a, 1, 1) && cB(c, 1, -1) && cB(d, 0, -2)) {
                    moveUp(form.a);
                    moveRight(form.a);
                    moveRight(form.c);
                    moveDown(form.c);
                    moveDown(form.d);
                    moveDown(form.d);
                    form.changeForm();
                    break;
                }
                if (f == 3 && cB(a, -1, -1) && cB(c, -1, 1) && cB(d, 0, 2)) {
                    moveDown(form.a);
                    moveLeft(form.a);
                    moveLeft(form.c);
                    moveUp(form.c);
                    moveUp(form.d);
                    moveUp(form.d);
                    form.changeForm();
                    break;
                }
                if (f == 4 && cB(a, 1, 1) && cB(c, 1, -1) && cB(d, 0, -2)) {
                    moveUp(form.a);
                    moveRight(form.a);
                    moveRight(form.c);
                    moveDown(form.c);
                    moveDown(form.d);
                    moveDown(form.d);
                    form.changeForm();
                    break;
                }
                break;
            case "t":
                if (f == 1 && cB(a, 1, 1) && cB(d, -1, -1) && cB(c, -1, 1)) {
                    moveUp(form.a);
                    moveRight(form.a);
                    moveDown(form.d);
                    moveLeft(form.d);
                    moveLeft(form.c);
                    moveUp(form.c);
                    form.changeForm();
                    break;
                }
                if (f == 2 && cB(a, 1, -1) && cB(d, -1, 1) && cB(c, 1, 1)) {
                    moveRight(form.a);
                    moveDown(form.a);
                    moveLeft(form.d);
                    moveUp(form.d);
                    moveUp(form.c);
                    moveRight(form.c);
                    form.changeForm();
                    break;
                }
                if (f == 3 && cB(a, -1, -1) && cB(d, 1, 1) && cB(c, 1, -1)) {
                    moveDown(form.a);
                    moveLeft(form.a);
                    moveUp(form.d);
                    moveRight(form.d);
                    moveRight(form.c);
                    moveDown(form.c);
                    form.changeForm();
                    break;
                }
                if (f == 4 && cB(a, -1, 1) && cB(d, 1, -1) && cB(c, -1, -1)) {
                    moveLeft(form.a);
                    moveUp(form.a);
                    moveRight(form.d);
                    moveDown(form.d);
                    moveDown(form.c);
                    moveLeft(form.c);
                    form.changeForm();
                    break;
                }
                break;
            case "z":
                if (f == 1 && cB(b, 1, 1) && cB(c, -1, 1) && cB(d, -2, 0)) {
                    moveUp(form.b);
                    moveRight(form.b);
                    moveLeft(form.c);
                    moveUp(form.c);
                    moveLeft(form.d);
                    moveLeft(form.d);
                    form.changeForm();
                    break;
                }
                if (f == 2 && cB(b, -1, -1) && cB(c, 1, -1) && cB(d, 2, 0)) {
                    moveDown(form.b);
                    moveLeft(form.b);
                    moveRight(form.c);
                    moveDown(form.c);
                    moveRight(form.d);
                    moveRight(form.d);
                    form.changeForm();
                    break;
                }
                if (f == 3 && cB(b, 1, 1) && cB(c, -1, 1) && cB(d, -2, 0)) {
                    moveUp(form.b);
                    moveRight(form.b);
                    moveLeft(form.c);
                    moveUp(form.c);
                    moveLeft(form.d);
                    moveLeft(form.d);
                    form.changeForm();
                    break;
                }
                if (f == 4 && cB(b, -1, -1) && cB(c, 1, -1) && cB(d, 2, 0)) {
                    moveDown(form.b);
                    moveLeft(form.b);
                    moveRight(form.c);
                    moveDown(form.c);
                    moveRight(form.d);
                    moveRight(form.d);
                    form.changeForm();
                    break;
                }
                break;
            case "i":
                if (f == 1 && cB(a, 2, 2) && cB(b, 1, 1) && cB(d, -1, -1)) {
                    moveUp(form.a);
                    moveUp(form.a);
                    moveRight(form.a);
                    moveRight(form.a);
                    moveUp(form.b);
                    moveRight(form.b);
                    moveDown(form.d);
                    moveLeft(form.d);
                    form.changeForm();
                    break;
                }
                if (f == 2 && cB(a, -2, -2) && cB(b, -1, -1) && cB(d, 1, 1)) {
                    moveDown(form.a);
                    moveDown(form.a);
                    moveLeft(form.a);
                    moveLeft(form.a);
                    moveDown(form.b);
                    moveLeft(form.b);
                    moveUp(form.d);
                    moveRight(form.d);
                    form.changeForm();
                    break;
                }
                if (f == 3 && cB(a, 2, 2) && cB(b, 1, 1) && cB(d, -1, -1)) {
                    moveUp(form.a);
                    moveUp(form.a);
                    moveRight(form.a);
                    moveRight(form.a);
                    moveUp(form.b);
                    moveRight(form.b);
                    moveDown(form.d);
                    moveLeft(form.d);
                    form.changeForm();
                    break;
                }
                if (f == 4 && cB(a, -2, -2) && cB(b, -1, -1) && cB(d, 1, 1)) {
                    moveDown(form.a);
                    moveDown(form.a);
                    moveLeft(form.a);
                    moveLeft(form.a);
                    moveDown(form.b);
                    moveLeft(form.b);
                    moveUp(form.d);
                    moveRight(form.d);
                    form.changeForm();
                    break;
                }
                break;
        }
    }

    private void removeRows(Pane pane) {
        ArrayList<Node> rects = new ArrayList<Node>();
        ArrayList<Integer> lines = new ArrayList<Integer>();
        ArrayList<Node> newrects = new ArrayList<Node>();
        int full = 0;
        //Check which line is full
        for (int i = 0; i < mesh[0].length; i++) {
            for (int j = 0; j < mesh.length; j++) {
                if (mesh[j][i] == 1) {
                    full++;
                }
            }

            if (full == mesh.length) {
                lines.add(i + lines.size());
            }
            full = 0;
        }
        //Deleting the row
        if (lines.size() > 0) {
            do {
                for (Node node : pane.getChildren()) {
                    if (node instanceof Rectangle) {
                        rects.add(node);
                    }
                }
                score += 50;
                linesNo++;

                //Deleting block on row
                for (Node node : rects) {
                    Rectangle a = (Rectangle) node;
                    if (a.getY() == lines.get(0) * SIZE) {
                        mesh[(int) a.getX() / SIZE][(int) a.getY() / SIZE] = 0;
                        pane.getChildren().remove(node);
                    } else {
                        newrects.add(node);
                    }
                }
                for (Node node : newrects) {
                    Rectangle a = (Rectangle) node;
                    if (a.getY() < lines.get(0) * SIZE) {
                        mesh[(int) a.getX() / SIZE][(int) a.getY() / SIZE] = 0;
                        a.setY(a.getY() + SIZE);
                    }
                }
                lines.remove(0);
                rects.clear();
                newrects.clear();

                for (Node node : pane.getChildren()) {
                    if (node instanceof Rectangle) {
                        rects.add(node);
                    }
                }

                for (Node node : rects) {
                    Rectangle a = (Rectangle) node;
                    try {
                        mesh[(int) a.getX() / SIZE][(int) a.getY() / SIZE] = 1;
                    } catch (ArrayIndexOutOfBoundsException e) {

                    }
                }
                rects.clear();
            } while (lines.size() > 0);
        }
    }

    private void moveDown(Rectangle rect) {
        if (rect.getY() + MOVE < YMAX) {
            rect.setY(rect.getY() + MOVE);
        }
    }

    private void moveRight(Rectangle rect) {
        if (rect.getX() + MOVE <= XMAX - SIZE) {
            rect.setX(rect.getX() + MOVE);
        }
    }

    private void moveLeft(Rectangle rect) {
        if (rect.getX() - MOVE >= 0) {
            rect.setX(rect.getX() - MOVE);
        }
    }

    private void moveUp(Rectangle rect) {
        if (rect.getY() - MOVE > 0) {
            rect.setY(rect.getY() - MOVE);
        }
    }

    public void moveDown(Form form) {
        //moving if down is full
        if (form.a.getY() == YMAX - SIZE || form.b.getY() == YMAX - SIZE || form.c.getY() == YMAX - SIZE
                || form.d.getY() == YMAX - SIZE || moveA(form) || moveB(form) || moveC(form) || moveD(form)) {
            mesh[(int) form.a.getX() / SIZE][(int) form.a.getY() / SIZE] = 1;
            mesh[(int) form.b.getX() / SIZE][(int) form.b.getY() / SIZE] = 1;
            mesh[(int) form.c.getX() / SIZE][(int) form.c.getY() / SIZE] = 1;
            mesh[(int) form.d.getX() / SIZE][(int) form.d.getY() / SIZE] = 1;
            removeRows(group);

            //Creating a new block and adding to the scene
            Form a = nextObj;
            nextObj = Controller.makeRect();
            object = a;
            group.getChildren().addAll(a.a, a.b, a.c, a.d);
            moveOnKeyPress(a);
        }
        //Moving one bloick if down is not full
        if (form.a.getY() + MOVE < YMAX && form.b.getY() + MOVE < YMAX && form.c.getY()
                + MOVE < YMAX && form.d.getY() + MOVE < YMAX) {
            int movea = mesh[(int) form.a.getX() / SIZE][((int) form.a.getY() / SIZE) + 1];
            int moveb = mesh[(int) form.b.getX() / SIZE][((int) form.b.getY() / SIZE) + 1];
            int movec = mesh[(int) form.c.getX() / SIZE][((int) form.c.getY() / SIZE) + 1];
            int moved = mesh[(int) form.d.getX() / SIZE][((int) form.d.getY() / SIZE) + 1];
            if (movea == 0 && movea == moveb && moveb == movec && movec == moved) {
                form.a.setY(form.a.getY() + MOVE);
                form.b.setY(form.b.getY() + MOVE);
                form.c.setY(form.c.getY() + MOVE);
                form.d.setY(form.d.getY() + MOVE);
            }
        }
    }

    private boolean moveA(Form form) {
        return (mesh[(int) form.a.getX() / SIZE][((int) form.a.getY() / SIZE) + 1] == 1);
    }

    private boolean moveB(Form form) {
        return (mesh[(int) form.b.getX() / SIZE][((int) form.b.getY() / SIZE) + 1] == 1);
    }

    private boolean moveC(Form form) {
        return (mesh[(int) form.c.getX() / SIZE][((int) form.c.getY() / SIZE) + 1] == 1);
    }

    private boolean moveD(Form form) {
        return (mesh[(int) form.d.getX() / SIZE][((int) form.d.getY() / SIZE) + 1] == 1);
    }

    private boolean cB(Rectangle rect, int x, int y) {
        boolean yb = false;
        boolean xb = false;
        if (x >= 0) {
            xb = rect.getX() + x * MOVE <= XMAX - SIZE;
        }
        if (x < 0) {
            xb = rect.getX() + x * MOVE >= 0;
        }
        if (y >= 0) {
            yb = rect.getY() + y * MOVE > 0;
        }
        if (y < 0) {
            yb = rect.getY() + y * MOVE < YMAX;
        }
        return xb && mesh[((int) rect.getX() / SIZE) + x][((int) rect.getY() / SIZE) - y] == 0;
    }

    //creating the scene and start the game
    public static void main(String[] args) {
        launch(Tetris.class);
    }
}
