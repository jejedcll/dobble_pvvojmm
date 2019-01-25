package frunivangers.jpv.generator;

import frunivangers.jpv.Carte;
import frunivangers.jpv.generator.serialization.Model;
import repositories.SymboleFactory;

import java.util.List;

public class ShuffleCarteListeGenerateur implements CarteListeGenerateur{

    private SymboleFactory symboleFactory;

    public ShuffleCarteListeGenerateur(SymboleFactory symboleFactory) {
        this.symboleFactory = symboleFactory;
    }

    @Override
    public List<Carte> fromModel(Model model) {
        //TODO
        return null;
    }
}
