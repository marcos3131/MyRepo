package draw;

import java.awt.*;
import javax.swing.*;



class ObszarRysunku extends JComponent {
	
	Dimension d;
	
	public ObszarRysunku(int w, int h) {
		d = new Dimension(w, h);
	}
	
	public Dimension getMinimumSize() { return d; }
	public Dimension getPrefferedSize() { return d; }
	public Dimension getMaximumSize() {
		return new Dimension(1000, 1000);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int w = getWidth();
		int h = getHeight();
		g.setColor(Color.blue);
		g.drawRect(0, 0, w-1, h-1);
		int hor = 10, vert = 10;
		while (hor < h) {
			g.drawLine(1, hor, w-1, hor);
			hor += 10;
		}
		
		while (vert < w) {
			g.drawLine(vert, 1, vert, h-1);
			vert += 10;
		}
	}
	
}

class Rysunek extends JFrame {
	
	Container cp = getContentPane();
	
	public Rysunek() {
		ObszarRysunku or = new ObszarRysunku(100, 100);
		cp.add(or);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		show();
	}
	
	public static void main(String[] args) {
		new Rysunek();
	}
}