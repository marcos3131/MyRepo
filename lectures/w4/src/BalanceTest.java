class Balance {
	
	private int number = 0;
	
	 public int balance() {
		 number++;
		 number--;
		 return number;
	 }
}

class BalanceThread extends Thread {
	
	private Balance b;	// referencja do obiektu klasy Balance
	private int count;	// liczba powtorzen petli w metodzie run
	
	public BalanceThread(String name, Balance b, int count) {
		super(name);
		this.b = b;
		this.count = count;
		start();
	}
	
	public void run() {
		int wynik = 0;
		// W petli wielokrotnie wywolujemy metode balance()
		// na rzecz obiektu b klasy Balance.
		// Jezeli wynik metody jest rozny od zera - przerywamy dzialanie petli 
		for (int i = 0; i < count; i++) {
			wynik = b.balance();
			if (wynik != 0) break;
		}
		// Pokazujemy wartosc zmiennej wynik na wyjsciu z metedy run()
		System.out.println(Thread.currentThread().getName() +
				" konczy z wynikiem " + wynik);
	}
}

class BalanceTest {
	
	public static void main(String[] args) {
		
		int tnum = Integer.parseInt(args[0]);		// leczba watkow
		int count = Integer.parseInt(args[1]);		// liczba powtorzen petli w run()
		
		// Twarzymy obiekt klasy balance
		Balance b =new Balance();
		
		// Tworzymy i uruchamiamy watki
		Thread[] thread = new Thread[tnum];		// tablice witkow
		for (int i = 0; i < tnum; i++)
			thread[i] = new BalanceThread("W"+(i+1), b, count);
		
		// czekaj na zakonczenie wszystich watkow
		try {
			for (int i = 0; i < tnum; i++) thread[i].join();
		} catch (InterruptedException exc) {
			System.exit(1);
		}
		System.out.println("Koniec programu");
	}
}