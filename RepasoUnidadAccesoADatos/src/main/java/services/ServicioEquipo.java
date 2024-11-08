package services;

import java.util.ArrayList;
import java.util.List;

import models.Equipo;
import models.Piloto;
import repositories.RepositorioEquipos;

public class ServicioEquipo {
	
	//Attributes
	private RepositorioEquipos repoEquipo;

	//Constructor
	public ServicioEquipo() {
		this.repoEquipo = new RepositorioEquipos();
	}
	
	public void crearEquipo(String nombre, String puntuacion, int identificadorEquipo, List<Piloto> pilotos) {
		this.repoEquipo.crearEquipo(nombre, puntuacion, identificadorEquipo, pilotos);
	}
	
	public List<Equipo> consultarEquipos() {
		return this.repoEquipo.consultarEquipos();
	}
	
	public Equipo consultarEquipo(int idEquipo) {
		return this.repoEquipo.consultarEquipo(idEquipo);
	}
	
	public void addPilotoAEquipo(int identificadorEquipo, Piloto p) {
		Equipo equipo = this.consultarEquipo(identificadorEquipo);
		if(equipo != null) {
			equipo.getPilotos().add(p);
		}
	}
	
	public List<Piloto> consultarPilotosPuntuacion (int puntuacion) {
		List<Piloto> pilotos = new ArrayList<Piloto>();
		
		for(Equipo equipo : this.repoEquipo.getEquipos()) {
			for(Piloto piloto : equipo.getPilotos()) {
				if(piloto.getPuntos() > puntuacion) {
					pilotos.add(piloto);
				}
			}
		}
		return pilotos;
	}
	
}
