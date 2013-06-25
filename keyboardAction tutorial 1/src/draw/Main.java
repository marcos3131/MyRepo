package draw;

import javax.swing.*;
import javax.swing.text.*;

import java.awt.event.*;
import java.awt.*;

class Writer extends AbstractAction {
	
	JTextComponent tc;
	
	public Writer(JTextComponent t) {
		super("write");
		tc = t;
	}
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		JComponent c = (JComponent) e.getSource();
		String txt = (String) c.getClientProperty("text");
		tc.replaceSelection(txt);
	}
	
}

class KMap extends JFrame {
	
	String[] txt = { "Piers", "Kot", "tygrys" };
	String[] keys = { "control P", "control K",  "control T" };
	JPanel cp = (JPanel) getContentPane();
	
	ActionMap amap = new ActionMap();
	
	KMap() {
		JTextArea ta = new JTextArea(20, 20);
		cp.add(new JScrollPane(ta));
		amap.put("write", new Writer(ta));
		cp.add(new JScrollPane(ta));
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		p.setBorder(BorderFactory.createLineBorder(Color.blue));
		
		for (int i = 0; i<txt.length; ++i) {
			JLabel l = createLabel(txt[i], keys[i]);
			l.putClientProperty("text", txt[i]);
			l.setAlignmentX(JLabel.RIGHT);
			p.add(l);
			JSeparator js = new JSeparator();
			js.setMaximumSize(new Dimension(1200, 7));
			p.add(js);
		}
		
		cp.add(p, "West");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		show();
	}
	
	JLabel createLabel(String txt, String key) {
		JLabel l = new JLabel(txt + " ");
		l.setPreferredSize(new Dimension(100, 500));
		l.setToolTipText("Wci�nij : ");
		InputMap imap = l.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		imap.put(KeyStroke.getKeyStroke(key), "write");
		l.setActionMap(amap);
		return l;
	}
	
	public static void main(String[] args) {
		new KMap();
	}
	
}