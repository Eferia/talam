package batiments;

import ressources.Ressource;
import ville.Ville;

/**
 * Entrepôt
 * @author alexandre
 *
 */
public class Entrepot extends Batiment {
	
	private int extensionLimiteBois = 50;
	private int extensionLimiteNourriture = 50;
	private int extensionLimiteAcier = 50;
	private int extensionLimitePierre = 50;
	
	public Entrepot() {
		super("Entrepot", 0, 0, 0, 0,  100, 100, 100, 5000, 10, 0);
	}
	
	public Entrepot(int x, int y, int hauteur, int largeur) {
		super("Entrepot", x, y, hauteur, largeur, 100, 100, 100, 5000, 10, 0);
	}
	
	@Override
	public void postConstruct(Ville ville) {
		Ressource.ACIER.setLimite(Ressource.ACIER.getLimite()+extensionLimiteAcier);
		Ressource.BOIS.setLimite(Ressource.BOIS.getLimite()+extensionLimiteBois);
		Ressource.NOURRITURE.setLimite(Ressource.NOURRITURE.getLimite()+extensionLimiteNourriture);
		Ressource.PIERRE.setLimite(Ressource.PIERRE.getLimite()+extensionLimitePierre);
	}
	
	@Override
	public void postDestruct(Ville ville) {
		Ressource.ACIER.setLimite(Ressource.ACIER.getLimite()-extensionLimiteAcier);
		Ressource.BOIS.setLimite(Ressource.BOIS.getLimite()-extensionLimiteBois);
		Ressource.NOURRITURE.setLimite(Ressource.NOURRITURE.getLimite()-extensionLimiteNourriture);
		Ressource.PIERRE.setLimite(Ressource.PIERRE.getLimite()-extensionLimitePierre);
	}
	
	public int getExtensionLimiteBois() {
		return extensionLimiteBois;
	}
	public void setExtensionLimiteBois(int extensionLimiteBois) {
		this.extensionLimiteBois = extensionLimiteBois;
	}
	public int getExtensionLimiteNourriture() {
		return extensionLimiteNourriture;
	}
	public void setExtensionLimiteNourriture(int extensionLimiteNourriture) {
		this.extensionLimiteNourriture = extensionLimiteNourriture;
	}
	public int getExtensionLimiteAcier() {
		return extensionLimiteAcier;
	}
	public void setExtensionLimiteAcier(int extensionLimiteAcier) {
		this.extensionLimiteAcier = extensionLimiteAcier;
	}
	public int getExtensionLimitePierre() {
		return extensionLimitePierre;
	}
	public void setExtensionLimitePierre(int extensionLimitePierre) {
		this.extensionLimitePierre = extensionLimitePierre;
	}

}
