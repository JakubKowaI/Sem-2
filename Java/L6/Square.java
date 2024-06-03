import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.layout.GridPane;
import java.util.Random;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

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

    public myThread(Square squar){
        this.square = squar;
        this.rand = squar.rand;
        this.m = squar.m;
        this.n = squar.n;
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
        int i=0;
        try{
            
        for(;square.area.getChildren().get(i)!=null;i++){
            Square temp = (Square)square.area.getChildren().get(i);
            try{
            if(temp.x == square.x-1 && temp.y == square.y){
                left = temp;
                //System.out.println(square.getId()+"left hit");
            }else if(temp.x == square.x+1 && temp.y == square.y){
                right = temp;
                //System.out.println("right hit");
            }else if(temp.x == square.x && temp.y == square.y-1){
                down = temp;
                //System.out.println("down hit");
            }else if(temp.x == square.x && temp.y == square.y+1){
                up = temp;
                //System.out.println("up hit");
            }
            if(square.x == 0&&left==null){
                //System.out.println("1 x: "+temp.x+" y: "+temp.y+ " "+square.getId());
                if(temp.x == m-1&&temp.y == square.y){
                    left = temp;
                    //System.out.println("left side hit");
                }
            }
            if(square.x == m-1&&right==null){
                //System.out.println("2 x: "+temp.x+" y: "+temp.y+ " x: "+square.x +" y: "+square.y+" "+square.getId());

                if(temp.x == 0&&temp.y == square.y){
                    right = temp;
                    //System.out.println("right side hit");
                }
            }
            if(square.y == 0&&down==null){
                //System.out.println("3 x: "+temp.x+" y: "+temp.y+ " "+square.getId());
                if(temp.x == square.x&&temp.y == n-1){
                    down = temp;
                    //System.out.println("down side hit");
                }
            }
            if(square.y == n-1&&up==null){
                //System.out.println("4 x: "+temp.x+" y: "+temp.y+ " "+square.getId());
                if(temp.x == square.x&&temp.y == 0){
                    up = temp;
                    //System.out.println("up side hit");
                }
            }
            }catch(Exception e){
                System.out.println("Error with searching neighbors");
            }
            /*if(left!=null&&right!=null&&up!=null&&down!=null){
                System.out.println("All neighbors found "+ square.getId());
                break;
            }*/            
        }
        }catch(Exception e){
            System.out.println(e.getMessage()+ " i: "+i+" " + square.getId());
        }
        while(true){
            System.out.println(square.getId()+" start");
            try{
                if((rand.nextDouble()%1.0) < square.p){
                    square.setFill(Color.color(rand.nextDouble(), rand.nextDouble(), rand.nextDouble()));
                }else{
                    try{
                        myThread threadLeft = left.thread;
                        myThread threadRight = right.thread;
                        myThread threadUp = up.thread;
                        myThread threadDown = down.thread;
                        int t=1;
                        if(threadLeft.exit==false){
                            left.thread.join();
                            //color = color.add(left.getFill());
                            if(t!=1)t++;
                        }
                        if(threadRight.exit==false){
                            right.thread.join();
                            //color = color.add(right.getFill());
                            if(t!=1)t++;
                        }
                        if(threadUp.exit==false){
                            up.thread.join();
                            //color = color.add(up.getFill());
                            if(t!=1)t++;
                        }
                        if(threadDown.exit==false){
                            down.thread.join();
                            //color = color.add(down.getFill());
                            if(t!=1)t++;
                        }
                        //color = color/(t+1);
                        //square.setFill(color);
                    }catch(Exception e){
                        System.out.println(e.getMessage());
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
                System.out.println(e.getMessage());
            }
            System.out.println(square.getId()+" end");
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
    int m;
    int n;

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

        
        //thread.start();
    }

    
    
}
