package controlador;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modelo.Estudiante;
import utilidades.UtilesEstudiantes;

public class GestorEstudiante {
	private final static Logger logger = LogManager.getLogger(UtilesEstudiantes.class);

	public static void main(String[] args) {

		UtilesEstudiantes ue = new UtilesEstudiantes();

		List<Estudiante> listaEstudiantes = new ArrayList<Estudiante>();

		Estudiante e1 = new Estudiante("Paco", 17, "001", "1º Bchillerato");
		ue.escribeEstudianteJSON(e1);

		ue.agregarEstudiante("Maria", 19, "002", "2º Carrera");
		ue.agregarEstudiante("Manolo", 13, "003", "2º ESO");
		ue.agregarEstudiante("Laura", 19, "004", "2º Carrera");
		ue.agregarEstudiante("Esteba", 30, "005", "Trabajando");
		ue.escribeEstudiantesJSON(ue.getEstudiantes());

		// Leer estudiantes desde el archivo JSON
		Estudiante[] estudiantes = ue.leerEstudiantesJSON();

		// Imprimir los estudiantes leídos
		if (estudiantes != null) {
			for (Estudiante estudiante : estudiantes) {
				logger.debug(estudiante);
			}
		} else {
			logger.debug("No se pudo leer la lista de estudiantes.");
		}

		logger.debug(ue.leerEstudianteJSON());

		ue.JSONEstudiantesTXT("EstudiantesTXT.txt");

		ue.JSONEstudianteTXT(e1, "EstudianteTXT.txt");

		listaEstudiantes.addAll(ue.getEstudiantes());
		ue.escriboCsv(listaEstudiantes, "EstudianteCSV.csv");
	}
}
