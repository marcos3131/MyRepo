import javax.swing.*;
import java.awt.*;

class MyButton extends JButton {
	
	public MyButton(String txt) {
		super(txt);
	}
	
	public void paintComponent(Graphics g ) {
		super.paintComponent(g);
		int w = getWidth();				// aktualna szerokosc ...
		int h = getHeight();			// i wysokosc komponentu
		g.setColor(Color.red);			// ustalenie koloru rysenku
		// rysowanie kwadracikow
		g.fillRect(0, 0, 10, 10);
		g.fillRect(w-10, 0, 10, 10);
		g.fillRect(0, h-10, 10, 10);
		g.fillRect(w-10, h-10, 10, 10);
	}
}

class MyButtonTest extends JFrame {
	Container cp = getContentPane();
	
	public void MyButtonTest() {
		MyButton mb = new MyButton("To jest przycisk");
		cp.add(mb);
		setVisible(true);
	}
	
	public static void main(String argv[]) {
		MyButtonTest mbt = new MyButtonTest();
		
		JFrame jf = new JFrame();
		jf.setVisible(true);
		jf.add(new MyButton("asdf"));
		jf.pack();
		jf.show();
	}
}