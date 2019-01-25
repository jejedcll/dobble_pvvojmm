package frunivangers.jpv;

import java.util.ArrayList;
import java.util.List;

public class Joueur {
	private static int conteur; 
	private int id;
	private int score;
	private List<Carte> main;
	private List<JoueurObservateur> obs;
	
	public Joueur() {
		this.score=0;
		this.main = new ArrayList<Carte>();
		this.id =conteur;
		conteur++;
	}
	
	
	public int getId() {
		return id;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public List<Carte> getMain() {
		return main;
	}


	public void ajouterCarte(Carte carte){
		this.main.add(carte);
	}

}
