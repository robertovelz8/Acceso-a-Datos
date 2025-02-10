package repositories;

import utiles.MySqlConector;

public class PartidaRepository {
	
	private MySqlConector conector;

	public PartidaRepository(MySqlConector conector) {
		this.conector = conector;
	}
}
