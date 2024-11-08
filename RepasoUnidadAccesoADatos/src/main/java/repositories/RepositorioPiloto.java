package repositories;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import models.Piloto;

public class RepositorioPiloto {

	// Attributes
	private static final Logger logger = LogManager.getLogger(RepositorioPiloto.class);
	List<Piloto> pilotos;

	// Constructors
	public RepositorioPiloto() {
		this.pilotos = new ArrayList<Piloto>();
	}

	// Getters & Setters
	public List<Piloto> getPilotos() {
		return pilotos;
	}

	public void setPilotos(List<Piloto> pilotos) {
		this.pilotos = pilotos;
	}

	// Create Piloto

	public void crearPiloto(String identificadorPiloto, String nombrePiloto, String pais, int puntos,
			int identificadorEquipo) {
		Piloto p1 = new Piloto(identificadorPiloto, nombrePiloto, pais, puntos, identificadorEquipo);
		this.pilotos.add(p1);
	}

	public Piloto consultarPiloto(String idPiloto) {
		boolean bandera = true;
		Piloto p = null;
		while (bandera) {
			for (Piloto piloto : pilotos) {
				if (idPiloto.equals(piloto.getIdentificadorPiloto())) {
					bandera = false;
					p = piloto;

				}
			}
		}
		return p;
	}

	public List<Piloto> consultarPilotos() {
		List<Piloto> listaPilotos = new ArrayList<Piloto>();
		for (Piloto piloto : pilotos) {
			listaPilotos.add(piloto);
		}
		return listaPilotos;
	}
}
