package controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.ext.Attributes2;

import models.Jugador;
import models.Resultado;
import services.Service;

public class GestionaTorneo {

	private static final Logger logger = LogManager.getLogger(GestionaTorneo.class);

	public static void main(String[] args) {
		
		
		Service s1 = new Service();
		
		Jugador j1 = new Jugador("Mica Galera", "micagalera@gmail.com", 14);
		s1.createJugador(j1);
		
		s1.actualizarPuntuacionNarrador(1, Resultado.ALGUNOS);
	}

}
