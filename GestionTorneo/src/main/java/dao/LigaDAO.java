package dao;

import models.Liga;
import utilesDAO.AbstractDAO;

public class LigaDAO extends AbstractDAO<Liga>{
	public LigaDAO() {
		setClase(Liga.class);
	}
}
