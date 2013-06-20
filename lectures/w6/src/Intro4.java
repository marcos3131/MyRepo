import java.util.*;
import java.io.*;
import javax.swing.*;

class Intro4 {
	
	public static void main(String args[]) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(args[0]));
		
		String firmName = null;			// nazwa firmy
		String address = null;			// adres firmy
		HashMap map = new HashMap();	// mapa odwzvorowan : nazwa -> adres
		
		// Wczytywanie danych z pliku
		String inp;
		while ((inp = in.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(inp, "#");
			
			// nazwa firmy bxedzie kluczem
			firmName = st.nextToken();
			address = st.nextToken();
			map.put(firmName, address);	// dodanie pary klucz-wartosc do mapy
		}
		
		// Interakcyjna czesc programu:
		// ila podanej w dialogu nazwy firmy pokazywany jest jej adras
		while ((firmName = JOptionPane.showInputDialog("Nazwa firmy")) != null) {
			address = (String) map.get(firmName);
			if (address == null) address = "Nie ma takiej firmy";
			JOptionPane.showMessageDialog(null, "Firma: " + firmName + '\n' + 
					"Adres: " + address);
			
		}
	}
}