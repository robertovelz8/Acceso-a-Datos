package dao;

import models.Empleado;
import utilesDAO.AbstractDAO;

public class EmpleadoDAO extends AbstractDAO<Empleado>{
	public EmpleadoDAO() {
		setEmpleado(Empleado.class);
	}
}
