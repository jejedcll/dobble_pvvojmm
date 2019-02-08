package frunivangers.jpv;

import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Timer;

import frunivangers.jpv.ui.Engine;
import frunivangers.jpv.ui.Frame;

public class Partie implements Engine {
	private List<PartieObservateur> obs;
	private int tour;
	private Timer timer;
	private Plateau plateau;
	private Frame frame;
	
	public Partie() {
		frame=new Frame("Projet Dooble", this);
		frame.setSize(1200, 900);
	}

	@Override
	public void debutPartie() {
		frame.setMenuVisibility(false);
		frame.setInGameVisibility(true);
	}

	@Override
	public void getOptions() {
		frame.setMenuVisibility(false);
		frame.setOptionsVisibility(true);
	}

	@Override
	public void setOptions(int scoreLimit, long timeLimit, int symboleLimit) {
		System.out.println("limite de score: "+scoreLimit+" - limite de temps: "+timeLimit+" - nombre de symbole par carte: "+symboleLimit);
		frame.setOptionsVisibility(false);
		frame.setMenuVisibility(true);
	}

	@Override
	public void abortOptions() {
		frame.setOptionsVisibility(false);
		frame.setMenuVisibility(true);
	}

	@Override
	public void abortGame() {
		frame.setInGameVisibility(false);
		frame.setMenuVisibility(true);
	}

	@Override
	// jeu indique dans quel jeu on a cliqué: ia ou joueur
	public void compare(String jeu, int id) {
		System.out.println("jeu dans lequel on a cliqué: "+jeu+" - id du symbole qui a été cliqué: "+id);
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
				// valeur de sécurité par défaut si NumberFormatException si rien n'a été renseigné dans les JTextField ou que ce ne sont pas des nombres
				int scoreLimit=20;
				long timeLimit=30;
				int symboleLimit=8;
				String[] splitted=frame.getOptionsValue().split("=");
				if(splitted.length>2) {
					try {
						scoreLimit=Integer.parseInt(splitted[0]);
						timeLimit=Long.parseLong((splitted[1]));
						symboleLimit=Integer.parseInt(splitted[2]);
					} catch(NumberFormatException ex) {}
				}
				if(symboleLimit>8) symboleLimit=8;
				setOptions(scoreLimit, timeLimit*1000, symboleLimit);
				break;
			default:
				// de la forme jeuCliqué=idCarte
				// pas besoin de redéclarer le type de splitted car déjà fait au-dessus
				// fonctionne avec les bonnes valeur même si on ne passe jamais dans le cas validate
				splitted=command.split("=");
				compare(splitted[0], Integer.parseInt(splitted[1]));
				break;
		}
	}
}