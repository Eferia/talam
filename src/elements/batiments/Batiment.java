package elements.batiments;

import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;

import elements.ObjetAffiche;
import ressources.Ressource;
import ville.Ville;

public abstract class Batiment extends ObjetAffiche {
	
	private String nom;
	
	//image en cas de clic/non clic
	protected Image imgObjetNoClick;
	protected ImageIcon icoObjetNoClick;
	protected Image imgObjetClick;
	protected ImageIcon icoObjetClick;
	
	//ressources
	private int coutBois;
	private int coutAcier;
	private int coutPierre;
	
	//caractéristiques
	private int durabilite;
	private int tempsConstruction;
	private int attractivite;
	
	//un seul bâtiment ne sera pas destructible
	private boolean isDestructible = true;
	
	private String description;
	
	protected Batiment(String nom, int x, int y, int largeur, int hauteur, int coutBois, int coutAcier, int coutPierre, int durabilite, int tempsConstruction, int attractivite) {
		super(x, y, largeur, hauteur);
		this.nom=nom;
		this.coutBois=coutBois;
		this.coutAcier=coutAcier;
		this.coutPierre=coutPierre;
		this.durabilite=durabilite;
		this.setTempsConstruction(tempsConstruction);
		this.attractivite=attractivite;
		this.description="Ceci n'est pas un(e) "+nom;
		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
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
				Batiment.this.imgObjet=Batiment.this.imgObjetClick;
			}

			@Override
			public void mouseExited(MouseEvent e) {
				Batiment.this.imgObjet=Batiment.this.imgObjetNoClick;
			}
			
		});
	}
	
	protected Batiment(String nom, int x, int y, int coutBois, int coutAcier, int coutPierre, int durabilite, int tempsConstruction, int attractivite) {
		super(x, y);
		this.nom=nom;
		this.coutBois=coutBois;
		this.coutAcier=coutAcier;
		this.coutPierre=coutPierre;
		this.durabilite=durabilite;
		this.setTempsConstruction(tempsConstruction);
		this.attractivite=attractivite;
		this.description="Ceci n'est pas un(e) "+nom;
		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("clic");
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
				Batiment.this.setIcon(Batiment.this.icoObjetClick);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				Batiment.this.setIcon(Batiment.this.icoObjetNoClick);
			}
			
		});
	}
	
	public int degat(int degats) {
		this.durabilite-=degats;
		return this.durabilite;
	}
	
	/**
	 * Vérifie que le bâtiment est constructible, sans le construire
	 * @return true si le bâtiment est constructible
	 */
	public boolean isConstructible() {
		return (this.getCoutAcier()<=Ressource.ACIER.getQuantite() &&
				this.getCoutBois()<=Ressource.BOIS.getQuantite() &&
				this.getCoutPierre()<=Ressource.PIERRE.getQuantite());
	}
	
	/**
	 * Tente de construire le bâtiment
	 * @return true si le bâtiment a été construit
	 */
	public boolean construire() {
		if(this.isConstructible()) {
			Ressource.ACIER.perteRessource(this.getCoutAcier());
			Ressource.BOIS.perteRessource(this.getCoutBois());
			Ressource.PIERRE.perteRessource(this.getCoutPierre());
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Tente de détruire le bâtiment pour récupérer des ressources
	 * @return true si le bâtiment a été détruit
	 */
	public boolean destruction() {
		if(this.isDestructible()) {
			Ressource.ACIER.gainRessource(this.getCoutAcier()/2);
			Ressource.BOIS.gainRessource(this.getCoutBois()/2);
			Ressource.PIERRE.gainRessource(this.getCoutPierre()/2);
			return true;
		} else {
			return false;
		}
	}
	
	
	/**
	 * Applique les effets de construction d'un bâtiment.
	 * @param ville
	 */
	public abstract void postConstruct(Ville ville);
	
	/**
	 * Retire les effets apportés par le bâtiment après destruction.
	 * @param ville
	 */
	public abstract void postDestruct(Ville ville);
	

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Image getImgObjetClick() {
		return imgObjetClick;
	}

	public void setImgObjetClick(Image imgObjetClick) {
		this.imgObjetClick = imgObjetClick;
	}

	public ImageIcon getIcoObjetClick() {
		return icoObjetClick;
	}

	public void setIcoObjetClick(ImageIcon icoObjetClick) {
		this.icoObjetClick = icoObjetClick;
	}

	public int getCoutBois() {
		return coutBois;
	}

	public void setCoutBois(int coutBois) {
		this.coutBois = coutBois;
	}

	public int getCoutAcier() {
		return coutAcier;
	}

	public void setCoutAcier(int coutAcier) {
		this.coutAcier = coutAcier;
	}

	public int getCoutPierre() {
		return coutPierre;
	}

	public void setCoutPierre(int coutPierre) {
		this.coutPierre = coutPierre;
	}

	public int getDurabilite() {
		return durabilite;
	}

	public void setDurabilite(int durabilite) {
		this.durabilite = durabilite;
	}

	public int getTempsConstruction() {
		return tempsConstruction;
	}

	public void setTempsConstruction(int tempsConstruction) {
		this.tempsConstruction = tempsConstruction;
	}

	public int getAttractivite() {
		return attractivite;
	}

	public void setAttractivite(int attractivite) {
		this.attractivite = attractivite;
	}

	public boolean isDestructible() {
		return isDestructible;
	}

	public void setDestructible(boolean isDestructible) {
		this.isDestructible = isDestructible;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

}
