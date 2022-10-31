package formatif5.model;

public class Auto {
	private double masse;
	private double force;
	private String sorte;
	public Auto(double masse, double force, String sorte) {
		super();
		this.masse = masse;
		this.force = force;
		this.sorte = sorte;
	}
	public double getMasse() {
		return masse;
	}
	public void setMasse(double masse) {
		this.masse = masse;
	}
	public double getForce() {
		return force;
	}
	public void setForce(double force) {
		this.force = force;
	}
	public String getSorte() {
		return sorte;
	}
	public void setSorte(String sorte) {
		this.sorte = sorte;
	}
	@Override
	public String toString() {
		return sorte+" " + masse + "KG, " + force + "N";
	}
	
	


	
}
