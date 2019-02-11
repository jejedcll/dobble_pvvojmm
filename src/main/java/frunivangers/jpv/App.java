package frunivangers.jpv;

import frunivangers.jpv.generator.GenerateurPaquet;
import frunivangers.jpv.generator.GenerateurPaquetMiniZinc;
import repositories.SymboleFactory;
import repositories.SymboleTypeRepository;
import repositories.VarianteRepository;
import repositories.impl.JsonFileVarianteRepository;
import repositories.impl.StaticSymboleTypeRepository;
import repositories.impl.SymboleFactoryImpl;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        new Partie();


//        try{
//            SymboleTypeRepository symboleTypeRepository = new StaticSymboleTypeRepository();
//            VarianteRepository varianteRepository = JsonFileVarianteRepository.fromFile(new File("variantes.json"));
//            SymboleFactory symboleFactory = new SymboleFactoryImpl(symboleTypeRepository, varianteRepository);
//
//            GenerateurPaquet generateurPaquet = new GenerateurPaquetMiniZinc("/home/etudiant/minzinc-bundle", symboleFactory, true);
//
//            Paquet paquet = generateurPaquet.generate(7,7,3,3);
//             for (Carte c : paquet.getCartes()){
//                 System.out.println(c.toString());
//             }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
