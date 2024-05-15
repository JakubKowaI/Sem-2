import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.Node;
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

public class L5Z1 extends Application {


    @Override
    public void start(Stage stage) {

        BorderPane root = new BorderPane();
        Pane canvas = new Pane();
        canvas.setId("canvas");
        canvas.setStyle("-fx-background-color: #FFFFFF;");
        canvas.setMinWidth(800);
        canvas.setMinHeight(500);
        ColorPicker colorPicker = new ColorPicker();
        canvas.getChildren().add(colorPicker);
        colorPicker.setVisible(false);
        colorPicker.setId("colorPicker");
        VBox sidebar = new VBox(5);        
        sidebar.setMaxWidth(200);
        sidebar.setMinWidth(200);
        MenuBar mainMenu = new MenuBar();
        Menu menu1 = new Menu("Info");
        Menu load = new Menu("Load");
        Guide guide = new Guide();
        final Label choice= new Label("");
        final Label shift= new Label("false");
        shift.setId("shift");
        shift.setVisible(false);
        final Label number = new Label("0");
        number.setId("number1");
        number.setVisible(false);
        Label mousePos = new Label("");
        mousePos.setId("mousePos");
        mousePos.setVisible(true);
        Label mouseClicked= new Label("");
        mouseClicked.setVisible(false);
        Info info = new Info();
        Button circleBtn = new Button("Circle");
        circleBtn.setMaxWidth(100);
        Button triangleBtn = new Button("Triangle");
        triangleBtn.setMaxWidth(100);
        Button rectangleBtn = new Button("Rectangle");
        rectangleBtn.setMaxWidth(100);
        Scene scene = new Scene(root, 1000, 500, Color.WHITESMOKE);
        root.setTop(mainMenu);
        root.setCenter(canvas);
        root.setRight(sidebar);       
        LoadItem loadItem = new LoadItem(scene);
        SaveItem saveItem = new SaveItem(scene);

        root.setOnKeyPressed(e->{
            if(e.isShiftDown()){
                shift.setText("true");
            }else{
                shift.setText("false");
            }
        });

        root.setOnKeyReleased(e->{
            if(e.isShiftDown()){
                shift.setText("true");
            }else{
                shift.setText("false");
            }
        });        

        sidebar.setOnMouseMoved(e->{
            mousePos.setText("Mouse out of canvas");
        });

        canvas.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(event.getSceneX()<=canvas.getWidth() && event.getSceneY()<=canvas.getHeight()){
                    mousePos.setText("Mouse position: " + event.getSceneX() + ", " + event.getSceneY());   
                }                                       
            }
        });
        canvas.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                mousePos.setText("Mouse out of canvas");
            }
        });
        canvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                mouseClicked.setText("Mouse clicked at: " + event.getX() + ", " + event.getY());
                
                if(choice.getText().equals("c")){
                        Circles circle = new Circles(scene);
                        circle.setCenterX(event.getX());
                        circle.setCenterY(event.getY());                     
                        canvas.getChildren().add(circle);
                        number.setText(Integer.toString(Integer.parseInt(number.getText())+1));
                }else{
                if(choice.getText().equals("t")){                    
                        Triangle triangle = new Triangle(scene);
                        triangle.getPoints().addAll(new Double[]{
                            event.getX(), event.getY(),
                            event.getX()+30, event.getY()+50,
                            event.getX()-30, event.getY()+50
                        });

                        canvas.getChildren().add(triangle);                        
                    }else{
                    if(choice.getText().equals("r")){
                        Rectang rectangle = new Rectang(scene);
                        canvas.getChildren().add(rectangle);
                        rectangle.setX(event.getX());
                        rectangle.setY(event.getY());
                    }}}                
                choice.setText("");
                }
        });

        circleBtn.setOnAction(e->{
            choice.setText("c");
        });
        
        triangleBtn.setOnAction(e->{
            choice.setText("t");
        });
        
        rectangleBtn.setOnAction(e->{
            choice.setText("r");
        });        
        
        sidebar.getChildren().addAll(circleBtn, triangleBtn, rectangleBtn,mousePos,mouseClicked,shift,number);
        sidebar.setAlignment(javafx.geometry.Pos.TOP_RIGHT);
        
        menu1.getItems().addAll(guide, info);
        load.getItems().addAll(loadItem,saveItem);
        mainMenu.getMenus().addAll(menu1,load);

        stage.setTitle("Paint 7D");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}