package frunivangers.jpv;

import java.util.HashMap;
import java.util.List;

import frunivangers.jpv.generator.GenerateurPaquet;
import frunivangers.jpv.generator.GenerateurPaquetMiniZinc;
import repositories.SymboleFactory;
import repositories.SymboleTypeRepository;
import repositories.VarianteRepository;
import repositories.impl.JsonFileVarianteRepository;
import repositories.impl.StaticSymboleTypeRepository;
import repositories.impl.SymboleFactoryImpl;

import java.io.File;
import java.io.FileNotFoundException;

public class Plateau {
	private Joueur J1;
	private Joueur IA;
	private Carte carteJoueur;
	private Carte carteIA;
	private Paquet pioche;

	public Plateau() {
		carteIA=null;
		carteJoueur=null;
		J1=new Joueur();
		IA=new Joueur();		
	}

	public void newGame() {
		J1.reset();
		IA.reset();
      try{
    	  SymboleTypeRepository symboleTypeRepository = new StaticSymboleTypeRepository();
    	  VarianteRepository varianteRepository = JsonFileVarianteRepository.fromFile(new File("variantes.json"));
    	  SymboleFactory symboleFactory = new SymboleFactoryImpl(symboleTypeRepository, varianteRepository);
    	  GenerateurPaquet generateurPaquet = new GenerateurPaquetMiniZinc("./minizinc-bundle", symboleFactory, true);
    	  pioche = generateurPaquet.generate(7,7,3,3);
    	  for (Carte c : pioche.getCartes()){
    		  System.out.println(c.toString());
    	  }
      } catch (FileNotFoundException e) {
    	  e.printStackTrace();
      	} catch (Exception e) {
      e.printStackTrace();
      }
	
		pioche.Distribuer(new Joueur[] {J1, IA});
	}

	public HashMap<String, Carte> retourneCarte(int tour) {
		if(tour<J1.getMain().size()) {
			carteJoueur=J1.getMain().get((tour-1));
			carteIA=IA.getMain().get((tour-1));
			HashMap<String, Carte> cartes=new HashMap<String, Carte>();
			cartes.put("ia", carteIA);
			cartes.put("j", carteJoueur);
			return cartes;
		}
		else return null;
	}

	public boolean compare(String jeu, int i) {
		Boolean b=false;
		switch(jeu) {
			case "ia":
				b=carteJoueur.compareSymbole(carteIA.getSymbole(i));
				break;
			case "j":
				b=carteIA.compareSymbole(carteJoueur.getSymbole(i));
				break;
		}
		return b;
	}
}