package batiments;

import ville.Ville;

/**
 * La vieille tour en ruine � reconstruire
 * @author alexandre
 *
 */
public class VieilleTour extends Batiment {

	public VieilleTour() {
		super("Vieille Tour", 0, 0, 0, 0, 0, 0, 0, 0, 0, 1);
		//B�timent d'histoire
		this.setDestructible(false);
		this.setDescription("Une tour myst�rieuse qui surplombe la ville, que l'on peut apercevoir lorsque le brouillard se l�ve. #mystere #magie #ruinedanslebrouillard");
	}
	
	public VieilleTour(int x, int y, int hauteur, int largeur) {
		super("Vieille Tour", x, y, hauteur, largeur, 0, 0, 0, 0, 0, 1);
		//B�timent d'histoire
		this.setDestructible(false);
		this.setDescription("Une tour myst�rieuse qui surplombe la ville, que l'on peut apercevoir lorsque le brouillard se l�ve. #mystere #magie #ruinedanslebrouillard");
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
