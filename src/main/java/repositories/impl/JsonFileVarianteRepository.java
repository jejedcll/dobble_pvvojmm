package repositories.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import frunivangers.jpv.Variante;
import repositories.VarianteRepository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class JsonFileVarianteRepository implements VarianteRepository {

    private Map<Integer, Variante> variantes;

    public JsonFileVarianteRepository(Map<Integer, Variante> variantes) {
        this.variantes = new HashMap<>(variantes);
    }

    public static JsonFileVarianteRepository fromFile(File file) throws JsonSyntaxException, JsonIOException, FileNotFoundException {
        final Gson gson=new GsonBuilder().create();
        Variante[] variantesArray =gson.fromJson(new BufferedReader(new FileReader(file)), Variante[].class);

        Map<Integer, Variante> variantesMap = new HashMap<>();
        for(Variante v : variantesArray){
            variantesMap.put(v.getId(), v);
        }

        return new JsonFileVarianteRepository(variantesMap);
    }

    public Variante getVariante(int i){
        return this.variantes.get(i);
    }

}
