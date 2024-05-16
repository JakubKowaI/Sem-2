import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.input.MouseEvent;
import javafx.scene.Scene;
import javafx.scene.input.ScrollEvent;
import javafx.scene.input.*;
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
