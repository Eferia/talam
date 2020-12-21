package batiments;

import ville.Ville;

/**
 * La vieille tour en ruine � reconstruire
 * @author alexandre
 *
 */
public class VieilleTour extends Batiment {

	protected VieilleTour(String nom, int coutBois, int coutAcier, int coutPierre, int durabilite,
			int tempsConstruction, int attractivite) {
		super(nom, coutBois, coutAcier, coutPierre, durabilite, tempsConstruction, attractivite);
		// TODO Auto-generated constructor stub
	}
	
	public VieilleTour() {
		super("Vieille Tour", 0, 0, 0, 0, 0, 1);
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
