package utilidadesFicheros.xml;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import models.Empleado;
import models.PuestoTrabajo;

public class ManejaFicheroEmpleadoXML extends ManejaFicherosXML <Empleado>{
	
	private static final Logger logger = LogManager.getLogger(ManejaFicheroEmpleadoXML.class);


	@Override
	protected void escribeModeloEnXML(String nombreFichero, Empleado e) {
		try {
			Document documento = this.construyoObjetoDocumento("empleado");
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
	protected void agregaModeloEnXML(Document documento, Element padre, Empleado e) {
		// Para cada una de los atributos de persona, creo un elemento hijo
		Element nombre = this.creaElemento("nombreApellido", e.getNombreApellido(), padre, documento);
		Element edad = this.creaElemento("edad", Integer.toString(e.getEdad()), padre, documento);
		Element empresa = this.creaElemento("empresa", e.getEmpresa(), padre, documento);
		agregaModeloEnXML(documento, padre, e.getPuesto());
		// El identificador lo vamos a crear como un atributo de la etiqueta empleado
		padre.setAttribute("identificador", e.getIdentificador());
		
	}
	
	protected void agregaModeloEnXML (Document documento, Element padre, PuestoTrabajo p) {
		if(p != null) {
			Element puestoElemento = documento.createElement("puesto");
			padre.appendChild(puestoElemento);
			Element identificador = this.creaElemento("identificador", p.getIdentificador(), puestoElemento, documento);
			Element nombrePuesto = this.creaElemento("nombrePuesto", p.getNombrePuesto(), puestoElemento, documento);
			Element departamento = this.creaElemento("departamento", p.getDepartamento(), puestoElemento, documento);
			Element salario = this.creaElemento("salario", Double.toString(p.getSalario()), puestoElemento, documento);
		}
	}


}
