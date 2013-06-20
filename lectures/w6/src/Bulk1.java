import java.util.*;
import java.lang.reflect.*;

class Bulk1 {
	
	static ArrayList jcfMethods(String interfaceName) {
		
		// Uzyskanie obiektu, reprezntujacego klase (interfejs)
		// o podanej nazwie
		Class klasa = null;
		try {
			klasa = Class.forName("java.util." + interfaceName);
		} catch(ClassNotFoundException exc) { System.exit(1); }
		
		// Uzyskanie tablicy publicznych metod,
		// ktore moga byc uzywane wobec typu klasa
		// - zawieraja rowniez metody z nadklas i nadinterfejsow
		
		Method[] metody = klasa.getMethods();
		
		ArrayList lista = new ArrayList();	// Lista metod
		
		// przebiegamy przez wszystkie dostepne metody
		for (int i=0; i < metody.length; i++) {
			
			// Uzyskanie tablicy typow parametrow danej metody
			Class[] param = metody[i].getParameterTypes();
			
			String opis = metody[i].getName() + "(";	// nazwa metody + znak (
			for (int j=0; j<param.length; j++) {
				String p = param[j].getName();			// nazwa typu parametru
				
				// poniewaz dla parametrow obiektowych nazwa typu
				// jest pelna kwalifikowana nazwa klasy - ";dejmujemy kwalifikacje"
				int l = p.lastIndexOf(".");
				if (l != -1) p = p.substring(l+1);
				opis += p + ',';
			}
			// ew. ostatni przecinek dany poprzednio - niepotrzebny
			if (opis.endsWith(",")) opis = opis.substring(0, opis.length()-1);
			opis += ")";
			lista.add(opis);
		}
		return lista;
	}
	
	static void showJcfMethods(String msg, Collection c) {
		System.out.println(msg);
		if (c.isEmpty()) System.out.println("Brak metod");
		for (Iterator it = c.iterator(); it.hasNext();) {
			System.out.println(it.next());
		}
	}
	
	public static void main(String args[]) {
		List collMet = jcfMethods("Collection");		// metody interfejsu Collection
		List listMet = jcfMethods("List");				// metody interfejsu List
		List setMet = jcfMethods("Set");				// metody interfejsu Set
		List sortedSetMet = jcfMethods("SortedSet");	// metody interfejsu SortedSet
		
		// Metody specyficzne dla list
		Set listOnly = new TreeSet(listMet);
		listOnly.removeAll(collMet);
		showJcfMethods("Metody specyficzne dla list", listOnly);
		
		// Metody specyficzne dla zbiorow uporzadkowanych
		Set ssetOnly = new TreeSet(sortedSetMet);
		ssetOnly.removeAll(setMet);
		showJcfMethods("Metody specyficzne dla zbioru uporzadkowanego", ssetOnly);
		
		// Metody wspolne dla list i zbiorow
		Set commonListAndSet = new TreeSet(listMet);
		commonListAndSet.retainAll(setMet);
		showJcfMethods("Metody wspolne dla listy i zbioru", commonListAndSet);
		
		// Czy te ostatnie przypadkiem nie sa po prostu metodami interfejsu Collection?
		commonListAndSet.removeAll(collMet);
		showJcfMethods("Czy wsrod ostatnich sa jakies, ktorych nie ma w Collection?",
				commonListAndSet);
		
	}
}