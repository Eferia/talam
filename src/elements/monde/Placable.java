package elements.monde;

import elements.ObjetAffiche;
import main.main;

public abstract class Placable extends ObjetAffiche {

	protected Placable(int x, int y, int largeur, int hauteur) {
		super(x, y, largeur, hauteur);
	}
	
	protected Placable(int x, int y) {
		super(x, y);
	}

}
