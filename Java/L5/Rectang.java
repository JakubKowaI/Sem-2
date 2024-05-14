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

public class Rectang extends Rectangle{
    Rectang(Scene scene){
        super(100,50);
        Pane canvas = (Pane) scene.lookup("#canvas");
        Label mousePos = (Label) scene.lookup("#mousePos");
        Label shift = (Label) scene.getRoot().lookup("#shift");
        Label number = (Label) scene.getRoot().lookup("#number1");
        ColorPicker colorPicker = (ColorPicker) scene.lookup("#colorPicker");

        Scale scalePos = new Scale();
        scalePos.setX(1.1);
        scalePos.setY(1.1);
        Scale scaleNeg = new Scale();
        scaleNeg.setX(0.9);
        scaleNeg.setY(0.9);
        Rotate rotatation = new Rotate();

        setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
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
        setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try{
                setX(getWidth()/-2+event.getX());
                setY(getHeight()/-2+event.getY());
                }catch(Exception e){
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
            }
        });

        setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(event.getButton() == MouseButton.PRIMARY){
                    if(mousePos.getText()=="Mouse out of canvas"){
                        try{
                        File file = new File("Shape"+number.getText()+".txt");
                        if(file.createNewFile()){
                            FileWriter myWriter = new FileWriter("Shape"+number.getText()+".txt");
                            myWriter.write("r\n"+getFill()+"\n"+getHeight()+"\n"+getWidth());
                            myWriter.close();
                            System.out.println("File created: " + file.getName());
                            canvas.getChildren().remove(this);
                            setVisible(false);    
                        }else{
                        while (!(file.createNewFile())) {
                            file = new File("Shape"+number.getText()+".txt");
                            System.out.println("File already exists."+ number.getText());
                            number.setText(String.valueOf(Integer.parseInt(number.getText())+1));
                        } 
                        FileWriter myWriter = new FileWriter("Shape"+(Integer.parseInt(number.getText())-1)+".txt");
                        number.setText(String.valueOf(Integer.parseInt(number.getText())+1));
                        myWriter.write("r\n"+getFill()+"\n"+getHeight()+"\n"+getWidth());
                        myWriter.close();
                        System.out.println("File created: " + file.getName());
                        canvas.getChildren().remove(this);
                        setVisible(false);    
                    }
                    }catch(IOException e){
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                    }                        
                    }                                                        
                }                
            }
        });
        
        setOnScroll(new EventHandler<ScrollEvent>() {
            @Override
            public void handle(ScrollEvent event) {
                try{
                if(shift.getText().equals("true")){
                    rotatation.setAngle(rotatation.getAngle() + event.getDeltaY());
                    rotatation.setPivotX(getX()+getWidth()/2);
                    rotatation.setPivotY(getY()+getHeight()/2);
                    getTransforms().add(rotatation);
                }else{
                    scalePos.setPivotX(getX()+getWidth()/2);
                    scalePos.setPivotY(getY()+getHeight()/2);
                    scaleNeg.setPivotX(getX()+getWidth()/2);
                    scaleNeg.setPivotY(getY()+getHeight()/2);
                    if(event.getDeltaY() > 0){
                        getTransforms().add(scalePos);
                    }else{
                        getTransforms().add(scaleNeg);
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
