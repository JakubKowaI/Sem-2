//import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import javafx.scene.layout.Pane;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import java.lang.reflect.Type;
import javafx.scene.shape.Line;

class element<Typ extends Comparable<Typ>> {
    Typ key;
    element<Typ> left;
    element<Typ> right;
    element(Typ key)
    {
      this.key = key;
      left = null;
      right = null;
    }
  }
  
  public class Tree<Typ extends Comparable<Typ>> {
    public element<Typ> root;
    public Tree() { root = null; }
    public void insert(Typ key) {root = treeInsert(key, root);}
    private element<Typ> treeInsert(Typ key, element<Typ> temp) {
      if( temp==null ) return new element<Typ>(key);
      if( key.compareTo(temp.key)<0 ) 
        temp.left = treeInsert(key, temp.left);
      else if( key.compareTo(temp.key)>0)
        temp.right = treeInsert(key, temp.right);
      return temp;
    }
    public boolean search(Typ key) { return treeSearch(key,root); }
    private boolean treeSearch(Typ key, element<Typ> temp) {
      if( temp==null ) return false;
      if( key.compareTo(temp.key)==0 ) return true;
      if( key.compareTo(temp.key)<0) 
        return treeSearch(key, temp.left);
      else
        return treeSearch(key, temp.right);
    }
    public void draw(PrintWriter outing) {
        String type = root.key.getClass().getName();
        if(type == "java.lang.Integer") {
            outing.println("start Integer");
        }
        if(type == "java.lang.Double") {
            outing.println("start Double");
        }
        if(type == "java.lang.String") {
            outing.println("start String");
        }
       treeDraw(root,outing); 
       outing.println("finish");
      }
    private Boolean treeDraw(element<Typ> temp,PrintWriter outing) { 
      if( temp!=null ){
        String type = temp.key.getClass().getName();
        if(type == "java.lang.Integer") {
            outing.println("Integer "+temp.key);
        }
        if(type == "java.lang.Double") {
            outing.println("Double "+temp.key);
        }
        if(type == "java.lang.String") {
            outing.println("String "+temp.key);
        }
        
        treeDraw(temp.left,outing);
        treeDraw(temp.right,outing);
        return false;
      }
      return false;
    }
    public void delete(Typ key) { root = treeDelete(key, root); }
    private element<Typ> treeDelete(Typ key, element<Typ> temp) {
      if( temp==null ) return null;
      if( key.compareTo(temp.key)<0 ) 
        temp.left = treeDelete(key, temp.left);
      else if( key.compareTo(temp.key)>0)
        temp.right = treeDelete(key, temp.right);
      else {
        if( temp.left==null ) return temp.right;
        if( temp.right==null ) return temp.left;
        if(findMin(temp).right==null){
            temp.key = findMin(temp).key;
            temp.left = treeDelete(temp.key, temp.left);
        }
        else{
            temp.key = findMin(temp.right).key;
            temp.right = treeDelete(temp.key, temp.right);
        }
      }
      return temp;
    }
    element<Typ> findMin(element<Typ> temp) {
      if( temp.left==null ) return temp;
      return findMin(temp.left);
    }
    void drawCircle(element<Typ> temp, double x, double y,Pane pane){
        if(temp!=null){
            Circle circle = new Circle(20);
            circle.setCenterX(x);
            circle.setCenterY(y);
            int mid;
            if(x>pane.getWidth()/2)
                mid = (int)(pane.getWidth()-circle.getCenterX())/2;
            else
                mid = (int)(circle.getCenterX())/2;
            Text text = new Text(temp.key.toString());
            text.setX(x);
            text.setY(y);
            text.setFill(Color.WHITE);
            Line lineLeft = new Line();
            Line lineRight = new Line();
            if(temp.left!=null){lineLeft = new Line(circle.getCenterX(), circle.getCenterY(), circle.getCenterX()-mid, circle.getCenterY()+50);}
            if(temp.right!=null){lineRight = new Line(circle.getCenterX(), circle.getCenterY(), circle.getCenterX()+mid, circle.getCenterY()+50);}
            pane.getChildren().addAll(circle,lineLeft,lineRight,text);
            drawCircle(temp.left, circle.getCenterX()-mid, circle.getCenterY()+50,pane);
            drawCircle(temp.right, circle.getCenterX()+mid, circle.getCenterY()+50,pane);
        }
    }
  }
  
