import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
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
        Label wynik = new Label();
        BorderPane root = new BorderPane(wynik,dane,null,przycisk,null);
        
        przycisk.setOnAction(new EventHandler<ActionEvent>() { 
            @Override
            public void handle(ActionEvent e) {
                String s="";
            for(int i=1;i<=Integer.parseInt(dane.getText());i++){
                WierszTrojkataPascala w = new WierszTrojkataPascala(i);
                s+=w.wypisz()+ "\n";
            }
            wynik.setText(s);
        dane.setText("");
            }
            });
            wynik.setAlignment(Pos.CENTER);
            Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("WTP");
        primaryStage.show();
    }
}
