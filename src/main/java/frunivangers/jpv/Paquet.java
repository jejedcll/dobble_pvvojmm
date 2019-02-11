package frunivangers.jpv;

import java.util.Collections;
import java.util.List;

public class Paquet {
	private List<Carte> cartes;
	
	public Paquet(List<Carte> c) {
		this.cartes = c ;
		Melanger();
	}

	private void Melanger(){
		Collections.shuffle(cartes);		
	}

	public void Distribuer(Joueur[] joueurs) {
		for(int i=0; i<(this.cartes.size())/joueurs.length; i+=joueurs.length) {
			for(int j=0; j<joueurs.length; j++) {
				joueurs[j].ajouterCarte(this.cartes.get(i+j));
			}
		}
	}

	public List<Carte> getCartes(){
		return Collections.unmodifiableList(this.cartes);
	}
}