import javax.swing.*;

public class Quiz {
	
	private final String[] CAP = {"Moskwa", "Wilno", "Minsk", 
			"Kijow", "Bratyslawa", "Praga", "Berlin"};
	
	private boolean[] entered = new boolean[CAP.length];
	
	private int count = 0;
	
	public Quiz() {
		JOptionPane.showMessageDialog(null, "Podaj nazwy stolic ladowych sasiadow Polski.");
		
		Timer t = new Timer();
		t.start();
		
		while(count != CAP.length) {
			String s = JOptionPane.showInputDialog("Podano " + count + '/' + CAP.length + " stolic.\n" +
					"Podaj nastepna stolice.");
		
			if (s == null) break;
			if (isOk(s)) count++;
		}
		System.exit(0);
	}
	
	private boolean isOk(String s) {
		for (int i=0; i < CAP.length; i++)
			if (!entered[i] && s.equalsIgnoreCase(CAP[i]))
				return entered[i] = true;
		return false;
	}
	
	public static void main(String[] args) {
		new Quiz();
	}
	
}
