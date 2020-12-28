package elements.batiments;

import ressources.Population;
import ville.Ville;

public class Maison extends Batiment {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5604207272009936884L;
	private int popHebergee = 10;
	
	private static String nom = "Maison";
	
	private String descriptionR = "Ceci n'est pas une maison.";

	public Maison() {
		super(nom, 0, 0, 0, 0,  20, 10, 30, 1000, 5, 3);
		this.setDescription(descriptionR);
	}
	
	public Maison(int x, int y, int hauteur, int largeur) {
		super(nom, x, y, hauteur, largeur, 20, 10, 30, 1000, 5, 3);
		this.setDescription(descriptionR);
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
