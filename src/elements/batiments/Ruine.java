package elements.batiments;

import javax.swing.ImageIcon;

import ville.Ville;

/**
 * Bâtiment présent au début du jeu, à détruire pour obtenir des ressources
 * @author alexandre
 *
 */
public class Ruine extends Batiment {
	
	private String image1 = "/assets/images/batiments/ruine1.png";
	private String image2 = "/assets/images/batiments/ruine2.png";
	
	public Ruine() {
		super("Ruine", 0, 0, 0, 0,  20, 10, 30, 1000, 0, 0);
		if(Math.random() <0.5) {
			this.icoObjet = new ImageIcon(getClass().getResource(image1));			
		} else {
			this.icoObjet = new ImageIcon(getClass().getResource(image2));	
		}
		this.imgObjet = icoObjet.getImage();
	}
	
	public Ruine(int x, int y, int hauteur, int largeur) {
		super("Ruine", x, y, hauteur, largeur, 20, 10, 30, 1000, 0, 0);
		if(Math.random() <0.5) {
			this.icoObjet = new ImageIcon(getClass().getResource(image1));			
		} else {
			this.icoObjet = new ImageIcon(getClass().getResource(image2));	
		}
		this.imgObjet = icoObjet.getImage();
	}
	
	public Ruine(int x, int y) {
		super("Ruine", x, y, 20, 10, 30, 1000, 0, 0);
		if(Math.random() <0.5) {
			this.icoObjet = new ImageIcon(getClass().getResource(image1));			
		} else {
			this.icoObjet = new ImageIcon(getClass().getResource(image2));	
		}
		this.imgObjet = icoObjet.getImage();
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
