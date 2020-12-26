package elements.batiments;

import ressources.Population;
import ville.Ville;

public class Maison extends Batiment {
	
	private int popHebergee = 10;

	public Maison() {
		super("Maison", 0, 0, 0, 0,  20, 10, 30, 1000, 5, 3);
		this.setDescription("Ceci n'est pas une maison.");
	}
	
	public Maison(int x, int y, int hauteur, int largeur) {
		super("Maison", x, y, hauteur, largeur, 20, 10, 30, 1000, 5, 3);
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
