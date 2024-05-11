
import java.awt.event.*;
import java.awt.*;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

class MyButton extends Button{
    MyButton(MyFrame f){
        super("+");
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
    int liczbakrow=0;
    int liczbaswin=0;
    int liczbakurczakow=0;

    public MyFrame(){
        super("WTP");
        setBounds(100,100,640,240);
        JPanel krowy=new JPanel();
        JPanel swinie = new JPanel();
        JPanel kurczaki = new JPanel();
        krowy.setLayout(new BorderLayout());
        swinie.setLayout(new BorderLayout());
        kurczaki.setLayout(new BorderLayout());
        
        krowy.add(new JLabel("<html><div text-align=center>Krowy<div/><html/>"),BorderLayout.NORTH);
        krowy.add(new Label(Integer.toString(liczbakrow)),BorderLayout.CENTER);
        krowy.add(new MyButton(this),BorderLayout.SOUTH);

        swinie.add(new Label("Swinie"),BorderLayout.NORTH);
        swinie.add(new Label(Integer.toString(liczbaswin)),BorderLayout.CENTER);
        swinie.add(new Button("+"),BorderLayout.SOUTH);

        kurczaki.add(new Label("Kurczaki"),BorderLayout.NORTH);
        kurczaki.add(new Label(Integer.toString(liczbakurczakow)),BorderLayout.CENTER);
        kurczaki.add(new Button("+"),BorderLayout.SOUTH);
        

        setLayout(new GridLayout(1,3));
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) { System.exit(0); }
        });
        /*pan.setLayout(new GridLayout(1,2));
        pan.add(dane);
        pan.add(button);
        newPan.add(wynik);
        add(pan, BorderLayout.NORTH);
        add(newPan,BorderLayout.CENTER);
        pan.setPreferredSize(new Dimension(300,55));*/
        add(krowy);
        add(swinie);
        add(kurczaki);
        
    }

    public void action(){
        liczbakrow=+1;
        krowy.add(new Label(Integer.toString(liczbakrow)),BorderLayout.CENTER);
    }
}

public class Main {
    public static void main(String[] args){
    MyFrame f = new MyFrame();
    f.setVisible(true);
    }
}
