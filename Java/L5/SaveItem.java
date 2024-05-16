import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.Action;
import javafx.scene.Scene;
import java.io.FileWriter;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.input.*;
import javafx.scene.control.*;
/**
 * Class SaveItem is a class that saves the items on the canvas to a file
 * @param scene is a Scene object that is used to get the canvas
 */
public class SaveItem extends MenuItem {
    /**
     * Constructor of the SaveItem class
     * @param scene is a Scene object that is used to get the canvas
     */
    SaveItem(Scene scene){
        super("Save Items");
        Pane canvas = (Pane) scene.lookup("#canvas");
        /**
         * Method that saves the items on the canvas to a file
         */
        setOnAction(new EventHandler<ActionEvent>(){
            /**
             * Method that saves the items on the canvas to a file
             * @param event
             * @throws IOException
             */
            @Override
            public void handle(ActionEvent event){                               
                try {
                    int j=0;
                    File file = new File("Canvas"+j+".txt");
                    if(file.createNewFile()){
                        System.out.println("File created: "+file.getName());
                        
                    }else{
                        while(file.exists()){
                            j++;
                            file = new File("Canvas"+j+".txt");
                        }
                    }
                    
                    FileWriter myWriter = new FileWriter("Canvas"+j+".txt");
                    System.out.println("File created: "+file.getName());
                    try{
                for(int i=0;canvas.getChildren().get(i)!=null;i++){                    
                    if(canvas.getChildren().get(i) instanceof Rectang ){
                        Rectang r = (Rectang) canvas.getChildren().get(i);                                              
                        myWriter.write("r\n");                                                
                        myWriter.write(r.getFill().toString()+"\n");
                        myWriter.write(r.getX()+"\n");
                        myWriter.write(r.getY()+"\n");
                        myWriter.write(r.getScaleX()+"\n");
                        myWriter.write(r.getScaleY()+"\n");
                        myWriter.write(r.getRotate()+"\n");
                        
                        System.out.println("Rectangle");
                    }else if(canvas.getChildren().get(i) instanceof Triangle){
                        Triangle t = (Triangle) canvas.getChildren().get(i);
                        myWriter.write("t\n");
                        myWriter.write(t.getFill()+"\n");
                        myWriter.write(t.getPoints().get(0)+"\n");
                        myWriter.write(t.getPoints().get(1)+"\n");
                        myWriter.write(t.getPoints().get(2)+"\n");
                        myWriter.write(t.getPoints().get(3)+"\n");
                        myWriter.write(t.getPoints().get(4)+"\n");
                        myWriter.write(t.getPoints().get(5)+"\n");
                        myWriter.write(t.getRotate()+"\n");
                        myWriter.write(t.getScaleX()+"\n");
                        myWriter.write(t.getScaleY()+"\n");
                        System.out.println("Triangle");
                    }else if(canvas.getChildren().get(i) instanceof Circles){
                        Circles c = (Circles) canvas.getChildren().get(i);
                        myWriter.write("c\n");
                        myWriter.write(c.getFill()+"\n");
                        myWriter.write(c.getRadius()+"\n");
                        myWriter.write(c.getCenterX()+"\n");
                        myWriter.write(c.getCenterY()+"\n");                        
                        System.out.println("Circle");
                    }                    
                }}catch(Exception e){                }
                myWriter.close();
                } catch (Exception e) {
                System.out.println("An error occurred.");
                //e.printStackTrace();
                }
            }
        });
    }
}
