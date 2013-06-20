public class Timer extends Thread {
	
	public void run() {
		int time = 0;
		while (true){
			try {
				sleep(1000);
			} catch(InterruptedException exc) {
				System.out.println("Watek zliczania czasu zostial przerwany.");
				return;
			}
			time++;
			int min = time/60;
			int sec = time%60;
			System.out.println(min + ":" + sec);
		}
	}
}