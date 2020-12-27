package elements;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import main.main;

public abstract class ObjetAffiche extends JLabel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4188871400191346268L;
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
			super();
		    this.x = x;
			this.y = y;
			this.largeur = largeur;
			this.hauteur = hauteur;
			this.setBounds(x, y, largeur, hauteur);
			this.setLocation(x, y);
		}
		
		protected ObjetAffiche(int x, int y){	
			super();
		    this.x = x;
			this.y = y;
			this.setBounds(x, y, largeur, hauteur);
			this.setLocation(x, y);
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
		
		public void setImgObjet(Image image) {this.imgObjet = image;}
		
		
		//**** METHODES ****//
		public void deplacement() {
			this.setX(this.getX() - 5*main.ecran.getDx());
			this.setBounds(x, y, largeur, hauteur);
		}
		
		public ImageIcon resizeToFit(String file) {
			System.out.println("resizing "+file+" to "+hauteur+", "+largeur);
//			return new ImageIcon(getClass().getResource(file));
			return new ImageIcon(new ImageIcon(getClass().getResource(file)).getImage().getScaledInstance(largeur, hauteur, Image.SCALE_DEFAULT));
		}

}
