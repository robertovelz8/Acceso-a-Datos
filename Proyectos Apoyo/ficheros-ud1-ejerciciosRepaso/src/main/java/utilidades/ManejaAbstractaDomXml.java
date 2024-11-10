/**
 * 
 */
package utilidades;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

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
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

/**
 * 
 */
public abstract class ManejaAbstractaDomXml<T> {

	/**
	 * 
	 */
	private static final Logger logger = LogManager.getLogger(ManejaAbstractaDomXml.class);

	/**
	 * 
	 */
	public static String rutaResources = "src\\main\\resources\\";

	/**
	 * Método común. XML Lectura DOM. Método que te devuelve Document desde un
	 * fichero xml
	 * 
	 * @param nombrefichero
	 * @return documento
	 */
	public Document getDocumentFromXML(String nombrefichero) {
		File file = new File(rutaResources + nombrefichero);
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

	/**
	 * XML Lectura DOM. Método que desde un Document devuelve un modelo(empleado,
	 * criatura)
	 */
	public T getModeloFromXML(String nombreFichero, String nombreRaiz) {
		T e = null;
		Document documento = getDocumentFromXML(nombreFichero);
		Node nodoModelo = documento.getElementsByTagName(nombreRaiz).item(0);
		if (nodoModelo.getNodeType() == Node.ELEMENT_NODE) {
			e = this.getModeloFromElement((Element) nodoModelo);
		}
		return e;
	}

	/**
	 * XML Lectura DOM. Método que desde un Document devuelve una lista de Empleados
	 * Lee una lista de empleados desde un archivo XML.
	 *
	 * @param nombreFichero el nombre del archivo XML que contiene la lista de
	 *                      empleados
	 * @param empleados     el nombre de la etiqueta raíz que contiene los nodos de
	 *                      cada empleado
	 * @return una lista de objetos Empleado extraídos del archivo XML
	 */

	public List<T> getModelosFromXML(String nombreFichero, String nombreEtiquetaPadre) {
		List<T> modelos = new ArrayList<>(); // Inicializa la lista de empleados a retornar

		// Carga el archivo XML en un documento
		Document documento = getDocumentFromXML(nombreFichero);

		// Obtiene el nodo raíz (la etiqueta que agrupa los empleados)
		NodeList nodoRaiz = documento.getElementsByTagName(nombreEtiquetaPadre);
		Node raiz = nodoRaiz.item(0); // Obtiene el primer nodo raíz de la lista

		// Verifica que el nodo raíz sea un elemento
		if (raiz != null && raiz.getNodeType() == Node.ELEMENT_NODE) {
			Element elemento = (Element) raiz;

			// Comprueba si el nodo raíz tiene hijos (cada hijo representa un empleado)
			if (elemento.hasChildNodes()) {
				NodeList nodosHijos = elemento.getChildNodes();

				// Itera sobre cada nodo hijo
				for (int j = 0; j < nodosHijos.getLength(); j++) {
					Node modeloNodo = nodosHijos.item(j);

					// Verifica si el nodo hijo es un elemento (un nodo <empleado>)
					if (modeloNodo.getNodeType() == Node.ELEMENT_NODE) {
						// Convierte el nodo en un objeto Empleado y lo agrega a la lista
						T e = this.getModeloFromElement((Element) modeloNodo);
						modelos.add(e); // Agrega empleado a la lista
					}
				}
			}
		}

		return modelos; // Retorna la lista de empleados
	}

	/**
	 * Método común. XML Escritura DOM. Método que devuelve un Document a partir de
	 * la raíz
	 * 
	 * @param nombreRaiz
	 * @return documento
	 * @throws ParserConfigurationException
	 */
	protected Document construyoObjetoDocumento(String nombreRaiz) throws ParserConfigurationException {
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
	 * Método común XML Escritura DOM Método que a partir de un Document, genera un
	 * fichero XML
	 * 
	 * @param documento
	 * @param nombreFichero
	 * @throws TransformerException
	 */
	protected void escribeDocumentoEnFichero(Document documento, String nombreFichero) throws TransformerException {
		// clases necesarias finalizar la creación del archivo XML
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer;
		transformer = transformerFactory.newTransformer();
		// Configurar el formato de salida para que esté indentado
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		DOMSource source = new DOMSource(documento);
		StreamResult resultado = new StreamResult(new File(this.rutaResources + nombreFichero));
		transformer.transform(source, resultado);
	}

	/**
	 * Método común XML Escritura DOM Método que genera un Element a partir de su
	 * nombre y su valor
	 * 
	 * @param nombreElemento
	 * @param valorElemento
	 * @param padre
	 * @param documento
	 * @return elemento
	 */
	protected Element creaElemento(String nombreElemento, String valorElemento, Element padre, Document documento) {
		Element elemento = documento.createElement(nombreElemento);
		Text texto = documento.createTextNode(valorElemento);
		padre.appendChild(elemento);// Se lo asigno a su padre como Hijo
		elemento.appendChild(texto);// Cargo el elemento con el valor
		return elemento;
	}

	/**
	 * XML Escritura DOM Método que genera un fichero xml a partir de una criatura
	 * 
	 * @param nombreFichero
	 * @param c
	 */
	public void escribeModeloEnXML(String nombreFichero, T c, String nombreEtiquetaRaiz) {
		try {
			Document documento = this.construyoObjetoDocumento(nombreEtiquetaRaiz);
			// Recupero la raíz del documento
			Element raiz = documento.getDocumentElement();
			agregaModeloADocumento(documento, raiz, c);
			escribeDocumentoEnFichero(documento, nombreFichero);
		} catch (ParserConfigurationException e1) {
			logger.error(e1.getMessage());
		} catch (TransformerException e1) {
			logger.error(e1.getMessage());
		}
	}

	/**
	 * XML Escritura DOM Método que escribe una lista de empleados a un fichero
	 * 
	 * @param nombreFichero
	 * @param empleados
	 */
	public void escribeModelosEnXML(String nombreFichero, List<T> modelos, String nombreRaiz, String nombrePadre) {
		try {
			Document documento = this.construyoObjetoDocumento(nombreRaiz);
			for (T m : modelos) {
				Element elemento = this.creaElemento(nombrePadre, null, documento.getDocumentElement(), documento);
				agregaModeloADocumento(documento, elemento, m);
			}
			escribeDocumentoEnFichero(documento, nombreFichero);
		} catch (ParserConfigurationException e1) {
			logger.error(e1.getMessage());
		} catch (TransformerException e1) {
			logger.error(e1.getMessage());
		}
	}

	/**
	 * XML Escritura DOM Método que escribe una lista de empleados a un fichero
	 * 
	 * @param nombreFichero
	 * @param empleados
	 */
	public void escribeModelosModificadosEnXML(String nombreFichero, List<T> modelos, String nombreRaiz,
			String nombrePadre) {
		try {
			Document documento = this.construyoObjetoDocumento(nombreRaiz);
			for (T m : modelos) {
				Element elemento = this.creaElemento(nombrePadre, null, documento.getDocumentElement(), documento);
				agregaModeloADocumentoModificado(documento, elemento, m);
			}
			escribeDocumentoEnFichero(documento, nombreFichero);
		} catch (ParserConfigurationException e1) {
			logger.error(e1.getMessage());
		} catch (TransformerException e1) {
			logger.error(e1.getMessage());
		}
	}

	/**
	 * @param elemento
	 * @return e
	 */
	abstract protected T getModeloFromElement(Element elemento);

	/**
	 * @param documento
	 * @param padre
	 * @param e
	 */
	abstract protected void agregaModeloADocumento(Document documento, Element padre, T e);

	/**
	 * @param documento
	 * @param padre
	 * @param e
	 */
	abstract protected void agregaModeloADocumentoModificado(Document documento, Element padre, T e);
}
