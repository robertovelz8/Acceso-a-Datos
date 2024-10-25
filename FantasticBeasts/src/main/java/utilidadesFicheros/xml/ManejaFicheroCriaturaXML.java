package utilidadesFicheros.xml;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import models.Criatura;

public class ManejaFicheroCriaturaXML extends ManejaFicherosXML<Criatura>{
	private static final Logger logger = LogManager.getLogger(ManejaFicheroCriaturaXML.class);

	@Override
	protected void escribeModeloEnXML(String nombreFichero, Criatura e) {
		try {
			Document documento = this.construyoObjetoDocumento("criatura");
			// Recupero la raíz del documento
			Element raiz = documento.getDocumentElement();
			agregaModeloEnXML(documento, raiz, e);
			escribeDocumentoEnFichero(documento, nombreFichero);
		} catch (ParserConfigurationException e1) {
			logger.error(e1.getMessage());
		} catch (TransformerException e1) {
			logger.error(e1.getMessage());
		}		
	}



	@Override
	protected void agregaModeloEnXML(Document documento, Element padre, Criatura c) {
		// Para cada una de los atributos de persona, creo un elemento hijo
		Element nombre = this.creaElemento("nombre", c.getNombre(), padre, documento);
		Element inmortal = this.creaElemento("inmortal", Boolean.toString(c.isInmortal()), padre, documento);
		Element magia = this.creaElemento("magia", Integer.toString(c.getMagia()), padre, documento);
		Element peligrosidad = this.creaElemento("peligrosidad", Integer.toString(c.getPeligrosidad()), padre, documento);
		// El identificador lo vamos a crear como un atributo de la etiqueta empleado
		padre.setAttribute("tipo", c.getTipo().name());
		
	}

}
