package dao;

import models.Estadio;
import utilesDAO.AbstractDAO;

public class EstadioDAO extends AbstractDAO<Estadio>{
	public EstadioDAO() {
		setClase(Estadio.class);
	}
}
