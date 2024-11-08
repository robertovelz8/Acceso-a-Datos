package controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import utilesXML.ManejaFicherosXML;

public class GestionaPeliculasXML {

	private static final Logger logger = LogManager.getLogger(GestionaPeliculasXML.class);
	
	public static void main(String[] args) {
		
		ManejaFicherosXML m1 = new ManejaFicherosXML();
		logger.debug(m1.getPeliculasFromXML("peliculas.xml", "CatalogoPeliculas"));
	}
	
	
	

}