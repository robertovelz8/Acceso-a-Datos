package controlador;

import java.util.List;

import fichero.ManejaContenidoPersona;
import modelo.Persona;

public class GestionaFicheroPersona {
	final static String rutaDirectorio = "C:\\Users\\EQUIPO\\eclipse-workspace\\com.CFGSLibreria\\src\\main\\resources\\";

	public static void main(String[] args) {
		String nombreFichero = rutaDirectorio + "personas.txt";
		ManejaContenidoPersona manejoPersona = new ManejaContenidoPersona();

		List<Persona> personas = manejoPersona.leerPersonaDeFichero(nombreFichero);
		manejoPersona.imprimePersonas(personas);

		String nombreFichero1 = rutaDirectorio + "personas.csv";
		ManejaContenidoPersona manejoPersona1 = new ManejaContenidoPersona();

		List<Persona> personas1 = manejoPersona1.leerPersonaDeFichero(nombreFichero1);
		manejoPersona1.imprimePersonas(personas1);
	}
}