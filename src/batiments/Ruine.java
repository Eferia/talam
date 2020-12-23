package batiments;

import ville.Ville;

/**
 * Bâtiment présent au début du jeu, à détruire pour obtenir des ressources
 * @author alexandre
 *
 */
public class Ruine extends Batiment {
	
	public Ruine() {
		super("Ruine", 0, 0, 0, 0,  20, 10, 30, 1000, 0, 0);
	}
	
	public Ruine(int x, int y, int hauteur, int largeur) {
		super("Ruine", x, y, hauteur, largeur, 20, 10, 30, 1000, 0, 0);
	}
	
	@Override
	public boolean isConstructible() {
		return false;
	}

	@Override
	public void postConstruct(Ville ville) {
		//N'apporte rien
	}

	@Override
	public void postDestruct(Ville ville) {
		//N'apportait rien
		
	}

}
