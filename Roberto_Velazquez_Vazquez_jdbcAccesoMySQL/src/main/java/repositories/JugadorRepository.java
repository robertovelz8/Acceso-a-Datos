package repositories;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exceptions.MiExcepcion;
import models.Jugador;
import models.Resultado;
import utiles.MySqlConector;


public class JugadorRepository {
	
	private MySqlConector conector;
	private List<Jugador> jugadores;

	public JugadorRepository() {
		this.jugadores = new ArrayList<Jugador>();
		try {
			this.conector = new MySqlConector();
		} catch (MiExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void createJugador(Jugador jugador) throws MiExcepcion {
		String query = "INSERT INTO VelazquezRobertoJugador (nombre, email, puntosTotales) VALUES (?, ?, ?)";
		try {
			PreparedStatement stmt = conector.getConnect().prepareStatement(query,
					PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, jugador.getNombre());
			stmt.setString(2, jugador.getEmail());
			stmt.setInt(3, jugador.getPuntosTotales());
			System.out.println("Jugador creado correctamente.");
			int filasAfectadas = stmt.executeUpdate();
			if (filasAfectadas > 0) {
				java.sql.ResultSet rs = stmt.getGeneratedKeys();
				if (rs.next()) {
					jugador.setId(rs.getInt(1));
				}
			}
		} catch (SQLException e) {
			throw new MiExcepcion(e.getMessage());
		}
	}

	public void actualizarPuntuacionNarrador(int id, Resultado res) throws MiExcepcion {
		Jugador jugador = new Jugador();
		String query = "UPDATE VelazquezRobertoJugador SET puntosTotales=? WHERE id=?";
		try {
			PreparedStatement stmt = conector.getConnect().prepareStatement(query,
					PreparedStatement.RETURN_GENERATED_KEYS);
			if (res == Resultado.ALGUNOS) {
				stmt.setInt(1, jugador.getPuntosTotales() + 3);
				stmt.setInt(2, id);
				int filasAfectadas = stmt.executeUpdate();
				if (filasAfectadas > 0) {
					java.sql.ResultSet rs = stmt.getGeneratedKeys();
					if (rs.next()) {
						jugador.setId(rs.getInt(1));
					}
				}
			} else {
				stmt.setInt(1, jugador.getPuntosTotales());
				stmt.setInt(2, id);
				System.out.println(stmt.executeUpdate());
			}

		} catch (SQLException e) {
			throw new MiExcepcion(e.getMessage());
		}
	}

	public void actualizarPuntuacionNOAcertante() {

	}

	public void actualizarPuntuacionAcertante() {

	}

	public void mostrarMejorJugador() {

	}

	public void listarJugadores() {

	}
}
