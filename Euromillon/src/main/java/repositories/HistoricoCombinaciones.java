package repositories;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import models.Combinacion;

public class HistoricoCombinaciones {

	// Attributes
	private static final Logger logger = LogManager.getLogger(HistoricoCombinaciones.class);
	private List<Combinacion> combinaciones;

	// Constructors
	public HistoricoCombinaciones(List<Combinacion> combinaciones) {
		super();
		this.combinaciones = new ArrayList<Combinacion>();
	}

	public HistoricoCombinaciones() {
		super();
		this.combinaciones = new ArrayList<Combinacion>();
	}

	// Getters & Setters

	public List<Combinacion> getCombinaciones() {
		return combinaciones;
	}

	public void setCombinaciones(List<Combinacion> combinaciones) {
		this.combinaciones = combinaciones;
	}

	// Methods

	public List<Combinacion> leerCsvCombinaciones(String ruta) {
		Scanner sc = null;
		try {
			FileReader fichero = new FileReader(ruta);
			sc = new Scanner(fichero);
			sc.useLocale(Locale.ENGLISH);
			sc.useDelimiter(",|\\n|\\r");

			// Saltar cabecera
			if (sc.hasNextLine()) {
				sc.nextLine();
			}

			while (sc.hasNextLine()) {
				String linea = sc.nextLine();
				String[] datos = linea.split(",");

				// Leer la fecha como String
				String fecha = datos[0].trim();

				// Leer los números ganadores (del 1 al 5)
				List<Integer> numerosGanadores = new ArrayList<>();
				for (int i = 1; i <= 5; i++) {
					numerosGanadores.add(Integer.parseInt(datos[i].trim()));
				}

				// Leer las estrellas (del 7 al 8)
				List<Integer> estrellas = new ArrayList<>();
				for (int i = 7; i <= 8; i++) {
					estrellas.add(Integer.parseInt(datos[i].trim()));
				}

				// Crear una nueva combinacion con fecha, numeros y estrellas
				Combinacion combinacion = new Combinacion(fecha, numerosGanadores, estrellas);
				// Añadir la combinacion a la lista
				combinaciones.add(combinacion);
			}
		} catch (FileNotFoundException e) {
			System.err.println("No se ha encontrado la ruta: " + ruta);
		} finally {
			if (sc != null) {
				sc.close();
			}
		}
		return combinaciones;
	}
}
