package services;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import models.Persona;

public class ManejaFicherosPersonas {
	private static final Logger logger = LogManager.getLogger(ManejaFicherosPersonas.class);
	List<Persona> personas = new ArrayList<Persona>();
	
	
	public List<Persona> leePersonasDeFicheros(String rutaYNombreFichero) {
		Scanner sc = null;
		
		try {
			FileReader fichero = new FileReader(rutaYNombreFichero);
			sc = new Scanner (fichero);
			sc.useLocale(Locale.ENGLISH);
			while(sc.hasNext()) {
				Persona p = new Persona();
				p.setNombre(sc.next());
				while(sc.hasNextDouble()) {
					p.getNotas().add(sc.nextDouble());
				}
				personas.add(p);
			}
		} catch (FileNotFoundException e) {
			logger.error("Excepción al acceder al fichero: "+rutaYNombreFichero+": "+e.getMessage());
		}finally {
			if(sc != null) {
				sc.close();
			}
		}
		return personas;
	}
	
	public void imprimePersonas(List<Persona> personas) {
		for(Persona p : personas) {
			logger.debug(p);
		}
	}
	
	public List<Persona> leerPersonasFicherosCsv(String rutaYNombreFichero) {
		Scanner sc = null;
		List<Persona> personas = new ArrayList<Persona>();
		try {
			FileReader fichero = new FileReader(rutaYNombreFichero);
			sc = new Scanner(fichero);
			sc.useLocale(Locale.ENGLISH);
			sc.useDelimiter(",");
			while (sc.hasNextLine()) {
				while (sc.hasNext()) {
					Persona p = new Persona();
					p.setNombre(sc.next());
					List<Double> notas = new ArrayList<Double>();
					while (sc.hasNextDouble()) {
						notas.add(sc.nextDouble());
					}
					p.setNotas(notas);
				}
			}
		} catch (FileNotFoundException e) {
			logger.error("Excepción al acceder al fichero csv: " + rutaYNombreFichero + ": " + e.getMessage());
		} finally {
			if (sc != null) {
				sc.close();
			}
		}

		return personas;
	}
	
}
