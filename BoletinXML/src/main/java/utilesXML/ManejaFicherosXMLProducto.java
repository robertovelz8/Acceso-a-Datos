package utilesXML;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
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
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import models.Producto;

public class ManejaFicherosXMLProducto {
	private static final String rutaResources = "src/main/resources/";
	private static final Logger logger = LogManager.getLogger(ManejaFicherosXMLProducto.class);

	public Document getDocumentFromXML(String nombrefichero) {

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

	public Producto getProductoFromElement(Element elemento) {
		Producto p = new Producto();
		String nombre = elemento.getElementsByTagName("nombreApellido").item(0).getTextContent().trim();
		double precio = Double.parseDouble(elemento.getElementsByTagName("edad").item(0).getTextContent().trim());
		int stock = Integer.parseInt(elemento.getElementsByTagName("empresa").item(0).getTextContent().trim());
		elemento.setAttribute("id", String.valueOf(p.getId()));
		elemento.setAttribute("aLaVenta", Boolean.toString(p.isaLaVenta()));
		p.setNombre(nombre);
		p.setPrecio(precio);
		p.setStock(stock);
		return p;
	}

	public List<Producto> getProductosFromXML(String nombreFichero, String nombreRaiz) {
		List<Producto> modelos = new ArrayList<Producto>();
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
						Producto p = this.getProductoFromElement((Element) modeloNodo);
						modelos.add(p);
					}
				}
			}
		}
		return modelos;
	}

	public void escribeDocumentoEnFichero(Document documento) throws TransformerException {
		// clases necesarias finalizar la creación del archivo XML
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer;
		transformer = transformerFactory.newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		DOMSource source = new DOMSource(documento);
		StreamResult resultado = new StreamResult(new File(rutaResources+"nuevoDoc.xml"));
		transformer.transform(source, resultado);
	}

	public void actualizarProducto (String nombreFichero, String nombreRaiz) {
		
		Document documento = getDocumentFromXML(nombreFichero);
		NodeList nodosProductos = documento.getElementsByTagName(nombreRaiz);
		
		for (int i = 0; i < nodosProductos.getLength(); i++) {
			Node producto = nodosProductos.item(i);
			Element elementoProducto = (Element) producto;
			if(producto.getNodeType() == Node.ELEMENT_NODE) {
				int stock = Integer.parseInt(elementoProducto.getElementsByTagName("Stock").item(0).getTextContent().trim());
				if(stock < 5) {
					elementoProducto.setAttribute("aLaVenta", "false");
				}
			}
			try {
				escribeDocumentoEnFichero(documento);
			} catch (TransformerException e) {
				
				logger.error(e.getMessage());
			}
		}		
	}
}
