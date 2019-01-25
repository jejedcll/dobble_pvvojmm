package frunivangers.jpv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;


public class GsonParser {
	private Map<Integer, Variante> variantes;

	public void parse(String file) {
		final Gson gson=new GsonBuilder().create();
		try {
			Variante[] variantesArray =gson.fromJson(new BufferedReader(new FileReader(file)), Variante[].class);

			this.variantes = new HashMap<>();
			for(Variante v : variantesArray){
				this.variantes.put(v.getId(), v);
			}

		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (JsonIOException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Variante getVariante(int i){
		return this.variantes.get(i);
	}
}
