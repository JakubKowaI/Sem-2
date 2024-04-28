import java.io.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.JLabel;
import javax.management.modelmbean.InvalidTargetObjectTypeException;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import java.lang.Process;

class MyButton extends Button{
    MyButton(MyFrame f){
        super("Licz");
        addActionListener(new MyButtonAdapter(f));
    }
}

class MyButtonAdapter implements ActionListener{
    MyFrame f;
    MyButtonAdapter(MyFrame f){
        this.f = f;
    }
    public void actionPerformed(ActionEvent e){
        f.action();
    }
}

class MyFrame extends JFrame{    
    JLabel wynik;
    TextField dane;
    MyButton button;
    Panel p;
    
    public MyFrame(){
        super("WTP");
        setBounds(100,100,640,240);
        wynik = new JLabel("Wynik", SwingConstants.CENTER);
        //wynik.setHorizontalAlignment(SwingConstants.CENTER);
        dane = new TextField("");
        button = new MyButton(this);
        p = new Panel();
        setLayout(new BorderLayout());
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) { System.exit(0); }
        });
        p.setLayout(new GridLayout(1,2));
        p.add(dane);
        p.add(button);
        add(p,BorderLayout.NORTH);
        add(wynik,BorderLayout.CENTER);
        p.setPreferredSize(new Dimension(100,55));
    }

    public void action(){
        try {
            
            String s="<html><div style='text-align:center'>";
            String[] test=dane.getText().split("\\s+");
            
Runtime rt = Runtime.getRuntime();

int i=0;
String[] commands=new String[test.length+1];

    commands[0]="./a";

while(i<test.length){
    //if(Integer.parseInt(test[i])<0)throw new Exception("Za mala liczba");

    commands[i+1]=test[i];
    
    i++;
}

ProcessBuilder builder=new ProcessBuilder(commands);
Process proces = builder.start();

BufferedReader wyjscie = new BufferedReader(new InputStreamReader(proces.getInputStream()));

BufferedReader bledy = new BufferedReader(new InputStreamReader(proces.getErrorStream()));
//System.out.println(wyjscie.readLine());
String temp;
while((temp =wyjscie.readLine())!=null){
                s+=temp+"<br/>";
}
                
                
            s+="</div></html>";
        wynik.setText(s);
        dane.setText("");
        this.pack();
}catch(NumberFormatException t){
    dane.setText("");
            wynik.setText("zly argument");
}
        catch (Exception e) {
            dane.setText("");
            wynik.setText(e.toString());
        }        
    }
}

public class WTP {
    public static void main(String[] args){
    MyFrame f = new MyFrame();
    f.setVisible(true);
    }
}
