// utilidades/UtilesEstudiantes.java
package utilidades;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import modelo.Estudiante;

public class UtilesEstudiantes {

	private final static Logger logger = LogManager.getLogger(UtilesEstudiantes.class);

	private static final String rutaResources = "src/main/resources/";
	private static final String nombreArchivo1 = "Estudiante.json";
	private static final String nombreArchivo2 = "Estudiantes.json";

	private List<Estudiante> estudiantes = new ArrayList<>();

	// Nos permite obtener los estudiates de nuestra lista de estudiantes
	public List<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	// Agrega Esudiantes a la lista que luego se cargara en el JSON
	public void agregarEstudiante(String nombre, int edad, String idEstudiante, String curso) {
		Estudiante e1 = new Estudiante(nombre, edad, idEstudiante, curso);
		this.estudiantes.add(e1);
	}

	// Crea estudiantes de forma individual
	public void escribeEstudianteJSON(Estudiante estudiante) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(estudiante);
		try (FileWriter fichero = new FileWriter(rutaResources + nombreArchivo1)) {
			fichero.write(json);
		} catch (IOException e) {
			logger.error("Error al escribir estudiante: ", e);
		}
	}

	// Crea multiples estudiantes
	public void escribeEstudiantesJSON(List<Estudiante> lista) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(lista);
		try (FileWriter writer = new FileWriter(rutaResources + nombreArchivo2)) {
			writer.write(json);
		} catch (IOException e) {
			logger.error("Error al escribir lista de estudiantes: ", e);
		}
	}

	public Estudiante leerEstudianteJSON() {
		Estudiante estudiante = null;
		Gson gson = new Gson();
		try (FileReader reader = new FileReader(rutaResources + nombreArchivo1)) {
			estudiante = gson.fromJson(reader, Estudiante.class);
		} catch (IOException e) {
			logger.debug("Error al leer el archivo JSON", e);
		}
		return estudiante;
	}

	public Estudiante[] leerEstudiantesJSON() {
		Estudiante[] estudiantes = null;
		Gson gson = new Gson();
		try {
			FileReader fr = new FileReader(rutaResources + nombreArchivo2);
			estudiantes = gson.fromJson(fr, Estudiante[].class);

		} catch (IOException e) {
			logger.debug(e.getMessage());
		}
		return estudiantes;
	}

	public void escriboCsv(List<Estudiante> listaEstudiantes, String nombreFichero) {
		PrintWriter out = null;
		try {
			FileWriter ficheroCsv;
			ficheroCsv = new FileWriter(rutaResources + nombreFichero);
			out = new PrintWriter(ficheroCsv);
			out.printf(generaCabeceraCsv());
			for (Estudiante estudiante : estudiantes) {
				out.printf("%s, %d, %s, %s, %n", estudiante.getNombre(), estudiante.getEdad(),
						estudiante.getIdEstudiante(), estudiante.getCurso());
			}

		} catch (IOException e) {
			System.out.println("IOException");
		} finally {
			if (out != null)
				out.close();
		}
	}

	private String generaCabeceraCsv() {
		String cabecera = "Nombre Edad Identificador Curso %n";
		return cabecera;
	}

	public void JSONEstudianteTXT(Estudiante estudiante, String archivoTXT) {
		Gson gson = new Gson();
		// Convertir el objeto estudiante a formato JSON
		String archivoJSON = gson.toJson(estudiante);

		try (FileWriter writer = new FileWriter(rutaResources + archivoTXT)) {
			writer.write(archivoJSON);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Excluimmos Edad, ya que no nos interesa
	// try es asi ya que sino no imprime el resultado en el archivo.txt
	public void JSONEstudiantesTXT(String ArchivoTXT) {
		try (PrintWriter writer = new PrintWriter(new FileWriter(rutaResources + ArchivoTXT))) {
			writer.println("Estudiantes");
			for (Estudiante estudiante : estudiantes) {
				writer.println("------------------");
				writer.println("Nombre: " + estudiante.getNombre());
				writer.println("Id Estudiante: " + estudiante.getIdEstudiante());
				writer.println("Curso: " + estudiante.getCurso());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
