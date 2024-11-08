package services;

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
	
	public void consultarEquipos() {
		this.repoEquipo.consultarEquipos();
	}
	
	public Equipo consultarEquipo(int idEquipo) {
		return this.repoEquipo.consultarEquipo(idEquipo);
	}
	
}
