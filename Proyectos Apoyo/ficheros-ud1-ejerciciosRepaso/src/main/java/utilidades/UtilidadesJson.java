/**
 * 
 */
package utilidades;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import modelo.Perro;

/**
 * 
 */
public class UtilidadesJson {

	/**
	 * 
	 */
	public static String rutaResources = "src\\main\\resources\\";

	/**
	 * API GSON. Lectura de Json. Lectura de fichero con un perro
	 * 
	 * @param nombreFichero
	 * @return perro
	 */
	public Perro getPerroJson(String nombreFichero) {
		Perro perro = null;

		try {
			FileReader fichero = new FileReader(rutaResources + nombreFichero);

			Gson gson = new Gson();
			perro = gson.fromJson(fichero, Perro.class);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return perro;

	}

	/**
	 * API GSON. Lectura de Json. Lectura de fichero con array de perros
	 * 
	 * @param nombreFichero
	 * @return perros
	 */
	public List<Perro> getPerrosJson(String nombreFichero) {

		Perro[] perro = null;
		List<Perro> perros = null;
		try {
			FileReader fichero = new FileReader(rutaResources + nombreFichero);

			Gson gson = new Gson();
			perro = gson.fromJson(fichero, Perro[].class);
			perros = Arrays.asList(perro);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return perros;

	}

	/**
	 * API GSON. Generar Json a partir de objetos. Escritura de un perro en un
	 * fichero JSON
	 * 
	 * @param perro
	 * @param ruta
	 */
	public void escribePerro(Perro perro, String ruta) {// Convertir el objeto a JSON
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation() // Solo incluir campos con @Expose
				.setPrettyPrinting() // Si quieres un JSON bonito
				.create();
		String json = gson.toJson(perro);
		FileWriter fichero = null;
		try {
			fichero = new FileWriter(ruta);
			fichero.write(json);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fichero != null) {
				try {
					fichero.close();
				} catch (IOException e) {
					System.out.println("Error al escribir empleado");
				}
			}
		}
	}

	/**
	 * API GSON. Generar Json a partir de objetos. Escritura de lista de perro en un
	 * fichero JSON
	 * 
	 * @param lista
	 * @param ruta
	 */
	public void escribePerros(List<Perro> lista, String ruta) { // Convertir el objeto a JSON
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation() // Solo incluir campos con @Expose
				.setPrettyPrinting() // Si quieres un JSON bonito
				.create();
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
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * @param perros
	 * @param nombreFichero
	 */
	public void escriboCsv(List<Perro> perros, String nombreFichero) {
		PrintWriter out = null;
		try {
			FileWriter ficheroCsv;
			ficheroCsv = new FileWriter(rutaResources + nombreFichero);
			out = new PrintWriter(ficheroCsv);
			out.printf(generaCabeceraCsv());
			for (Perro perro : perros) {
				out.printf("%s, %s, %s, %s, %s, %d, %d %n", perro.getIdentificador(), perro.getNombre(),
						perro.getSexo(), perro.getRaza(), perro.getColor(), perro.getEdad(), perro.getPeso());
			}

		} catch (IOException e) {
			System.out.println("IOException");
		} finally {
			if (out != null)
				out.close();
		}
	}

	/**
	 * @return cabecera
	 */
	private String generaCabeceraCsv() {
		String cabecera = "Identificador, nombre, sexo, raza, edad, peso %n";
		return cabecera;

	}
}
