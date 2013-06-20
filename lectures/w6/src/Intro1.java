import java.util.*;
import java.io.*;

class Intro1 {
	
	public static void main(String args[]) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(args[0]));
		// Utworzenie obiektu klasy ArrayList
		ArrayList list = new ArrayList();
		String firm;
		while ((firm = in.readLine()) != null)
			// dodanie kolejnego elementu do listy
			list.add(firm);
		// wyprowadzenie zawartosci listy
		for (int i=0; i < list.size(); i++) System.out.println(list.get(i));
	}
	
}