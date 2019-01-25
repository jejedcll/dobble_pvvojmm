package frunivangers.jpv.generator;

import frunivangers.jpv.Carte;
import frunivangers.jpv.generator.serialization.Model;

import java.util.List;

public interface CarteListeGenerateur {

    public List<Carte> fromModel(Model model);
}
