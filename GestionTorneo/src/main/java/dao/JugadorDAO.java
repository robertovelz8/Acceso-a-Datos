package dao;

import models.Jugador;
import utilesDAO.AbstractDAO;

public class JugadorDAO extends AbstractDAO<Jugador>{
	public JugadorDAO() {
		setClase(Jugador.class);
	}
}
