
import java.awt.event.*;
import java.awt.*;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

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

class MyFrame extends Frame{    
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
        setLayout(new GridLayout(1,2));
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) { System.exit(0); }
        });
        p.setLayout(new GridLayout(2,1));
        p.add(dane);
        p.add(button);
        add(p);
        add(wynik);
    }

    public void action(){
        try {
            String s="<html><div style='text-align:center;'>";
            for(int i=0;i<=Integer.parseInt(dane.getText());i++){
                WierszTrojkataPascala w = new WierszTrojkataPascala(i);
                s+=w.wypisz()+"<br/>";
            }
            s+="</div></html>";
            
        wynik.setText(s);
        dane.setText("");
        } catch (Exception e) {
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
