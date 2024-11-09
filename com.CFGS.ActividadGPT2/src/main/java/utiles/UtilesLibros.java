package utiles;

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
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import modelo.Genero;
import modelo.Libro;
import repositorio.RepositorioLibro;

public class UtilesLibros {

	// Logger para registrar mensajes de depuración y errores
	private static final Logger logger = LogManager.getLogger(UtilesLibros.class);

	// Constantes que definen la ruta del archivo XML
	private static final String rutaResources = "src/main/resources/";
	private static final String nombreFichero = "catalogoLibrosXML.xml";
	private static final String rutaCompleta = rutaResources + nombreFichero;

	// Instancia de RepositorioLibro donde se almacenarán los libros cargados del
	// XML
	private RepositorioLibro rp;

	// Constructor que recibe el repositorio donde se almacenarán los libros
	public UtilesLibros(RepositorioLibro repositorio) {
		this.rp = repositorio;
	}

	/**
	 * Método cargarLibros "getDoumentFromXML"
	 * 
	 * Este método lee el archivo XML especificado en 'rutaCompleta' y carga todos
	 * los elementos <Libro> en el repositorio de libros 'rp'.
	 * 
	 * @throws Exception Si ocurre un error al parsear o leer el archivo XML.
	 */
	public void cargarLibros() {
		try {
			// Crea el archivo en la ruta especificada
			File file = new File(rutaCompleta);

			// Si el archivo no existe, no realiza ninguna acción
			if (!file.exists()) {
				logger.debug("Archivo XML no encontrado.");
				return;
			}

			// Crea un objeto DocumentBuilder para procesar el XML
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

			// Lee el archivo y lo convierte en un objeto Document
			Document doc = dBuilder.parse(file);

			// Normaliza el contenido XML (elimina espacios en blanco innecesarios)
			doc.getDocumentElement().normalize();

			// Obtiene todos los nodos <Libro> en el documento
			NodeList listaLibros = doc.getElementsByTagName("Libro");

			// Itera sobre cada elemento <Libro> encontrado en el XML
			for (int i = 0; i < listaLibros.getLength(); i++) {
				Node node = listaLibros.item(i);

				// Verifica si el nodo es de tipo Element
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;

					// Extrae y asigna valores de título, autor, ISBN y género
					String titulo = element.getElementsByTagName("Titulo").item(0).getTextContent().trim();
					String autor = element.getElementsByTagName("Autor").item(0).getTextContent().trim();
					int isbn = Integer.parseInt(element.getElementsByTagName("ISBN").item(0).getTextContent().trim());
					Genero genero = Genero.valueOf(
							element.getElementsByTagName("Genero").item(0).getTextContent().trim().toUpperCase());

					// Añade el libro al repositorio usando los datos extraídos
					rp.agregarLibro(titulo, autor, isbn, genero);
				}
			}
			// Mensaje para confirmar que los libros se cargaron correctamente
			logger.debug("Libros cargados desde el XML correctamente.");
		} catch (Exception e) {
			// Captura cualquier excepción y registra el mensaje de error
			logger.error("Error al cargar libros desde XML: " + e.getMessage());
		}
	}

	/**
	 * Método escribeCatalogoLibros
	 * 
	 * Este método guarda el catálogo actual de libros en el archivo XML
	 * especificado en 'rutaCompleta'.
	 * 
	 * @throws ParserConfigurationException Si ocurre un error al configurar el
	 *                                      parser XML.
	 * @throws TransformerException         Si ocurre un error al transformar el
	 *                                      XML.
	 */
	public void escribeCatalogoLibros() {
		try {
			// Configuración para crear un documento XML
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();

			// Crea el nodo raíz <Catalogo>
			Element elementoRaiz = doc.createElement("CatalogoLibros");
			doc.appendChild(elementoRaiz);

			// Agrega cada libro del repositorio como un elemento <Libro>
			for (Libro libro : rp.getCatalogoLibros()) {
				Element elementoLibro = doc.createElement("Libro");

				Element titulo = doc.createElement("Titulo");
				titulo.appendChild(doc.createTextNode(libro.getTitulo()));
				elementoLibro.appendChild(titulo);

				Element autor = doc.createElement("Autores");
				autor.appendChild(doc.createTextNode(libro.getAutor()));
				elementoLibro.appendChild(autor);

				Element isbn = doc.createElement("ISBN");
				isbn.appendChild(doc.createTextNode(String.valueOf(libro.getISBN())));
				elementoLibro.appendChild(isbn);

				Element genero = doc.createElement("Genero");
				genero.appendChild(doc.createTextNode(libro.getGeneroLibro().toString()));
				elementoLibro.appendChild(genero);

				elementoRaiz.appendChild(elementoLibro);
			}

			// Guarda el documento en el archivo XML especificado
			guardarDocumentoEnFichero(doc, nombreFichero);
			logger.debug("Catálogo guardado en el archivo XML.");
		} catch (ParserConfigurationException | TransformerException e) {
			// Captura cualquier excepción y registra el mensaje de error
			logger.error("Error al escribir en el archivo XML: " + e.getMessage());
		}
	}

	/**
	 * Método auxiliar guardarDocumentoEnFichero
	 * 
	 * Este método guarda el contenido del documento XML en un archivo especificado.
	 * 
	 * @param documento El documento XML que se desea guardar
	 * @throws TransformerException Si ocurre un error al transformar el XML.
	 */
	private void guardarDocumentoEnFichero(Document documento, String nombreFichero) throws TransformerException {
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		DOMSource source = new DOMSource(documento);
		StreamResult resultado = new StreamResult(new File(rutaResources + nombreFichero));
		transformer.transform(source, resultado);
	}
}