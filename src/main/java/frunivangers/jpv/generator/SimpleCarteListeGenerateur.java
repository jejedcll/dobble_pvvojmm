package frunivangers.jpv.generator;

import frunivangers.jpv.Carte;
import frunivangers.jpv.GsonParser;
import frunivangers.jpv.Symbole;
import frunivangers.jpv.Variante;
import frunivangers.jpv.generator.serialization.CarteSymbol;
import frunivangers.jpv.generator.serialization.CartesVariantes;
import frunivangers.jpv.generator.serialization.Model;
import repositories.SymboleFactory;

import java.util.ArrayList;
import java.util.List;

public class SimpleCarteListeGenerateur implements CarteListeGenerateur {

    private final SymboleFactory symboleFactory;

    public SimpleCarteListeGenerateur(SymboleFactory symboleFactory){
        this.symboleFactory= symboleFactory;
    }

    @Override
    public List<Carte> fromModel(Model model) {

        List<Carte> cartes = new ArrayList<>();
        for(int i = 0; i < model.cards_symbols.length; ++i){
            List<Symbole> symboleList = new ArrayList<>();
            CarteSymbol carteSymbol = model.cards_symbols[i];
            CartesVariantes cartesVariantes = model.cards_variantes[i];

            for(int j = 0; j < carteSymbol.symboles.length; ++j) {
                int idSym = carteSymbol.symboles[j];
                int idVar = cartesVariantes.variantes[j];

                Symbole symbole = this.symboleFactory.createSymbole(idSym, idVar);

                symboleList.add(symbole);
            }
            cartes.add(new Carte(symboleList));
        }

        return cartes;
    }
}
