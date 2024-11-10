package Utilidades;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class UtilidadesRecetaDOM {

	private static Logger logger = LogManager.getLogger(UtilidadesProductos.class);

	private static final String rutaResources = "src/main/resources/";
	private static final String nombreArchivo = "Receta.xml";

	// Método para crear el XML
	public void crearRecetaXML(String titulo, String[] ingredientes, String[] cantidades, String procedimiento,
			String tiempo) {
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.newDocument();

			// Elemento raíz
			Element elementoRaiz = doc.createElement("Receta");
			doc.appendChild(elementoRaiz);

			// Título
			Element tituloElemento = doc.createElement("titulo");
			tituloElemento.appendChild(doc.createTextNode(titulo));
			elementoRaiz.appendChild(tituloElemento);

			// Ingredientes
			Element ingredientesElemento = doc.createElement("ingredientes");
			elementoRaiz.appendChild(ingredientesElemento);
			for (int i = 0; i < ingredientes.length; i++) {
				Element ingrediente = doc.createElement("ingrediente");
				ingrediente.setAttribute("cantidad", cantidades[i]);
				ingrediente.appendChild(doc.createTextNode(ingredientes[i]));
				ingredientesElemento.appendChild(ingrediente);
			}

			// Procedimiento
			Element procedimientoElemento = doc.createElement("procedimiento");
			procedimientoElemento.appendChild(doc.createTextNode(procedimiento));
			elementoRaiz.appendChild(procedimientoElemento);

			// Tiempo
			Element tiempoElemento = doc.createElement("tiempo");
			tiempoElemento.appendChild(doc.createTextNode(tiempo));
			elementoRaiz.appendChild(tiempoElemento);

			// Llamada a escribeDocumentoEnFichero para guardar el XML
			escribeDocumentoEnFichero(doc, nombreArchivo);

		} catch (ParserConfigurationException | TransformerException e) {
			logger.debug(e.getMessage());
		}
	}

	// Método para guardar el XML en el archivo
	private void escribeDocumentoEnFichero(Document documento, String nombreFichero) throws TransformerException {
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		DOMSource source = new DOMSource(documento);
		StreamResult resultado = new StreamResult(new File(rutaResources + nombreFichero));
		transformer.transform(source, resultado);
	}
}