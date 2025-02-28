package repositories;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import exceptions.MiExcepcion;
import models.Partida;
import utiles.MySqlConector;

public class PartidaRepository {
	private static final Logger logger = LogManager.getLogger(PartidaRepository.class);
	private MySqlConector conector;

	public PartidaRepository(MySqlConector conector) throws MiExcepcion {

		this.conector = new MySqlConector();
	}

	public void crearPartida(Partida partida) throws MiExcepcion {
		String query = "INSERT INTO VelazquezRobertoPartida (id, narrador_id, fecha, resultado) VALUES (?, ?, ?, ?)";
		try {
			PreparedStatement ps = conector.getConnect().prepareStatement(query);
			ps.setInt(1, partida.getId());
			ps.setInt(2, partida.getNarrador().getId());
			ps.setDate(3, Date.valueOf(partida.getFecha()));
			ps.setString(4, partida.getResultado().name());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new MiExcepcion("Error al agregar partida: " + e.getMessage());
		}
		logger.debug("Partida creada correctamente.");
	}

	public void listarPartidasOrdenadasPorFecha() throws MiExcepcion {
		String query = "SELECT id, narrador_id, fecha, resultado FROM VelazquezRobertoPartida ORDER BY fecha DESC";

		try (Connection conn = conector.getConnect();
				PreparedStatement stmt = conn.prepareStatement(query);
				ResultSet rs = stmt.executeQuery()) {

			// Imprimir encabezado
			logger.debug("ID - Narrador ID - Fecha - Resultado");

			while (rs.next()) {
				int id = rs.getInt("id");
				int narradorId = rs.getInt("narrador_id");
				LocalDate fecha = rs.getDate("fecha").toLocalDate();
				String resultado = rs.getString("resultado");

				logger.debug(id + " - " + narradorId + " - " + fecha + " - " + resultado);
			}

		} catch (SQLException e) {
			throw new MiExcepcion("Error al obtener las partidas ordenadas por fecha: " + e.getMessage());
		}
	}

	public int contarPartidas() throws MiExcepcion {
        String query = "SELECT COUNT(*) FROM VelazquezRobertoPartida";
        Statement s = null;
        ResultSet rs = null;
        try {
            s = conector.getConnect().createStatement();
            rs = s.executeQuery(query);
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new MiExcepcion("Error al contar partidas: " + e.getMessage());
        }
        return 0;
    }
}
