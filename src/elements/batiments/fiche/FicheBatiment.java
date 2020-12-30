package elements.batiments.fiche;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import elements.ObjetAffiche;
import main.main;

/**
 * Fenêtre qui s'affiche lorsqu'on clique sur un bâtiment
 * @author alexandre
 *
 */
public class FicheBatiment extends ObjetAffiche {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7033554303334192436L;
	
	private boolean isAffiche = false;
	
	private int largeurFiche=largeurBase*4;
	private int hauteurFiche=hauteurBase*3;

	private String visuelFenetre = "/assets/images/ficheBatiment.png";
	URL url = getClass().getResource("/assets/images/RINGM__.TTF");

	protected FicheBatiment(int x, int y) {
		super(x, y);
		this.setBounds(x, y, largeurFiche, hauteurFiche);
		this.addMouseListener(new FicheListener());
	}
	
	public FicheBatiment(int x, int y, String texte, ImageIcon image) {
		super(x, y);
		this.icoObjet = resizeToFit(visuelFenetre, largeurFiche, hauteurFiche);
		this.setBounds(x, y, largeurFiche, hauteurFiche);
		this.setIcon(icoObjet);
		this.setFont(getFonte());
		this.setText(texte);
		this.setForeground(Color.white);
		this.setHorizontalTextPosition(JLabel.CENTER);
		this.setVerticalTextPosition(JLabel.CENTER);
		this.addMouseListener(new FicheListener());
	}
	
	//TODO centrer la fiche, une seule fiche à la fois
	
	private Font getFonte() {
		Font fonte = new Font("Arial", Font.ITALIC, 15);
		try {
			 fonte = Font.createFont(Font.TRUETYPE_FONT, new File(url.getPath()));
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
	
	@Override
	public void deplacement() {
		this.setX(this.getX() - 5*main.ecran.getDx());
		this.setBounds(x, y, largeurFiche, largeurFiche);
	}
	
	private class FicheListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			FicheBatiment.this.isAffiche = !FicheBatiment.this.isAffiche;
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public boolean isAffiche() {
		return this.isAffiche;
	}
	
	public void setIsAffiche(boolean isAffiche) {
		this.isAffiche=isAffiche;
	}
	
	public void toggleIsAffiche() {
		this.isAffiche = !this.isAffiche;
	}

	public int getLargeurFiche() {
		return largeurFiche;
	}

	public void setLargeurFiche(int largeurFiche) {
		this.largeurFiche = largeurFiche;
	}

	public int getHauteurFiche() {
		return hauteurFiche;
	}

	public void setHauteurFiche(int hauteurFiche) {
		this.hauteurFiche = hauteurFiche;
	}

}
