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
	private Ingame inGame=null;
	private OptionsPanel optionsPanel=null;

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

		inGame=new Ingame(e);
		add(inGame);
		inGame.setVisible(false);
		
		optionsPanel=new OptionsPanel(e);
		optionsPanel.setBorder(new EmptyBorder(100,10,10,10));
		add(optionsPanel);
		optionsPanel.setVisible(false);
	}

	public void setTitleLabelText(String title) {
		if(titleLabel!=null) titleLabel.setText(title);
	}

	public void setMenuVisibility(boolean b) {
		if(menuPanel!=null) menuPanel.setVisible(b);
	}

	public void setInGameVisibility(boolean b) {
		if(inGame!=null) inGame.setVisible(b);
	}

	public void setOptionsVisibility(boolean b) {
		if(optionsPanel!=null) optionsPanel.setVisible(b);
	}

	public String getOptionsValue() {
		return optionsPanel.getOptionsValue();
	}

	public void setImage(String slot, String path) throws IOException {
		inGame.setImage(slot, path);
	}
}