package frunivangers.jpv;

import java.util.ArrayList;
import java.util.List;

public class Joueur {
	private static int conteur; 
	private int id;
	private int score;
	private List<Carte> main;

	public Joueur() {
		score=0;
		main=new ArrayList<Carte>();
		id=conteur;
		conteur++;
	}

	public int getId() {
		return id;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int s) {
		score=s;
	}

	public List<Carte> getMain() {
		return main;
	}

	public void ajouterCarte(Carte carte){
		main.add(carte);
	}

	public void reset() {
		score=0;
		main.clear();
	}
}