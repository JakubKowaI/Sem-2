import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;


public class WTP extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        

        TextArea dane = new TextArea();
        Button przycisk = new Button("Licz");
        //Label wynik = new Label();
        VBox box = new VBox();
        BorderPane root = new BorderPane();
        root.setTop(dane);
        root.setCenter(przycisk);
        root.setBottom(box);
        box.setAlignment(Pos.CENTER);
        dane.setPromptText("Podaj liczbe wierszy");
        dane.setPrefSize(200, 20);
        przycisk.setPrefSize(200, 20);
        
        
        
        przycisk.setOnAction(new EventHandler<ActionEvent>() { 
            @Override
            public void handle(ActionEvent e) {
                try{
                    if(Integer.parseInt(dane.getText())<0)throw new Exception();
                String s="";
                box.getChildren().clear();

            for(int i=0;i<=Integer.parseInt(dane.getText());i++){
                WierszTrojkataPascala w = new WierszTrojkataPascala(i);
                box.getChildren().add(new Label(w.wypisz()));
            }
            
        dane.setText("");
        dane.setPromptText("Podaj liczbe wierszy");
        primaryStage.sizeToScene();
                }catch(Exception ex)
                {
                    dane.setText("");
                    dane.setPromptText("Błedne dane! Podaj liczbe wierszy");
                }
            }            
            });
            //wynik.setAlignment(Pos.CENTER);
            Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("WTP");
        primaryStage.show();
    }
}
