package utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import modelos.Equipo;
import modelos.Piloto;

public class ManejaFicheroXMLEquipos extends ManejaDOMXml<Equipo> {

	public void escribeModeloEnXML(String nombreFichero, List<Equipo> equipillos) {
		try {
			Document documento = this.construyoObjetoDocumento("equipos");
			for (Equipo e : equipillos) {
				Element elemento = this.creaElemento("equipo", null, documento.getDocumentElement(), documento);
				elemento.setAttribute("identificadorEquipo", String.valueOf(e.getIdentificador()));
				agregaModeloADocumento(documento, elemento, e);
			}
			escribeDocumentoEnFichero(documento, nombreFichero);
		} catch (ParserConfigurationException e1) {
			System.out.println(e1.getMessage());
		} catch (TransformerException e1) {
			System.out.println(e1.getMessage());
		}
	}

	protected void agregaModeloADocumento(Document documento, Element padre, Equipo e) {
		Element nombreEquipo = this.creaElemento("nombreEquipo", e.getNombreEquipo(), padre, documento);
		Element puntos = this.creaElemento("puntos", String.valueOf(e.getPuntos()), padre, documento);
		List<Piloto> pilotillos = new ArrayList<Piloto>();
		for (Entry<Integer, Piloto> entrada : e.getPilotos().entrySet()) {
			pilotillos.add(entrada.getValue());
		}
		if (pilotillos != null) {
			Element pilotosChildren = documento.createElement("pilotos");
			padre.appendChild(pilotosChildren);
			for (Piloto pil : pilotillos) {
				Element pilotoElement = this.creaElemento("piloto", null, padre, documento);
				pilotoElement.setAttribute("identificadorPiloto", String.valueOf(pil.getIdentificadorPiloto()));
				Element nombrePiloto = this.creaElemento("nombrePiloto", pil.getNombrePiloto(), pilotoElement,
						documento);
				Element puntosPiloto = this.creaElemento("puntos", String.valueOf(pil.getPuntos()), pilotoElement,
						documento);
				Element idEquipo = this.creaElemento("identificadorEquipo",
						String.valueOf(pil.getIdentificadorEquipo()), pilotoElement, documento);
				Element pais = this.creaElemento("pais", pil.getPais(), pilotoElement, documento);

				pilotosChildren.appendChild(pilotoElement);
			}

		}
	}

	private Equipo getEquipoFromElement(Element elemento) {
		Equipo e = new Equipo();
		String nombre = elemento.getElementsByTagName("nombreEquipo").item(0).getTextContent();
		int puntos = Integer.parseInt(elemento.getElementsByTagName("puntos").item(0).getTextContent());
		// String tiempo =
		// elemento.getElementsByTagName("tiempo").item(0).getTextContent();
		int id = Integer.parseInt(elemento.getAttribute("identificadorEquipo")); // La etiqueta empleado tiene el
																					// atributo identificador
		e.setNombreEquipo(nombre);
		e.setPuntos(puntos);
		e.setIdentificador(id);

		return e;
	}

	public List<Equipo> getEquiposFromXML(String nombreFichero) {
		List<Equipo> equipos = new ArrayList<>();
		Document documento = getDocumentFromXML(nombreFichero);
		NodeList nodoRaiz = documento.getElementsByTagName("equipos");
		Node raiz = nodoRaiz.item(0);
		if (raiz.getNodeType() == Node.ELEMENT_NODE) {
			Element elemento = (Element) raiz;
			if (elemento.hasChildNodes()) {
				NodeList nodosHijos = elemento.getChildNodes();
				for (int j = 0; j < nodosHijos.getLength(); j++) {
					Node productoNodo = nodosHijos.item(j);
					if (productoNodo.getNodeType() == Node.ELEMENT_NODE) {
						Equipo e = this.getEquipoFromElement((Element) productoNodo);
						equipos.add(e);
					}
				}
			}
		}
		return equipos;
	}

	public List<Piloto> getPilotosFromXML(String nombreFichero) {
		List<Piloto> pilotos = new ArrayList<>();
		Document documento = getDocumentFromXML(nombreFichero);
		NodeList nodoRaiz = documento.getElementsByTagName("pilotos");
		Node raiz = nodoRaiz.item(0);
		if (raiz.getNodeType() == Node.ELEMENT_NODE) {
			Element elemento = (Element) raiz;
			if (elemento.hasChildNodes()) {
				NodeList nodosHijos = elemento.getChildNodes();
				for (int j = 0; j < nodosHijos.getLength(); j++) {
					Node productoNodo = nodosHijos.item(j);
					if (productoNodo.getNodeType() == Node.ELEMENT_NODE) {
						Piloto e = this.getPilotoFromElement((Element) productoNodo);
						pilotos.add(e);
					}
				}
			}
		}
		return pilotos;
	}

	private Piloto getPilotoFromElement(Element elemento) {
		Piloto e = new Piloto();
		String nombre = elemento.getElementsByTagName("nombrePiloto").item(0).getTextContent();
		int idEquipo = Integer.parseInt(elemento.getElementsByTagName("identificadorEquipo").item(0).getTextContent());
		int puntos = Integer.parseInt(elemento.getElementsByTagName("puntos").item(0).getTextContent());
		// String tiempo =
		// elemento.getElementsByTagName("tiempo").item(0).getTextContent();
		int id = Integer.parseInt(elemento.getAttribute("identificadorPiloto")); // La etiqueta empleado tiene el
																					// atributo identificador
		String pais = elemento.getElementsByTagName("pais").item(0).getTextContent();
		e.setNombrePiloto(nombre);
		e.setIdentificadorEquipo(idEquipo);
		e.setPuntos(puntos);
		e.setIdentificadorPiloto(id);
		e.setPais(pais);

		return e;
	}

	@Override
	protected void escribeModeloEnXML(String nombreFichero, Equipo elementoIntroducido) {
		// TODO Auto-generated method stub

	}
}
