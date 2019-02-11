package frunivangers.jpv.ui;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ingame extends JPanel {
	private JLabel nbTourLabel;
	private JLabel scoreJoueurLabel;
	private JLabel scoreIaLabel;
	private JLabel tempsRestantLabel;
	LoadAndShow symbIa_1;
	LoadAndShow symbIa_2;
	LoadAndShow symbIa_3;
	LoadAndShow symbIa_4;
	LoadAndShow symbIa_5;
	LoadAndShow symbIa_6;
	LoadAndShow symbIa_7;
	LoadAndShow symbIa_8;
	LoadAndShow symbJ_1;
	LoadAndShow symbJ_2;
	LoadAndShow symbJ_3;
	LoadAndShow symbJ_4;
	LoadAndShow symbJ_5;
	LoadAndShow symbJ_6;
	LoadAndShow symbJ_7;
	LoadAndShow symbJ_8;

	public Ingame(Engine e) {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		JPanel bandeauSup=new JPanel();
		JPanel bandeauInf=new JPanel();
		JPanel plateau=new JPanel();
		JLabel txtSymboleIa=new JLabel("Jeu adverse");
		JPanel symboleIa=new JPanel();
		JLabel txtSymboleJoueur=new JLabel("Votre jeu");
		JPanel symboleJoueur=new JPanel();
		bandeauSup.setLayout(new FlowLayout());
		bandeauInf.setLayout(new FlowLayout());
		plateau.setLayout(new BoxLayout(plateau, BoxLayout.PAGE_AXIS));
		symboleIa.setLayout(new GridLayout(2, 4));
		symboleJoueur.setLayout(new GridLayout(2, 4));
		add(bandeauSup);
		add(bandeauInf);
		add(plateau);
		txtSymboleIa.setAlignmentX(CENTER_ALIGNMENT);
		plateau.add(txtSymboleIa);
		plateau.add(symboleIa);
		txtSymboleJoueur.setAlignmentX(CENTER_ALIGNMENT);
		plateau.add(txtSymboleJoueur);
		plateau.add(symboleJoueur);

		JLabel titreTourLabel=new JLabel("Tour :");
		bandeauSup.add(titreTourLabel);
		nbTourLabel=new JLabel("1");
		bandeauSup.add(nbTourLabel);

		JLabel txtScoreJoueurLabel=new JLabel("Score Joueur :");
		bandeauSup.add(txtScoreJoueurLabel);
		scoreJoueurLabel=new JLabel("0");
		bandeauSup.add(scoreJoueurLabel);

		JLabel txtScoreIaLabel=new JLabel("Score IA :");
		bandeauSup.add(txtScoreIaLabel);
		scoreIaLabel=new JLabel("0");
		bandeauSup.add(scoreIaLabel);

		JLabel txtTempsRestantLabel=new JLabel("Temps restant :");
		bandeauInf.add(txtTempsRestantLabel);
		tempsRestantLabel=new JLabel("00:00:00");
		bandeauInf.add(tempsRestantLabel);

		// création des symbole pour l'IA;
		symbIa_1=new LoadAndShow();
		symbIa_2=new LoadAndShow();
		symbIa_3=new LoadAndShow();
		symbIa_4=new LoadAndShow();
		symbIa_5=new LoadAndShow();
		symbIa_6=new LoadAndShow();
		symbIa_7=new LoadAndShow();
		symbIa_8=new LoadAndShow();
		symbIa_1.addActionListener(e);
		symbIa_2.addActionListener(e);
		symbIa_3.addActionListener(e);
		symbIa_4.addActionListener(e);
		symbIa_5.addActionListener(e);
		symbIa_6.addActionListener(e);
		symbIa_7.addActionListener(e);
		symbIa_8.addActionListener(e);
		symbIa_1.setActionCommand("ia=1");
		symbIa_2.setActionCommand("ia=2");
		symbIa_3.setActionCommand("ia=3");
		symbIa_4.setActionCommand("ia=4");
		symbIa_5.setActionCommand("ia=5");
		symbIa_6.setActionCommand("ia=6");
		symbIa_7.setActionCommand("ia=7");
		symbIa_8.setActionCommand("ia=8");
		symboleIa.add(symbIa_1);
		symboleIa.add(symbIa_2);
		symboleIa.add(symbIa_3);
		symboleIa.add(symbIa_4);
		symboleIa.add(symbIa_5);
		symboleIa.add(symbIa_6);
		symboleIa.add(symbIa_7);
		symboleIa.add(symbIa_8);

		//création des symbole pour le joueur;
		symbJ_1 = new LoadAndShow();
		symbJ_2=new LoadAndShow();
		symbJ_3=new LoadAndShow();
		symbJ_4=new LoadAndShow();
		symbJ_5=new LoadAndShow();
		symbJ_6=new LoadAndShow();
		symbJ_7=new LoadAndShow();
		symbJ_8=new LoadAndShow();
		symbJ_1.addActionListener(e);
		symbJ_2.addActionListener(e);
		symbJ_3.addActionListener(e);
		symbJ_4.addActionListener(e);
		symbJ_5.addActionListener(e);
		symbJ_6.addActionListener(e);
		symbJ_7.addActionListener(e);
		symbJ_8.addActionListener(e);
		symbJ_1.setActionCommand("joueur=1");
		symbJ_2.setActionCommand("joueur=2");
		symbJ_3.setActionCommand("joueur=3");
		symbJ_4.setActionCommand("joueur=4");
		symbJ_5.setActionCommand("joueur=5");
		symbJ_6.setActionCommand("joueur=6");
		symbJ_7.setActionCommand("joueur=7");
		symbJ_8.setActionCommand("joueur=8");
		symboleJoueur.add(symbJ_1);
		symboleJoueur.add(symbJ_2);
		symboleJoueur.add(symbJ_3);
		symboleJoueur.add(symbJ_4);
		symboleJoueur.add(symbJ_5);
		symboleJoueur.add(symbJ_6);
		symboleJoueur.add(symbJ_7);
		symboleJoueur.add(symbJ_8);

		JButton abandonButton=new JButton("Abandonner");
		abandonButton.addActionListener(e);
		abandonButton.setActionCommand("abort");
		abandonButton.setAlignmentX(CENTER_ALIGNMENT);
		add(abandonButton);
	}

	public void setImage(String slot, String path) throws IOException {
		switch(slot) {
			case "ia1":
				symbIa_1.setImage(path);
				break;
			case "ia2":
				symbIa_2.setImage(path);
				break;
			case "ia3":
				symbIa_3.setImage(path);
				break;
			case "ia4":
				symbIa_4.setImage(path);
				break;
			case "ia5":
				symbIa_5.setImage(path);
				break;
			case "ia6":
				symbIa_6.setImage(path);
				break;
			case "ia7":
				symbIa_7.setImage(path);
				break;
			case "ia8":
				symbIa_8.setImage(path);
				break;
			case "j1":
				symbJ_1.setImage(path);
				break;
			case "j2":
				symbJ_2.setImage(path);
				break;
			case "j3":
				symbJ_3.setImage(path);
				break;
			case "j4":
				symbJ_4.setImage(path);
				break;
			case "j5":
				symbJ_5.setImage(path);
				break;
			case "j6":
				symbJ_6.setImage(path);
				break;
			case "j7":
				symbJ_7.setImage(path);
				break;
			case "j8":
				symbJ_8.setImage(path);
				break;
				
		}
	}
}