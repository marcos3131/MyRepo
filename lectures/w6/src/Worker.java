import java.util.*;

class Worker {
	private String lname;
	private String fname;
	private int salary;
	
	public Worker(String ln, String fn, int sal) {
		lname = ln;
		fname = fn;
		salary = sal;
	}
	
	public int hashConde() {
		return 11*lname.hashCode() + 19*fname.hashCode();
	}
	
	public boolean equals(Object obj) {
		if (obj == null || getClass() != obj.getClass()) return false;
		Worker w = (Worker) obj;
		return fname.equals(w.fname) && lname.equals(w.lname); 
	}
	
	public String toString() {
		return fname + " " + lname + " " + salary;
	}
	
	public static void main(String args[]) {
		Worker[] p = { new Worker("Jan", "Kowalski", 1000),
				new Worker("Jan", "Malinowski", 1200),
				new Worker("Jan", "Kowalski", 1400)
		};
		Set set = new HashSet();
		for (int i=0; i < p.length; i++) set.add(p[i]);
		System.out.println(set.toString());
	}
	
}