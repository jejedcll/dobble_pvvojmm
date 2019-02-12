package frunivangers.jpv.ui;

import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class OptionsPanel extends JPanel {
	private JTextField timeField;
	private JTextField carteField;
	private JTextField symboleField;
	private JTextField symboleCarteField;
	private JTextField varianteField;

	public OptionsPanel(Engine e) {
		JPanel timePanel=new JPanel();
		timePanel.setLayout(new FlowLayout());
		JLabel timeLabel=new JLabel("Limite de temps en seconde:");
		timeField=new JTextField();
		timeField.setColumns(5);
		timePanel.add(timeLabel);
		timePanel.add(timeField);
		timePanel.setAlignmentX(CENTER_ALIGNMENT);

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JPanel cartePanel=new JPanel();
		cartePanel.setLayout(new FlowLayout());
		JLabel carteLabel=new JLabel("Nombre total de carte à générer:");
		carteField=new JTextField();
		carteField.setColumns(5);
		cartePanel.add(carteLabel);
		cartePanel.add(carteField);
		cartePanel.setAlignmentX(CENTER_ALIGNMENT);

		JPanel symbolePanel=new JPanel();
		symbolePanel.setLayout(new FlowLayout());
		JLabel symboleLabel=new JLabel("Nombre de symbole à utiliser (60 maximum):");
		symboleField=new JTextField();
		symboleField.setColumns(2);
		symbolePanel.add(symboleLabel);
		symbolePanel.add(symboleField);
		symbolePanel.setAlignmentX(CENTER_ALIGNMENT);

		JPanel symboleCartePanel=new JPanel();
		symboleCartePanel.setLayout(new FlowLayout());
		JLabel symboleCarteLabel=new JLabel("Nombre de symbole par carte (8 maximum):");
		symboleCarteField=new JTextField();
		symboleCarteField.setColumns(1);
		symboleCartePanel.add(symboleCarteLabel);
		symboleCartePanel.add(symboleCarteField);
		symboleCartePanel.setAlignmentX(CENTER_ALIGNMENT);

		JPanel variantePanel=new JPanel();
		variantePanel.setLayout(new FlowLayout());
		JLabel varianteLabel=new JLabel("Nombre de variantes de symbole à utiliser (48 maximum):");
		varianteField=new JTextField();
		varianteField.setColumns(2);
		variantePanel.add(varianteLabel);
		variantePanel.add(varianteField);
		variantePanel.setAlignmentX(CENTER_ALIGNMENT);

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

		add(timePanel);
		add(cartePanel);
		add(symbolePanel);
		add(symboleCartePanel);
		add(variantePanel);
		add(buttonPanel);
	}

	public String getOptionsValue() {
		return timeField.getText()+"="+carteField.getText()+"="+symboleField.getText()+"="+symboleCarteField.getText()+"="+varianteField.getText();
	}

	public void setTimeFieldTxt(String s) {
		timeField.setText(s);
	}

	public void setCarteFieldTxt(String s) {
		carteField.setText(s);
	}

	public void setSymboleFieldTxt(String s) {
		symboleField.setText(s);
	}

	public void setSymboleCarteFieldTxt(String s) {
		symboleCarteField.setText(s);
	}

	public void setVarianteFieldTxt(String s) {
		varianteField.setText(s);
	}
}