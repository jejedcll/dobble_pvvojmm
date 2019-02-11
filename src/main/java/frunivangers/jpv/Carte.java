package frunivangers.jpv;

import java.util.List;

public class Carte {
	private List<Symbole> symboles;

	public Carte(List<Symbole> s) {
		symboles=s;
	}

	public List<Symbole> getSymboles() {
		return symboles;
	}

	public Symbole getSymbole(int i) {
		return symboles.get(i);
	}

	public boolean compareSymbole(Symbole s) {
		boolean symidentique=false;
		for(int i=0; i<symboles.size(); i++) {
			if(symboles.get(i).getId()==s.getId()) symidentique=true;
			if(symidentique) break;
		}
		return symidentique;
	}

	@Override
	public String toString() {
		return "Carte{" +
				"symboles=" + symboles +
				'}';
	}
}