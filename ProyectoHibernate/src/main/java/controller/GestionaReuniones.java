package controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.ReunionDAO;
import ud3.Reunion;

public class GestionaReuniones {

	private static final Logger logger = LogManager.getLogger(GestionaReuniones.class);

	public static void main(String[] args) {
		ReunionDAO r1 = new ReunionDAO();
		List<Reunion> reuniones = r1.getAll();
		for (Reunion reunion : reuniones) {
			logger.debug(reunion);
		}
	}

}
