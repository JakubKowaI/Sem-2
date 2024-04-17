import java.lang.*;
import java.io.*;

public class test{
public static void main(String[] args){

    try{
Runtime rt = Runtime.getRuntime();
String[] commands = {"./a", "6","3"};
Process proc = rt.exec(commands);

BufferedReader stdInput = new BufferedReader(new 
     InputStreamReader(proc.getInputStream()));

BufferedReader stdError = new BufferedReader(new 
     InputStreamReader(proc.getErrorStream()));

// Read the output from the command
System.out.println("Here is the standard output of the command:\n");
String s = null;
while ((s = stdInput.readLine()) != null) {
    System.out.println(s);
}}
catch(Exception e){
System.out.println(e);
}
}
}
