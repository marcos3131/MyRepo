import javax.swing.*;import java.io.*;import java.util.*;

class CapitalsMap {
	
	// Mamy tera; jeden spojny zestaw danych: kraje-stolice
	Map countryCapital = new HashMap();
	
	public CapitalsMap() {
		readInfo();
		String in;
		while ((in = JOptionPane.showInputDialog("Kraj")) != null) {
			// Uzyskiwanie wartosci po kluczu
			String cap = (String) countryCapital.get(in);
			if (cap == null) cap = "Brak danych";
			JOptionPane.showMessageDialog(null, "Kraj: " + in + " Stolica: " + cap);
		}
		System.exit(0);
	}
	
	private void readInfo() {
		try {
			BufferedReader in = new BufferedReader(
					new FileReader("stolice.txt"));
			String line;
			while ((line = in.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line, "/");
				// Dodawanie do mapy pary: kraj - stolica
				countryCapital.put(st.nextToken(), st.nextToken());
			}
			in.close();
		}catch (Exception exc) {
			System.out.println(exc.toString());
			System.exit(1);
		}
	}
	
	public static void main(String args[]) {
		new CapitalsMap();
	}
}