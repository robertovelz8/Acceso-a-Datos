package repositories;

import utiles.MySqlConector;

public class JugadorRepository {
	private MySqlConector conector;

	public JugadorRepository(MySqlConector conector) {
		this.conector = conector;
	}
}
