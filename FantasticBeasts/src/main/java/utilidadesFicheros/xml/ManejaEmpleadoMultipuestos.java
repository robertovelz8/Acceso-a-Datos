package utilidadesFicheros.xml;

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

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import models.Empleado;

public class ManejaEmpleadoMultipuestos ManejaFicherosXML <EmpleadoMultipuestos> {

	private static final String rutaResources = "src\\main\\resources\\";

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
	
	protected void escribeDocumentoEnFichero(Document documento, String nombreFichero) throws TransformerException {
		// clases necesarias finalizar la creación del archivo XML
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer;
		transformer = transformerFactory.newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		DOMSource source = new DOMSource(documento);
		StreamResult resultado = new StreamResult(new File(this.rutaResources + nombreFichero));
		transformer.transform(source, resultado);
	}

	protected Element creaElemento(String nombreElemento, String valorElemento, Element padre, Document documento) {
		Element elemento = documento.createElement(nombreElemento);
		Text texto = documento.createTextNode(valorElemento);
		padre.appendChild(elemento);// Se lo asigno a su padre como Hijo
		elemento.appendChild(texto);// Cargo el elemento con el valor
		return elemento;
	}
	
	private  Empleado getEmpleadoFromElement(Element elemento) {
			Empleado e = new Empleado();
			String nombre = elemento.getElementsByTagName("nombreApellido").item(0).getTextContent();
			int edad = Integer.parseInt(elemento.getElementsByTagName("edad").item(0).getTextContent());
			String empresa = elemento.getElementsByTagName("empresa").item(0).getTextContent();
			String id = elemento.getAttribute("identificador"); // La etiqueta empleado tiene el atributo identificador
			e.setEdad(edad);
			e.setNombreApellido(nombre);
			e.setIdentificador(id);
			e.setEmpresa(empresa);
			return e;
	}
	
}