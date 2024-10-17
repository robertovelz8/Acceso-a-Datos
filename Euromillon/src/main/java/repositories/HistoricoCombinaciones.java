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
		Scanner sc = null;
		try {
			FileReader fichero = new FileReader(ruta);
			sc = new Scanner(fichero);
			sc.useLocale(Locale.ENGLISH);
			sc.useDelimiter(", || \\n || \\r");
			
			//Saltar cabecera
			if (sc.hasNextLine()) {
				sc.nextLine();
			}
			
			while(sc.hasNextLine()) {
				Combinacion c = new Combinacion ();
			}
			
		}catch(FileNotFoundException e) {
			logger.error("No se ha encontrado la ruta: "+ruta);
		}
		
	}
	
}
