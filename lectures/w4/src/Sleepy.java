import javax.swing.*;

class Counter {
  private double val;
  public void incr() { val++; }
  public String toString() { return String.valueOf(val); }
}

class Increaser extends Thread {

  private Counter count;  // zwi�kszany licznik
  private int freq;       // cz�stotliwo�� zwi�kszania

  Increaser(Counter c, int f) {
    super("Increasing thread");
    freq = f;
    count = c;
    start();
  }

  public void run() {
    while (true) {
      synchronized(count) {
        try {
          count.wait(freq);                // czeka freq ms
        } catch (InterruptedException exc) {
            System.out.println(getName() + " interrupted.");
            return;
        }
       count.incr();               // zwi�kszenie licznika
       System.out.println(count);  // pokaz warto�� licznika
      }
    }
  }
}

class Sleepy extends Thread {

	  private Counter count;
	  private final int N = 100;

	  public Sleepy(Counter c) {
	    count = c;
	    start();
	  }

	  public void run() {
	    for (int i=1; i <= N; i++) {
	      // w ostatniej iteracji usypiamy na d�ugo
	      int time = 1000;
	      synchronized(count) {
	        System.out.println("Sleep at " + count);
	        try {
	          sleep(time);
	        } catch (InterruptedException exc) {
	        }
	      }
	    }
	  }
	}

class SleepyTest {
	
	public static void main(String[] args) {
		int freq = 3000;
		Counter counter = new Counter();
		Increaser inc = new Increaser(counter, freq);
		new Sleepy(counter);
	}
	
}

























