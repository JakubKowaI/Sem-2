import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

import java.util.Random;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

class myThread extends Thread{
    Square square;
    boolean exit = false;
    Random rand;

    public myThread(Square squar){
        this.square = squar;
        this.rand = squar.rand;
        try{
        square.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){                                   
                event();            
            }
        });}catch(Exception e){
            System.out.println("Errors with mouse event");
        }
    }

    public synchronized void event(){
        exit=!exit;
                if(!exit)
                notify();
                System.out.println(exit);
    }

    public void run(){
        while(true){
            try{
                if(rand.nextDouble() < square.p){
                    square.setFill(Color.color(rand.nextDouble(), rand.nextDouble(), rand.nextDouble()));
                }else{
                    try{
                        int i=0;
                        while(square.area.getChildren().get(i)){
                            Square temp = (Square)square.area.getChildren().get(i);
                            if(temp.x == square.x && temp.y == square.y){
                                break;
                            }else
                        }
                    }catch(Exception e){
                        System.out.println("Error with searching");
                    }
                }
                try{
                    synchronized(this){
                        while(exit)
                            wait();                    
                        }
                    }catch(Exception e){
                        System.out.println("Error with wait");
                    }
                
                sleep(rand.nextInt(square.k)+(square.k/2));

            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

public class Square extends Rectangle{
    myThread thread;
    int k;
    Double p;
    Random rand;
    int x;
    int y;
    GridPane area;

    public Square(int k, Double p,Random rand,int x, int y, GridPane area){
        super(50,50);
        this.k = k;
        this.p = p;
        this.rand = rand;
        this.x = x;
        this.y = y;
        this.area = area;
        thread = new myThread(this);
        setFill(Color.color(rand.nextDouble(), rand.nextDouble(), rand.nextDouble()));

        
        thread.start();
    }

    
    
}
