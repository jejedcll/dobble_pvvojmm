package frunivangers.jpv.generator;

import frunivangers.jpv.Paquet;

import java.io.IOException;

public interface GenerateurPaquet {

    Paquet generate(int nombreCarte, int nombreSymbol, int nombreSymboleParCarte, int nombreVariantes ) throws Exception;
}
