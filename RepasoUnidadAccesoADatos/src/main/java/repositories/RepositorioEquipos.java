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
	public List<Equipo> consultarEquipos() {
		List<Equipo> equiposLista = new ArrayList<Equipo>();
		for (Equipo equipo : equipos) {
			equiposLista.add(equipo);
		}
		return equiposLista;
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
	
	public void addPilotoAEquipo(int identificadorEquipo, Piloto p) {
		Equipo equipo = this.consultarEquipo(identificadorEquipo);
		if(equipo != null) {
			equipo.getPilotos().add(p);
		}
	}
	
	public List<Piloto> consultarPilotosPuntuacion (int puntuacion) {
		List<Piloto> pilotos = new ArrayList<Piloto>();
		
		for(Equipo equipo : equipos) {
			for(Piloto piloto : equipo.getPilotos()) {
				if(piloto.getPuntos() > puntuacion) {
					pilotos.add(piloto);
				}
			}
		}
		return pilotos;
	}
}
