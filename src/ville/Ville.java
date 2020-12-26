package ville;

import java.util.ArrayList;
import java.util.List;

import elements.batiments.Batiment;
import elements.batiments.Ruine;
import elements.batiments.VieilleTour;
import ressources.Collecte;
import ressources.Population;
import ressources.Ressource;

import main.main;

/**
 * Ville
 * @author alexandre
 *
 */
public class Ville {
	
	private String nom;
	
	//population
	private static int attractivite = 1;
	private static Population population;
	
	//batiments
	private static List<Batiment> batiments = new ArrayList<>();
	private int limiteBatiments;
	
	public Ville(String nom) {
		this.nom=nom;
		//lance la collecte de ressources
		Collecte collecte = new Collecte();
		
		//limites de ressources naked
		Ressource.ACIER.setLimite(200);
		Ressource.BOIS.setLimite(200);
		Ressource.PIERRE.setLimite(200);
		
		//ressources de départ
		Ressource.ACIER.gainRessource(100);
		Ressource.BOIS.gainRessource(100);
		Ressource.PIERRE.gainRessource(100);
		
		limiteBatiments = 30;
		
		//Bâtiments de départ
		batiments.add(new Ruine((int) (main.screensize.getWidth()*70/100), (int) (main.screensize.getHeight()*70/100)));
		batiments.add(new Ruine((int) (main.screensize.getWidth()*50/100), (int) (main.screensize.getHeight()*60/100)));
		batiments.add(new Ruine((int) (main.screensize.getWidth()*110/100), (int) (main.screensize.getHeight()*55/100)));
		//Vieille Tour
		batiments.add(new VieilleTour((int) (main.screensize.getWidth()*24/100), (int) (main.screensize.getHeight()*30/100)));
	}
	
	/**
	 * Construit un bâtiment, et applique ses effets, si possible
	 * @param batiment
	 */
	public void constructBatiment(Batiment batiment) {
		// attention, appel de batiment.construire
		if(batiments.size()<limiteBatiments && batiment.construire()) {
			Ville.attractivite+=batiment.getAttractivite();
			batiment.postConstruct(this);
			Ville.batiments.add(batiment);
		}
	}
	
	/**
	 * Detruit un batiment, et retire ses effets, si possible
	 * @param batiment
	 */
	public void detruireBatiment(Batiment batiment) {
		if(Ville.batiments.contains(batiment) && batiment.destruction()) {
			Ville.attractivite-=batiment.getAttractivite();
			Ville.batiments.remove(batiment);
		}
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public int getLimiteRessource(String ressource) {
		Ressource res = Ressource.valueOf(ressource);
		return res.getLimite();
	}
	
	public void setLimiteRessource(String ressource, int valeur) {
		Ressource res = Ressource.valueOf(ressource);
		res.setLimite(valeur);
	}
	
	public int getRessource(String ressource) {
		Ressource res = Ressource.valueOf(ressource);
		return res.quantiteAAfficher();
	}
	
	public void setRessource(String ressource, Double valeur) {
		Ressource res = Ressource.valueOf(ressource);
		res.setQuantite(valeur);
	}

	public static int getAttractivite() {
		return attractivite;
	}

	public static void setAttractivite(int attractivite) {
		Ville.attractivite = attractivite;
	}

	public static Population getPopulation() {
		return population;
	}

	public static void setPopulation(Population population) {
		Ville.population = population;
	}

	public static List<Batiment> getBatiments() {
		return batiments;
	}

	public static void setBatiments(List<Batiment> batiments) {
		Ville.batiments = batiments;
	}
}
