package utiles;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import modelo.Categoria;
import modelo.Productos;
import repositorio.RepositorioProductos;

public class UtilidadesProductos {
	private static Logger logger = LogManager.getLogger(UtilidadesProductos.class);

	private static final String rutaResources = "src/main/resources/";
	private static final String nombreArchivo = "catalogo_productos.xml";
	private static final String rutaCompleta = rutaResources + nombreArchivo;

	// Instancia de RepositorioProductos donde se almacenarán los productos cargados
	// del XML
	private RepositorioProductos rp;

	// Constructor que recibe el repositorio donde se almacenarán los libros
	public UtilidadesProductos(RepositorioProductos repositorio) {
		this.rp = repositorio;
	}

	// Lee los productos de catalogo_productos.xml y los imprime por consola
	public void leerProductosXML() {
		try {
			// Cargar el archivo XML
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(rutaCompleta);
			doc.getDocumentElement().normalize();

			NodeList listaProductos = doc.getElementsByTagName("Producto");

			// Recorrer cada productos
			for (int i = 0; i < listaProductos.getLength(); i++) {
				Node producto = listaProductos.item(i);

				if (producto.getNodeType() == Node.ELEMENT_NODE) {
					Element elemento = (Element) producto;

					// Obtener Nombre, Precio, Cantidad y Categoria
					String nombre = elemento.getElementsByTagName("Nombre").item(0).getTextContent().trim();
					Double precio = Double
							.parseDouble(elemento.getElementsByTagName("Precio").item(0).getTextContent().trim());
					Integer cantidad = Integer
							.parseInt(elemento.getElementsByTagName("Cantidad").item(0).getTextContent().trim());
					Categoria categoriaProducto = Categoria
							.valueOf(elemento.getElementsByTagName("Categoria").item(0).getTextContent().trim());

					// Metodo del Repositorio que guarda los elementos que ya existen en el XML
					// en la Lista catalogoProductos del RepositorioProductos
					rp.agregarProducto(nombre, precio, cantidad, categoriaProducto);

					// Imprimir Nombre, Año y Director en la consola
					logger.debug("Nombre: " + nombre);
					logger.debug("precio: " + precio);
					logger.debug("cantidad: " + cantidad);
					logger.debug("Categoria: " + categoriaProducto);
					logger.debug("---------------------------");
				}
			}
		} catch (Exception e) {
			logger.debug(e.getMessage());
		}
	}

	// Crea multiples estudiantes
	public void escribeProductosJSON(String nombreJSON) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(rp.catalogoProductos());
		try (FileWriter writer = new FileWriter(rutaResources + nombreJSON)) {
			writer.write(json);
			logger.debug("JSON ha sido creado con exito");
		} catch (IOException e) {
			logger.error("Error al escribir lista de productos: ", e);
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
	public void escribeCatalogoProductos() {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.newDocument();

			Element raiz = doc.createElement("Catalogo");
			doc.appendChild(raiz);

			for (Productos producto : rp.catalogoProductos()) {
				Element elementoProducto = doc.createElement("Producto");

				Element nombre = doc.createElement("Nombre");
				nombre.appendChild(doc.createTextNode(producto.getNombre()));
				elementoProducto.appendChild(nombre);

				Element precio = doc.createElement("Precio");
				precio.appendChild(doc.createTextNode(String.valueOf(producto.getPrecio())));
				elementoProducto.appendChild(precio);

				Element cantidad = doc.createElement("Cantidad");
				cantidad.appendChild(doc.createTextNode(String.valueOf(producto.getCantidad())));
				elementoProducto.appendChild(cantidad);

				Element categoria = doc.createElement("Categoria");
				categoria.setTextContent(producto.getCategoriaProducto().toString());
				elementoProducto.appendChild(categoria);

				raiz.appendChild(elementoProducto);
			}

			guardarDocumentoEnFichero(doc, nombreArchivo);
			logger.debug("Catálogo guardado en el archivo XML.");
		} catch (Exception e) {
			logger.error("Error al escribir el archivo XML: " + e.getMessage());
		}
	}

	public void modificaProductoAModificarCantidad(String nombreProductoAModificarCantidad, Integer cantidadNueva) {
		try {
			// Cargar el archivo XML
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(rutaCompleta);
			doc.getDocumentElement().normalize();

			NodeList listaProductos = doc.getElementsByTagName("Producto");

			for (int i = 0; i < listaProductos.getLength(); i++) {
				Node prod = listaProductos.item(i);

				if (prod.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) prod;

					String nombre = element.getElementsByTagName("Nombre").item(0).getTextContent().trim();

					if (nombre.equals(nombreProductoAModificarCantidad)) {
						// Localiza el nodo Cantidad y actualiza su valor
						element.getElementsByTagName("Cantidad").item(0).setTextContent(cantidadNueva.toString());
					}
				}
			}
			// Guardar el archivo XML con los cambios
			guardarDocumentoEnFichero(doc, nombreArchivo);

		} catch (Exception e) {
			logger.error("Error al modificar la cantidad: " + e.getMessage());
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