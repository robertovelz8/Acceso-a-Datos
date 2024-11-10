package controladores;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modelos.Equipo;
import modelos.Piloto;
import repositorios.RepositorioEquipos;
import servicios.ServicioEquipos;
import utilities.ManejaFicheroJson;
import utilities.ManejaFicheroXMLEquipos;

public class GestionaClasificacion {
	private static final Logger logger = LogManager.getLogger(GestionaClasificacion.class);

	private static final String rutaresources = "src/main/resources/";

	public static void main(String[] args) {
		ManejaFicheroXMLEquipos manejo = new ManejaFicheroXMLEquipos();
		ManejaFicheroJson manejoJson = new ManejaFicheroJson();
		ServicioEquipos servicio = new ServicioEquipos();
		String origenXML = rutaresources + "formula1.xml";
		String destinoJson = rutaresources + "pilotos.json";
		String destinoXML = rutaresources + "formula1Escrito.xml";
		String destinoXMLPodium = rutaresources + "formula1Podium.xml";
		String destinoXMLPeores = rutaresources + "formula1Peores.xml";

		RepositorioEquipos repEquipos = new RepositorioEquipos();
		List<Equipo> equiposLeidos = manejo.getEquiposFromXML(origenXML);
		/*
		 * for(Equipo e: equiposLeidos) { repEquipos.addEquipo(e); }
		 */
		List<Piloto> pilotosLeidos = manejo.getPilotosFromXML(origenXML);
		servicio.asignarPilotosaEquipos(equiposLeidos, pilotosLeidos);
		for (Equipo e : servicio.asignarPilotosaEquipos(equiposLeidos, pilotosLeidos)) {
			repEquipos.addEquipo(e);
		}
		repEquipos.pilotosConMayorPuntuacionQue(4);
		List<Piloto> listaPrueba = repEquipos.pilotosConMayorPuntuacionQue(4);
		manejoJson.escribePilotos(listaPrueba, destinoJson);
		manejo.escribeModeloEnXML(destinoXML, equiposLeidos);
		// Aquí se generan los XML con las listas de equipos ordenadas y seleccionadas
		manejo.escribeModeloEnXML(destinoXMLPodium, servicio.podiumMejoresEquipos(equiposLeidos));
		manejo.escribeModeloEnXML(destinoXMLPeores, servicio.podiumPeoresEquipos(equiposLeidos));

	}
}