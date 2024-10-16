package repositories;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import models.Combinacion;

public class HistoricoCombinaciones {
	
	//Attributes
	private static final Logger logger = LogManager.getLogger(HistoricoCombinaciones.class);
	private List<Combinacion> combinaciones;
	
	//Constructors
	public HistoricoCombinaciones(List<Combinacion> combinaciones) {
		super();
		this.combinaciones = new ArrayList<Combinacion>();
	}

	public HistoricoCombinaciones() {
		super();
		this.combinaciones = new ArrayList<Combinacion>();
	}

	//Getters & Setters
	
	public List<Combinacion> getCombinaciones() {
		return combinaciones;
	}

	public void setCombinaciones(List<Combinacion> combinaciones) {
		this.combinaciones = combinaciones;
	}
	
	//Methods
	
	public void leerCsvCombinaciones (String ruta) {
		try (Scanner scanner = new Scanner(new File(ruta))) {
            scanner.useLocale(Locale.ENGLISH);
			if (scanner.hasNextLine()) {
                scanner.nextLine(); // Saltar la cabecera
            }
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(",");
                String fecha = values[0];
                
                List<Integer> numeros = new ArrayList<>();
                for (int i = 1; i <= 5; i++) {
                    numeros.add(Integer.parseInt(values[i].trim()));
                }
                
                List<Integer> estrellas = new ArrayList<>();
                estrellas.add(Integer.parseInt(values[7].trim()));
                estrellas.add(Integer.parseInt(values[8].trim()));

                Combinacion combinacion = new Combinacion(fecha, numeros, estrellas);
                combinaciones.add(combinacion);
            }
        } catch (FileNotFoundException e) {
            logger.debug("No se ha encontrado la ruta: "+ruta);
        }
		logger.debug(combinaciones);
	}
	
}
