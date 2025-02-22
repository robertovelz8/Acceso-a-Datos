package repositories;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import exceptions.MiExcepcion;
import models.Partida;
import utiles.MySqlConector;

public class PartidaRepository {

	private MySqlConector conector;
	
	public PartidaRepository() {
		try {
			this.conector = new MySqlConector();
		} catch (MiExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void createPartida(Partida partida) throws MiExcepcion {
		String query = "INSERT INTO VelazquezRobertoPartida (narrador_id, fecha, resultado) VALUES (?, ?, ?)";
		try {
			PreparedStatement stmt = conector.getConnect().prepareStatement(query);
			stmt.setInt(1, partida.getNarrador().getId());
			stmt.setDate(2, java.sql.Date.valueOf(partida.getFecha()));
			stmt.setString(3, partida.getResultado().toString());
			System.out.println("Partida creada correctamente.");
			System.out.println(stmt.executeUpdate());
		} catch (SQLException e) {
			throw new MiExcepcion(e.getMessage());
		}
	}

	public void listarPartidas() {

	}
}
