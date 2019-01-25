package frunivangers.jpv;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import javax.swing.DropMode;
import javax.swing.JButton;

public class Frame extends JFrame{
	
	public Frame(String title) {
		setTitle(title);
		setSize(1200, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
        JTextField message = new JTextField(30);
        JButton envoyer = new JButton("envoyer");
		JTextArea chat = new JTextArea();
		chat.setEditable(false);
		chat.setEditable(false);
		JPanel contentpane = (JPanel)getContentPane();
		setVisible(true);
		contentpane.setLayout(null);
		contentpane.add(chat,BorderLayout.CENTER);
		
		
	}
	
}
