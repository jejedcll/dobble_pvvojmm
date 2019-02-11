package frunivangers.jpv.generator;

import com.google.gson.Gson;
import frunivangers.jpv.Carte;
import frunivangers.jpv.Paquet;
import frunivangers.jpv.generator.serialization.Model;
import repositories.SymboleFactory;

import java.io.*;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("WeakerAccess")
public class GenerateurPaquetMiniZinc implements GenerateurPaquet {

    private final static Logger logger = LogManager.getLogger();

    private boolean shuffle = true;
    private String minizincPath;
    private SymboleFactory symboleFactory;

    public GenerateurPaquetMiniZinc(String minizincPath, SymboleFactory symboleFactory) {
        this.minizincPath = minizincPath;
        this.symboleFactory = symboleFactory;
    }

    public GenerateurPaquetMiniZinc(String minizincPath, SymboleFactory symboleFactory, boolean shuffle) {
        this.minizincPath = minizincPath;
        this.symboleFactory = symboleFactory;
        this.shuffle = shuffle;
    }

    @Override
    public Paquet generate(int nombreCarte, int nombreSymbol, int nombreSymboleParCarte, int nombreVariantes) throws IOException, InterruptedException {
        assert nombreCarte > 0;
        assert nombreSymbol > 0;
        assert nombreSymboleParCarte > 0;
        assert nombreSymboleParCarte <= nombreSymbol;
        assert nombreVariantes > 0;

        logger.info("Starting minizinc generation with parameters : NC=" + nombreCarte + ", NS=" + nombreSymbol + ", NSC=" + nombreSymboleParCarte + ", NV=" + nombreVariantes);

        File dataFile = this.setUpDataFile(nombreCarte, nombreSymbol, nombreSymboleParCarte, nombreVariantes);
        Model model = this.loadFromMinizinc(dataFile);

        System.out.println(model);
        logger.info("Minizinc", "Model loaded from minizinc : " + model.toString());

        List<Carte> carteList = this.cartesListFromModel(model);
        logger.info("Card list generated");
        return new Paquet(carteList);
    }

    protected List<Carte> cartesListFromModel(Model model){
        logger.info("Creating card list with shuffle=" + this.shuffle);

        CarteListeGenerateur carteListeGenerateur;
        if(this.shuffle){
            carteListeGenerateur = new ShuffleCarteListeGenerateur(this.symboleFactory);
        }else{
            carteListeGenerateur = new SimpleCarteListeGenerateur(this.symboleFactory);
        }
        return carteListeGenerateur.fromModel(model);
    }

    protected File setUpDataFile(int nombreCarte, int nombreSymbol, int nombreSymboleParCarte, int nombreVariante) throws IOException {

        logger.info("Setting up data file");
        File dataFile = new File("data.dzn");

        BufferedWriter writer = new BufferedWriter(new FileWriter(dataFile, false));

        writer.write("NC=" + nombreCarte + ";");
        writer.newLine();
        writer.write("NS=" + nombreSymbol + ";");
        writer.newLine();
        writer.write("NSC=" + nombreSymboleParCarte + ";");
        writer.newLine();
        writer.write("NV=" + nombreVariante + ";");
        writer.newLine();

        writer.close();
        logger.info("Data file create " + dataFile.getAbsolutePath());
        return dataFile;
    }

    protected Model loadFromMinizinc(File dataFile) throws IOException, InterruptedException {

        String jsonModel = this.runMinizinc(dataFile);

        Gson gson = new Gson();

        logger.info("Deserializing json");
        logger.debug("'" + jsonModel + "'");
        Model model = gson.fromJson(jsonModel, Model.class);

        logger.info("Json deserialized");

        return model;
    }

    protected String runMinizinc(File dataFile) throws IOException, InterruptedException {

        ProcessBuilder processBuilder = new ProcessBuilder();

        // Run a shell command
        String command = "export LD_LIBRARY_PATH=" + minizincPath + "/lib:$LD_LIBRARY_PATH"
                + " && " + minizincPath +"/bin/minizinc model.mzn " + dataFile.getAbsolutePath()
                + "| head -n -1";
        logger.info("Running minizinc with command : \"" + command + "\"");

        processBuilder.command("bash", "-c", command);
        Process process = processBuilder.start();

        StringBuilder output = new StringBuilder();

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(process.getInputStream()));

        BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));

        String line;

        StringBuilder errorsBuilder = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            output.append(line).append('\n');
        }
        while((line = errorReader.readLine()) != null){
            errorsBuilder.append(line).append('\n');
        }


        int exitVal = process.waitFor();
        logger.info("Minizinc", "Minizinc process ended with exit value " + exitVal);

        String errors = errorsBuilder.toString();
        if(! errors.isEmpty()){
            logger.warn("Minzinc", "Miniznc process output on stderr");
            logger.warn("Minizinc", errors);
        }

        if (exitVal != 0) {
            throw new RuntimeException();
        }

        return output.toString();
    }
}
