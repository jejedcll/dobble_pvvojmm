package frunivangers.jpv;

public class TimerThread extends Thread {
	private Partie partie;
	private int timeLimit;
	
	public TimerThread(Partie p, int time) {
		partie=p;
		timeLimit=time;
	}
	
	@Override
	public void run() {
		try {
			while(timeLimit>0) {
				Thread.sleep(1000);
				timeLimit--;
				partie.setTempsRestantLabelTxt(timeLimit+"");
			}
			Thread.sleep(1000);
			System.out.println("Fin temps");
			partie.endGame("Perdu, temps écoulé !");
		} catch (InterruptedException e) {}
	}
}