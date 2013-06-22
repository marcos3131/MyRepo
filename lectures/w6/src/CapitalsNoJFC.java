import javax .swing.*;
import java.io.*;
import java.util.*;

class CapitalsNoJFC {
	
	private final int NC = 300;
	String[] country = new String[NC],
		capital = new String[NC];
	
	public CapitalsNoJFC() {
		readInfo();
		String in;
		while ((in = JOptionPane.showInputDialog("Kraj")) != null) {
			String cap = getCapital(in);
			if (cap == null) cap = "Brak danych";
			JOptionPane.showMessageDialog(null, "Kraj: " + in + " Stolica: " + cap);
		}
	}
	
	public void readInfo() {
		
	}
	
	public String getCapital(String s) {
		return "";
	}
}