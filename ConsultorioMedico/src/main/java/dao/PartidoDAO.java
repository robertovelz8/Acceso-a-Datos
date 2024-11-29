package dao;

import models.Partido;
import utilesDAO.AbstractDAO;

public class PartidoDAO extends AbstractDAO<Partido>{
	public PartidoDAO() {
		setClase(Partido.class);
	}
}
