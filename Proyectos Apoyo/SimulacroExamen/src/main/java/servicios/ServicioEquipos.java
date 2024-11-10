package servicios;

import java.util.Collections;
import java.util.List;

import modelos.Equipo;
import modelos.Piloto;
import repositorios.RepositorioEquipos;

public class ServicioEquipos {
	private RepositorioEquipos repos;
	
	public RepositorioEquipos getRepos() {
		return repos;
	}

	public void setRepos(RepositorioEquipos repos) {
		this.repos = repos;
	}

	public List<Equipo> asignarPilotosaEquipos(List<Equipo> equipos, List<Piloto> pilotos) {
		for(Equipo e: equipos) {
			for(Piloto p: pilotos) {
				if(p.getIdentificadorEquipo()==e.getIdentificador()) {
					
					e.getPilotos().put(p.getIdentificadorPiloto(), p);
				}
			}
		}
		return equipos;
	}
	//método para los 3 mejores equipos
	public List<Equipo> podiumMejoresEquipos(List<Equipo> equipos){
		Collections.sort(equipos);
		//Con reversed le damos la vuelta y con sublist()elegimos los 4 primeros índices, ya que el último no lo coge
		List<Equipo> mejoresEquipos = equipos.reversed().subList(0, 3);

		return mejoresEquipos;
	}
	//método para los 3 peores equipos
	public List<Equipo> podiumPeoresEquipos(List<Equipo> equipos){
		Collections.sort(equipos);
		//Cogemos los 3 primeros (empezando por el de menor puntuacion)
		List<Equipo> peoresEquipos = equipos.subList(0, 3);

		return peoresEquipos;
	}
}
