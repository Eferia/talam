package batiments;

import ressources.Ressource;
import ville.Ville;

public abstract class Batiment extends ObjetAffiche {
	
	private String nom;
	
	//ressources
	private int coutBois;
	private int coutAcier;
	private int coutPierre;
	
	//caract�ristiques
	private int durabilite;
	private int tempsConstruction;
	private int attractivite;
	
	//un seul b�timent ne sera pas destructible
	private boolean isDestructible = true;
	
	private String description;
	
	protected Batiment(String nom, int x, int y, int largeur, int hauteur, int coutBois, int coutAcier, int coutPierre, int durabilite, int tempsConstruction, int attractivite) {
		super(x, y, largeur, hauteur);
		this.nom=nom;
		this.coutBois=coutBois;
		this.coutAcier=coutAcier;
		this.coutPierre=coutPierre;
		this.durabilite=durabilite;
		this.setTempsConstruction(tempsConstruction);
		this.attractivite=attractivite;
		this.description="Ceci n'est pas un(e) "+nom;
	}
	
	public int degat(int degats) {
		this.durabilite-=degats;
		return this.durabilite;
	}
	
	/**
	 * V�rifie que le b�timent est constructible, sans le construire
	 * @return true si le b�timent est constructible
	 */
	public boolean isConstructible() {
		return (this.getCoutAcier()<=Ressource.ACIER.getQuantite() &&
				this.getCoutBois()<=Ressource.BOIS.getQuantite() &&
				this.getCoutPierre()<=Ressource.PIERRE.getQuantite());
	}
	
	/**
	 * Tente de construire le b�timent
	 * @return true si le b�timent a �t� construit
	 */
	public boolean construire() {
		if(this.isConstructible()) {
			Ressource.ACIER.perteRessource(this.getCoutAcier());
			Ressource.BOIS.perteRessource(this.getCoutBois());
			Ressource.PIERRE.perteRessource(this.getCoutPierre());
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Tente de d�truire le b�timent pour r�cup�rer des ressources
	 * @return true si le b�timent a �t� d�truit
	 */
	public boolean destruction() {
		if(this.isDestructible()) {
			Ressource.ACIER.gainRessource(this.getCoutAcier()/2);
			Ressource.BOIS.gainRessource(this.getCoutBois()/2);
			Ressource.PIERRE.gainRessource(this.getCoutPierre()/2);
			return true;
		} else {
			return false;
		}
	}
	
	
	/**
	 * Applique les effets de construction d'un b�timent.
	 * @param ville
	 */
	public abstract void postConstruct(Ville ville);
	
	/**
	 * Retire les effets apport�s par le b�timent apr�s destruction.
	 * @param ville
	 */
	public abstract void postDestruct(Ville ville);
	

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getCoutBois() {
		return coutBois;
	}

	public void setCoutBois(int coutBois) {
		this.coutBois = coutBois;
	}

	public int getCoutAcier() {
		return coutAcier;
	}

	public void setCoutAcier(int coutAcier) {
		this.coutAcier = coutAcier;
	}

	public int getCoutPierre() {
		return coutPierre;
	}

	public void setCoutPierre(int coutPierre) {
		this.coutPierre = coutPierre;
	}

	public int getDurabilite() {
		return durabilite;
	}

	public void setDurabilite(int durabilite) {
		this.durabilite = durabilite;
	}

	public int getTempsConstruction() {
		return tempsConstruction;
	}

	public void setTempsConstruction(int tempsConstruction) {
		this.tempsConstruction = tempsConstruction;
	}

	public int getAttractivite() {
		return attractivite;
	}

	public void setAttractivite(int attractivite) {
		this.attractivite = attractivite;
	}

	public boolean isDestructible() {
		return isDestructible;
	}

	public void setDestructible(boolean isDestructible) {
		this.isDestructible = isDestructible;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

}
