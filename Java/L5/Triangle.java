import javafx.scene.layout.Pane;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.scene.control.ColorPicker;
import javafx.event.EventHandler;
import javafx.scene.shape.Polygon;
import javafx.scene.input.ScrollEvent;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.*;
/**
 * Class Triangle is a class that creates a triangle object
 * @param scene 
 */
public class Triangle extends Polygon{
    /**
     * Constructor of the Triangle class
     * @param scene
     */
    Triangle(Scene scene){
        super();
        Pane canvas = (Pane) scene.lookup("#canvas");
        Label mousePos = (Label) scene.lookup("#mousePos");
        Label shift = (Label) scene.getRoot().lookup("#shift");
        Label number = (Label) scene.getRoot().lookup("#number1");
        ColorPicker colorPicker = (ColorPicker) scene.lookup("#colorPicker");
        /**
         * setOnMouseClicked is a method that sets the action of the right mouse button click in order to change color of the shape
         */
        setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            /**
             * Method that sets the action of the right mouse button click in order to change color of the shape
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
             * Method that sets the action of the mouse drag in order to move the shape
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
                
                getPoints().set(0, event.getX());//Zapytac czemu dziala!!!!
                getPoints().set(1, event.getY()-25);
                getPoints().set(2, event.getX()+30);
                getPoints().set(3, event.getY()+25);
                getPoints().set(4, event.getX()-30);
                getPoints().set(5, event.getY()+25);
                }catch(Exception e){
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
            }
        });
        /**
         * setOnScroll is a method that sets the action of the scroll in order to zoom in and out the shape
         */
        setOnScroll(new EventHandler<ScrollEvent>() {
            @Override
            /**
             * Method that sets the action of the scroll in order to zoom in and out the shape
             * @param event
             * @throws Exception
             */
            public void handle(ScrollEvent event) {
                try{
                if(shift.getText().equals("true")){
                    setRotate(getRotate()+event.getDeltaY());
                }else{                    
                    if(event.getDeltaY() > 0){
                setScaleX(getScaleX()*1.1);
                setScaleY(getScaleY()*1.1);
            }else{
                setScaleX(getScaleY()*0.9);
                setScaleY(getScaleY()*0.9);
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
