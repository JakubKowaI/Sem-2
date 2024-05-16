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
/**
 * Class LoadItem is a class that loads the items from a file to the canvas
 * @param scene is a Scene object that is used to get the canvas
 */
public class LoadItem extends MenuItem {
    /**
     * LoadItem is a constructor that loads the items from a file to the canvas
     * @param scene is a Scene object that is used to get the canvas
     */
    LoadItem(Scene scene){
        super("Load Items");
        Pane canvas = (Pane) scene.lookup("#canvas");
        /**
         * setOnAction is a method that loads the items from a file to the canvas
         */
        setOnAction(new EventHandler<ActionEvent>(){
            @Override
            /**
             * handle is a method that loads the items from a file to the canvas
             * @param event
             * @throws FileNotFoundException
             */
            public void handle(ActionEvent event){
                try { 
                    try{
                        while(canvas.getChildren().get(0)!=null)canvas.getChildren().remove(canvas.getChildren().get(0));
                    }catch(Exception e){
                    }
                    
                FileChooser fileDir = new FileChooser(); 
                File file=fileDir.showOpenDialog(null);                
                               
                Scanner reader = new Scanner(file);
                
                    String data=reader.nextLine();
                    //System.out.println(data);
                    try{
                    while(data!=null){
                        
                        System.out.println("|"+data);
                        if(data.equals("c")){                          
                            Circles circle = new Circles(scene);
                            canvas.getChildren().add(circle);
                            circle.setFill(Color.web(reader.nextLine()));
                            circle.setRadius(Double.parseDouble(reader.nextLine()));
                            circle.setCenterX(Double.parseDouble(reader.nextLine()));
                            circle.setCenterY(Double.parseDouble(reader.nextLine()));
                            System.out.println("c");
                        }else if (data.equals("t")) {
                            Triangle triangle = new Triangle(scene);
                            canvas.getChildren().add(triangle); 
                            triangle.setFill(Color.web(reader.nextLine()));
                            triangle.getPoints().addAll(new Double[]{
                                Double.parseDouble(reader.nextLine()), Double.parseDouble(reader.nextLine()),
                                Double.parseDouble(reader.nextLine()), Double.parseDouble(reader.nextLine()),
                                Double.parseDouble(reader.nextLine()), Double.parseDouble(reader.nextLine())
                            });
                            triangle.setRotate(Double.parseDouble(reader.nextLine()));
                            triangle.setScaleX(Double.parseDouble(reader.nextLine()));
                            triangle.setScaleY(Double.parseDouble(reader.nextLine()));
                            System.out.println("t");
                            
                        }else if (data.equals("r")) {
                            Rectang rectangle = new Rectang(scene);
                            canvas.getChildren().add(rectangle);
                            rectangle.setFill(Color.web(reader.nextLine()));
                            rectangle.setX(Double.parseDouble(reader.nextLine()));
                            rectangle.setY(Double.parseDouble(reader.nextLine()));            
                            rectangle.setScaleX(Double.parseDouble(reader.nextLine()));
                            rectangle.setScaleY(Double.parseDouble(reader.nextLine()));
                            rectangle.setRotate(Double.parseDouble(reader.nextLine()));
                            System.out.println("r");
                        }          
                              data=reader.nextLine();
                    }
                    
                }catch(Exception e){}
                reader.close();
                } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
                }
            }
        });
    }
}
