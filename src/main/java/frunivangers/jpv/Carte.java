package frunivangers.jpv;

import java.util.List;
import java.util.ArrayList;

public class Carte {
	
	private List<Symbole> symboles;
	
	public Carte(List<Symbole> s) {
		this.symboles= s;
	}
	
	public List<Symbole> GetSymboles() {
		return this.symboles;
	}
	
	
	private boolean CompareSymbole(Symbole s) {
		boolean symidentique =false;
		for(int i=0;i<this.symboles.size();i++) {
				if(this.symboles.get(i).getId()==s.getId()) symidentique =true;
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
