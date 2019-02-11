package frunivangers.jpv.ui;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EndGamePanel extends JPanel {
	JLabel endGameLabel;
	JButton backButton;

	public EndGamePanel(Engine e) {
		setLayout(new BorderLayout());
		endGameLabel=new JLabel();
		backButton=new JButton();
		endGameLabel.setHorizontalAlignment(JLabel.CENTER);
		endGameLabel.setFont(new Font(endGameLabel.getFont().getFontName(), Font.BOLD, 30));
		backButton.setText("Retour au Menu");
		backButton.setFont(new Font(backButton.getFont().getFontName(), Font.BOLD, 20));
		backButton.addActionListener(e);
		backButton.setActionCommand("back");
		add(endGameLabel, BorderLayout.CENTER);
		add(backButton, BorderLayout.PAGE_END);
	}

	public void setEndGameLabelText(String s) {
		endGameLabel.setText(s);
	}
}