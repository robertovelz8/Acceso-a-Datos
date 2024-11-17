package controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.DepartamentoDAO;
import models.Departamento;

public class GestionaDepartamentos {
	private static final Logger logger = LogManager.getLogger(GestionaDepartamentos.class);

	public static void main(String[] args) {
		DepartamentoDAO r1 = new DepartamentoDAO();
		List<Departamento> departamentos = r1.getAll();
		for (Departamento dept : departamentos) {
			logger.debug(dept);
		}
	}
}
