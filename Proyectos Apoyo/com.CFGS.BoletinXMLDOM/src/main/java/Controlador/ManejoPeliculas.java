package Controlador;

import Utilidades.UtilesPeliculas;

public class ManejoPeliculas {

	public static void main(String[] args) {
		UtilesPeliculas utilesPeliculas = new UtilesPeliculas();

		// Leer y mostrar películas desde el archivo XML
		utilesPeliculas.leerPeliculasXML();
	}

}