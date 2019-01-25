package main.java.frunivangers.jpv;

import java.util.Map;
import java.util.Timer;

public class Plateau {
	private Joueur J1;
	private Joueur IA;
	private Carte cartejoueur;
	private Carte carteIA;
	
	public boolean retourneCarte(int tour) {
		
		if(tour > J1.getMain().size()) {
			return false;
		}
		this.cartejoueur=J1.getMain().get((tour-1));
		this.carteIA =IA.getMain().get((tour-1));
		
			return true;
	}
	
	public Plateau() {
		this.carteIA = null;
		this.cartejoueur =null;
		this.J1 = new Joueur();
		this.IA =new Joueur();
		//this.pioche = new Paquet();		
	}

}
