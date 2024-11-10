package fichero;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modelo.Persona;

public class ManejaContenidoPersona {
	private static final Logger logger = LogManager.getLogger(ManejaContenidoPersona.class);

	public List<Persona> leerPersonaDeFichero(String rutaNombreFichero) {
		Scanner in = null;
		List<Persona> personas = new ArrayList<Persona>();

		try {
			FileReader fichero = new FileReader(rutaNombreFichero);
			in = new Scanner(fichero);
			in.useLocale(Locale.ENGLISH);
			while (in.hasNextLine()) {
				Persona p = new Persona();
				p.setNombre(in.nextLine());
				while (in.hasNextDouble()) {
					p.getNotas().add(in.nextDouble());
				}
				personas.add(p);
			}
		} catch (FileNotFoundException e) {
			logger.error("Excepción al acceder al fichero: " + rutaNombreFichero + e.getMessage());
		} finally {
			if (in != null) {
				in.close();
			}
		}
		return personas;
	}

	public static List<Persona> leerPersonasFicheroCsv(String nombreFichero) {
		List<Persona> personas = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(nombreFichero))) {
			String linea;

			while ((linea = br.readLine()) != null) {
				String[] datos = linea.split(",");
				String nombre = datos[0];

				List<Double> valores = new ArrayList<>();
				for (int i = 1; i < datos.length; i++) {
					valores.add(Double.parseDouble(datos[i].trim()));
				}

				personas.add(new Persona());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return personas;
	}

	public void imprimePersonas(List<Persona> personas) {
		for (Persona p : personas) {
			logger.debug(p);
		}
	}
}