import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.input.MouseEvent;
import javafx.scene.Node;
import javafx.stage.Stage;
import static javafx.application.Application.launch;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.Action;
import javax.swing.plaf.FileChooserUI;
import javax.swing.plaf.LabelUI;
import javafx.stage.FileChooser;
import java.io.FileWriter;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.input.ScrollEvent;
import javafx.scene.input.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.Group;
import javafx.scene.control.CheckBox;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.control.*;
/**
 * Class Circles is a class that creates a circle object
 */
public class Circles extends Circle{
    /**
     * Constructor of the Circles class
     * @param scene
     */
    Circles(Scene scene){
        super(50);
        Pane canvas = (Pane) scene.lookup("#canvas");
        Label mousePos = (Label) scene.lookup("#mousePos");
        Label shift = (Label) scene.getRoot().lookup("#shift");
        Label number = (Label) scene.getRoot().lookup("#number1");
        ColorPicker colorPicker = (ColorPicker) scene.lookup("#colorPicker");
        /**
         * setOnMouseClicked is a method that sets the action of the right mouse button click in order to change the color of the shape
         */
        setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            /**
             * handle is a method that sets the action of the right mouse button click in order to change the color of the shape
             * @param event
             * @throws Exception
             */
            public void handle(MouseEvent event) {
                try{
                if(event.getButton() == MouseButton.SECONDARY){                    
                    colorPicker.relocate(event.getX(), event.getY()-colorPicker.getHeight());
                    colorPicker.show();
                    colorPicker.setOnAction(e->{
                        setFill(colorPicker.getValue());
                    });                                    
                }
                }catch(Exception e){
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
            }
        });
        /**
         * setOnMouseDragged is a method that sets the action of the mouse drag in order to move the shape
         */
        setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            /**
             * handle is a method that sets the action of the mouse drag in order to move the shape
             * @param event
             * @throws Exception
             */
            public void handle(MouseEvent event) {
                try{
                    if(event.getSceneX()<=canvas.getWidth() && event.getSceneY()<=canvas.getHeight()){
                        mousePos.setText("Mouse position: " + event.getSceneX() + ", " + event.getSceneY());  
                    }else{
                        mousePos.setText("Mouse out of canvas");
                    }    

                setCenterX(event.getX());
                setCenterY(event.getY());
                }catch(Exception e){
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
            }
        });
        /**
         * setOnScroll is a method that sets the action of the mouse scroll in order to change the radius of the shape
         */
        setOnScroll(new EventHandler<ScrollEvent>() {
            @Override
            /**
             * handle is a method that sets the action of the mouse scroll in order to change the radius of the shape
             * @param event
             * @throws Exception
             */
            public void handle(ScrollEvent event) {
                try{
                if(shift.getText().equals("true")){
                    
                }else{
                    
                if(event.getDeltaY() > 0){
                    setRadius(getRadius()+event.getDeltaY());
                }else{
                    setRadius(getRadius()+event.getDeltaY());
                }
                }
            }catch(Exception e){
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            }
        });
    }
}
