package Utilidades;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class UtilesPeliculas {

	private static Logger logger = LogManager.getLogger(UtilesPeliculas.class);

	private static final String rutaResources = "src/main/resources/";
	private static final String nombreArchivo = "peliculas.xml";
	private static final String rutaCompleta = rutaResources + nombreArchivo;

	public void leerPeliculasXML() {
		try {
			// Cargar el archivo XML
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(rutaCompleta);
			doc.getDocumentElement().normalize();

			NodeList listaPeliculas = doc.getElementsByTagName("Pelicula");

			// Recorrer cada película
			for (int i = 0; i < listaPeliculas.getLength(); i++) {
				Node pelicula = listaPeliculas.item(i);

				if (pelicula.getNodeType() == Node.ELEMENT_NODE) {
					Element elemento = (Element) pelicula;

					// Obtener Titulo, Año y Director
					String titulo = elemento.getElementsByTagName("Titulo").item(0).getTextContent();
					String año = elemento.getElementsByTagName("Fecha").item(0).getTextContent();
					String director = elemento.getElementsByTagName("Director").item(0).getTextContent();

					// Imprimir Titulo, Año y Director en la consola
					logger.debug("Título: " + titulo);
					logger.debug("Año: " + año);
					logger.debug("Director: " + director);

					// Obtener y mostrar actores
					logger.debug("Actores: ");
					NodeList listaActores = elemento.getElementsByTagName("Actor");
					for (int o = 0; o < listaActores.getLength(); o++) {
						logger.debug(" - " + listaActores.item(o).getTextContent());
					}
					logger.debug("---------------------------");
				}
			}
		} catch (

		Exception e) {
			e.printStackTrace();
		}
	}
}