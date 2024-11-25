package controller;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.ReunionDAO;
import dao.SalaDao;
import ud3.Reunion;
import ud3.Sala;

public class GestionaReuniones {

	private static final Logger logger = LogManager.getLogger(GestionaReuniones.class);

	public static void main(String[] args) {
		
		SalaDao s1 = new SalaDao();
		Sala sala1 = new Sala("Sala 1", 32);
		Sala sala4 = new Sala("Sala 4", 31);
		s1.create(sala1);
		s1.create(sala4);
		
		ReunionDAO r1 = new ReunionDAO();
		Reunion reunion4 = new Reunion(LocalDateTime.now().plusDays(3), "Asunto importantísisisimo 3", sala4);
		Reunion reunion5 = new Reunion(LocalDateTime.now().plusDays(3), "Asunto importantísisisimo 4", sala1);
		r1.create(reunion4);
		r1.create(reunion5);
		sala4.addReunion(reunion4);
		/*
		List<Reunion> reuniones = r1.getAll();
		for (Reunion reunion : reuniones) {
			logger.debug(reunion);
		}
		
		for (Sala sala : s1.getAll()) {
			logger.debug(sala);
		}
		*/
		for (Reunion r : r1.getAllReuniones()) {
			logger.debug(r);
		}
		
		
	}

}
