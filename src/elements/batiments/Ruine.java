package elements.batiments;

import elements.batiments.fiche.FicheBatiment;
import ville.Ville;

/**
 * Bâtiment présent au début du jeu, à détruire pour obtenir des ressources
 * @author alexandre
 *
 */
public class Ruine extends Batiment {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7231480429307725299L;
	private String image1 = "/assets/images/batiments/ruine1.png";
	private String imageClick1 = "/assets/images/batiments/ruine1Click.png";
	private String image2 = "/assets/images/batiments/ruine2.png";
	private String imageClick2 = "/assets/images/batiments/ruine2Click.png";
	
	private static String nom = "Ruine";
	
	private String descriptionR = "Cela a sûrement été une maison, mais c'est inhabitable";
	
	public Ruine() {
		super(nom, 0, 0, 0, 0,  20, 10, 30, 1000, 0, 0);
		if(Math.random() <0.5) {
			this.icoObjetNoClick = resizeToFit(image1);
			this.icoObjetClick = resizeToFit(imageClick1);
		} else {
			this.icoObjetNoClick = resizeToFit(image2);
			this.icoObjetClick = resizeToFit(imageClick2);
		}
		this.icoObjet = icoObjetNoClick;
		this.setIcon(icoObjet);
		this.description = descriptionR;
		setFiche();
	}
	
	public Ruine(int x, int y, int hauteur, int largeur) {
		super(nom, x, y, hauteur, largeur, 20, 10, 30, 1000, 0, 0);
		if(Math.random() <0.5) {
			this.icoObjetNoClick = resizeToFit(image1);
			this.icoObjetClick = resizeToFit(imageClick1);
		} else {
			this.icoObjetNoClick = resizeToFit(image2);
			this.icoObjetClick = resizeToFit(imageClick2);
		}
		this.icoObjet = icoObjetNoClick;
		this.setIcon(icoObjet);
		this.setSize(largeur, hauteur);
		this.description = descriptionR;
		setFiche();
	}
	
	public Ruine(int x, int y) {
		super(nom, x, y, 20, 10, 30, 1000, 0, 0);
		if(Math.random() <0.5) {
			this.icoObjetNoClick = resizeToFit(image1);
			this.icoObjetClick = resizeToFit(imageClick1);
		} else {
			this.icoObjetNoClick = resizeToFit(image2);
			this.icoObjetClick = resizeToFit(imageClick2);
		}
		this.icoObjet = icoObjetNoClick;
		this.setIcon(icoObjet);
		this.description = descriptionR;
		setFiche();
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
