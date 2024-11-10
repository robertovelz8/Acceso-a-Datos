package utilidades;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import modelos.Droguita;
import modelos.Yonki;



public class ManejaFicheroXMLDroguitas extends ManejaDOMXml<Droguita> {
	


	public void escribeModeloEnXML(String nombreFichero, List<Droguita> droguitas) {
		try {
			Document documento = this.construyoObjetoDocumento("droguitas");
			for(Droguita e : droguitas)
			{
				Element elemento = this.creaElemento("droguita", null, documento.getDocumentElement(), documento);
				elemento.setAttribute("tipo", String.valueOf(e.getTipo()).toLowerCase());
				agregaModeloADocumento(documento, elemento, e);
			}
			escribeDocumentoEnFichero(documento, nombreFichero);
		} catch (ParserConfigurationException e1) {
			System.out.println(e1.getMessage());
		} catch (TransformerException e1) {
			System.out.println(e1.getMessage());
		}	
	}
	public void escribeYonkisEnXML(String nombreFichero, List<Yonki> yonketas) {
		try {
			Document documento = this.construyoObjetoDocumento("droguitas");
			for(Yonki e : yonketas)
			{
				Element elemento = this.creaElemento("yonki", null, documento.getDocumentElement(), documento);
				elemento.setAttribute("detenciones", String.valueOf(e.getDetenciones()));
				agregaModeloADocumento(documento, elemento, e);
			}
			escribeDocumentoEnFichero(documento, nombreFichero);
		} catch (ParserConfigurationException e1) {
			System.out.println(e1.getMessage());
		} catch (TransformerException e1) {
			System.out.println(e1.getMessage());
		}	
	}
	protected void agregaModeloADocumento(Document documento, Element padre, Droguita e) {
		Element nombre = this.creaElemento("nombre", e.getNombre(), padre, documento);
		Element dosis = this.creaElemento("dosis", String.valueOf(e.getDosis()), padre, documento);
		Element paisDeProcedencia = this.creaElemento("paisDeProcedencia", e.getPaisDeProcedencia(), padre, documento);
		Element mortal = this.creaElemento("mortal", String.valueOf(e.isMortal()), padre, documento);

		List<Yonki> enganchaos = new ArrayList<Yonki>();
		for( Yonki entrada : e.getEnganchaos()) {
			enganchaos.add(entrada);
		}
		if(enganchaos!=null) {
			Element enganchaosChildren = documento.createElement("enganchaos");
			padre.appendChild(enganchaosChildren);
			for(Yonki yonk:enganchaos) {
				Element yonkiElement = this.creaElemento("yonki", null, padre, documento);
				yonkiElement.setAttribute("detenciones", String.valueOf(yonk.getDetenciones()));
				Element nombreyonki = this.creaElemento("nombre", yonk.getNombre(), yonkiElement, documento);
				Element edad = this.creaElemento("edad", String.valueOf(yonk.getEdad()), yonkiElement, documento);
				Element ciudadDeProcedencia = this.creaElemento("ciudadDeProcedencia", String.valueOf(yonk.getCiudadDeProcedencia()), yonkiElement, documento);
				Element adiccion = this.creaElemento("adiccion", yonk.getAdiccion(), yonkiElement, documento);
				Element proyectoHombre = this.creaElemento("proyectoHombre", String.valueOf(yonk.isProyectoHombre()), yonkiElement, documento);
				Element dineroInvertido = this.creaElemento("dineroInvertido", String.valueOf(yonk.getDineroInvertido()), yonkiElement, documento);
				Element genero = this.creaElemento("genero", String.valueOf(yonk.getGenero()).toLowerCase(), yonkiElement, documento);

				enganchaosChildren.appendChild(yonkiElement);
			}

		}
	}
	protected void agregaModeloADocumento(Document documento, Element yonkiElement, Yonki e) {
		yonkiElement.setAttribute("detenciones", String.valueOf(e.getDetenciones()));
		Element nombreyonki = this.creaElemento("nombre", e.getNombre(), yonkiElement, documento);
		Element edad = this.creaElemento("edad", String.valueOf(e.getEdad()), yonkiElement, documento);
		Element ciudadDeProcedencia = this.creaElemento("ciudadDeProcedencia", String.valueOf(e.getCiudadDeProcedencia()), yonkiElement, documento);
		Element adiccion = this.creaElemento("adiccion", e.getAdiccion(), yonkiElement, documento);
		Element proyectoHombre = this.creaElemento("proyectoHombre", String.valueOf(e.isProyectoHombre()), yonkiElement, documento);
		Element dineroInvertido = this.creaElemento("dineroInvertido", String.valueOf(e.getDineroInvertido()), yonkiElement, documento);
		Element genero = this.creaElemento("genero", String.valueOf(e.getGenero()).toLowerCase(), yonkiElement, documento);
	}
	private  Droguita getDroguitaFromElement(Element elemento)
	{
		Droguita e = new Droguita();
			String nombre = elemento.getElementsByTagName("nombre").item(0).getTextContent();
			Droguita.TipoDroguita tipo = Droguita.TipoDroguita.valueOf((elemento.getAttribute("tipo")).toUpperCase());
			double dosis = Double.parseDouble(elemento.getElementsByTagName("dosis").item(0).getTextContent());
			String paisDeProcedencia = elemento.getElementsByTagName("paisDeProcedencia").item(0).getTextContent();
			boolean mortal = Boolean.parseBoolean(elemento.getAttribute("mortal")); // La etiqueta empleado tiene el atributo identificador
			e.setTipo(tipo);
			e.setNombre(nombre);
			e.setDosis(dosis);
			e.setPaisDeProcedencia(paisDeProcedencia);
			e.setMortal(mortal);

			return e;
		}
	public List<Droguita> getDroguitasFromXML(String nombreFichero){
		List<Droguita> equipos = new ArrayList<>();
			Document documento = getDocumentFromXML(nombreFichero);
			NodeList nodoRaiz = documento.getElementsByTagName("droguitas");
			Node raiz = nodoRaiz.item(0);
			if(raiz.getNodeType()==Node.ELEMENT_NODE) {
				Element elemento = (Element) raiz;
				if(elemento.hasChildNodes()) {
					NodeList nodosHijos = elemento.getChildNodes();
					for(int j =0;j<nodosHijos.getLength();j++) {
						Node productoNodo = nodosHijos.item(j);
						if(productoNodo.getNodeType()==Node.ELEMENT_NODE) {
							Droguita e = this.getDroguitaFromElement((Element) productoNodo);
								equipos.add(e);
					}
				}
			}
		}
		return equipos;
	}
	public List<Yonki> getYonkisFromXML(String nombreFichero){
		List<Yonki> yonkisitos = new ArrayList<>();
			Document documento = getDocumentFromXML(nombreFichero);
			NodeList nodoRaiz = documento.getElementsByTagName("yonkis");
			Node raiz = nodoRaiz.item(0);
			if(raiz.getNodeType()==Node.ELEMENT_NODE) {
				Element elemento = (Element) raiz;
				if(elemento.hasChildNodes()) {
					NodeList nodosHijos = elemento.getChildNodes();
					for(int j =0;j<nodosHijos.getLength();j++) {
						Node productoNodo = nodosHijos.item(j);
						if(productoNodo.getNodeType()==Node.ELEMENT_NODE) {
							Yonki e = this.getPilotoFromElement((Element) productoNodo);
								yonkisitos.add(e);
					}
				}
			}
		}
		return yonkisitos;
	}
	private  Yonki getPilotoFromElement(Element elemento)
	{
			Yonki e = new Yonki();
			String nombre = elemento.getElementsByTagName("nombre").item(0).getTextContent();
			int edad = Integer.parseInt(elemento.getElementsByTagName("edad").item(0).getTextContent());
			String ciudadDeProcedencia = (elemento.getElementsByTagName("ciudadDeProcedencia").item(0).getTextContent());
			String adiccion = elemento.getElementsByTagName("adiccion").item(0).getTextContent();
			int detenciones = Integer.parseInt(elemento.getAttribute("detenciones")); // La etiqueta empleado tiene el atributo identificador
			boolean proyectoHombre = Boolean.parseBoolean(elemento.getElementsByTagName("proyectoHombre").item(0).getTextContent());
			double dineroInvertido = Double.parseDouble(elemento.getElementsByTagName("dineroInvertido").item(0).getTextContent());
			Yonki.Genero genero = Yonki.Genero.valueOf((elemento.getElementsByTagName("genero").item(0).getTextContent()).toUpperCase());
			e.setNombre(nombre);
			e.setEdad(edad);
			e.setCiudadDeProcedencia(ciudadDeProcedencia);
			e.setAdiccion(adiccion);
			e.setDetenciones(detenciones);
			e.setProyectoHombre(proyectoHombre);
			e.setDineroInvertido(dineroInvertido);
			e.setGenero(genero);
			return e;
		}
	@Override
	protected void escribeModeloEnXML(String nombreFichero, Droguita elementoIntroducido) {
		// TODO Auto-generated method stub
		
	}
	}
