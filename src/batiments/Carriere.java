package batiments;

import ressources.Ressource;
import ville.Ville;

public class Carriere extends Batiment {
	
	private Double croissancePierre = 0.5;

	public Carriere(String nom, int coutBois, int coutAcier, int coutPierre, int durabilite, int tempsConstruction,
			int attractivite) {
		super(nom, coutBois, coutAcier, coutPierre, durabilite, tempsConstruction, attractivite);
		// TODO Auto-generated constructor stub
	}
	
	public Carriere() {
		super("Carriere", 50, 50, 100, 2500, 20, 0);
	}

	@Override
	public void postConstruct(Ville ville) {
		Ressource.PIERRE.addCroissance(croissancePierre);
	}
	
	@Override
	public void postDestruct(Ville ville) {
		Ressource.PIERRE.loseCroissance(croissancePierre);
	}

}
