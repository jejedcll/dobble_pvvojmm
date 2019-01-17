package dobble_pvvojmm;

import java.util.List;

public class Joueur {
	private int id;
	private int score;
	private List<Carte> main;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public void setMain(List<Carte> main) {
		this.main = main;
	}

	public void ajouterCarte(Carte carte){
		this.main.add(carte);
	}

}
