import java.util.*;

class ListIter1 {
	
	static void state(ListIterator it) {
		int pi = it.previousIndex(),
		ni = it.nextIndex();
		System.out.println("Iterator jest pomiedzy indeksami: " + pi + " " + ni);
	}
	
	public static void main(String args[]) {
		LinkedList list = new LinkedList(Arrays.asList(new String[] { "E0", "E1", "E2", "E3" }
														));
		ListIterator it = list.listIterator();
		it.next();
		state(it);
		it.add("nowy1");
		System.out.println(list.toString());
		it.next();
		it.next();
		it.previous();
		state(it);
		it.add("nawy2");
		System.out.println(list.toString());
		it.previous();
		it.previous();
		state(it);
		it.remove();
		System.out.println(list.toString());
	}
}