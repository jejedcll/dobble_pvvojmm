package frunivangers.jpv;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.HashMap;

import frunivangers.jpv.ui.Engine;
import frunivangers.jpv.ui.Frame;

public class Partie implements Engine {
	private int tour;
	private Plateau plateau;
	private Frame frame;
	// valeur de sécurité par défaut si NumberFormatException si rien n'a été renseigné dans les JTextField ou que ce ne sont pas des nombres
	int carteLimit=10;
	int timeLimit=10;
	int symboleLimit=8;

	private TimerThread timerThread;

	public Partie() {
		plateau=new Plateau();
		frame=new Frame("Projet Dooble", this);
		frame.setSize(1200, 900);
		frame.setCarteFieldTxt(carteLimit+"");
		frame.setTimeFieldTxt(timeLimit+"");
		frame.setSymboleFieldTxt(symboleLimit+"");
	}

	public void setTempsRestantLabelTxt(String s) {
		frame.setTempsRestantLabelTxt(s);
	}

	@Override
	public void debutPartie() {
		frame.setMenuVisibility(false);
		tour=1;
		plateau.newGame(carteLimit, symboleLimit);
		showSymboles(plateau.retourneCarte(1));
		frame.setScoreIaLabelTxt("0");
		frame.setScoreJoueurLabelTxt("0");
		frame.setInGameVisibility(true);
		startNewTimer();
	}

	@Override
	public void getOptions() {
		frame.setMenuVisibility(false);
		frame.setOptionsVisibility(true);
	}

	@Override
	public void setOptions(int carteLimit, long timeLimit, int symboleLimit) {
		System.out.println("nombre de carte: "+carteLimit+" - limite de temps: "+timeLimit+" - nombre de symbole par carte: "+symboleLimit);
		frame.setOptionsVisibility(false);
		frame.setMenuVisibility(true);
	}

	@Override
	public void abortOptions() {
		frame.setOptionsVisibility(false);
		frame.setMenuVisibility(true);
	}

	@Override
	public void showSymboles(HashMap<String, Carte> cartes) {
		for(String main: cartes.keySet()) {
			// carteIA d'abord, puis carteJoueur
			int i=1;
			for(Symbole s: cartes.get(main).getSymboles()) {
				try {
					frame.setImage(main.equals("j") ? "j"+i : "ia"+i, "images/"+s.getVariante().getCheminCouleur(), s.getId());
					i++;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void abortGame() {
		timerThread.interrupt();
		frame.setInGameVisibility(false);
		frame.setMenuVisibility(true);
	}

	@Override
	public void endGame(String endGameText) {
		frame.setInGameVisibility(false);
		frame.setEndGameLabelText(endGameText);
		frame.setEndGameVisibility(true);
	}

	@Override
	public void backToMenu() {
		frame.setEndGameVisibility(false);
		frame.setMenuVisibility(true);
	}

	@Override
	// jeu indique dans quel jeu on a cliqué: ia ou joueur, id est l'id du symbole dans le jeu, de 1 à 8
	public void compare(String jeu, int id) {
		System.out.println("jeu dans lequel on a cliqué: "+jeu+" - id du symbole qui a été cliqué: "+id);
		if(id<=symboleLimit) {
			timerThread.interrupt();
			Boolean b=plateau.compare(jeu, id);
			Joueur[] joueurs=plateau.getJoueurs(); // 0=IA, 1=joueur
			if(b) {
				joueurs[1].setScore(joueurs[1].getScore()+1);
				frame.setScoreJoueurLabelTxt(joueurs[1].getScore()+"");
			}
			else {
				joueurs[0].setScore(joueurs[0].getScore()+1);
				frame.setScoreIaLabelTxt(joueurs[0].getScore()+"");
			}
			tour++;
			HashMap<String, Carte> cartes=plateau.retourneCarte(tour);
			if(cartes!=null) {
				frame.setNbTourLabelTxt(tour+"");
				showSymboles(cartes);
				startNewTimer();
			}
			else {
				String texte;
				if(joueurs[0].getScore()>joueurs[1].getScore()) texte="Désoler, vous avez perdu à "+joueurs[1].getScore()+" points contre "+joueurs[0].getScore()+" points !";
				else if(joueurs[0].getScore()<joueurs[1].getScore()) texte="Bravo, vous avez gagné à "+joueurs[1].getScore()+" points contre "+joueurs[0].getScore()+" points !";
				else texte="Égalité à "+joueurs[1].getScore()+" points !";
				endGame(texte);
			}
		}
	}

	@Override
	public void exit() {
		System.exit(0);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command=e.getActionCommand();
		switch(command) {
			case "play":
				debutPartie();
				break;
			case "options":
				getOptions();
				break;
			case "cancel":
				abortOptions();
				break;
			case "abort":
				abortGame();
				break;
			case "exit":
				exit();
				break;
			case "validate":
				String[] splitted=frame.getOptionsValue().split("=");
				if(splitted.length>2) {
					try {
						carteLimit=Integer.parseInt(splitted[0]);
						timeLimit=Integer.parseInt((splitted[1]));
						symboleLimit=Integer.parseInt(splitted[2]);
					} catch(NumberFormatException ex) {}
				}
				if(symboleLimit>8) symboleLimit=8;
				setOptions(carteLimit, timeLimit, symboleLimit);
				break;
			case "back":
				backToMenu();
				break;
			default:
				// de la forme jeuCliqué=idCarte
				// pas besoin de redéclarer le type de splitted car déjà dans le cas validate
				// fonctionne avec les bonnes valeur même si on ne passe jamais dans le cas validate
				splitted=command.split("=");
				compare(splitted[0], Integer.parseInt(splitted[1]));
				break;
		}
	}

	private void startNewTimer() {
		if(timerThread!=null) timerThread.interrupt();
		timerThread=new TimerThread(this, timeLimit);
		frame.setTempsRestantLabelTxt(timeLimit+"");
		timerThread.start();
	}
}