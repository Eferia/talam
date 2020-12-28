package elements.monde;

import elements.ObjetAffiche;
import main.main;

/**
 * Réprésente tous les éléments plaçables mais pas cliquables du jeu (arbres, rochers, étendues d'eau, etc...)
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
