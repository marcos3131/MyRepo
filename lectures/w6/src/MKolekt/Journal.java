package MKolekt;

import java.util.*;

class Journal implements CollectionHelper, Comparable {
	private String title;
	private int year;
	private static int retainAfter = 0;		// rok wydania,
											// od ktorego ew. zosltawiac gazety
	public Journal() { }
	public Journal(String t, int y) {
		title = t;
		year = y;
	}
	
	public boolean isReadyToRemove() {
		return year < retainAfter;
	}
	
	// Tworzy Journal ze Stringu, w ktorym tytul jest ujety w cudzyslow
	// a za tytulem znajduje sie rok wydania. Dodaje do kolekcji.
	public void makeObjectAndCollect(String s, Collection c) {
		String title = "";
		int year = -1;
		try {
			StringTokenizer st = new StringTokenizer(s, "\"");
			title = st.nextToken();
			year = Integer.parseInt(st.nextToken().trim());
		} catch (Exception exc) { }
		Journal j = new Journal(title, year);
		c.add(j);
	}
	
	public static void setLimitYear(int y) { retainAfter = y; }
	
	public boolean equals(Object obj) {
		return title.equals(obj);
	}
	
	public int compareTo(Object o) {
		return title.compareTo(o.toString());
	}
	
	public int hashCode() { return title.hashCode(); }
	
	public String toString() { return title + " " + year; }
	
}

class Student implements CollectionHelper, Comparable {
	private String name;
	private double mark;				// ocena
	private static double minMark;		// minimalna ocena
	
	public Student() {}
	public Student(String nam, double m) {
		name = nam;
		mark = m;
	}
	
	public void setMark(double m) { mark = m; }
	
	public boolean isReadyToRemove() {
		return mark < minMark;
	}
	
	public void makeObjectAndCollect(String s, Collection c) {
		StringTokenizer st = new StringTokenizer(s);
		String name = "", txt = "";
		double mark = 0;
		while (st.hasMoreTokens()) {
			try {
				txt = st.nextToken();
				mark = Double.parseDouble(txt);
				break;
			} catch (NumberFormatException exc) {
				name += txt + " ";
			}
		}
		Student stud = new Student(name.trim(), mark);
		c.add(stud);
	}
	
	// Ustalenie minimalnej oceny.
	// Studenci z nizsza ocena maga byc usunieci z kolekcji.
	public static void setLimitMark(double m) {
		minMark = m;
	}
	
	public boolean equals(Object obj) {
		return name.equals(obj);
	}
	
	public int compareTo(Object o) {
		return compareTo(o);
	}
	
	public int hashCode() { return name.hashCode(); }
	
	public String toString() { return name + " " + mark; }
	
}
