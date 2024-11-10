/**
 * 
 */
package utilidades;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import modelo.Perro;

/**
 * 
 */
public class ManejaPerroDomXml extends ManejaAbstractaDomXml<Perro> {

	/**
	 * XML Lectura DOM Método que desde un Element devuelve un objeto Perro
	 * 
	 * @param elemento El elemento XML del cual se extraen los datos para crear el
	 *                 objeto Perro
	 * @return p Un objeto Perro con los datos obtenidos del elemento XML
	 */
	protected Perro getModeloFromElement(Element elemento) {
		// Instanciar un nuevo objeto Perro
		Perro p = new Perro();

		// Obtener y asignar el atributo "id"
		String id = elemento.getAttribute("id");
		p.setIdentificador(id);

		// Obtener y asignar los valores de los elementos hijos
		String nombre = elemento.getElementsByTagName("Nombre").item(0).getTextContent().trim();
		String sexo = elemento.getElementsByTagName("Sexo").item(0).getTextContent().trim();
		String raza = elemento.getElementsByTagName("Raza").item(0).getTextContent().trim();
		String color = elemento.getElementsByTagName("Color").item(0).getTextContent().trim();
		int edad = Integer.parseInt(elemento.getElementsByTagName("Edad").item(0).getTextContent().trim());
		int peso = Integer.parseInt(elemento.getElementsByTagName("Peso").item(0).getTextContent().trim());

		// Configurar los valores en el objeto Perro
		p.setNombre(nombre);
		p.setSexo(sexo);
		p.setRaza(raza);
		p.setColor(color);
		p.setEdad(edad);
		p.setPeso(peso);

		return p;
	}

	/**
	 * XML Escritura DOM Método que agrega al documento un perro
	 * 
	 * @param documento El documento XML al que se agregará el perro
	 * @param padre     El elemento padre en el que se insertará el elemento perro
	 * @param perro     El objeto Perro con los datos a agregar
	 */
	protected void agregaModeloADocumento(Document documento, Element padre, Perro perro) {
		// Agregar el atributo "id"

		padre.setAttribute("id", perro.getIdentificador());

		// Agregar los subelementos de Perro
		Element nombre = this.creaElemento("Nombre", perro.getNombre(), padre, documento);
		Element sexo = this.creaElemento("Sexo", perro.getSexo(), padre, documento);
		Element raza = this.creaElemento("Raza", perro.getRaza(), padre, documento);
		Element color = this.creaElemento("Color", perro.getColor(), padre, documento);
		Element edad = this.creaElemento("Edad", Integer.toString(perro.getEdad()), padre, documento);
		Element peso = this.creaElemento("Peso", Integer.toString(perro.getPeso()), padre, documento);
	}

	/**
	 * XML Escritura DOM Método que agrega al documento un perro
	 * 
	 * @param documento El documento XML al que se agregará el perro
	 * @param padre     El elemento padre en el que se insertará el elemento perro
	 * @param perro     El objeto Perro con los datos a agregar
	 */
	protected void agregaModeloADocumentoModificado(Document documento, Element padre, Perro perro) {
		// Agregar el atributo "id"

		padre.setAttribute("id", perro.getIdentificador());

		// Agregar los subelementos de Perro
		Element nombre = this.creaElemento("Nombre", perro.getNombre(), padre, documento);
		Element sexo = this.creaElemento("Sexo", perro.getSexo(), padre, documento);
		Element raza = this.creaElemento("Raza", perro.getRaza(), padre, documento);
		Element color = this.creaElemento("Color", perro.getColor(), padre, documento);
		Element edad = this.creaElemento("Edad", Integer.toString(perro.getEdad()), padre, documento);
		Element peso = this.creaElemento("Peso", Integer.toString(perro.getPeso()), padre, documento);
		Element vacunado = this.creaElemento("Vacunado", Boolean.toString(perro.isVacunado()), padre, documento);
	}
}
