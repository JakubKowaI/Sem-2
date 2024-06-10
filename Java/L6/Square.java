import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.layout.GridPane;
import java.util.Random;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
/**
 * Class that creates a thread in a square
 */
class myThread extends Thread{
    Square square;
    Square left;
    Square right;
    Square up;
    Square down;
    boolean exit = false;
    Random rand;
    int m;
    int n;
    /**
     * Constructor that creates a thread in a square
     * @param squar
     */
    public myThread(Square squar){
        this.square = squar;
        this.rand = squar.rand;
        this.m = squar.m;
        this.n = squar.n;
        try{
            /**
             * Method that handles the mouse event stopping the thread
             */
        square.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){                                   
                event();            
            }
        });}catch(Exception e){
            System.out.println("Errors with mouse event");
        }
    }
    /**
     * Method that stops the thread
     */
    public synchronized void event(){
        exit=!exit;
                if(!exit)
                notify();
                System.out.println(exit);
    }
    /**
     * Method that runs the thread
     */
    public void run(){
        int i=0;
        /**
         * Method that searches for the neighbors of the square
         */
        try{            
        for(;square.area.getChildren().get(i)!=null;i++){
            Square temp = (Square)square.area.getChildren().get(i);
            try{
            if(temp.x == square.x-1 && temp.y == square.y){
                left = temp;
            }else if(temp.x == square.x+1 && temp.y == square.y){
                right = temp;
            }else if(temp.x == square.x && temp.y == square.y-1){
                down = temp;
            }else if(temp.x == square.x && temp.y == square.y+1){
                up = temp;
            }
            if(square.x == 0&&left==null){
                if(temp.x == m-1&&temp.y == square.y){
                    left = temp;
                }
            }
            if(square.x == m-1&&right==null){

                if(temp.x == 0&&temp.y == square.y){
                    right = temp;
                }
            }
            if(square.y == 0&&down==null){
                if(temp.x == square.x&&temp.y == n-1){
                    down = temp;
                }
            }
            if(square.y == n-1&&up==null){
                if(temp.x == square.x&&temp.y == 0){
                    up = temp;
                }
            }
            }catch(Exception e){
                System.out.println("Error with searching neighbors");
            }
        }
        }catch(Exception e){
            System.out.println(e.getMessage()+ " i: "+i+" " + square.getId());
        }
        /**
         * Method that changes the color of the square
         */
        while(true){
            System.out.println(square.getId()+" start");
            try{
                /**
                 * Method that stops the thread
                 */
                try{
                    synchronized(this){
                        while(exit)
                            wait();                    
                        }
                    }catch(Exception e){
                        System.out.println("Error with wait");
                    }
                if((rand.nextDouble()%1.0) <= square.p){
                    square.setFill(Color.color(rand.nextDouble(), rand.nextDouble(), rand.nextDouble()));
                }else{
                    try{
                        synchronized(square.area){
                        myThread threadLeft = left.thread;
                        myThread threadRight = right.thread;
                        myThread threadUp = up.thread;
                        myThread threadDown = down.thread;

                        Double r=0.0;
                        Double g=0.0;
                        Double b=0.0;
                        int t=1;
                        if(threadLeft.exit==false){
                            Color leftColor = (Color) left.getFill();
                            r+=leftColor.getRed();
                            g+=leftColor.getGreen();
                            b+=leftColor.getBlue();
                            if(t<=4)t++;
                        }
                        if(threadRight.exit==false){
                            Color rightColor = (Color) right.getFill();
                            r+=rightColor.getRed();
                            g+=rightColor.getGreen();
                            b+=rightColor.getBlue();
                            if(t<=4)t++;
                        }
                        if(threadUp.exit==false){
                            Color upColor = (Color) up.getFill();
                            r+=upColor.getRed();
                            g+=upColor.getGreen();
                            b+=upColor.getBlue();
                            if(t<=4)t++;
                        }
                        if(threadDown.exit==false){
                            Color downColor = (Color) down.getFill();
                            r+=downColor.getRed();
                            g+=downColor.getGreen();
                            b+=downColor.getBlue();
                            if(t<=4)t++;
                        }
                        r=r/t;
                        g=g/t;
                        b=b/t;
                        square.setFill(Color.color(r,g,b));
                    }
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                }
                
                
                sleep(rand.nextInt(square.k)+(square.k/2));

            }catch(InterruptedException e){
                System.out.println(e.getMessage());
            }
            System.out.println(square.getId()+" end");
        }
    }
}
/**
 * Class that creates a square with a thread and extends a rectangle 
 */
public class Square extends Rectangle{
    myThread thread;
    int k;
    Double p;
    Random rand;
    int x;
    int y;
    GridPane area;
    int m;
    int n;
    /**
     * Constructor that creates a square with a thread
     * @param k
     * @param p
     * @param rand
     * @param x
     * @param y
     * @param area
     * @param m
     * @param n
     */
    public Square(int k, Double p,Random rand,int x, int y, GridPane area,int m, int n){
        super(50,50);
        this.k = k;
        this.p = p;
        this.rand = rand;
        this.x = x;
        this.y = y;
        this.area = area;
        this.m=m;
        this.n=n;
        thread = new myThread(this);
        setFill(Color.color(rand.nextDouble(), rand.nextDouble(), rand.nextDouble()));        
    }    
}
