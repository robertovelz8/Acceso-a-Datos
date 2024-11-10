package Utilidades;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class UtilidadesProductos {

	private static Logger logger = LogManager.getLogger(UtilidadesProductos.class);

	private static final String rutaResources = "src/main/resources/";
	private static final String nombreArchivo = "Productos.xml";
	private static final String rutaCompleta = rutaResources + nombreArchivo;

	private Document getDocumentFromXML() {
		File file = new File(rutaCompleta);
		Document documento = null;
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			documento = dBuilder.parse(file);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return documento;
	}

	// clases necesarias finalizar la creación del archivo XML
	private void escribeDocumentoEnFichero(Document documento, String nombreFichero) throws TransformerException {
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer;
		transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(documento);
		StreamResult resultado = new StreamResult(new File(rutaResources + nombreFichero));
		transformer.transform(source, resultado);
	}

	public void actualizarAtributo(String nombreFichero, String nombreRaiz) {

		try {
			Document doc = getDocumentFromXML();
			NodeList listaProductos = doc.getElementsByTagName(nombreRaiz);

			for (int i = 0; i < listaProductos.getLength(); i++) {

				Node prod = listaProductos.item(i);

				if (prod.getNodeType() == Node.ELEMENT_NODE) {

					Element element = (Element) prod;
					int stock = Integer.parseInt(element.getElementsByTagName("Stock").item(0).getTextContent().trim());

					if (stock < 5) {
						element.setAttribute("aLaVenta", "false");
					}
				}
				escribeDocumentoEnFichero(doc, nombreFichero);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

}