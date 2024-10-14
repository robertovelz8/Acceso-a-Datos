package controller;

import java.util.List;

import models.Persona;
import services.ManejaFicherosPersonas;

public class GestionaFicherosPersona {

	final static String rutaDirectorio = "C:\\Users\\EQUIPO\\Downloads\\LeerFicheros\\src\\main\\resources\\";

	public static void main(String[] args) {
		String nombreFichero = rutaDirectorio + "personas.txt";
		ManejaFicherosPersonas manejoPersonas = new ManejaFicherosPersonas();
		List<Persona> personas = manejoPersonas.leePersonasDeFicheros(nombreFichero);
		
		manejoPersonas.imprimePersonas(personas);

		String rutaDirectorioCsv = rutaDirectorio + "personas.csv";
		
		manejoPersonas.leerPersonasFicherosCsv(rutaDirectorioCsv);
		manejoPersonas.imprimePersonas(personas);
	}

}
