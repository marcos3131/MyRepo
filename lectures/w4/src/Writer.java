// Klasa ila ustalania i pobierania tekstow
class Teksty {
	
	String txt = null;
	boolean newTxt = false;
	// metoda ustelajaca tekst - wywoluje Autor
	synchronized void setTextToWrite(String s) {
		while (newTxt == true) {
			try {
				wait();
			} catch(InterruptedException exc) { }
		}
		txt = s;
		newTxt = true;
		notifyAll();
	}
	
	// Metoda pobrania tekstu - wywoluje Writer
	synchronized String getTextToWrite() {
		while (newTxt == false) {
			try {
				wait();
			}catch(InterruptedException exc) { }
		}
		newTxt = false;
		notifyAll();
		return txt;
	}
	
}

// Klasa "ypisywacza"
class Writer extends Thread {
	
	Teksty txtArea;
	
	Writer(Teksty t) {
		txtArea = t;
	}
	
	public void run() {
		String txt = txtArea.getTextToWrite();
		while (txt != null) {
			System.out.println("-> " + txt);
			txt = txtArea.getTextToWrite();
		}
	}
	
}

class Author extends Thread {
	
	Teksty txtArea;
	
	Author(Teksty t) {
		txtArea = t;
	}
	
	public void run() {
		
		String[] s = { "Pies", "kot", "Zebra", "Lew", "Owca", "Slon", null };
		for (int i=0; i < s.length; i++) {
			try {
				sleep((int)(Math.random() * 1000));
			} catch(InterruptedException exc) { }
			txtArea.setTextToWrite(s[i]);
		}
	}
	
}

class Koord {
	
	public static void main(String[] args) {
		Teksty t = new Teksty();
		Thread t1 = new Author(t);
		Thread t2 = new Writer(t);
		t1.start();
		t2.start();
	}
}




























