import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class Client extends Thread{
  Socket socket;
  Client(Socket socket){
    this.socket = socket;

  }
  public void run() {
    try {
  //Odbieranie od socketa
  InputStream input = socket.getInputStream();
  BufferedReader in = new BufferedReader(new InputStreamReader(input));

  //Wysylanie do socketa
  OutputStream output = socket.getOutputStream();
  PrintWriter outing = new PrintWriter(output, true);
    
  Tree<String> treeString = new Tree<String>();
  Tree<Integer> treeInt = new Tree<Integer>();
  Tree<Double> treeDouble = new Tree<Double>();
    
      outing.println("finish");
      
  String line;
  do {        
      // Odbieranie od socketa
      line = in.readLine();
      if(line.contains("Search")){
        if(line.contains("Integer"))
          System.out.println(treeInt.search(Integer.parseInt(line.replace("Search Integer ", ""))));
        if(line.contains("Double"))
          System.out.println(treeDouble.search(Double.parseDouble(line.replace("Search Double ", ""))));
        if(line.contains("String"))
          System.out.println(treeString.search(line.replace("Search String ", "")));
      }
      if(line.contains("Insert")){
        if(line.contains("Integer")){
        treeInt.insert(Integer.parseInt(line.replace("Insert Integer ", "")));
        treeInt.draw(outing);
        }
        if(line.contains("Double")){
        treeDouble.insert(Double.parseDouble(line.replace("Insert Double ", "")));
        treeDouble.draw(outing);
        }
        if(line.contains("String")){            
        treeString.insert(line.replace("Insert String ", ""));
        treeString.draw(outing);
        }
      }
      if(line.contains("Delete")){
        if(line.contains("Integer")){
          treeInt.delete(Integer.parseInt(line.replace("Delete Integer ", "")));
          treeInt.draw(outing);
        }
        if(line.contains("Double")){
          treeDouble.delete(Double.parseDouble(line.replace("Delete Double ", "")));
          treeDouble.draw(outing);
        }
        if(line.contains("String")){
          treeString.delete(line.replace("Delete String ", ""));
          treeString.draw(outing);
        }
      }
      // Wypisywanie na serwerze
      System.out.println(line);   
      
      // Wysylanie do socketa
      //outing.println("-> ("+line+")");

      } while (!line.equals("end"));
      socket.close();
  } catch (IOException ex) {
      System.out.println("Server exception: " + ex.getMessage());
      ex.printStackTrace();
  }
    }
}

public class L7Server {
    public static void main(String[] args) {
    
    try (ServerSocket serverSocket = new ServerSocket(4444)) {
 
      System.out.println("Server is listening on port 4444");
      while (true) {
        Socket socket = serverSocket.accept();
      new Client(socket).start();   
      }
              
  } catch (IOException ex) {
      System.out.println("Server exception: " + ex.getMessage());
      ex.printStackTrace();
  }
}
}
