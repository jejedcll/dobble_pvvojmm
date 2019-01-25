package frunivangers.jpv.generator;

import frunivangers.jpv.Carte;
import frunivangers.jpv.Symbole;
import frunivangers.jpv.generator.serialization.CarteSymbol;
import frunivangers.jpv.generator.serialization.CartesVariantes;
import frunivangers.jpv.generator.serialization.Model;
import repositories.SymboleFactory;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ShuffleCarteListeGenerateur implements CarteListeGenerateur{

    private SymboleFactory symboleFactory;

    public ShuffleCarteListeGenerateur(SymboleFactory symboleFactory) {
        this.symboleFactory = symboleFactory;
    }

    @Override
    public List<Carte> fromModel(Model model) {
        List<Carte> cartes = new ArrayList<>();

        for(int i = 0; i < model.cards_symbols.length; ++i){

            List<Symbole> symboleList = new ArrayList<>();

            CarteSymbol symbols = model.cards_symbols[i];
            CartesVariantes variantes = model.cards_variantes[i];

            List<Integer> varianteIdList = new ArrayList<>();
            for(int v : variantes.variantes){varianteIdList.add(v);}
            Collections.shuffle(varianteIdList);

            for(int j = 0; j < symbols.symboles.length; ++j){
                symboleList.add(this.symboleFactory.createSymbole(symbols.symboles[j], varianteIdList.get(j)));
            }
            cartes.add(new Carte(symboleList));
        }

        return cartes;
    }
}
