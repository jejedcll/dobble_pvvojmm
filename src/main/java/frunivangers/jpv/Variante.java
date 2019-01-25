package frunivangers.jpv;

public class Variante {
	private static int compteur =0;
	private int id;
	private String couleur;
	private String taille;
	private String cheminCouleur;

	public Variante(String couleur, String taille, String chemin) {
		this.id = compteur;
		compteur++;
		this.cheminCouleur=chemin;
		this.couleur =couleur;
		this.taille=taille;
	}

	public static int getCompteur() {
		return compteur;
	}


	public int getId() {
		return id;
	}


	public String getCouleur() {
		return couleur;
	}


	public String getTaille() {
		return taille;
	}


	public String getCheminCouleur() {
		return cheminCouleur;
	}


}
