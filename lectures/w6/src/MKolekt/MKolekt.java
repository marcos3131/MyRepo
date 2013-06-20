package MKolekt;

import java.io.*;
import java.util.*;

public class MKolekt {
	
	// Tworzy obiekt klasy
	// okreslonej przez klase obiektu mrg
	// na podstawie informacji z pliku tekstowego o nazwie fname
	// i dodaje je do kolekcji c
	
	public static void makeCollectionFromFile(Collection c, String fname,
			CollectionHelper mgr) {
		try {
			BufferedReader in = new BufferedReader(
					new FileReader(fname)
					);
			String line;
			while((line = in.readLine()) != null)
				mgr.makeObjectAndCollect(line, c);
			
			in.close();
		} catch(IOException exc) { System.exit(1); }
	}
	
	// Usuwa obiekty przeznaczone do usuniecia
	// na podstawie wyniku metody isReadyToRemove
	// z kolekcji c
	public static void iterRemove(Collection c) {
		Iterator iter = c.iterator();
		while (iter.hasNext()) {
			Object o = iter.next();
			CollectionHelper elt = (CollectionHelper) o;
			if (elt.isReadyToRemove()) iter.remove();
		}
	}
	
	// Wypisuje na konsoli wszystkie elementy kolekcji c 
	public static void show(Collection c) {
		for (Iterator iter = c.iterator(); iter.hasNext(); )
			System.out.println(iter.next().toString());
	}
	
}