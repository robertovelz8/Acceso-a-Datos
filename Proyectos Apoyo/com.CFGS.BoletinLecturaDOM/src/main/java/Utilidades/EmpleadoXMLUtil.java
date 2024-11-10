package Utilidades;

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

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import Modelo.Empleado;
import Modelo.Puesto;

public class EmpleadoXMLUtil {

	/**
	 * Genera un archivo XML a partir de un objeto Empleado.
	 * 
	 * @param empleado    El objeto Empleado a convertir a XML.
	 * @param rutaArchivo Ruta donde se guardará el archivo XML.
	 */
	public void generarXML(Empleado empleado, String rutaArchivo) {
		try {
			// Configuración para crear un nuevo documento XML
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.newDocument(); // Se crea un nuevo documento XML vacío

			// Nodo raíz <empleado>
			Element root = doc.createElement("empleado");
			root.setAttribute("id", empleado.getId()); // Atributo "id" en <empleado>
			doc.appendChild(root); // Se añade el nodo <empleado> al documento XML

			// Añadir los subelementos con información del empleado
			crearElemento(doc, root, "nombreApellidos", empleado.getNombreApellidos());
			crearElemento(doc, root, "edad", String.valueOf(empleado.getEdad()));
			crearElemento(doc, root, "empresa", empleado.getEmpresa());

			// Nodo <puestos> para contener múltiples <puesto>
			Element puestosElem = doc.createElement("puestos");
			root.appendChild(puestosElem); // Se añade <puestos> como hijo de <empleado>

			// Iterar sobre la lista de puestos y añadir cada uno al XML
			for (Puesto puesto : empleado.getPuestos()) {
				Element puestoElem = doc.createElement("puesto");
				puestoElem.setAttribute("id", puesto.getId()); // Atributo "id" en <puesto>

				// Añadir los elementos específicos de cada puesto
				crearElemento(doc, puestoElem, "nombrePuesto", puesto.getNombrePuesto());
				crearElemento(doc, puestoElem, "departamento", puesto.getDepartamento());
				crearElemento(doc, puestoElem, "salario", String.valueOf(puesto.getSalario()));

				puestosElem.appendChild(puestoElem); // Añade <puesto> a <puestos>
			}

			// Configurar el transformador para escribir el documento XML en un archivo
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes"); // Configura el formato del XML
			DOMSource source = new DOMSource(doc); // Fuente del documento XML
			StreamResult result = new StreamResult(new File(rutaArchivo)); // Salida a archivo
			transformer.transform(source, result); // Se genera el archivo XML

		} catch (ParserConfigurationException | TransformerException e) {
			e.printStackTrace(); // Manejo de posibles excepciones en la configuración o transformación
		}
	}

	/**
	 * Método auxiliar para crear un elemento y agregarlo al documento.
	 * 
	 * @param doc         Documento donde se crea el elemento.
	 * @param parent      Elemento padre.
	 * @param tagName     Nombre de la etiqueta.
	 * @param textContent Contenido de texto del elemento.
	 */
	private void crearElemento(Document doc, Element parent, String tagName, String textContent) {
		Element elem = doc.createElement(tagName); // Crea un nuevo elemento
		elem.appendChild(doc.createTextNode(textContent)); // Añade el texto al elemento
		parent.appendChild(elem); // Añade el elemento al padre
	}

	/**
	 * Lee un archivo XML y construye una lista de objetos Empleado.
	 * 
	 * @param rutaArchivo Ruta del archivo XML a leer.
	 * @return Lista de objetos Empleado leídos del archivo XML.
	 */
	public List<Empleado> leerEmpleadosDesdeXML(String rutaArchivo) {
		List<Empleado> empleados = new ArrayList<>(); // Lista para almacenar empleados

		try {
			// Configuración para leer el archivo XML
			File archivo = new File(rutaArchivo);
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(archivo); // Analiza el archivo XML y construye el árbol DOM

			// Obtiene todos los nodos <empleado> del archivo XML
			NodeList empleadoNodes = doc.getElementsByTagName("empleado");
			for (int i = 0; i < empleadoNodes.getLength(); i++) {
				Element empElem = (Element) empleadoNodes.item(i); // Elemento <empleado>
				Empleado empleado = new Empleado();

				// Extrae el atributo y los elementos de <empleado>
				empleado.setId(empElem.getAttribute("id"));
				empleado.setNombreApellidos(empElem.getElementsByTagName("nombreApellidos").item(0).getTextContent());
				empleado.setEdad(Integer.parseInt(empElem.getElementsByTagName("edad").item(0).getTextContent()));
				empleado.setEmpresa(empElem.getElementsByTagName("empresa").item(0).getTextContent());

				// Obtiene todos los nodos <puesto> para el empleado
				NodeList puestoNodes = empElem.getElementsByTagName("puesto");
				for (int j = 0; j < puestoNodes.getLength(); j++) {
					Element puestoElem = (Element) puestoNodes.item(j); // Elemento <puesto>
					Puesto puesto = new Puesto();

					// Extrae el atributo y los elementos de <puesto>
					puesto.setId(puestoElem.getAttribute("id"));
					puesto.setNombrePuesto(puestoElem.getElementsByTagName("nombrePuesto").item(0).getTextContent());
					puesto.setDepartamento(puestoElem.getElementsByTagName("departamento").item(0).getTextContent());
					puesto.setSalario(
							Double.parseDouble(puestoElem.getElementsByTagName("salario").item(0).getTextContent()));

					empleado.addPuesto(puesto); // Agrega el puesto al empleado
				}

				empleados.add(empleado); // Agrega el empleado a la lista
			}
		} catch (Exception e) {
			e.printStackTrace(); // Manejo de posibles excepciones
		}

		return empleados; // Devuelve la lista de empleados
	}
}