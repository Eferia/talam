package ressources;

/**
 * Thread qui permet de collecter les ressources avec le temps
 * @author alexandre
 *
 */
public class Collecte implements Runnable {
	
	private final int PAUSE = 1000;
	
	public Collecte() {
		Thread collecte = new Thread(this);
		collecte.start();
	}

	@Override
	public void run() {
		while(true){											
		    try{Thread.sleep(PAUSE);}
			catch (InterruptedException e){}
			for(Ressource ressource:Ressource.values()) {
				ressource.croit();
			}
		}	

	}

}
