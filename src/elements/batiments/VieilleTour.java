package elements.batiments;

import ville.Ville;

/**
 * La vieille tour en ruine à reconstruire pour débloque la magie
 * @author alexandre
 *
 */
public class VieilleTour extends Batiment {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4906801708657722326L;
	private String tour0 = "/assets/images/batiments/tour0.png";
	
	private static String nom = "Vieille Tour";
	private String descriptionR = "Une tour mystérieuse qui surplombe la ville, que l'on peut apercevoir lorsque le brouillard se lève. #mystere #magie #ruinedanslebrouillard";

	public VieilleTour() {
		super(nom, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1);
		//Bâtiment d'histoire
		this.setDestructible(false);
		this.setDescription(descriptionR);
		this.icoObjetNoClick = resizeToFit(tour0);
		this.icoObjetClick = resizeToFit(tour0);
		this.icoObjet = icoObjetNoClick;
		this.setIcon(icoObjet);
	}
	
	public VieilleTour(int x, int y, int hauteur, int largeur) {
		super(nom, x, y, hauteur, largeur, 0, 0, 0, 0, 0, 1);
		//Bâtiment d'histoire
		this.setDestructible(false);
		this.setDescription(descriptionR);
		this.icoObjetNoClick = resizeToFit(tour0);
		this.icoObjetClick = resizeToFit(tour0);
		this.icoObjet = icoObjetNoClick;
		this.setIcon(icoObjet);
	}
	
	public VieilleTour(int x, int y) {
		super(nom, x, y, 0, 0, 0, 0, 0, 1);
		this.hauteur=(int) (hauteurBase*4);
		this.largeur=(int) (largeurBase*2.5);
		this.setDestructible(false);
		this.setDescription(descriptionR);
		this.icoObjetNoClick = resizeToFit(tour0);
		this.icoObjetClick = resizeToFit(tour0);
		this.icoObjet = icoObjetNoClick;
		this.setIcon(icoObjet);
	}
	
	
	@Override
	public boolean isConstructible() {
		return false;
	}

	@Override
	public void postConstruct(Ville ville) {
		//N'est pas constructible
	}

	@Override
	public void postDestruct(Ville ville) {
		//N'est pas destructible
	}

}
