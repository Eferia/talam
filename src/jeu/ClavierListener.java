package jeu;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import main.main;

public class ClavierListener implements KeyListener {

	@Override
	public void keyTyped(KeyEvent e) {
		//Rien pour le moment
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int posMax = main.ecran.getDefaultSize();
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			main.ecran.setDx(1);
        	if(main.ecran.getxPos() == -1){ 
        		main.ecran.setxPos(0);
        		main.ecran.setxFond1(0);
        		main.ecran.setxFond2(0);
        		main.ecran.setxFond3(0);
        		main.ecran.setxFond4(0);
        		main.ecran.setxPremierPlan(0);
        	}
		}else if(e.getKeyCode() == KeyEvent.VK_LEFT){	
			main.ecran.setDx(-1);
			if(main.ecran.getxPos() == posMax+1){ 
        		main.ecran.setxPos(posMax);
        		main.ecran.setxFond1(-posMax);
        		main.ecran.setxFond2(-posMax*2);
        		main.ecran.setxFond3(-posMax*3);
        		main.ecran.setxFond4(-posMax*4);
        		main.ecran.setxPremierPlan(-posMax*5);
        	}
		}


	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_LEFT){
			main.ecran.setDx(0);
		}
	}

}
