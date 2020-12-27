package elements.monde;

import javax.swing.ImageIcon;

public class Arbre extends Placable {

	public Arbre(int x, int y) {
		super(x, y);
		Double toss = Math.random();
		this.hauteur=hauteurBase*2;
		this.largeur=largeurBase*1;
		if(toss<0.3) {
			this.icoObjet = new ImageIcon(getClass().getResource("/assets/images/ressources/arbre1.png"));
		} else if (toss<0.6) {
			this.icoObjet = new ImageIcon(getClass().getResource("/assets/images/ressources/arbre2.png"));
		} else {
			this.icoObjet = new ImageIcon(getClass().getResource("/assets/images/ressources/arbre3.png"));
		}
		this.imgObjet = icoObjet.getImage();
	}

}
