package controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.ArbitroDAO;
import dao.EquipoDAO;
import dao.EstadioDAO;
import dao.JugadorDAO;
import dao.LigaDAO;
import dao.PartidoDAO;
import models.Arbitro;
import models.Equipo;
import models.Estadio;
import models.Jugador;
import models.Liga;
import models.Partido;

public class GestionTorneosController {
	private static final Logger logger = LogManager.getLogger(GestionTorneosController.class);

	public static void main(String[] args) {
	    LigaDAO ligaDao = new LigaDAO();
	    JugadorDAO jugadorDao = new JugadorDAO();
	    PartidoDAO partidoDao = new PartidoDAO();
	    EstadioDAO estadioDao = new EstadioDAO();
	    Liga liga1 = new Liga();
	    liga1.setNombre("Liga Santander");
	    liga1.setPais("España");
	    liga1.setNivel("Primera División");

	    Equipo eq1 = new Equipo("Betis", "1843", liga1);
	    Equipo eq2 = new Equipo("Cádiz", "1911", liga1);
	    List<Equipo> equipos = new ArrayList<>();
	    equipos.add(eq1);
	    equipos.add(eq2);
	    liga1.setEquipos(equipos);
	    Partido p1 = new Partido();
	    List<Partido> partidos = new ArrayList<Partido>();
	    partidos.add(p1);
	    Arbitro a1 = new Arbitro("Mateu Lahoz", "española", "11 años", partidos);
	    List<Arbitro> arbitros = new ArrayList<>();
	    arbitros.add(a1);
	    p1.setFecha("2011-12-03");
	    p1.setResultado("2-0");
	    p1.setArbitros(arbitros);
	    liga1.setArbitros(arbitros);
	    Jugador j1 = new Jugador("Leo Messi", "CF", "1983-07-12", 10);
	    Estadio estadio1 = new Estadio("Benito Villamarín", 47213, "Heliópolis");
	    ligaDao.create(liga1);
	    jugadorDao.create(j1);
	    partidoDao.create(p1);
	    estadioDao.create(estadio1);
	}
}
