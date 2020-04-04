package tetris;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Menu extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        
        GridPane g = new GridPane();
        
        Label title = new Label("         TETRIS");
        g.add(title, 1, 0);
        
        VBox background = new VBox();
        background.getChildren().add(new Label("Background"));
        Button blue = new Button("    Blue    ");
        Button red = new Button("    Red     ");
        Button green = new Button("   Green  ");
        background.getChildren().add(blue);
        background.getChildren().add(red);
        background.getChildren().add(green);
        
        g.add(background, 0, 1);
        
        VBox music = new VBox();
        music.getChildren().add(new Label("Background"));
        Button eightbit = new Button("    8-bit   ");
        Button piano = new Button("    Piano  ");
        Button trumpet = new Button("Trumpet ");
        music.getChildren().add(eightbit);
        music.getChildren().add(piano);
        music.getChildren().add(trumpet);
        
        g.add(music, 2, 1);
        
        Button newgame = new Button("Start new game");
        newgame.setOnAction((event) -> {
          launch(Tetris.class);
      });
        g.add(newgame, 1, 2);

        Scene nakyma = new Scene(g, 500, 500);

        stage.setScene(nakyma);
        stage.show();
    }
    
}
