import java.awt.Label;
import java.awt.TextArea;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.geometry.Insets;


public class WTP extends application{
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public static void start(Stage primaryStage){
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(0, 10, 0, 10));

        TextArea dane = new TextArea();
        Button przycisk = new Button("Licz");
        //Label wynik = new Label();
        grid.add(dane);
        grid.add(przycisk);
        przycisk.setOnAction(new EventHandler<ActionEvent>() { 
            @Override
            public void handle(ActionEvent e) {
            for(int i=0;i<=Integer.parseInt(dane.getText());i++){
                WierszTrojkataPascala w = new WierszTrojkataPascala(i);
                grid.add(new Label(w));
            }            
        dane.setText("");
            }
            });

        primaryStage.setScene(new Scene(grid, 300, 250));
        primaryStage.show();
    }
}
