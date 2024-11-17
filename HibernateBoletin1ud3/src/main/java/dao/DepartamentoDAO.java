package dao;

import models.Departamento;
import utilesDAO.AbstractDAO;

public class DepartamentoDAO extends AbstractDAO<Departamento>{

	public DepartamentoDAO() {
		setDepartamento(Departamento.class);
	}
	
}
