package elements.monde;

import elements.ObjetAffiche;
import main.main;

/**
 * R�pr�sente tous les �l�ments pla�ables mais pas cliquables du jeu (arbres, rochers, �tendues d'eau, etc...)
 * @author alexandre
 *
 */
public abstract class Placable extends ObjetAffiche {

	protected Placable(int x, int y, int largeur, int hauteur) {
		super(x, y, largeur, hauteur);
	}
	
	protected Placable(int x, int y) {
		super(x, y);
	}
	
	@Override
	public void deplacement() {
		this.setX(this.getX() - 5*main.ecran.getDx());
	}

}
