
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
import static javafx.application.Application.launch;

class Form {
    Rectangle a;
    Rectangle b;
    Rectangle c;
    Rectangle d;
    Color color;
    private String name;
    public int form = 1;
    
    public Form(Rectangle a, Rectangle b, Rectangle c, Rectangle d){
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    public Form(Rectangle a, Rectangle b, Rectangle c, Rectangle d, String name){
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.name = name;
    
    
    //set the color of the polygons
    switch (name) {
        case "j":
            color = Color.SLATEGRAY;
        case "l":
            color = Color.DARKGOLDENROD;
        case "o":
            color = Color.INDIANRED;
        case "s":
            color = Color.FORESTGREEN;
        case "t":
            color = Color.CADETBLUE;
        case "z":
            color = Color.HOTPINK;
        case "i":
            color = Color.SANDYBROWN;
        
        
        }
    this.a.setFill(color);
    this.b.setFill(color);
    this.c.setFill(color);
    this.d.setFill(color);
    }
    
    //getters
    public String getName(){
        return name;
    }
    
    public void changeForm(){
        if (form != 4){
            form++;
        }
        else{
            form = 1;
        }
    }
}
