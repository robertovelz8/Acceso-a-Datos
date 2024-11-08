package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Equipo {
	
	//Attributes
	private String nombreEquipo;
	private String puntuacion;
	private int identificadorEquipo;
	List<Piloto> pilotos;

	//Constructors
	public Equipo(String nombre, String puntuacion, int identificadorEquipo, List<Piloto> pilotos) {
		this.nombreEquipo = nombre;
		this.puntuacion = puntuacion;
		this.identificadorEquipo = identificadorEquipo;
		this.pilotos = new ArrayList<Piloto>();
	}

	public Equipo() {
	}

	//Getters & Setters
	public List<Piloto> getPilotos() {
		return pilotos;
	}

	public String getNombreEquipo() {
		return nombreEquipo;
	}

	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo     ;
	}

	public String getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(String puntuacion) {
		this.puntuacion = puntuacion;
	}

	public int getIdentificadorEquipo() {
		return identificadorEquipo;
	}

	public void setIdentificadorEquipo(int identificadorEquipo) {
		this.identificadorEquipo = identificadorEquipo;
	}

	public void setPilotos(List<Piloto> pilotos) {
		this.pilotos = pilotos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(identificadorEquipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipo other = (Equipo) obj;
		return identificadorEquipo == other.identificadorEquipo;
	}

	@Override
	public String toString() {
		return "Equipo [nombre=" + nombreEquipo + ", puntuacion=" + puntuacion + ", identificadorEquipo="
				+ identificadorEquipo + ", pilotos=" + pilotos + "]";
	}
}
