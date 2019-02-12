package frunivangers.jpv.ui;

import java.awt.event.ActionListener;
import java.util.HashMap;

import frunivangers.jpv.Carte;

public interface Engine extends ActionListener {
	public void debutPartie();
	public void getOptions();
	public void setOptions(int timeLimit, int carteLimit, int symboleLimit, int symboleCarteLimit, int varianteLimit);
	public void abortOptions();
	public void showSymboles(HashMap<String, Carte> cartes);
	public void abortGame();
	public void endGame(String endGameText);
	public void backToMenu();
	public void compare(String jeu, int id);
	public void exit();
}