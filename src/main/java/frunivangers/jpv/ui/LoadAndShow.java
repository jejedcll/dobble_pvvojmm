package frunivangers.jpv.ui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;

public class LoadAndShow extends JButton {
BufferedImage image;
Dimension size=new Dimension();

	public LoadAndShow() {}
	// si path est relatif, sa racine est le dossier d'exécution du programme. Si lancé via éclipse, c'est la racine du projet
	public LoadAndShow(String path, int id) throws IOException {
		try {
			image=ImageIO.read(new File(path));
			int x=(((id-1)%15)*52)-3;
			if(x<0) x=0;
			int y=(id/15)*72;
			if(id%15==0) y-=72;
			image=image.getSubimage(x, y, 48, 65);
			size.setSize(image.getWidth(), image.getHeight());
		} catch (IOException e) {
			System.out.println("Erreur chargement de l'image "+path+" dans la classe LoadAndShow !");
			throw e;
		}
	}

	public void setImage(String path, int id) throws IOException {
		try {
			image=ImageIO.read(new File(path));
			int x=(((id-1)%15)*52)-3;
			if(x<0) x=0;
			int y=(id/15)*72;
			if(id%15==0) y-=72;
			image=image.getSubimage(x, y, 48, 65);
			size.setSize(image.getWidth(), image.getHeight());
			repaint();
		} catch (IOException e) {
			System.out.println("Erreur chargement de l'image "+path+" dans la classe LoadAndShow !");
			throw e;
		}
	}

	 /**
	 * Drawing an image can allow for more
	 * flexibility in processing/editing.
	 */
	protected void paintComponent(Graphics g) {
		// Center image in this component.
		int x=(getWidth()-size.width)/2;
		int y=(getHeight()-size.height)/2;
		g.drawImage(image, x, y, this);
	}

	public Dimension getPreferredSize() { return size; }
}