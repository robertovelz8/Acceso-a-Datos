package utilities;

import java.io.File;
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

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public abstract class ManejaDOMXml <T> { //escribe el arbol de la estructura
	protected  Element creaElemento(String nombreElemento, String valorElemento, Element padre, Document documento) {

	Element elemento = documento.createElement(nombreElemento);
	Text texto = documento.createTextNode(valorElemento);
	padre.appendChild(elemento);// Se lo asigno a su padre como Hijo
	elemento.appendChild(texto);// Cargo el elemento con el valor
	return elemento;
}

	protected  Document construyoObjetoDocumento(String nombreRaiz) throws ParserConfigurationException {
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
	
	protected  void escribeDocumentoEnFichero(Document documento, String nombreFichero) throws TransformerException {
		// clases necesarias finalizar la creación del archivo XML
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer;
		transformer = transformerFactory.newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		DOMSource source = new DOMSource(documento);
		StreamResult resultado = new StreamResult(new File(nombreFichero));
		transformer.transform(source, resultado);
	}	
	/*public T getModeloFromXML(String nombreFichero, String nombreRaiz) {
		T e = null;
		Document documento = getDocumentFromXML(nombreFichero);
		Node nodoModelo= documento.getElementsByTagName(nombreRaiz).item(0);
		if(nodoModelo.getNodeType()== Node.ELEMENT_NODE) {
			e = this.getModeloFromElement((Element)nodoModelo);
		}
		return e
	}*/
	protected Document getDocumentFromXML(String nombrefichero) {
		File file = new File(nombrefichero);
		Document documento = null;
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			documento = dBuilder.parse(file);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return documento;
	} 

	
	protected abstract void escribeModeloEnXML(String nombreFichero, List<T> listaIntroducida);//para una lista
	protected abstract void escribeModeloEnXML(String nombreFichero, T elementoIntroducido);//sobrecargo el método y lo hago para un solo elemento
	protected abstract void agregaModeloADocumento(Document documento,Element padre,  T e);	
	}

