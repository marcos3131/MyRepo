import javax.swing.JApplet;
import java.awt.*;

public class PuzzleAplet extends JApplet {
	public void init() 
	{
		setSize(600,450);
		PuzzlePanel pp= new PuzzlePanel();
		add(pp);
	}
}