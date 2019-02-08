package frunivangers.jpv.ui;

import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuPanel extends JPanel {

	public MenuPanel(Engine e) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JButton playButton=new JButton("Jouer");
		JButton optionsButton=new JButton("Options");
		JButton exitButton=new JButton("Quitter");
		playButton.setFont(new Font(playButton.getFont().getFontName(), Font.BOLD, 20));
		optionsButton.setFont(new Font(optionsButton.getFont().getFontName(), Font.BOLD, 20));
		exitButton.setFont(new Font(exitButton.getFont().getFontName(), Font.BOLD, 20));
		playButton.addActionListener(e);
		optionsButton.addActionListener(e);
		exitButton.addActionListener(e);
		playButton.setActionCommand("play");
		optionsButton.setActionCommand("options");
		exitButton.setActionCommand("exit");
		playButton.setAlignmentX(CENTER_ALIGNMENT);
		optionsButton.setAlignmentX(CENTER_ALIGNMENT);
		exitButton.setAlignmentX(CENTER_ALIGNMENT);
		add(playButton);
		add(optionsButton);
		add(exitButton);
	}
}