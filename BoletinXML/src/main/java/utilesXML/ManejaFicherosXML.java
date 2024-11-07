package utilesXML;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import models.Pelicula;

public class ManejaFicherosXML {

	private static final Logger logger = LogManager.getLogger(ManejaFicherosXML.class);
	private static final String rutaResources = "src/main/resources/";

	private Document getDocumentFromXML(String nombrefichero) {

		// Ruta para obtener el fichero .XML
		File file = new File(rutaResources + nombrefichero);
		Document documento = null;
		try {
			// Crear un DocumentBuilderFactory y un DocumentBuilder
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

			// Parsear el XML
			documento = dBuilder.parse(file);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return documento;
	}

	// Método para extraer los datos de una película desde un elemento XML
	private Pelicula getPeliculaFromElement(Element elemento) {
		Pelicula p = new Pelicula();
		String titulo = elemento.getElementsByTagName("Titulo").item(0).getTextContent().trim();
		String fecha = elemento.getElementsByTagName("Fecha").item(0).getTextContent().trim();
		String director = elemento.getElementsByTagName("Director").item(0).getTextContent().trim();
		p.setTitulo(titulo);
		p.setFecha(fecha);
		p.setDirector(director);
		List<String> actores = new ArrayList<String>();
		p.setActores(actores);
		NodeList actoresListaNodos = elemento.getElementsByTagName("Actor");
		for (int i = 0; i < actoresListaNodos.getLength(); i++) {
			Element actorElemento = (Element) actoresListaNodos.item(i);
			String o = actorElemento.getTextContent().trim();
			p.getActores().add(o);
		}
		return p;
	}

	public List<Pelicula> getPeliculasFromXML(String nombreFichero, String nombreRaiz) {
		List<Pelicula> modelos = new ArrayList<Pelicula>();
		Document documento = getDocumentFromXML(nombreFichero);
		NodeList nodoRaiz = documento.getElementsByTagName(nombreRaiz);
		Node raiz = nodoRaiz.item(0); // obtengo el nodo raíz
		if (raiz.getNodeType() == Node.ELEMENT_NODE) {
			Element elemento = (Element) raiz;
			if (elemento.hasChildNodes()) { // cada hijo es una pelicula
				NodeList nodosHijos = elemento.getChildNodes();
				for (int j = 0; j < nodosHijos.getLength(); j++) {
					Node modeloNodo = nodosHijos.item(j);
					if (modeloNodo.getNodeType() == Node.ELEMENT_NODE) {
						Pelicula p = this.getPeliculaFromElement((Element) modeloNodo);
						modelos.add(p);
					}
				}
			}
		}
		return modelos;
	}
}