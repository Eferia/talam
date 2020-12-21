package batiments;

import ressources.Population;
import ville.Ville;

public class Maison extends Batiment {
	
	private int popHebergee = 10;

	public Maison(String nom, int coutBois, int coutAcier, int coutPierre, int durabilite, int tempsConstruction,
			int attractivite) {
		super("Maison", 20, 10, 30, 1000, 5, 3);
		this.setDescription("Ceci n'est pas une maison.");
	}

	@Override
	public void postConstruct(Ville ville) {
		Population population = Ville.getPopulation();
		population.setLimitePop(population.getLimitePop()+popHebergee);
	}
	
	@Override
	public void postDestruct(Ville ville) {
		Population population = Ville.getPopulation();
		population.setLimitePop(population.getLimitePop()-popHebergee);
	}
	
	

}
