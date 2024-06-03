import javax.swing.border.Border;
import javafx.application.Application;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.layout.Pane;
import javafx.scene.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.*;
import javafx.event.EventHandler;
import javafx.stage.WindowEvent;
import java.util.Random;

        

public class L6Z1 extends Application{
        static int m=10;
        static int n=10;
        static int k=10;
        static Double p=0.5;
        Random rand = new Random();
    @Override
    public void start(Stage stage) {
        
        
        GridPane area = new GridPane(); 
        Scene scene = new Scene(area, m*50, n*50, Color.WHITESMOKE); 
        int t=0;
        for (int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                Square square = new Square(k,p,rand,i,j,area,m,n);
                square.setId("Square"+t);
                t++;
                area.add(square, i, j);
            }
        }
        try{
        for(int i=0;area.getChildren().get(i)!=null;i++){
            Square temp = (Square)area.getChildren().get(i);
            Thread thread = temp.thread;
            thread.start();
        }
        }catch(Exception e){
            //System.out.println("Error with threads");
        }
        stage.setScene(scene);
        stage.show();

        stage.setOnCloseRequest(new EventHandler<WindowEvent>() 
  {
      public void handle(WindowEvent e){
          System.out.println("end");  
          try {
               System.exit(0);
          } 
          catch (Exception e1) {
               System.out.println(e1.getMessage());
          }
      }
   });
    }
    
    public static void main(String[] args) { 
        try{
            m=Integer.parseInt(args[0]);
            n=Integer.parseInt(args[1]);
            k=Integer.parseInt(args[2]);
            p=Integer.parseInt(args[3])/100.0;
        }catch(Exception e){
            System.out.println("Erorr with arguments");
        }    
        launch(args);
    }
}