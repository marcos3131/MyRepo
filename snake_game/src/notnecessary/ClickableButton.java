package notnecessary;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;


public abstract class ClickableButton extends JButton implements MouseListener {

	public ClickableButton(String s) {
		super(s);

		this.addMouseListener(this);
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	//@Override
	//public abstract void mouseClicked(MouseEvent e);

}