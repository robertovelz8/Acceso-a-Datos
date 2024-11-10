package utiles;

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
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import modelo.Pedido;
import modelo.Plato;
import repositorio.RepositorioPedido;

public class UtilidadesPedido {

	// Logger para registrar mensajes de depuración y errores
	private static final Logger logger = LogManager.getLogger(UtilidadesPedido.class);

	// Constantes que definen la ruta del archivo XML
	private static final String rutaResources = "src/main/resources/";
	private static final String nombreFichero = "pedidos.xml";
	private static final String rutaCompleta = rutaResources + nombreFichero;

	// Instancia de RepositorioPedido donde se almacenarán los pedidos XML cargados
	private RepositorioPedido rp;

	// Constructor que recibe el repositorio donde se almacenarán los libros
	public UtilidadesPedido(RepositorioPedido repositorio) {
		this.rp = repositorio;
	}

	public void cargarPedidos() {
		try {
			// Crea el archivo en la ruta especificada
			File file = new File(rutaCompleta);
			List<Pedido> pedidos = new ArrayList<>();

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

			// Obtiene todos los nodos <Pedido> en el documento
			NodeList listaPedidos = doc.getElementsByTagName("Pedido");
			for (int i = 0; i < listaPedidos.getLength(); i++) {
				Node nodo = listaPedidos.item(i);
				if (nodo.getNodeType() == Node.ELEMENT_NODE) {
					Element elemento = (Element) nodo;
					String idPedido = elemento.getElementsByTagName("IDPedido").item(0).getTextContent().trim();
					String nombreCliente = elemento.getElementsByTagName("NombreCliente").item(0).getTextContent()
							.trim();

					List<Plato> platos = new ArrayList<>();

					// Obtiene todos los nodos <Plato> que se encuentran dentro de Pedido
					NodeList listaPlatos = elemento.getElementsByTagName("Plato");
					for (int j = 0; j < listaPlatos.getLength(); j++) {
						Element platoElem = (Element) listaPlatos.item(j);
						String nombrePlato = platoElem.getElementsByTagName("Nombre").item(0).getTextContent().trim();
						double precioPlato = Double
								.parseDouble(platoElem.getElementsByTagName("Precio").item(0).getTextContent().trim());
						platos.add(new Plato(nombrePlato, precioPlato));
					}
					double total = Double
							.parseDouble(elemento.getElementsByTagName("Total").item(0).getTextContent().trim());
					pedidos.add(new Pedido(idPedido, nombreCliente, platos, total));

					rp.agregarPedido(idPedido, nombreCliente, platos, total);
				}
			}
			// Mensaje para confirmar que los libros se cargaron correctamente
			logger.debug("Libros cargados desde el XML correctamente.");
		} catch (Exception e) {
			// Captura cualquier excepción y registra el mensaje de error
			logger.error("Error al cargar libros desde XML: " + e.getMessage());
		}
	}

	public void escribeCatalogoPedidos(String nombreArchivo) {
		try {
			// Configuración para crear un documento XML
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();

			// Crea el nodo raíz <Catalogo>
			Element elementoRaiz = doc.createElement("Pedidos");
			doc.appendChild(elementoRaiz);

			// Agrega cada libro del repositorio como un elemento <Libro>
			for (Pedido pedido : rp.catalogoPedido()) {
				Element elementoPedido = doc.createElement("Pedido");

				Element idPedido = doc.createElement("IDPedido");
				idPedido.appendChild(doc.createTextNode(pedido.getIdPedido()));
				elementoPedido.appendChild(idPedido);

				Element nombreCliente = doc.createElement("NombreCliente");
				nombreCliente.appendChild(doc.createTextNode(pedido.getNombreCliente()));
				elementoPedido.appendChild(nombreCliente);

				Element elementoSubRaiz = doc.createElement("Platos");
				elementoPedido.appendChild(elementoSubRaiz);

				for (Plato platos : pedido.getPlatos()) {
					Element plato = doc.createElement("Plato");
					elementoSubRaiz.appendChild(plato);

					Element nombre = doc.createElement("Nombre");
					nombre.appendChild(doc.createTextNode(platos.getNombre().toString()));
					plato.appendChild(nombre);

					Element precio = doc.createElement("Precio");
					precio.appendChild(doc.createTextNode(String.valueOf(platos.getPrecio())));
					plato.appendChild(precio);

				}
				Element total = doc.createElement("Total");
				total.appendChild(doc.createTextNode(String.valueOf(pedido.getTotal())));
				elementoPedido.appendChild(total);

				elementoRaiz.appendChild(elementoPedido);
			}

			// Guarda el documento en el archivo XML especificado
			guardarDocumentoEnFichero(doc, nombreArchivo);
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
	private void guardarDocumentoEnFichero(Document documento, String nombreArchivo) throws TransformerException {
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		DOMSource source = new DOMSource(documento);
		StreamResult resultado = new StreamResult(new File(rutaResources + nombreArchivo));
		transformer.transform(source, resultado);
	}
}
