package frunivangers.jpv.generator;

import com.google.gson.Gson;
import frunivangers.jpv.Carte;
import frunivangers.jpv.Paquet;
import frunivangers.jpv.generator.serialization.Model;
import repositories.SymboleFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings("WeakerAccess")
public class GenerateurPaquetMiniZinc implements GenerateurPaquet {

    private boolean shuffle = true;
    private String minizincPath;
    private SymboleFactory symboleFactory;

    public GenerateurPaquetMiniZinc(String minizincPath, SymboleFactory symboleFactory) {
        this.minizincPath = minizincPath;
        this.symboleFactory = symboleFactory;
    }

    public GenerateurPaquetMiniZinc(String minizincPath, boolean shuffle) {
        this.minizincPath = minizincPath;
        this.shuffle = shuffle;
    }

    @Override
    public Paquet generate(int nombreCarte, int nombreSymbol, int nombreSymboleParCarte, int nombreVariantes) throws IOException, InterruptedException {
        assert nombreCarte > 0;
        assert nombreSymbol > 0;
        assert nombreSymboleParCarte > 0;
        assert nombreSymboleParCarte <= nombreSymbol;
        assert nombreVariantes > 0;

        File dataFile = this.setUpDataFile(nombreCarte, nombreSymbol, nombreSymboleParCarte, nombreVariantes);
        Model model = this.loadFromMinizinc(dataFile);

        List<Carte> carteList = new ArrayList<>();

        return new Paquet(Collections.unmodifiableList(carteList));
    }

    protected List<Carte> cartesListFromModel(Model model){

        CarteListeGenerateur carteListeGenerateur;
        if(this.shuffle){
            carteListeGenerateur = new SimpleCarteListeGenerateur(this.symboleFactory);
        }else{
            carteListeGenerateur = new ShuffleCarteListeGenerateur(this.symboleFactory);
        }

        return carteListeGenerateur.fromModel(model);
    }

    protected File setUpDataFile(int nombreCarte, int nombreSymbol, int nombreSymboleParCarte, int nombreVariante) throws IOException {
        //TODO create data.dzn file

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

        return dataFile;
    }

    protected Model loadFromMinizinc(File dataFile) throws IOException, InterruptedException {

        String jsonModel = this.runMinizinc(dataFile);

        Gson gson = new Gson();

        Model model = gson.fromJson(jsonModel, Model.class);

        System.out.println(model);

        return model;
    }

    protected String runMinizinc(File dataFile) throws IOException, InterruptedException {

        ProcessBuilder processBuilder = new ProcessBuilder();

        // Run a shell command
        String command = "export LD_LIBRARY_PATH=" + minizincPath + "/lib:$LD_LIBRARY_PATH"
                + " && " + minizincPath +"/bin/minizinc model.mzn " + dataFile.getAbsolutePath()
                + "| head -n -1";

        processBuilder.command("bash", "-c", command);
        Process process = processBuilder.start();

        StringBuilder output = new StringBuilder();

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(process.getInputStream()));

        BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));

        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
            output.append(line).append('\n');
        }
        while((line = errorReader.readLine()) != null){
            System.err.println(line);
        }

        int exitVal = process.waitFor();
        if (exitVal != 0) {
            throw new RuntimeException();
        }

        return output.toString();
    }
}
