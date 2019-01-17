package dobble_pvvojmm;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Paquet {
	private List<Carte> cartes;
	
	private void Melanger(){
		Collections.shuffle(cartes);		
	}
	
	private void Distribuer(Joueur[] joueurs) {
		for(int i=0; i<(this.cartes.size())/joueurs.length;i+=joueurs.length) {
			for(int j=0;j<joueurs.length;j++) {
				joueurs[j].ajouterCarte(this.cartes.get(i+j));
			}
		}
	}
}
