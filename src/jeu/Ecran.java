package jeu;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import elements.ObjetAffiche;
import elements.monde.Arbre;
import main.main;
import ville.Ville;

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
	
	private List<ObjetAffiche> tabObjets = new ArrayList<>(); //liste des objets à afficher
	
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
        
        createArbres();
        
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
			for(int i = 0; i < Ville.getBatiments().size(); i++){Ville.getBatiments().get(i).deplacement();}
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
		
 		//Afficher les objets du décor
 		for(ObjetAffiche objet : tabObjets) {
 			g2.drawImage(objet.getImgObjet(), objet.getX(), objet.getY(), objet.getLargeur(), objet.getHauteur(), null);
 		}
 		//Afficher les bâtiments
 		for(ObjetAffiche objet : Ville.getBatiments()) {
 			g2.drawImage(objet.getImgObjet(), objet.getX(), objet.getY(), objet.getLargeur(), objet.getHauteur(), null);
 		}
 		
 		//Afficher les menus
 		//laisser en dernier
 		g2.drawImage(this.imgMenu, this.xMenu, 0, (int) screenSize.getWidth(), (int) screenSize.getHeight()*17/100, null);
 		g2.drawImage(this.imgMenuBas, this.xMenuBas, this.yMenuBas, (int) screenSize.getWidth(), (int) screenSize.getHeight()*15/100, null);
 		
	}
	
	public void createArbres() {
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*80/100), (int) (main.screensize.getHeight()*40/100)));
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*81/100), (int) (main.screensize.getHeight()*40/100)));
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*81/100), (int) (main.screensize.getHeight()*42/100)));
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*82/100), (int) (main.screensize.getHeight()*40/100)));
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*82/100), (int) (main.screensize.getHeight()*42/100)));
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*82/100), (int) (main.screensize.getHeight()*43/100)));
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*83/100), (int) (main.screensize.getHeight()*43/100)));
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*83/100), (int) (main.screensize.getHeight()*45/100)));
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*83/100), (int) (main.screensize.getHeight()*46/100)));
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*85/100), (int) (main.screensize.getHeight()*48/100)));
        //10
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*85/100), (int) (main.screensize.getHeight()*47/100)));
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*86/100), (int) (main.screensize.getHeight()*45/100)));
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*88/100), (int) (main.screensize.getHeight()*42/100)));
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*88/100), (int) (main.screensize.getHeight()*45/100)));
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*90/100), (int) (main.screensize.getHeight()*47/100)));
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*90/100), (int) (main.screensize.getHeight()*48/100)));
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*91/100), (int) (main.screensize.getHeight()*44/100)));
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*91/100), (int) (main.screensize.getHeight()*45/100)));
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*92/100), (int) (main.screensize.getHeight()*49/100)));
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*93/100), (int) (main.screensize.getHeight()*45/100)));
        //20
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*80/100), (int) (main.screensize.getHeight()*50/100)));
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*81/100), (int) (main.screensize.getHeight()*50/100)));
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*81/100), (int) (main.screensize.getHeight()*52/100)));
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*82/100), (int) (main.screensize.getHeight()*53/100)));
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*82/100), (int) (main.screensize.getHeight()*54/100)));
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*82/100), (int) (main.screensize.getHeight()*55/100)));
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*83/100), (int) (main.screensize.getHeight()*55/100)));
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*83/100), (int) (main.screensize.getHeight()*56/100)));
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*83/100), (int) (main.screensize.getHeight()*57/100)));
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*85/100), (int) (main.screensize.getHeight()*50/100)));
        //10
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*85/100), (int) (main.screensize.getHeight()*57/100)));
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*86/100), (int) (main.screensize.getHeight()*52/100)));
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*88/100), (int) (main.screensize.getHeight()*58/100)));
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*88/100), (int) (main.screensize.getHeight()*60/100)));
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*90/100), (int) (main.screensize.getHeight()*60/100)));
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*90/100), (int) (main.screensize.getHeight()*65/100)));
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*91/100), (int) (main.screensize.getHeight()*63/100)));
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*91/100), (int) (main.screensize.getHeight()*66/100)));
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*92/100), (int) (main.screensize.getHeight()*69/100)));
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*93/100), (int) (main.screensize.getHeight()*71/100)));
        //20
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*94/100), (int) (main.screensize.getHeight()*57/100)));
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*94/100), (int) (main.screensize.getHeight()*52/100)));
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*95/100), (int) (main.screensize.getHeight()*58/100)));
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*96/100), (int) (main.screensize.getHeight()*60/100)));
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*96/100), (int) (main.screensize.getHeight()*60/100)));
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*97/100), (int) (main.screensize.getHeight()*65/100)));
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*97/100), (int) (main.screensize.getHeight()*63/100)));
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*97/100), (int) (main.screensize.getHeight()*66/100)));
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*97/100), (int) (main.screensize.getHeight()*69/100)));
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*98/100), (int) (main.screensize.getHeight()*71/100)));
        //30
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*98/100), (int) (main.screensize.getHeight()*57/100)));
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*99/100), (int) (main.screensize.getHeight()*52/100)));
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*100/100), (int) (main.screensize.getHeight()*58/100)));
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*100/100), (int) (main.screensize.getHeight()*60/100)));
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*101/100), (int) (main.screensize.getHeight()*60/100)));
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*101/100), (int) (main.screensize.getHeight()*65/100)));
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*102/100), (int) (main.screensize.getHeight()*63/100)));
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*103/100), (int) (main.screensize.getHeight()*66/100)));
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*103/100), (int) (main.screensize.getHeight()*69/100)));
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*103/100), (int) (main.screensize.getHeight()*71/100)));
        //40
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*94/100), (int) (main.screensize.getHeight()*77/100)));
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*94/100), (int) (main.screensize.getHeight()*72/100)));
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*95/100), (int) (main.screensize.getHeight()*78/100)));
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*96/100), (int) (main.screensize.getHeight()*80/100)));
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*96/100), (int) (main.screensize.getHeight()*80/100)));
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*97/100), (int) (main.screensize.getHeight()*85/100)));
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*97/100), (int) (main.screensize.getHeight()*83/100)));
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*97/100), (int) (main.screensize.getHeight()*86/100)));
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*97/100), (int) (main.screensize.getHeight()*89/100)));
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*98/100), (int) (main.screensize.getHeight()*91/100)));
        //50
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*98/100), (int) (main.screensize.getHeight()*77/100)));
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*99/100), (int) (main.screensize.getHeight()*72/100)));
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*100/100), (int) (main.screensize.getHeight()*78/100)));
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*100/100), (int) (main.screensize.getHeight()*80/100)));
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*101/100), (int) (main.screensize.getHeight()*80/100)));
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*101/100), (int) (main.screensize.getHeight()*85/100)));
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*102/100), (int) (main.screensize.getHeight()*83/100)));
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*103/100), (int) (main.screensize.getHeight()*86/100)));
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*103/100), (int) (main.screensize.getHeight()*89/100)));
        tabObjets.add(new Arbre((int) (main.screensize.getWidth()*103/100), (int) (main.screensize.getHeight()*91/100)));
        //60
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
	
	public Dimension getScreenSize() {return screenSize;}
	
	public List<ObjetAffiche> getTabObjets(){return tabObjets;}
	
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
	
	public void setTabObjets(List<ObjetAffiche> liste) {this.tabObjets = liste;}
	
	public void mergeTabObjets(List<ObjetAffiche> liste) {
		for(ObjetAffiche objet:liste) {
			if(!tabObjets.contains(objet)) {
				tabObjets.add(objet);
			}
		}
	}

}
