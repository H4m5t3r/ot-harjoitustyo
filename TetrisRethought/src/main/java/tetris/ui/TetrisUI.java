
package tetris.ui;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import tetris.domain.Controller;
import tetris.domain.Form;
import tetris.domain.Tetris;

public class TetrisUI extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        Tetris tetris = new Tetris();
        Pane group = new Pane();
        Form object;
        Scene scene = new Scene(group, tetris.xmax + 150, tetris.ymax);
        Form nextObj = tetris.controller.makeRect();
        Line line = new Line(tetris.xmax, 0, tetris.xmax, tetris.ymax);
        Text scoretext = new Text("Score: ");
        scoretext.setStyle("-fx-font: 20 arial;");
        scoretext.setY(50);
        scoretext.setX(tetris.xmax + 5);
        Text level = new Text("Lines: ");
        level.setStyle("-fx-font: 20 arial;");
        level.setY(100);
        level.setX(tetris.xmax + 5);
        level.setFill(Color.GREEN);
        group.getChildren().addAll(scoretext, line, level);
        
        //Creating the first block and the stage
        Form a = nextObj;
        group.getChildren().addAll(a.a, a.b, a.c, a.d);
        moveOnKeyPress(a, scene, tetris);
        object = a;
        nextObj = tetris.controller.makeRect();
        
        stage.setScene(scene);
        stage.show();
    }
    
    private void moveOnKeyPress(Form form, Scene scene, Tetris tetris) {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                case RIGHT:
                    tetris.controller.moveRight(form, tetris.mesh);
                    break;
                case DOWN:
                    tetris.moveDown(form);
                    tetris.score++;
                    break;
                case LEFT:
                    tetris.controller.moveLeft(form, tetris.mesh);
                    break;
                case UP:
                    tetris.moveTurn(form);
                    break;
                }
            }
        });
    }
}
