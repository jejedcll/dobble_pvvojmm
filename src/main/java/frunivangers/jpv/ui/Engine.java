package frunivangers.jpv.ui;

import java.awt.event.ActionListener;

public interface Engine extends ActionListener {
	public void debutPartie();
	public void getOptions();
	public void setOptions(int scoreLimit, long timeLimit, int symboleLimit);
	public void abortOptions();
	public void abortGame();
	public void compare(String jeu, int id);
	public void exit();
}