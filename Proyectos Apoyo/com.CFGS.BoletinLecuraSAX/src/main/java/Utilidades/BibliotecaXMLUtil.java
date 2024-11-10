package Utilidades;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import Modelo.Libros;

public class BibliotecaXMLUtil extends DefaultHandler {
	private List<Libros> libros;
	private Libros libroActual;
	private StringBuilder buffer;

	/**
	 * Método para leer el archivo XML y obtener una lista de objetos Libro.
	 * 
	 * @param rutaArchivo Ruta del archivo XML a leer.
	 * @return Lista de objetos Libro extraídos del XML.
	 */
	public List<Libros> getModeloFromXML(String rutaArchivo) {
		libros = new ArrayList<>();
		buffer = new StringBuilder();

		try {
			// Verifica que el archivo existe antes de intentar leerlo
			File archivo = new File(rutaArchivo);
			if (!archivo.exists()) {
				throw new FileNotFoundException(
						"El archivo XML no se encontró en la ruta especificada: " + rutaArchivo);
			}

			// Crea el parseador SAX y parsea el archivo
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			saxParser.parse(archivo, this);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return libros;
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) {
		// Inicializa un nuevo objeto Libro cuando se encuentra la etiqueta <libro>
		if (qName.equals("libro")) {
			libroActual = new Libros();
			libroActual.setIdentificador(attributes.getValue("identificador"));
		} else {
			// Limpia el buffer para capturar el contenido de los elementos
			buffer.setLength(0);
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) {
		// Acumula el texto dentro de una etiqueta
		buffer.append(ch, start, length);
	}

	@Override
	public void endElement(String uri, String localName, String qName) {
		// Asigna el texto del buffer al campo correspondiente de Libro
		switch (qName) {
		case "autor":
			libroActual.setAutor(buffer.toString());
			break;
		case "titulo":
			libroActual.setTitulo(buffer.toString());
			break;
		case "genero":
			libroActual.setGenero(buffer.toString());
			break;
		case "precio":
			libroActual.setPrecio(Double.parseDouble(buffer.toString()));
			break;
		case "libro":
			// Agrega el libro a la lista una vez que se cierra la etiqueta <libro>
			libros.add(libroActual);
			break;
		}
	}
}