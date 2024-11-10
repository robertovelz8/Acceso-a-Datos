package utilidades;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import modelos.Droguita;
import modelos.Yonki;

public class ManejaFicheroJson {
	public void escribeDroguitas(List<Droguita> lista, String ruta) {	// Convertir el objeto a JSON
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(lista);
		// Escribir el JSON en un archivo
		FileWriter writer = null;
		try {
			writer = new FileWriter(ruta);
			writer.write(json);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try { 	writer.close(); } 
	catch (IOException e) {e.printStackTrace();	}
	}	
	}	
}
	public void escribeyonkis(List<Yonki> lista, String ruta) {	// Convertir el objeto a JSON
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(lista);
		// Escribir el JSON en un archivo
		FileWriter writer = null;
		try {
			writer = new FileWriter(ruta);
			writer.write(json);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try { 	writer.close(); } 
	catch (IOException e) {e.printStackTrace();	}
	}	}	}


}
