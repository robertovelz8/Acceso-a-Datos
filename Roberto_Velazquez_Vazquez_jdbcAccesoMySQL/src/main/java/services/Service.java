package services;

import exceptions.MiExcepcion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import models.Jugador;
import models.Partida;
import models.Resultado;
import repositories.JugadorRepository;
import repositories.PartidaRepository;

@Data
public class Service {
	
	private JugadorRepository jugadorRepo;
	private PartidaRepository partidaRepo;
	
	public Service () {
		this.jugadorRepo = new JugadorRepository();
		this.partidaRepo = new PartidaRepository();
	}
	
	public void createJugador(Jugador jugador) {
		try {
			jugadorRepo.createJugador(jugador);
		} catch (MiExcepcion e) {
			e.printStackTrace();
		}
	}
	
	public void createPartida (Partida partida) {
		try {
			partidaRepo.createPartida(partida);
		} catch (MiExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void actualizarPuntuacionNarrador(int id, Resultado res) {
		try {
			jugadorRepo.actualizarPuntuacionNarrador(id, res);
		} catch (MiExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
