package frunivangers.jpv.ui;

import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class OptionsPanel extends JPanel {
	private JTextField scoreField;
	private JTextField timeField;
	private JTextField symboleField;

	public OptionsPanel(Engine e) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JPanel scorePanel=new JPanel();
		scorePanel.setLayout(new FlowLayout());
		JLabel scoreLabel=new JLabel("Limite de score:");
		scoreField=new JTextField();
		scoreField.setColumns(5);
		scorePanel.add(scoreLabel);
		scorePanel.add(scoreField);
		scorePanel.setAlignmentX(CENTER_ALIGNMENT);

		JPanel timePanel=new JPanel();
		timePanel.setLayout(new FlowLayout());
		JLabel timeLabel=new JLabel("Limite de temps en seconde:");
		timeField=new JTextField();
		timeField.setColumns(5);
		timePanel.add(timeLabel);
		timePanel.add(timeField);
		timePanel.setAlignmentX(CENTER_ALIGNMENT);

		JPanel symbolePanel=new JPanel();
		symbolePanel.setLayout(new FlowLayout());
		JLabel symboleLabel=new JLabel("Nombre de symbole par carte (8 maximum):");
		symboleField=new JTextField();
		symboleField.setColumns(1);
		symbolePanel.add(symboleLabel);
		symbolePanel.add(symboleField);
		symbolePanel.setAlignmentX(CENTER_ALIGNMENT);

		JPanel buttonPanel=new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		JButton validateButton=new JButton("Valider");
		JButton cancelButton=new JButton("Annuler");
		validateButton.addActionListener(e);
		cancelButton.addActionListener(e);
		validateButton.setActionCommand("validate");
		cancelButton.setActionCommand("cancel");
		buttonPanel.add(validateButton);
		buttonPanel.add(cancelButton);
		buttonPanel.setAlignmentX(CENTER_ALIGNMENT);

		add(scorePanel);
		add(timePanel);
		add(symbolePanel);
		add(buttonPanel);
	}

	public String getOptionsValue() {
		return scoreField.getText()+"="+timeField.getText()+"="+symboleField.getText();
	}
}