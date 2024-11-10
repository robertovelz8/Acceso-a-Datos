package utilidades;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import modelo.Empleado;

public class ManejaFicheroEmpleadosXML {
	private static final Logger logger = LogManager.getLogger(ManejaFicheroEmpleadosXML.class);

	/**
	 * @param nombreRaiz
	 * @return
	 * @throws ParserConfigurationException
	 */

	private Document construyoObjetoDocumento(String nombreRaiz) throws ParserConfigurationException {
		Document documento = null;
		DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factoria.newDocumentBuilder();
		DOMImplementation implementacion = builder.getDOMImplementation();
		documento = implementacion.createDocument(null, nombreRaiz, null);
		// Primer parámetro uri: si null no está validado por ninguna ruta
		// segundo parámetro: nombre fichero
		// tercer parámetro: document type Por defecto null
		return documento;
	}

	/**
	 * @param documento
	 * @param nombreFichero
	 */
	private void escribeDocumentoEnFichero(Document documento, String nombreFichero) throws TransformerException {
		// clases necesarias finalizar la creación del archivo XML
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer;
		transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(documento);
		StreamResult resultado = new StreamResult(new File(
				"C:\\Users\\EQUIPO\\eclipse-workspace\\com.CFGS.Archivos\\src\\main\\resources" + nombreFichero));
		transformer.transform(source, resultado);

	}

	/**
	 * @param documento
	 * @param padre
	 * @param e
	 */
	private void agregaEmpleadoADocumento(Document documento, Element padre, Empleado e) {
		// Para cada una de los atributos de persona, creo un elemento hijo
		Element nombre = this.creaElemento("nombreApellido", e.getNombreApellido(), padre, documento);
		Element edad = this.creaElemento("edad", Integer.toString(e.getEdad()), padre, documento);
		Element empresa = this.creaElemento("empresa", e.getEmpresa(), padre, documento);
		// El identificador lo vamos a crear como un atributo de la etiqueta empleado
		padre.setAttribute("identificador", e.getIdentificador());
	}

	/**
	 * @param nombreElemento
	 * @param valorElemento
	 * @param padre
	 * @param documento
	 * @return
	 */

	private Element creaElemento(String nombreElemento, String valorElemento, Element padre, Document documento) {
		Element elemento = documento.createElement(nombreElemento);
		Text texto = documento.createTextNode(valorElemento);
		padre.appendChild(elemento);// Se lo asigno a su padre como Hijo
		elemento.appendChild(texto);// Cargo el elemento con el valor
		return elemento;
	}

	/**
	 * @param nombreFichero
	 * @param e
	 */
	public void escribeEmpleadoEnXML(String nombreFichero, Empleado e) throws TransformerException {
		try {
			Document documento = this.construyoObjetoDocumento("empleado");
			// Recupero la raíz del documento
			Element raiz = documento.getDocumentElement();
			agregaEmpleadoADocumento(documento, raiz, e);
			escribeDocumentoEnFichero(documento, nombreFichero);
		} catch (ParserConfigurationException e1) {
			logger.error(e1.getMessage());
		}
	}
}