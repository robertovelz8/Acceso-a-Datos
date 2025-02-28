package controller;

import java.time.LocalDate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import exceptions.MiExcepcion;
import models.Jugador;
import models.Partida;
import models.Resultado;
import repositories.JugadorRepository;
import repositories.PartidaRepository;
import services.Service;
import utiles.MySqlConector;

public class GestionaTorneo {

	private static final Logger logger = LogManager.getLogger(GestionaTorneo.class);

	public static void main(String[] args) {

		try {
			MySqlConector conector = new MySqlConector();
			JugadorRepository repositorioJugadores = new JugadorRepository(conector);
			PartidaRepository repositorioPartida = new PartidaRepository(conector);
			Service s1 = new Service(repositorioJugadores, repositorioPartida);

			// Crear jugadores
			
			 int idJugador1 = s1.createJugador(new Jugador("Mica Galera", "micagalera@gmail.com", 0));
			 int idJugador2 = s1.createJugador(new Jugador("Juan Perez", "juanperez@gmail.com", 0));
			 int idJugador3 = s1.createJugador(new Jugador("Ana Lopez", "analopez@gmail.com", 0));
			 int idJugador4 = s1.createJugador(new Jugador("Carlos Ruiz", "carlosruiz@gmail.com", 0));
			 
			 
			Jugador j1 = new Jugador(idJugador1, "Mica Galera", "micagalera@gmail.com", 0);
			Jugador j2 = new Jugador(idJugador2, "Juan Perez", "juanperez@gmail.com", 0);
			Jugador j3 = new Jugador(idJugador3, "Ana Lopez", "analopez@gmail.com", 0);
			Jugador j4 = new Jugador(idJugador4, "Carlos Ruiz", "carlosruiz@gmail.com", 0);
			
			
			// Crear varias partidas
			Partida p1 = new Partida(0, j1, LocalDate.now(), Resultado.ALGUNOS);
			Partida p2 = new Partida(0, j2, LocalDate.now().minusDays(1), Resultado.TODOS);
			Partida p3 = new Partida(0, j3, LocalDate.now().minusDays(2), Resultado.NADIE);
			Partida p4 = new Partida(0, j4, LocalDate.now().minusDays(3), Resultado.ALGUNOS);
			Partida p5 = new Partida(0, j2, LocalDate.now().minusDays(4), Resultado.TODOS);


			// Crear partidas
			try {
				s1.crearPartida(p1);
				s1.crearPartida(p2);
				s1.crearPartida(p3);
				s1.crearPartida(p4);
				s1.crearPartida(p5);
			} catch (MiExcepcion e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
	        // Actualizar puntuación del narrador
	        s1.actualizarPuntuacionNarrador(idJugador1, Resultado.ALGUNOS);

			
	        // Actualizar puntuación del no acertante
	        s1.actualizarPuntuacionNOAcertante(idJugador3, Resultado.NADIE);
			
	        // Actualizar puntuación del acertante
	        s1.actualizarPuntuacionAcertante(idJugador4, Resultado.ALGUNOS);
			
	        // Mostrar jugadores ordenados por puntos
	        s1.mostrarJugadoresOrdenadosPorPuntos();
	        
	        //Obtener al jugador con mayor número de puntos
	        s1.obtenerJugadorConMayorPuntuacion();
			
			
	        // Listar las partidas ordenadas por fecha
	        s1.listarPartidasOrdenadasPorFecha();

		} catch (MiExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
