package elements.batiments.fiche;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;

import main.main;

public class FicheBatiment2 extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6177289714655353712L;
	
	private boolean isAffiche = false;
	
	private JButton boutonFermer;
	private JLabel texteDescription;
	private JLabel texteNom;
	
	Image background;
	
	Image batiment;
	
	private int largeur = (int) (main.screensize.getHeight()*5/100) * 4;
	private int hauteur = (int) (main.screensize.getHeight()*5/100) * 3;
	
	private String visuelFenetre = "/assets/images/ficheBatiment.png";
	private String cheminFonte = "/assets/images/RINGM__.TTF";
	private String imageBoutonFermer = "/assets/images/boutonFermer.png";
	
	public FicheBatiment2(int x, int y, String nom, String texte, ImageIcon image) {
		super(main.fenetre);
		//fenetre
		this.setLocation(new Point(x, y));
		this.setSize(largeur, hauteur);
        this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        this.setUndecorated(true);
        this.setLocationRelativeTo(null);
        this.setTitle(nom);
        //contenu - background
        ImageIcon backgroundIcon = resizeToFit(visuelFenetre, largeur, hauteur);
        background = backgroundIcon.getImage();
        this.setContentPane(new BackgroundPane(background));
        //contenu - image
        this.getContentPane().add(new JLabel(image));
        batiment = image.getImage();
        this.getContentPane().revalidate();
        this.getContentPane().repaint();
        //contenu - description
        this.initDescription(texte);
        this.add(texteDescription);
        //contenu - nom du bâtiment
        this.initNom(nom);
        this.add(texteNom);
        //fenetre
        this.revalidate();
        this.repaint();
//        this.pack();
	}
	
	@Override
	public void paintComponents(Graphics g) {
		super.paintComponents(g);
		
		Graphics g2 = (Graphics2D) g;
		
		g2.drawImage(batiment, (int) this.getLocation().getX(), (int) this.getLocation().getY(), largeur, hauteur, this);
		
	}
	
	/**
	 * Crée l'image à afficher à partir d'un fichier
	 * @param file Image à utiliser
	 * @param largeur Largeur du JLabel
	 * @param hauteur Hauteur du JLabel
	 * @return Icone utilisable par JLabel
	 */
	private ImageIcon resizeToFit(String file, int largeur, int hauteur) {
		System.out.println("resizing "+file+" to "+hauteur+", "+largeur);
		return new ImageIcon(new ImageIcon(getClass().getResource(file)).getImage().getScaledInstance(largeur, hauteur, Image.SCALE_DEFAULT));
	}
	
	/**
	 * Crée le JLabel avec la description
	 * @param texte
	 */
	private void initDescription(String texte) {
		this.texteDescription = new JLabel(texte);
		this.texteDescription.setFont(getFonte());
		this.texteDescription.setForeground(Color.white);
	}
	
	private void initNom(String nom) {
		this.texteNom = new JLabel(nom);
		this.texteNom.setFont(getFonte());
		this.texteNom.setForeground(Color.white);
	}
	
	/**
	 * Récupère la fonte
	 * @return
	 */
	private Font getFonte() {
		Font fonte = new Font("Arial", Font.ITALIC, 15);
		try {
			 fonte = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream(cheminFonte));
			 fonte = fonte.deriveFont((float) 15);
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fonte;
	}
	
	public boolean isAffiche() {
		return isAffiche;
	}

	public void setAffiche(boolean isAffiche) {
		this.isAffiche = isAffiche;
	}
	
	public void toggleIsAffiche() {
		this.isAffiche = !this.isAffiche;
	}

	public int getLargeur() {
		return largeur;
	}
	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}
	public int getHauteur() {
		return hauteur;
	}
	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}
	
	/**
	 * Pour l'image de fond
	 * @author alexandre
	 *
	 */
	private class BackgroundPane extends JComponent{
		
	    /**
		 * 
		 */
		private static final long serialVersionUID = -8218447477075937392L;
		
		final Image img;
	    
		public BackgroundPane (Image image) {
	        img = image;
	    }
	    
		@Override
	    public void paintComponent (Graphics g) {
	        super.paintComponent (g);
	        g.drawImage (img, 0, 0, this);
	    }
		
	}

}
