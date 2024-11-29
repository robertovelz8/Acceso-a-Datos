package dao;

import models.Equipo;
import utilesDAO.AbstractDAO;

public class EquipoDAO extends AbstractDAO<Equipo>{
	public EquipoDAO() {
		setClase(Equipo.class);
	}
}
