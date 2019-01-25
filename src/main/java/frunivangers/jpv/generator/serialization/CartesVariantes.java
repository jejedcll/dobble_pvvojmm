package frunivangers.jpv.generator.serialization;

import java.util.Arrays;

public class CartesVariantes {

    private int id;
    private int[] variantes;

    @Override
    public String toString() {
        return "CartesVariantes{" +
                "id=" + id +
                ", variantes=" + Arrays.toString(variantes) +
                '}';
    }
}
