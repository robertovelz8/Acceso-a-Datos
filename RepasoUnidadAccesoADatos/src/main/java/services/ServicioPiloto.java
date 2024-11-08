package services;

import java.util.List;

import models.Piloto;
import repositories.RepositorioPiloto;

public class ServicioPiloto {
	
	//Attributes
	private RepositorioPiloto repoPiloto;

	//Constructor
	public ServicioPiloto() {
		this.repoPiloto = new RepositorioPiloto();
	}
	
	public void crearPiloto(String identificadorPiloto, String nombrePiloto, 
			String pais, int puntos, int identificadorEquipo) {
		this.repoPiloto.crearPiloto(identificadorPiloto, nombrePiloto, pais, puntos, identificadorEquipo);
	}
	
	public Piloto consultarPiloto(String idPiloto) {
		return this.repoPiloto.consultarPiloto(idPiloto);
	}
	
	public List<Piloto> consultarPilotos () {
		return this.repoPiloto.consultarPilotos();
	}
}
