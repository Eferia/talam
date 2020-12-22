package batiments;

import ressources.Ressource;
import ville.Ville;

public class Carriere extends Batiment {
	
	private Double croissancePierre = 0.5;
	
	public Carriere() {
		super("Carriere", 0, 0, 0, 0, 50, 50, 100, 2500, 20, 0);
	}
	
	public Carriere(int x, int y, int hauteur, int largeur) {
		super("Carriere", x, y, hauteur, largeur, 50, 50, 100, 2500, 20, 0);
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
