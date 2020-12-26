package elements;

import java.awt.Image;

import javax.swing.ImageIcon;

import main.main;

public abstract class ObjetAffiche {
	
	//**** VARIABLES ****//
		 //dimensions de l'objet
		protected int x, y; //position de l'objet	
		protected Image imgObjet;
		protected ImageIcon icoObjet;
		protected int hauteurBase = (int) (main.screensize.getHeight()*5/100);
		protected int largeurBase = (int) (main.screensize.getWidth()*5/100);
		protected int largeur = largeurBase;
		protected int hauteur = hauteurBase;
		
		
		//**** CONSTRUCTEUR ****//	
		protected ObjetAffiche(int x, int y, int largeur, int hauteur){		
		    this.x = x;
			this.y = y;
			this.largeur = largeur;
			this.hauteur = hauteur;
		}
		
		protected ObjetAffiche(int x, int y){		
		    this.x = x;
			this.y = y;
		}
		
		
	    //**** GETTERS ****//	
	    public int getX() {return x;}

		public int getY() {return y;}

		public int getLargeur() {return largeur;}

		public int getHauteur() {return hauteur;}
		
		public Image getImgObjet() {return imgObjet;}


		//**** SETTERS ****//	
		public void setX(int x) {this.x = x;}

		public void setY(int y) {this.y = y;}

		public void setLarg(int largeur) {this.largeur = largeur;}

		public void setHaut(int hauteur) {this.hauteur = hauteur;}
		
		
		//**** METHODES ****//
		public void deplacement() {
			this.setX(this.getX() - 5*main.ecran.getDx());
		}

}
