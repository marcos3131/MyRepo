import java.io.*;
import java.util.*;

public class Author {
	
	private int linesToWrite;	// ile wierszy ma napisac autor
	String[] words;				// z jakich slow sie beda skladac
	private Writer out;			// strumien do ktorego zapisuje teksty
	static final int N = 5;		// maksymalna liczba slow w wieszu
	
	public Author(int l, String[] words, Writer w) {
		linesToWrite = l;
		this.words = words;
		out = w;
		try {
			write();			// wywolanie pisania
		} catch(IOException exc) {
			System.out.println(exc.toString());
		} catch(InterruptedException exc) {}
	}
	
	// Metoda pisania przez autora
	public void write() throws IOException,
								InterruptedException {
		Random rand = new Random();
		for (int i=0; i < linesToWrite; i++) {
			
			// Kazdy wiersz sklada sie z losowo wybranej nw liczby slow
			int nw = rand.nextInt(N) + 1;
			String line = "";
			
			for (int k=0; k<nw; k++) {
				int wordNum = rand.nextInt(words.length);
				line += words[wordNum] + " ";
			}
			out.write(line);
			out.write('\n');
			Thread.sleep((rand.nextInt(3) + 1) * 1000);	// autor mysli nad
		}												// nastepnym wierszem
		out.write("Koniec pracy\n");
		out.close();
		System.out.println("Autor Skonczyl pisac");
	}
}