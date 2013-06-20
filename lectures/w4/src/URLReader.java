import java.net.*;
import java.io.*;
import java.util.*;

class URLReader {
	
	public static void main(String [] args) throws Exception {
		BufferedReader list = new BufferedReader(
				new FileReader(args[0]));
		String urlString;
		while ((urlString = list.readLine()) != null) {
			readAndSave(new URL(urlString));	// tworzony nowy obiekt klasy URL
		}										// oznaczajacy zasob z Sieci
		list.close();
		System.exit(0);
		
	}
	
	static void readAndSave(URL url) throws Exception {
		
		BufferedReader in = new BufferedReader(
				new InputStreamReader(
						url.openStream()	// zwraca InputStream zwiazany ...
						)
				);
		
		String fname = null;
		StringTokenizer st = new StringTokenizer(url.getFile(),
												"/"
												);
		BufferedWriter out = new BufferedWriter(new FileWriter(fname));
		
		String s;
		while ((s = in.readLine()) != null) {
			out.write(s);
			out.newLine();
		}
	}
}