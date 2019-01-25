package frunivangers.jpv.generator;

import frunivangers.jpv.Paquet;

public interface GenerateurPaquet {

    Paquet generate(int nombreCarte, int nombreSymbol, int nombreSymboleParCarte, int nombreVariantes );
}
