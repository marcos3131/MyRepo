package MKolekt;

import java.util.*;

interface CollectionHelper {
	
	// Tworzymy obiekt z podanego napisu s i dodaje go do kolekcji c
	void makeObjectAndCollect(String s, Collection c);
	
	// Zwraca true, jesli obiekt powinien byc usuniety z kolekcji
	boolean isReadyToRemove();
	
}