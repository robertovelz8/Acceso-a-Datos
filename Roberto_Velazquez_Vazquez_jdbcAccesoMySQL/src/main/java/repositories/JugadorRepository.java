package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import exceptions.MiExcepcion;
import models.Jugador;
import models.Resultado;
import utiles.MySqlConector;


public class JugadorRepository {
	private static final Logger logger = LogManager.getLogger(JugadorRepository.class);
	private MySqlConector conector;
	private List<Jugador> jugadores;

	public JugadorRepository(MySqlConector conector) {
		this.jugadores = new ArrayList<Jugador>();
		try {
			this.conector = new MySqlConector();
		} catch (MiExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public JugadorRepository() {
		try {
			this.conector = new MySqlConector();
		} catch (MiExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int createJugador(Jugador jugador) throws MiExcepcion {
		String query = "INSERT INTO VelazquezRobertoJugador (nombre, email, puntosTotales) VALUES (?, ?, ?)";
		try {
			PreparedStatement stmt = conector.getConnect().prepareStatement(query,
					PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, jugador.getNombre());
			stmt.setString(2, jugador.getEmail());
			stmt.setInt(3, jugador.getPuntosTotales());
			logger.debug("Jugador creado correctamente.");
			int filasAfectadas = stmt.executeUpdate();
			if (filasAfectadas > 0) {
				ResultSet rs = stmt.getGeneratedKeys();
	            if (rs.next()) {
	                return rs.getInt(1);
	            }
			}
		} catch (SQLException e) {
			throw new MiExcepcion(e.getMessage());
		}
		throw new MiExcepcion("No se pudo obtener el ID del jugador.");
	}

	public void actualizarPuntuacionNarrador(int narradorId, Resultado resultado) throws MiExcepcion {
	    // Solo actualizamos si el resultado es ALGUNOS
	    if (resultado == Resultado.ALGUNOS) {
	        String updateQuery = "UPDATE VelazquezRobertoJugador SET puntosTotales = puntosTotales + 3 WHERE id = ?";

	        try (Connection conn = conector.getConnect();
	             PreparedStatement stmt = conn.prepareStatement(updateQuery)) {
	            
	            stmt.setInt(1, narradorId);

	            int filasAfectadas = stmt.executeUpdate();
	            if (filasAfectadas > 0) {
	                logger.debug("Puntuación actualizada correctamente para el narrador con ID: " + narradorId);
	            } else {
	                throw new MiExcepcion("No se encontró un narrador con el ID proporcionado.");
	            }
	        } catch (SQLException e) {
	            throw new MiExcepcion("Error al actualizar la puntuación: " + e.getMessage());
	        }
	    } else {
	        logger.debug("No se realizó ninguna actualización, ya que el resultado no es ALGUNOS.");
	    }
	}

	public void actualizarPuntuacionNOAcertante(int jugadorId, Resultado resultado) throws SQLException {
        if (resultado == Resultado.TODOS || resultado == Resultado.NADIE) {
            String sql = "UPDATE VelazquezRobertoJugador SET puntosTotales = puntosTotales + 2 WHERE id = ?";
            try (Connection conexion = conector.getConnect();  // Obtener la conexión
                 PreparedStatement stmt = conexion.prepareStatement(sql)) { // Usar la conexión correcta
                
                stmt.setInt(1, jugadorId);
                int filasActualizadas = stmt.executeUpdate();
                
                if (filasActualizadas == 0) {
                    throw new SQLException("No se encontró un jugador con el ID especificado.");
                }
            }
            logger.debug("Puntuación actualizada correctamente para el jugador no acertante con ID: " + jugadorId);
        }
    }

	public void actualizarPuntuacionAcertante(int jugadorId, Resultado resultado) throws MiExcepcion {
	    int puntosIncremento = 0;

	    // Determinar los puntos a incrementar según el resultado
	    if (resultado == Resultado.TODOS || resultado == Resultado.NADIE) {
	        puntosIncremento = 2;
	    } else if (resultado == Resultado.ALGUNOS) {
	        puntosIncremento = 3;
	    } else {
	        System.out.println("No se realizó ninguna actualización, ya que el resultado no es válido.");
	        return;
	    }

	    // Query para actualizar la puntuación del jugador
	    String updateQuery = "UPDATE VelazquezRobertoJugador SET puntosTotales = puntosTotales + ? WHERE id = ?";

	    try (Connection conn = conector.getConnect();
	         PreparedStatement stmt = conn.prepareStatement(updateQuery)) {

	        stmt.setInt(1, puntosIncremento);
	        stmt.setInt(2, jugadorId);

	        int filasAfectadas = stmt.executeUpdate();
	        if (filasAfectadas > 0) {
	            logger.debug("Puntuación actualizada correctamente para el jugador acertante con ID: " + jugadorId);
	        } else {
	            throw new MiExcepcion("No se encontró un jugador con el ID proporcionado.");
	        }
	    } catch (SQLException e) {
	        throw new MiExcepcion("Error al actualizar la puntuación: " + e.getMessage());
	    }
	}

	public Jugador obtenerJugadorConMayorPuntuacion() throws MiExcepcion {
	    String query = "SELECT id, nombre, email, puntosTotales FROM VelazquezRobertoJugador ORDER BY puntosTotales DESC LIMIT 1";

	    try (Connection conn = conector.getConnect();
	         PreparedStatement stmt = conn.prepareStatement(query);
	         ResultSet rs = stmt.executeQuery()) {

	        if (rs.next()) {
	            Jugador jugador = new Jugador(
	                rs.getString("nombre"),
	                rs.getString("email"),
	                rs.getInt("puntosTotales")
	            );
	            jugador.setId(rs.getInt("id")); // Asignamos manualmente el ID

	            logger.debug("Jugador con mayor puntuación: " + jugador);
	            return jugador;
	        } else {
	            throw new MiExcepcion("No hay jugadores registrados en la base de datos.");
	        }
	    } catch (SQLException e) {
	        throw new MiExcepcion("Error al obtener el jugador con mayor puntuación: " + e.getMessage());
	    }
	}

	public void mostrarJugadoresOrdenadosPorPuntos() throws MiExcepcion {
	    String query = "SELECT nombre, puntosTotales FROM VelazquezRobertoJugador ORDER BY puntosTotales DESC";

	    try (Connection conn = conector.getConnect();
	         PreparedStatement stmt = conn.prepareStatement(query);
	         ResultSet rs = stmt.executeQuery()) {

	        // Imprimir encabezado
	        System.out.println("Jugador - Puntos");

	        while (rs.next()) {
	            String nombre = rs.getString("nombre");
	            int puntosTotales = rs.getInt("puntosTotales");
	            logger.debug(nombre + " - " + puntosTotales);
	        }

	    } catch (SQLException e) {
	        throw new MiExcepcion("Error al obtener los jugadores ordenados: " + e.getMessage());
	    }
	}

	
}
