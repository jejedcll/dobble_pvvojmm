package frunivangers.jpv;

import java.util.HashMap;
import java.util.List;

public class Plateau {
	private Joueur J1;
	private Joueur IA;
	private Carte carteJoueur;
	private Carte carteIA;
	private Paquet pioche;

	public Plateau() {
		carteIA=null;
		carteJoueur=null;
		J1=new Joueur();
		IA=new Joueur();		
	}

	public void newGame(List<Carte> c) {
		J1.reset();
		IA.reset();
		pioche=new Paquet(c);
		pioche.Distribuer(new Joueur[] {J1, IA});
	}

	public HashMap<String, Carte> retourneCarte(int tour) {
		if(tour<J1.getMain().size()) {
			carteJoueur=J1.getMain().get((tour-1));
			carteIA=IA.getMain().get((tour-1));
			HashMap<String, Carte> cartes=new HashMap<String, Carte>();
			cartes.put("ia", carteIA);
			cartes.put("j", carteJoueur);
			return cartes;
		}
		else return null;
	}

	public boolean compare(String jeu, int i) {
		Boolean b=false;
		switch(jeu) {
			case "ia":
				b=carteJoueur.compareSymbole(carteIA.getSymbole(i));
				break;
			case "j":
				b=carteIA.compareSymbole(carteJoueur.getSymbole(i));
				break;
		}
		return b;
	}
}