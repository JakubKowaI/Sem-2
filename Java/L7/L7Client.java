import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Optional;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.border.Border;
import javax.swing.plaf.ComboBoxUI;
import javafx.event.ActionEvent;
import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.layout.Pane;
import javafx.scene.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.*;
import javafx.event.EventHandler;
import javafx.stage.WindowEvent;
import javafx.geometry.Pos;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ChoiceBox;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;


class listener extends Thread {
    Socket socket;
    Tree<Integer> treeIntClient = new Tree<Integer>();
    Tree<Double> treeDoubleClient = new Tree<Double>();
    Tree<String> treeStringClient = new Tree<String>();
    Pane pane;

    listener(Socket socket,Pane pane) {
        this.socket = socket;
        this.pane = pane;
    }
    
    public void run() {
        try {
            InputStream input = socket.getInputStream();
            BufferedReader inting = new BufferedReader(new InputStreamReader(input));
            String line = inting.readLine();               
            while(!line.equals("end")){
            do{
                line = inting.readLine();
                if(line.contains("Integer")){
                    if(line.contains("start Integer"))
                        treeIntClient= new Tree<Integer>();
                    else
                        treeIntClient.insert(Integer.parseInt(line.replace("Integer ", "")));
                    }
                if(line.contains("Double")){
                    if(line.contains("start Double"))
                    treeDoubleClient= new Tree<Double>();
                    else
                    treeDoubleClient.insert(Double.parseDouble(line.replace("Double ", "")));
                }
                if(line.contains("String")){
                    if(line.contains("start String"))
                    treeStringClient= new Tree<String>();
                    else
                    treeStringClient.insert(line.replace("String ", ""));
                }
                if(!line.contains("finish")&&!line.contains("start"))
                System.out.println(line);
            } while (!line.equals("finish"));
        }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
/**
 * Main class of the program
 * @param m number of rows
 * @param n number of columns
 * @param k time of waiting
 * @param p probability of changing color
 */
public class L7Client extends Application{
        /**
         * Method that creates the grid of squares and starts the threads
         * @param stage
         */

         

    @Override
    public void start(Stage stage) {    
        Pane pane = new Pane();
        BorderPane root = new BorderPane(); 
        HBox topBar = new HBox();
        topBar.setAlignment(Pos.CENTER);
        ChoiceBox<String> choiceBox = new ChoiceBox<String>();
        choiceBox.getItems().addAll("Integer","Double","String");
        topBar.getChildren().add(choiceBox);
        root.setTop(topBar);
        try {
      Socket socket = new Socket("localhost", 4444);
      // Wysylanie do serwera
      listener listen = new listener(socket,pane);
      OutputStream output = socket.getOutputStream();
      PrintWriter outing = new PrintWriter(output, true);

      // Odbieranie z serwera
      InputStream input = socket.getInputStream();
      BufferedReader inting = new BufferedReader(new InputStreamReader(input));
    
        Button searchButton = new Button("Search");
        searchButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TextInputDialog dialog = new TextInputDialog();
                dialog.setTitle("Search");
                dialog.setContentText("Type the thing you want to search for: ");
                Button searchButton = (Button) dialog.getDialogPane().lookupButton(ButtonType.OK);
                searchButton.setText("Search!");
                dialog.showAndWait().ifPresent(string -> {
                    System.out.println("Search " +choiceBox.getValue()+" "+ string);
                    outing.println("Search " +choiceBox.getValue()+" "+ string);
                });
            }
        });
        Button insertButton = new Button("Insert");
        insertButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TextInputDialog dialog = new TextInputDialog();
                dialog.setTitle("Insert");
                dialog.setContentText("Type the thing you want to insert: ");
                Button searchButton = (Button) dialog.getDialogPane().lookupButton(ButtonType.OK);
                searchButton.setText("Insert!");
                dialog.showAndWait().ifPresent(string -> {
                    System.out.println("Insert " +choiceBox.getValue()+" "+ string);
                    outing.println("Insert " +choiceBox.getValue()+" "+ string);
                });
            }
        });
        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TextInputDialog dialog = new TextInputDialog();
                dialog.setTitle("Delete");
                dialog.setContentText("Type the thing you want to delete: ");
                Button searchButton = (Button) dialog.getDialogPane().lookupButton(ButtonType.OK);
                searchButton.setText("Delete!");
                dialog.showAndWait().ifPresent(string -> {
                    System.out.println("Delete " +choiceBox.getValue()+" "+ string);
                    outing.println("Delete " +choiceBox.getValue()+" "+ string);
                });                
            }
        });
        Button drawButton = new Button("Draw");
        
        drawButton.setOnAction(new EventHandler<ActionEvent>() {            
            @Override
            public void handle(ActionEvent event) {
                pane.getChildren().clear();
                if(choiceBox.getValue().equals("Integer")){
                    if(listen.treeIntClient.root!=null){
                        Circle circle = new Circle(20);
                        Text text = new Text(listen.treeIntClient.root.key.toString());
                        circle.setCenterX(pane.getWidth()/2);
                        circle.setCenterY(pane.getHeight()/2);
                        text.setX(pane.getWidth()/2);
                        text.setY(pane.getHeight()/2);
                        text.setFill(Color.WHITE);
                        Line lineLeft = new Line();
                        Line lineRight = new Line();
                        if(listen.treeIntClient.root.left!=null)lineLeft = new Line(circle.getCenterX(), circle.getCenterY(), circle.getCenterX()-50, circle.getCenterY()-50);
                        if(listen.treeIntClient.root.right!=null)lineRight = new Line(circle.getCenterX(), circle.getCenterY(), circle.getCenterX()+50, circle.getCenterY()-50);
                        pane.getChildren().addAll(circle,lineLeft,lineRight,text);
                        listen.treeIntClient.drawCircle(listen.treeIntClient.root.left, circle.getCenterX()-50, circle.getCenterY()-50,pane);
                        listen.treeIntClient.drawCircle(listen.treeIntClient.root.right, circle.getCenterX()+50, circle.getCenterY()-50,pane);
                    }
                }
                if(choiceBox.getValue().equals("Double")){
                    if(listen.treeDoubleClient.root!=null){
                        Circle circle = new Circle(20);
                        Text text = new Text(listen.treeDoubleClient.root.key.toString());
                        circle.setCenterX(pane.getWidth()/2);
                        circle.setCenterY(pane.getHeight()/2);
                        text.setX(pane.getWidth()/2);
                        text.setY(pane.getHeight()/2);
                        text.setFill(Color.WHITE);
                        Line lineLeft = new Line();
                        Line lineRight = new Line();
                        if(listen.treeDoubleClient.root.left!=null)lineLeft = new Line(circle.getCenterX(), circle.getCenterY(), circle.getCenterX()-50, circle.getCenterY()-50);
                        if(listen.treeDoubleClient.root.right!=null)lineRight = new Line(circle.getCenterX(), circle.getCenterY(), circle.getCenterX()+50, circle.getCenterY()-50);
                        pane.getChildren().addAll(circle,lineLeft,lineRight,text);
                        listen.treeDoubleClient.drawCircle(listen.treeDoubleClient.root.left, circle.getCenterX()-50, circle.getCenterY()-50,pane);
                        listen.treeDoubleClient.drawCircle(listen.treeDoubleClient.root.right, circle.getCenterX()+50, circle.getCenterY()-50,pane);
                    }
                }
                if(choiceBox.getValue().equals("String")){
                    if(listen.treeStringClient.root!=null){
                        Circle circle = new Circle(20);
                        Text text = new Text(listen.treeStringClient.root.key);
                        circle.setCenterX(pane.getWidth()/2);
                        circle.setCenterY(pane.getHeight()/2);
                        text.setX(pane.getWidth()/2);
                        text.setY(pane.getHeight()/2);
                        text.setFill(Color.WHITE);
                        Line lineLeft = new Line();
                        Line lineRight = new Line();
                        if(listen.treeStringClient.root.left!=null)lineLeft = new Line(circle.getCenterX(), circle.getCenterY(), circle.getCenterX()-50, circle.getCenterY()-50);
                        if(listen.treeStringClient.root.right!=null)lineRight = new Line(circle.getCenterX(), circle.getCenterY(), circle.getCenterX()+50, circle.getCenterY()-50);
                        pane.getChildren().addAll(circle,lineLeft,lineRight,text);
                        listen.treeStringClient.drawCircle(listen.treeStringClient.root.left, circle.getCenterX()-50, circle.getCenterY()-50,pane);
                        listen.treeStringClient.drawCircle(listen.treeStringClient.root.right, circle.getCenterX()+50, circle.getCenterY()-50,pane);
                    }
                }
                    
                
            }
        });
        
        root.setCenter(pane);
        topBar.getChildren().addAll(searchButton, insertButton, deleteButton, drawButton);

        Scene scene = new Scene(root, 1000, 500, Color.WHITESMOKE);
        
        stage.setScene(scene);
        stage.show();
        
        listen.start();
        
        /**
         * Method that closes the program
         */
        stage.setOnCloseRequest(new EventHandler<WindowEvent>(){
        public void handle(WindowEvent e){
            System.out.println("end");  
            try {
                outing.println("end");
                socket.close();
                System.exit(0);
            } 
            catch (Exception e1) {
                System.out.println(e1.getMessage());
            }
        }
        });
    }
    catch (UnknownHostException e) {
       System.out.println("Unknown host: localhost"); System.exit(1);
     }
     catch  (IOException e) {
       System.out.println("No I/O"); System.exit(1);
     }
    }
    /**
     * Main method that starts the program
     * @param args
     */
    public static void main(String[] args) {  
        launch(args);
    }
}