package frunivangers.jpv.generator.serialization;

import java.util.ArrayList;
import java.util.Arrays;

public class Model {

    public CartesVariantes[] cards_variantes;
    public CarteSymbol[] cards_symbols;

    @Override
    public String toString() {
        return "Model{" +
                "cards_variantes=" + Arrays.toString(cards_variantes) +
                ", cards_symbol=" + Arrays.toString(cards_symbols) +
                '}';
    }
}
