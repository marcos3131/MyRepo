package snakegame;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class ScoreboardPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public ScoreboardPanel() {
		setBackground(Color.PINK);
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblName = new JLabel("Name:");
		panel_2.add(lblName, BorderLayout.CENTER);
		
		repaint();
	}

}
