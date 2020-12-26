package jeu;

import main.main;

public class Timer implements Runnable {

    private final int PAUSE = 3; // temps d'attente en ms entre 2 tours de boucle
	
	@Override
	public void run(){		
		while(true){ // boucle infinie						
			// Instruction répétée à chaque tour de boucle			
			main.ecran.repaint();
			try{Thread.sleep(PAUSE);} // on arrête le flux principal pendant le temps égal à PAUSE (en ms)
			catch (InterruptedException e){}
		}		
	}

}
