package ressources;

public class Population {
	
	private int limitePop = 50;
	private int pop = 5;
	
	public Population(int limite, int pop) {
		this.setLimitePop(limite);
		this.pop=pop;
	}
	
	public int croissance(int attractivite) {
		this.pop += attractivite;
		return this.pop;
	}

	public int getLimitePop() {
		return limitePop;
	}

	public void setLimitePop(int limitePop) {
		this.limitePop = limitePop;
	}

}
