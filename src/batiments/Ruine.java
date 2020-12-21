package batiments;

import ville.Ville;

/**
 * Bâtiment présent au début du jeu, à détruire pour obtenir des ressources
 * @author alexandre
 *
 */
public class Ruine extends Batiment {

	protected Ruine(String nom, int coutBois, int coutAcier, int coutPierre, int durabilite, int tempsConstruction,
			int attractivite) {
		super(nom, coutBois, coutAcier, coutPierre, durabilite, tempsConstruction, attractivite);
		// TODO Auto-generated constructor stub
	}
	
	public Ruine() {
		super("Ruine", 20, 10, 30, 1000, 0, 0);
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
