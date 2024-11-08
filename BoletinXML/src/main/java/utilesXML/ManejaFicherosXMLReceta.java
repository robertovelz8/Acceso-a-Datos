package utilesXML;

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

public class ManejaFicherosXMLReceta {
	
	private static final String rutaResources = "src/main/resources/";
	private static final Logger logger = LogManager.getLogger(ManejaFicherosXMLReceta.class);
	public void creaRecetaXML (String titulo, String[] ingredientes, String[] cantidad, String procedimiento, String tiempo) {
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document documento = dBuilder.newDocument();
			
			//Crear elemento raiz Receta
			Element raiz = documento.createElement("Receta");
			documento.appendChild(raiz);
			
			//Crear elemento titulo
			Element elementoTitulo = documento.createElement("titulo");
			elementoTitulo.appendChild(documento.createTextNode(titulo));
			raiz.appendChild(elementoTitulo);
			
			//Crear elemento ingredientes
			Element elementoIngredientes = documento.createElement("ingredientes");
			for (int i = 0; i < ingredientes.length; i++) {
				Element elementoIngrediente = documento.createElement("ingrediente");
				elementoIngrediente.appendChild(documento.createTextNode(ingredientes[i]));
				elementoIngrediente.setAttribute("cantidad", cantidad[i]);
				elementoIngredientes.appendChild(elementoIngrediente);
			}
			raiz.appendChild(elementoIngredientes);
			
			//Crear procedimientos
			Element elementoProcedimiento = documento.createElement("procedimiento");
			elementoProcedimiento.appendChild(documento.createTextNode(procedimiento));
			raiz.appendChild(elementoProcedimiento);
			
			//Crear elemento tiempo
			Element elementoTiempo = documento.createElement("tiempo");
			elementoTiempo.appendChild(documento.createTextNode(tiempo));
			raiz.appendChild(elementoTiempo);
			escribeDocumentoEnFichero(documento);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void escribeDocumentoEnFichero(Document documento) throws TransformerException {
		// clases necesarias finalizar la creación del archivo XML
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer;
		transformer = transformerFactory.newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		DOMSource source = new DOMSource(documento);
		StreamResult resultado = new StreamResult(new File(rutaResources+"nuevaReceta.xml"));
		transformer.transform(source, resultado);
	}
}
