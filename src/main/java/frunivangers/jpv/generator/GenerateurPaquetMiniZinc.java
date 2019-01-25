package frunivangers.jpv.generator;

import frunivangers.jpv.Carte;
import frunivangers.jpv.Paquet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenerateurPaquetMiniZinc implements GenerateurPaquet {

    private boolean shuffle = true;

    public GenerateurPaquetMiniZinc(){
    }

    public GenerateurPaquetMiniZinc(boolean shuffle) {
        this.shuffle = shuffle;
    }

    @Override
    public Paquet generate(int nombreCarte, int nombreSymbol, int nombreSymboleParCarte, int nombreVariantes) {
        assert nombreCarte > 0;
        assert nombreSymbol > 0;
        assert nombreSymboleParCarte > 0;
        assert nombreSymboleParCarte <= nombreSymbol;
        assert nombreVariantes > 0;

        List<Carte> carteList = new ArrayList<>();

        //TODO
        return new Paquet(Collections.unmodifiableList(carteList));
    }
}
