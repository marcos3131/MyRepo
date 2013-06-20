package MKolekt;

import java.util.*;

class Iter1 {
	
	public Iter1(String inGaz, String inStud) {
		List gazety = new ArrayList();
		Set studenci = new HashSet();
		MKolekt.makeCollectionFromFile(gazety,inGaz,new Journal());
		MKolekt.makeCollectionFromFile(studenci, inStud, new Student());
		MKolekt.show(gazety);
		MKolekt.show(studenci);
		// ustalenie minimalnego roku wydania
		// gazety wydane wczesniej beda usuniete z kolekcji
		Journal.setLimitYear(2000);
		MKolekt.iterRemove(gazety);
		// ustalenie minimalnej oceny
		// studenci z ocena nizsza beda usunieci z kolekcji
		Student.setLimitMark(3);
		MKolekt.iterRemove(studenci);
		System.out.println("\nPo usunieciu z listy gazet ponizej 2000 roku:");
		MKolekt.show(gazety);
		System.out.println("\nPo usunieciu ze zbioru studentow ponizej 3");
		MKolekt.show(studenci);
	}
	
	public static void main(String args[]) {
		new Iter1(args[0], args[1]);	// argumenty: plik gazet, plik studentow
	}
	
}