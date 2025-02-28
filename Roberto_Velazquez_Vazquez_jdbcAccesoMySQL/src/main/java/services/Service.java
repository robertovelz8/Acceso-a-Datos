package services;

import exceptions.MiExcepcion;
import models.Jugador;
import models.Partida;
import models.Resultado;
import repositories.JugadorRepository;
import repositories.PartidaRepository;

import java.sql.SQLException;

public class Service {

    private final JugadorRepository jugadorRepo;
    private final PartidaRepository partidaRepo;

    // Constructor que recibe las dependencias (repositorios)
    public Service(JugadorRepository jugadorRepository, PartidaRepository partidaRepository) {
        this.jugadorRepo = jugadorRepository;
        this.partidaRepo = partidaRepository;
    }

    // Servicio para crear un jugador
    public int createJugador(Jugador jugador) throws MiExcepcion {
        return jugadorRepo.createJugador(jugador);
    }

    // Servicio para crear una partida
    public void crearPartida(Partida partida) throws MiExcepcion {
        if (partidaRepo.contarPartidas() >= 5) {
            throw new MiExcepcion("No se pueden agregar más de 5 partidas");
        }
        partidaRepo.crearPartida(partida);
    }

    // Servicio para actualizar la puntuación del narrador
    public void actualizarPuntuacionNarrador(int id, Resultado res) throws MiExcepcion {
        jugadorRepo.actualizarPuntuacionNarrador(id, res);
    }

    // Servicio para actualizar la puntuación del no acertante
    public void actualizarPuntuacionNOAcertante(int jugadorId, Resultado resultado) throws MiExcepcion {
        try {
			jugadorRepo.actualizarPuntuacionNOAcertante(jugadorId, resultado);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    // Servicio para actualizar la puntuación del acertante
    public void actualizarPuntuacionAcertante(int jugadorId, Resultado resultado) throws MiExcepcion {
        jugadorRepo.actualizarPuntuacionAcertante(jugadorId, resultado);
    }

    // Servicio para obtener al jugador con mayor puntuación
    public Jugador obtenerJugadorConMayorPuntuacion() throws MiExcepcion {
        return jugadorRepo.obtenerJugadorConMayorPuntuacion();
    }

    // Servicio para mostrar los jugadores ordenados por puntos
    public void mostrarJugadoresOrdenadosPorPuntos() throws MiExcepcion {
        jugadorRepo.mostrarJugadoresOrdenadosPorPuntos();
    }

    // Servicio para listar las partidas ordenadas por fecha
    public void listarPartidasOrdenadasPorFecha() throws MiExcepcion {
        partidaRepo.listarPartidasOrdenadasPorFecha();
    }
}