package jeu;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import batiments.ObjetAffiche;

public class Ecran extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4872839325311816127L;
	
	
	private ImageIcon icoFond1;
	private Image imgFond1;
	private ImageIcon icoFond2;
	private Image imgFond2;
	private ImageIcon icoFond3;
	private Image imgFond3;
	private ImageIcon icoFond4;
	private Image imgFond4;
	private ImageIcon icoPremierPlan;
	private Image imgPremierPlan;
	private ImageIcon icoMenu;
	private Image imgMenu;
	private ImageIcon icoMenuBas;
	private Image imgMenuBas;
	private ImageIcon icoRuine1;
	private Image imgRuine1;
	
	Dimension screenSize;
	
	private int xFond1=0;
	private int xFond2=0;
	private int xFond3=0;
	private int xFond4=0;
	private int xPremierPlan=0;
	private int xMenu=0;
	private int xMenuBas=0;
	private int xRuine1=900;
	
	private int yMenuBas=860;
	private int yRuine1=600;
	
	private int defaultSize = 2000;
	
	private int dx=0; // déplacement horizontal du fond d'écran.
	private int xPos=0; // position de l'observateur
	
	private ArrayList<ObjetAffiche> tabObjets = new ArrayList<>(); //liste des objets à afficher
	
	public Ecran() {
		super ();
		
		icoFond1 = new ImageIcon(getClass().getResource("/assets/images/fond/fond1.png"));
        imgFond1 = icoFond1.getImage();
		icoFond2 = new ImageIcon(getClass().getResource("/assets/images/fond/fond2.png"));
        imgFond2 = icoFond2.getImage();
		icoFond3 = new ImageIcon(getClass().getResource("/assets/images/fond/fond3.png"));
        imgFond3 = icoFond3.getImage();
		icoFond4 = new ImageIcon(getClass().getResource("/assets/images/fond/fond4.png"));
        imgFond4 = icoFond4.getImage();
        icoPremierPlan = new ImageIcon(getClass().getResource("/assets/images/fond/premierPlan.png"));
        imgPremierPlan = icoPremierPlan.getImage();
		icoMenu = new ImageIcon(getClass().getResource("/assets/images/fond/menu.png"));
        imgMenu = icoMenu.getImage();
        icoMenuBas = new ImageIcon(getClass().getResource("/assets/images/fond/menuBas.png"));
        imgMenuBas = icoMenuBas.getImage();
        icoRuine1 = new ImageIcon(getClass().getResource("/assets/images/batiments/ruine1.png"));
        imgRuine1 = icoRuine1.getImage();
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        this.setFocusable(true);  
		this.requestFocusInWindow();
		this.addKeyListener(new ClavierListener());
		
		Thread timer = new Thread(new Timer());
		timer.start();
	}
	
	/**
	 * Déplace la scène de la valeur de dx
	 */
	public void deplacement() { // Déplacement de la scène
		if (xPos>=0 && xPos <= defaultSize){
			this.xPos += this.dx;
			this.xFond1 -= this.dx;
			this.xFond2 -= 2*this.dx;
			this.xFond3 -= 3*this.dx;
			this.xFond4 -= 4*this.dx;
			this.xPremierPlan -= 5*this.dx;
			this.xRuine1 -= 5*this.dx;
			for(int i = 0; i < this.tabObjets.size(); i++){this.tabObjets.get(i).deplacement();}			
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
 		super.paintComponent(g);
 		Graphics g2 = (Graphics2D) g;
 		
 		this.deplacement();
 		
 		g2.drawImage(this.imgFond1, this.xFond1, 0, defaultSize*2, (int) screenSize.getHeight(), null);
 		g2.drawImage(this.imgFond2, this.xFond2, 0, defaultSize*3, (int) screenSize.getHeight(), null);
 		g2.drawImage(this.imgFond3, this.xFond3, 0, defaultSize*4, (int) screenSize.getHeight(), null);
 		g2.drawImage(this.imgFond4, this.xFond4, 0, defaultSize*5, (int) screenSize.getHeight(), null);
 		g2.drawImage(this.imgPremierPlan, this.xPremierPlan, 0, defaultSize*6, (int) screenSize.getHeight(), null);
 		g2.drawImage(this.imgMenu, this.xMenu, 0, (int) screenSize.getWidth(), (int) screenSize.getHeight()*17/100, null);
 		g2.drawImage(this.imgMenuBas, this.xMenuBas, this.yMenuBas, (int) screenSize.getWidth(), (int) screenSize.getHeight()*15/100, null);
 		g2.drawImage(this.imgRuine1, this.xRuine1, this.yRuine1, (int) screenSize.getWidth()*10/100, (int) screenSize.getHeight()*10/100, null);
 		
	}
	
	//**** GETTERS ****//	
	public int getDx() {return dx;}
	
	public int getxPos() {return xPos;}
	
	public int getxFond1() {return xFond1;}
	
	public int getxFond2() {return xFond2;}

	public int getxFond3() {return xFond3;}
	
	public int getxFond4() {return xFond4;}
	
	public int getxPremierPlan() {return xPremierPlan;}
	
	public int getxMenu() {return xMenu;}
	
	public int getxMenuBas() {return xMenuBas;}
	
	public int getxRuine1() {return xRuine1;}
	
	public int getDefaultSize() {return defaultSize;}
	
	//**** SETTERS ****//
	public void setDx(int dx) {this.dx = dx;}

	public void setxPos(int xPos) {this.xPos = xPos;}

	public void setxFond1(int xFond1) {this.xFond1 = xFond1;}

	public void setxFond2(int xFond2) {this.xFond2 = xFond2;}	
	
	public void setxFond3(int xFond3) {this.xFond3 = xFond3;}

	public void setxFond4(int xFond4) {this.xFond4 = xFond4;}	
	
	public void setxPremierPlan(int xPremierPlan) {this.xPremierPlan=xPremierPlan;}
	
	public void setxMenu(int xMenu) {this.xMenu=xMenu;}
	
	public void setxMenuBas(int xMenuBas) {this.xMenu=xMenuBas;}
	
	public void setxRuine1(int xRuine1) {this.xMenu=xRuine1;}

}
