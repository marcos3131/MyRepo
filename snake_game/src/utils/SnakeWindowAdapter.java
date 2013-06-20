package utils;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import snakegame.Scoreboard;


public class SnakeWindowAdapter extends WindowAdapter {
	Scoreboard mScoreboard;

	public SnakeWindowAdapter(Scoreboard sb) {
		super();
		mScoreboard = sb;
	}

	public void windowClosing(WindowEvent e) {
		JFrame frame = (JFrame)e.getSource();

		/* int result = JOptionPane.showConfirmDialog(
					frame,
					"Are you sure you want to exit the application?",
					"Exit Application",
					JOptionPane.YES_NO_OPTION);

			if (result == JOptionPane.YES_OPTION) { */

		// save scores
		mScoreboard.writeRecords("scoreboard.txt");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
