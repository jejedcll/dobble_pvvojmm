package frunivangers.jpv.ui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.io.IOException;

import javax.swing.BoxLayout;

public class Frame extends JFrame {
	private JLabel titleLabel=null;
	private MenuPanel menuPanel=null;
	private Ingame inGamePanel=null;
	private OptionsPanel optionsPanel=null;
	private EndGamePanel endGamePanel=null;

	public Frame(String title, Engine e) {
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setTitle(title);

		titleLabel=new JLabel();
		titleLabel.setText(title);
		titleLabel.setAlignmentX(CENTER_ALIGNMENT);
		titleLabel.setFont(new Font(titleLabel.getFont().getFontName(), Font.BOLD, 30));
		titleLabel.setBorder(new EmptyBorder(10,10,10,10));
		add(titleLabel);

		menuPanel=new MenuPanel(e);
		menuPanel.setBorder(new EmptyBorder(100,10,10,10));
		add(menuPanel);

		inGamePanel=new Ingame(e);
		add(inGamePanel);
		inGamePanel.setVisible(false);
		
		optionsPanel=new OptionsPanel(e);
		optionsPanel.setBorder(new EmptyBorder(100,10,10,10));
		add(optionsPanel);
		optionsPanel.setVisible(false);

		endGamePanel=new EndGamePanel(e);
		add(endGamePanel);
		endGamePanel.setVisible(false);
	}

	public void setTitleLabelText(String title) {
		if(titleLabel!=null) titleLabel.setText(title);
	}

	public void setMenuVisibility(boolean b) {
		if(menuPanel!=null) menuPanel.setVisible(b);
	}

	public void setInGameVisibility(boolean b) {
		if(inGamePanel!=null) inGamePanel.setVisible(b);
	}

	public void setOptionsVisibility(boolean b) {
		if(optionsPanel!=null) optionsPanel.setVisible(b);
	}

	public String getOptionsValue() {
		return optionsPanel.getOptionsValue();
	}

	public void setImage(String slot, String path, int id) throws IOException {
		inGamePanel.setImage(slot, path, id);
	}

	public void setEndGameVisibility(boolean b) {
		endGamePanel.setVisible(b);
	}

	public void setEndGameLabelText(String s) {
		endGamePanel.setEndGameLabelText(s);
	}
}