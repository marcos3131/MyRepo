import java.awt.*;
import javax.swing.*;

class Przyklad  {

public static void main(String[] args)  {

  Icon[] icon = { new ImageIcon("ocean.jpg"),   // ikony z plików JPEG
                       new ImageIcon("pool.jpg"),
                       new ImageIcon("town.jpg"),
                      };
  String[] opis = { "Ocean", "Pool", "Town" }; //  tekst na przyciskach
  JFrame f = new JFrame();                     // utworzenie okna ramowego
  Container cp = f.getContentPane();           // ... i pobranie jego contentPane
  cp.setLayout(new FlowLayout());              // ustalenie rozk³adu FlowLayout

  for (int i=0; i<icon.length; i++) {

     // tworzenie kolejnych przycisków
     JButton b = new JButton(opis[i], icon[i]);

     // Ustalenie pisma i koloru napisu na przyciskach
     b.setFont( new Font("Dialog", Font.BOLD | Font.ITALIC, 18));
     b.setForeground(Color.blue);

    //  Ustalenie pozycji tekstu na przycisku wzglêdem ikony
     b.setVerticalTextPosition(SwingConstants.BOTTOM);
     b.setHorizontalTextPosition(SwingConstants.CENTER);

     cp.add(b);   // dodanie przycisku do contentPane
     }

  f.pack(); // spakowanie okna
            // (wymiary okna takie by dok³adnie zmieœciæ komponenty)
  f.show(); // pokazanie okna
  }

}
