package frunivangers.jpv.generator.serialization;

import java.util.ArrayList;
import java.util.Arrays;

public class CarteSymbol {

    private int id;
    private int[] symboles;

    @Override
    public String toString() {
        return "CarteSymbol{" +
                "id=" + id +
                ", symboles=" + Arrays.toString(symboles) +
                '}';
    }
}
