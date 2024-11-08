package repositories;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import models.Equipo;
import models.Piloto;

public class RepositorioEquipos {

	// Attributes
	private List<Equipo> equipos;
	private static final Logger logger = LogManager.getLogger(RepositorioEquipos.class);

	// Constructors

	public RepositorioEquipos() {
		this.equipos = new ArrayList<Equipo>();
	}

	// Getters & Setters
	public List<Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(List<Equipo> equipos) {
		this.equipos = equipos;
	}

	// Create Equipo
	public void crearEquipo(String nombre, String puntuacion, int identificadorEquipo, List<Piloto> pilotos) {
		Equipo e1 = new Equipo(nombre, puntuacion, identificadorEquipo, pilotos);
		this.equipos.add(e1);
	}

	// consultar Equipos
	public void consultarEquipos() {
		for (Equipo equipo : equipos) {
			logger.debug(equipo);
		}
	}

	// Consultar 1 equipo
	public Equipo consultarEquipo(int idEquipo) {
		boolean bandera = true;
		Equipo e = null;
		while (bandera) {
			for (Equipo equipo : equipos) {
				if (idEquipo == equipo.getIdentificadorEquipo()) {
					bandera = false;
					e = equipo;
					
				}
			}
		}
		return e;
	}
}
