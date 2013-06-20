//program Klienta:
import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Klient {

public static void main(String[] args) {
OknoKlient okno = new OknoKlient();
okno.setSize(300,200);
okno.setTitle("Okno klienta.");
okno.setVisible(true);
okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}

class OknoKlient extends JFrame implements ActionListener{
JTextField pole1=null, pole2=null;
Socket polaczenie = null;
InputStream we=null;
OutputStream wy=null;
Watek1 w1=null;
Watek2 w2=null;

public OknoKlient() {
setLayout(new FlowLayout());
JLabel lab1=new JLabel("Wpisz polskie s³owo do przet³umaczenia:");
add(lab1);
pole1 =new JTextField(20);
add(pole1);

JButton przycisk1=new JButton("wyczyœæ");
przycisk1.addActionListener(this);
add(przycisk1);

JButton przycisk2=new JButton("przet³umacz");
przycisk2.addActionListener(this);
add(przycisk2);

JButton przycisk3=new JButton("koniec");
przycisk3.addActionListener(this);
add(przycisk3);

JLabel lab2=new JLabel("S³owo w jêzyku angielskim:");
add(lab2);
pole2 =new JTextField(20);
add(pole2);

try{
    polaczenie= new Socket("localhost", 8866);
    } catch(Exception e){  }
/* koniec konstruktora: */
}

public void actionPerformed(ActionEvent ev) {

if(ev.getActionCommand()=="wyczyœæ") {
      pole1.setText("");
      pole2.setText("");
    }

if(ev.getActionCommand()=="przet³umacz") {
      w2=new Watek2(polaczenie,wy);
      w2.start();
    }
if(ev.getActionCommand()=="koniec") {
      w1=new Watek1(polaczenie,wy);
      w1.start();
    }
}

class Watek1 extends Thread {
Socket polaczenie;
OutputStream wy;
DataOutputStream zapis = null;
InputStream we;
BufferedReader odczyt = null;

public Watek1(Socket polaczenie,OutputStream wy)
    {
     this.polaczenie=polaczenie;
    this.wy=wy;
    }

public void run() {
            try{
                wy=polaczenie.getOutputStream();
                zapis = new DataOutputStream(wy);
                zapis.writeBytes("koniec");
                                        polaczenie.close();
                                        System.exit(0);
                                      }  catch(Exception e){ }


/* koniec metody run():   */
}

/* koniec klasy wew: */
}

class Watek2 extends Thread {
Socket polaczenie;
OutputStream wy;
DataOutputStream zapis = null;
InputStream we;
BufferedReader odczyt = null;

public Watek2(Socket polaczenie,OutputStream wy)
    {
       this.polaczenie=polaczenie;
       this.wy=wy;
    }

public void run() {
            try{
                            wy=polaczenie.getOutputStream();
                            String slowoPL=pole1.getText();

                if( slowoPL!=null && !(slowoPL.equals("")) ) {
                zapis = new DataOutputStream(wy);
                zapis.writeBytes(slowoPL + "\n");
                
                we=polaczenie.getInputStream();
                odczyt= new BufferedReader (new InputStreamReader(we));
                String slowoEN=odczyt.readLine();

                            if (slowoEN!=null && !(slowoEN.equals("")) )  {
                            pole2.setText(slowoEN);
                                               }
                            else if (slowoEN==null && !(slowoEN.equals("")) )  {
                            pole2.setText("");
                                               }
                                                 }

             }  catch(Exception e){ }

/* koniec metody run():   */
}
/* koniec klasy wew: */
}
/* koniec klasy Oknopolaczenie: */
}