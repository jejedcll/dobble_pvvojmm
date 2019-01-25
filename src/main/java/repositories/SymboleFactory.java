package repositories;

import frunivangers.jpv.Symbole;

public interface SymboleFactory {

    Symbole createSymbole(int symboleTypeId, int varianteTypeId);

}
