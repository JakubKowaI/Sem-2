
import java.awt.event.*;
import java.awt.*;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;
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

class MyFrame extends JFrame{    
    JLabel wynik;
    TextField dane;
    MyButton button;
    JPanel pan;
    JPanel newPan;
    
    public MyFrame(){
        super("WTP");
        setBounds(100,100,640,240);
        wynik = new JLabel("Wynik", SwingConstants.CENTER);
        dane = new TextField("");
        button = new MyButton(this);
        pan = new JPanel();
        newPan = new JPanel();

      

        setLayout(new BorderLayout());
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) { System.exit(0); }
        });
        pan.setLayout(new GridLayout(1,2));
        pan.add(dane);
        pan.add(button);
        newPan.add(wynik);
        add(pan, BorderLayout.NORTH);
        add(newPan,BorderLayout.CENTER);
        pan.setPreferredSize(new Dimension(300,55));
        
    }

    public void action(){
        try {
            if(Integer.parseInt(dane.getText())<0)throw new Exception("Za mala liczba");
            String s="<html><div style='text-align:center;'>";
            for(int i=0;i<=Integer.parseInt(dane.getText());i++){
                WierszTrojkataPascala w = new WierszTrojkataPascala(i);
                s+=w.wypisz()+"<br/>";
            }
            s+="</div></html>";
            
        wynik.setText(s);
        dane.setText("");
        this.pack();
        }catch (Exception e) {
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
