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
import javafx.scene.paint.Color;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import static javafx.application.Application.launch;
import javafx.application.Application; 
import javafx.scene.Group; 
import javafx.scene.Scene; 
import javafx.scene.paint.Color; 
import javafx.scene.shape.Rectangle; 
import javafx.scene.transform.Rotate; 
import javafx.scene.transform.Scale; 
import javafx.scene.transform.Translate; 
import javafx.stage.Stage; 
import org.w3c.dom.css.Rect;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.shape.Polygon;
import javafx.scene.input.ScrollEvent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.input.*;

public class L5Z1 extends Application {


    @Override
    public void start(Stage stage) {

        BorderPane root = new BorderPane();
        

        Pane canvas = new Pane();
        ColorPicker colorPicker = new ColorPicker();
        canvas.getChildren().add(colorPicker);
        colorPicker.setVisible(false);

        final Label choice= new Label("");
        final Label shift= new Label("");
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
        Label mousePos = new Label("");
        Label mouseClicked= new Label("");
        canvas.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                mousePos.setText("Mouse position: " + event.getX() + ", " + event.getY());
                
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
                        Circle circle = new Circle(event.getX(), event.getY(), 50);
                        Scale scalePos = new Scale();
                        scalePos.setX(1.1);
                        scalePos.setY(1.1);
                        Scale scaleNeg = new Scale();
                        scaleNeg.setX(0.9);
                        scaleNeg.setY(0.9);
                        Rotate rotatation = new Rotate();

                        circle.setOnMouseClicked(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                if(event.getButton() == MouseButton.SECONDARY){
                                    
                                    colorPicker.relocate(event.getX(), event.getY()-colorPicker.getHeight());
                                    colorPicker.show();
                                    colorPicker.setOnAction(e->{
                                        circle.setFill(colorPicker.getValue());
                                    });                                    
                            }
                            }
                        });
                        circle.setOnMouseDragged(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                circle.setCenterX(event.getX());
                                circle.setCenterY(event.getY());
                            }
                        });

                        circle.setOnScroll(new EventHandler<ScrollEvent>() {
                            @Override
                            public void handle(ScrollEvent event) {
                                if(shift.getText().equals("true")){
                                    rotatation.setAngle(rotatation.getAngle() + event.getDeltaY());
                                    rotatation.setPivotX(circle.getCenterX());
                                    rotatation.setPivotY(circle.getCenterY());
                                    circle.getTransforms().add(rotatation);
                                }else{
                                    scalePos.setPivotX(circle.getCenterX());
                                    scalePos.setPivotY(circle.getCenterY());
                                    scaleNeg.setPivotX(circle.getCenterX());
                                    scaleNeg.setPivotY(circle.getCenterY());
                                if(event.getDeltaY() > 0){

                                    circle.getTransforms().add(scalePos);
                                }else{
                                    circle.getTransforms().add(scaleNeg);
                                }
                            }
                            }
                        });
                        
                        canvas.getChildren().add(circle);
                }else{
                if(choice.getText().equals("t")){
                    
                        Polygon triangle = new Polygon();
                        triangle.getPoints().addAll(new Double[]{
                            event.getX(), event.getY(),
                            event.getX()+30, event.getY()+50,
                            event.getX()-30, event.getY()+50
                        });
                        Scale scalePos = new Scale();
                        scalePos.setX(1.1);
                        scalePos.setY(1.1);
                        Scale scaleNeg = new Scale();
                        scaleNeg.setX(0.9);
                        scaleNeg.setY(0.9);
                        Rotate rotatation = new Rotate();
                        Translate trans = new Translate(0 ,0);

                        triangle.setOnMouseClicked(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                if(event.getButton() == MouseButton.SECONDARY){                                    
                                    colorPicker.relocate(event.getX(), event.getY()-colorPicker.getHeight());
                                    colorPicker.show();
                                    colorPicker.setOnAction(e->{
                                        triangle.setFill(colorPicker.getValue());
                                    });                                    
                            }
                            }
                        });

                        triangle.setOnMouseDragged(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                
                                triangle.getPoints().set(0, event.getX());//Zapytac czemu dziala!!!!
                                triangle.getPoints().set(1, event.getY()-25);
                                triangle.getPoints().set(2, event.getX()+30);
                                triangle.getPoints().set(3, event.getY()+25);
                                triangle.getPoints().set(4, event.getX()-30);
                                triangle.getPoints().set(5, event.getY()+25);
                            }
                        });
                        
                        triangle.setOnScroll(new EventHandler<ScrollEvent>() {
                            @Override
                            public void handle(ScrollEvent event) {
                                if(shift.getText().equals("true")){
                                    rotatation.setAngle(rotatation.getAngle() + event.getDeltaY());
                                    rotatation.setPivotX((triangle.getPoints().get(0)+triangle.getPoints().get(2)+triangle.getPoints().get(4))/3);
                                    rotatation.setPivotY((triangle.getPoints().get(1)+triangle.getPoints().get(3)+triangle.getPoints().get(5))/3);
                                    triangle.getTransforms().add(rotatation);
                                }else{
                                    scalePos.setPivotX((triangle.getPoints().get(0)+triangle.getPoints().get(2)+triangle.getPoints().get(4))/3);
                                    scalePos.setPivotY((triangle.getPoints().get(1)+triangle.getPoints().get(3)+triangle.getPoints().get(5))/3);
                                    scaleNeg.setPivotX((triangle.getPoints().get(0)+triangle.getPoints().get(2)+triangle.getPoints().get(4))/3);
                                    scaleNeg.setPivotY((triangle.getPoints().get(1)+triangle.getPoints().get(3)+triangle.getPoints().get(5))/3);
                                    if(event.getDeltaY() > 0){
                                triangle.getTransforms().add(scalePos);
                            }else{
                                triangle.getTransforms().add(scaleNeg);
                            }
                                }
                            }
                        });

                        canvas.getChildren().add(triangle);
                    }else{
                    if(choice.getText().equals("r")){
                    
                        Rectangle rect = new Rectangle(event.getX(), event.getY(), 50, 100);
                        Scale scalePos = new Scale();
                        scalePos.setX(1.1);
                        scalePos.setY(1.1);
                        Scale scaleNeg = new Scale();
                        scaleNeg.setX(0.9);
                        scaleNeg.setY(0.9);
                        Rotate rotatation = new Rotate();

                        rect.setOnMouseClicked(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                if(event.getButton() == MouseButton.SECONDARY){
                                    
                                    colorPicker.relocate(event.getX(), event.getY()-colorPicker.getHeight());
                                    colorPicker.show();
                                    colorPicker.setOnAction(e->{
                                        rect.setFill(colorPicker.getValue());
                                    });                                    
                            }
                            }
                        });
                        rect.setOnMouseDragged(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                rect.setX(rect.getWidth()/-2+event.getX());
                                rect.setY(rect.getHeight()/-2+event.getY());
                            }
                        });
                        
                        rect.setOnScroll(new EventHandler<ScrollEvent>() {
                            @Override
                            public void handle(ScrollEvent event) {
                                if(shift.getText().equals("true")){
                                    rotatation.setAngle(rotatation.getAngle() + event.getDeltaY());
                                    rotatation.setPivotX(rect.getX()+rect.getWidth()/2);
                                    rotatation.setPivotY(rect.getY()+rect.getHeight()/2);
                                    rect.getTransforms().add(rotatation);
                                }else{
                                    scalePos.setPivotX(rect.getX()+rect.getWidth()/2);
                                    scalePos.setPivotY(rect.getY()+rect.getHeight()/2);
                                    scaleNeg.setPivotX(rect.getX()+rect.getWidth()/2);
                                    scaleNeg.setPivotY(rect.getY()+rect.getHeight()/2);
                                    if(event.getDeltaY() > 0){
                                rect.getTransforms().add(scalePos);
                            }else{
                                rect.getTransforms().add(scaleNeg);
                            }
                                }
                            }
                        });
                        canvas.getChildren().add(rect);
                    }}}
                
                choice.setText("");
                }
        });

        MenuBar mainMenu = new MenuBar();
        Menu menu1 = new Menu("Info");

        MenuItem guide = new MenuItem("Guide");
        guide.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Dialog<String> dialog = new Dialog<String>();
                dialog.setTitle("Guide");
                ButtonType type = new ButtonType("Got it!", ButtonData.CANCEL_CLOSE);
                dialog.setContentText("Use the buttons to spawn shapes\nYou can drag the shapes\nUse the scroll while having cursor on the shape to scale it\nPress the right mouse button to change color\nTo rotate the shape scroll while holding shift\nHave fun!");
                dialog.getDialogPane().getButtonTypes().add(type);
                dialog.showAndWait();
            }
        });

        MenuItem info = new MenuItem("Info");
        info.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Dialog<String> dialog = new Dialog<String>();
                dialog.setTitle("Info");
                ButtonType type = new ButtonType("Now i know!", ButtonData.CANCEL_CLOSE);
                dialog.setContentText("Paint 7D\nBrought to you to show you some shapes\nMade by: Jacob Kowal");
                dialog.getDialogPane().getButtonTypes().add(type);
                dialog.showAndWait();
            }
        });

        VBox sidebar = new VBox(5);
        Button circle = new Button("Circle");
        circle.setOnAction(e->{
            choice.setText("c");
        });
        Button triangle = new Button("Triangle");
        triangle.setOnAction(e->{
            choice.setText("t");
        });
        Button rectangle = new Button("Rectangle");
        rectangle.setOnAction(e->{
            choice.setText("r");
        });
        
        sidebar.getChildren().addAll(circle, triangle, rectangle,mousePos,mouseClicked,shift);
        sidebar.setAlignment(javafx.geometry.Pos.TOP_RIGHT);
        

        root.setRight(sidebar);
        menu1.getItems().addAll(guide, info);
        mainMenu.getMenus().add(menu1);
        root.setTop(mainMenu);
        root.setCenter(canvas);
        Scene scene = new Scene(root, 600, 500, Color.WHITESMOKE);        

        stage.setTitle("Paint 7D");
        stage.setScene(scene);
        stage.show();

    }

    

    public static void main(String[] args) {
        launch(args);
    }
}