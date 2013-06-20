import java.awt.Dimension;

import javax.swing.*;
import java.awt.*;

class SomePanel extends JPanel {
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.black);
		
		Rectangle r = g.getClipBounds();
		
		g.fillRect(r.x, r.y, r.width, r.height);
	}
}

public class Main {
	public static void main(String[] args) {
		JFrame lJFrame = new JFrame();
		// init
		// *game objects
		Dimension lWindowDimension = new Dimension(800, 600);
		// *JFrame
		lJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		lJFrame.setSize(lWindowDimension);
		lJFrame.setResizable(false);
		lJFrame.setLocation(100, 100);
		lJFrame.setVisible(true);

		SomePanel p = new SomePanel();
		
		lJFrame.add(p);
	}

}
