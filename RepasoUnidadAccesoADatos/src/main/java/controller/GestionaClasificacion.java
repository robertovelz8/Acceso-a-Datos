package controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import models.Piloto;
import services.ServicioEquipo;
import services.ServicioPiloto;

public class GestionaClasificacion {

	private static final Logger logger = LogManager.getLogger(GestionaClasificacion.class);

	public static void main(String[] args) {
		
		ServicioPiloto sp = new ServicioPiloto();
		sp.crearPiloto("123456A", "Latifi", "FRA", 123, 823193);
		
		logger.debug(sp.consultarPilotos());
		logger.debug(sp.consultarPiloto("123456A"));
		
		ServicioEquipo se = new ServicioEquipo();
		se.crearEquipo("Red Bull", "342", 199012, sp.consultarPilotos());
		
		logger.debug(se.consultarEquipos());
		logger.debug(se.consultarEquipo(199012));
		
		sp.crearPiloto("123456B", "Michael Schumacher", "ALE", 212, 433245);

		se.addPilotoAEquipo(199012, sp.consultarPiloto("123456B"));
		logger.debug(se.consultarEquipo(199012));
		
		logger.debug(se.consultarPilotosPuntuacion(4));
		
		
		
	}

}
