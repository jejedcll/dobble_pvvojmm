package frunivangers.jpv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;


public class GsonParser {
	private static Variante[] variantes={};

	public void parse(String file) {
		final Gson gson=new GsonBuilder().create();
		try {
			variantes=gson.fromJson(new BufferedReader(new FileReader(file)), Variante[].class);
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (JsonIOException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Variante getRandomVariante() {
		return variantes[((int)(Math.random()*variantes.length))];
	}
}
