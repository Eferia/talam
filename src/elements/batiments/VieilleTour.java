package elements.batiments;

import javax.swing.ImageIcon;

import ville.Ville;

/**
 * La vieille tour en ruine à reconstruire
 * @author alexandre
 *
 */
public class VieilleTour extends Batiment {
	
	private String tour0 = "/assets/images/batiments/tour0.png";

	public VieilleTour() {
		super("Vieille Tour", 0, 0, 0, 0, 0, 0, 0, 0, 0, 1);
		//Bâtiment d'histoire
		this.setDestructible(false);
		this.setDescription("Une tour mystérieuse qui surplombe la ville, que l'on peut apercevoir lorsque le brouillard se lève. #mystere #magie #ruinedanslebrouillard");
		this.icoObjetNoClick = resizeToFit(tour0);
		this.icoObjetClick = resizeToFit(tour0);
		this.setIcon(icoObjet);
	}
	
	public VieilleTour(int x, int y, int hauteur, int largeur) {
		super("Vieille Tour", x, y, hauteur, largeur, 0, 0, 0, 0, 0, 1);
		//Bâtiment d'histoire
		this.setDestructible(false);
		this.setDescription("Une tour mystérieuse qui surplombe la ville, que l'on peut apercevoir lorsque le brouillard se lève. #mystere #magie #ruinedanslebrouillard");
		this.icoObjetNoClick = resizeToFit(tour0);
		this.icoObjetClick = resizeToFit(tour0);
		this.setIcon(icoObjet);
	}
	
	public VieilleTour(int x, int y) {
		super("Ruine", x, y, 0, 0, 0, 0, 0, 1);
		this.hauteur=(int) (hauteurBase*4);
		this.largeur=(int) (largeurBase*2.5);
		this.setDestructible(false);
		this.setDescription("Une tour mystérieuse qui surplombe la ville, que l'on peut apercevoir lorsque le brouillard se lève. #mystere #magie #ruinedanslebrouillard");
		this.icoObjetNoClick = resizeToFit(tour0);
		this.icoObjetClick = resizeToFit(tour0);
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
