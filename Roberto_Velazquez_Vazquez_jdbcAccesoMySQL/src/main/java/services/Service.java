package services;

import java.sql.PreparedStatement;

import exceptions.MiExcepcion;
import models.Jugador;
import repositories.JugadorRepository;
import repositories.PartidaRepository;

public class Service {
	
	private JugadorRepository jugadorRepo;
	private PartidaRepository partidaRepo;
	
	//Constructors
	public Service(JugadorRepository jugadorRepo, PartidaRepository partidaRepo) {
		this.jugadorRepo = jugadorRepo;
		this.partidaRepo = partidaRepo;
	}
	public Service() {
	}
	
	public void createJugador(Jugador jugador) throws MiExcepcion {
		String query = "INSERT INTO VelazquezRobertoJugador (nombre, email, puntosTotales) VALUES (?, ?, ?)";
		try {
			PreparedStatement stmt = jugadorRepo
		} catch (MiExcepcion ex) {
			
		}
	}
	
	
	
}
