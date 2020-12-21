package ressources;

public enum Ressource {
	
	BOIS("Bois", 0.0, 0, 0.0),
	NOURRITURE("Nourriture", 0.0, 0, 0.0),
	ACIER("Acier", 0.0, 0, 0.0),
	PIERRE("Pierre", 0.0, 0, 0.0);
	
	private String nom;
	private Double quantite;
	private int limite;
	private Double croissance;
	
	private Ressource(String nom, Double quantite, int limite, Double croissance) {
		this.nom=nom;
		this.quantite=quantite;
		this.limite=limite;
		this.croissance=croissance;
	}
	
	public Double gainRessource(int quantiteAjoutee) {
		if(this.quantite+quantiteAjoutee<=limite) {
			this.quantite += quantiteAjoutee;
		} else {
			this.quantite = Double.valueOf(limite);
		}
		return this.quantite;
	}
	
	public boolean perteRessource(int quantiteRetiree) {
		if(this.quantite-quantiteRetiree>=0) {
			this.quantite -= quantiteRetiree;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean possede(int quantiteRequise) {
		return (this.quantite>=quantiteRequise);
	}
	
	public void addCroissance(Double croissanceAjoutee) {
		this.croissance+=croissanceAjoutee;
	}
	
	public void loseCroissance(Double croissanceRetiree) {
		this.croissance-=croissanceRetiree;
	}
	
	public void croit() {
		this.quantite+=this.croissance;
	}
	
	public int quantiteAAfficher() {
		return this.quantite.intValue();
	}
	
	//getters
	public String getNom() {
		return this.nom;
	}
	
	public Double getQuantite() {
		return this.quantite;
	}
	
	public void setQuantite(Double quantite) {
		this.quantite=quantite;
	}
	
	public int getLimite() {
		return this.limite;
	}
	
	public void setLimite(int limite) {
		this.limite=limite;
	}

	public Double getCroissance() {
		return croissance;
	}

	public void setCroissance(Double croissance) {
		this.croissance = croissance;
	}
	
	
}
