package repositories;

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

import models.Equipo;
import models.Pelicula;
import models.Piloto;

public class ManejoFicherosPiloto {
	private static final Logger logger = LogManager.getLogger(ManejoFicherosPiloto.class);
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
		private Equipo getEquipoFromElement(Element elemento) {
			Equipo e = new Equipo();
			String nombreEquipo = elemento.getElementsByTagName("nombreEquipo").item(0).getTextContent().trim();
			int puntos = Integer.parseInt(elemento.getElementsByTagName("puntos").item(0).getTextContent().trim());
			String puntuacion = elemento.getElementsByTagName("puntuacion").item(0).getTextContent().trim();
			elemento.setAttribute("identificadorEquipo", Integer.toString(e.getIdentificadorEquipo()));
			e.setNombreEquipo(nombreEquipo);
			e.setPuntuacion(puntuacion);
			
			List<Piloto> pilotos = new ArrayList<Piloto>();
			
			NodeList actoresListaNodos = elemento.getElementsByTagName("Actor");
			for (int i = 0; i < actoresListaNodos.getLength(); i++) {
				Element actorElemento = (Element) actoresListaNodos.item(i);
				String o = actorElemento.getTextContent().trim();
				p.getActores().add(o);
			}
			return e;
		}

		public List<Piloto> getPilotoFromXML(String nombreFichero, String nombreRaiz) {
			List<Piloto> modelos = new ArrayList<Piloto>();
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
							Piloto p = this.getPilotoFromElement((Element) modeloNodo);
							modelos.add(p);
						}
					}
				}
			}
			return modelos;
		}
}
