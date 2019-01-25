package main.java.frunivangers.jpv;

public class Symbole {
	private static int compteur =0;
	private int id;
	private Variante variante;
	
	public Symbole(Variante variante) {
		this.id=this.compteur;
		this.compteur ++;
		this.variante =variante;
	}
	
	
	public int getId() {
		return this.getId();
	}

}
