package models;

import java.util.Objects;

public class Piloto {
	
	//Attributes
	private String identificadorPiloto;
	private String nombrePiloto;
	private String pais;
	private int puntos;
	private int identificadorEquipo;
	
	//Constructors
	public Piloto(String identificadorPiloto, String nombrePiloto, String pais, int puntos, int identificadorEquipo) {
		this.identificadorPiloto = identificadorPiloto;
		this.nombrePiloto = nombrePiloto;
		this.pais = pais;
		this.puntos = puntos;
		this.identificadorEquipo = identificadorEquipo;
	}

	public Piloto() {
	}

	//Getters & Setters
	
	public String getIdentificadorPiloto() {
		return identificadorPiloto;
	}

	public void setIdentificadorPiloto(String identificadorPiloto) {
		this.identificadorPiloto = identificadorPiloto;
	}

	public String getNombrePiloto() {
		return nombrePiloto;
	}

	public void setNombrePiloto(String nombrePiloto) {
		this.nombrePiloto = nombrePiloto;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public int getIdentificadorEquipo() {
		return identificadorEquipo;
	}

	public void setIdentificadorEquipo(int identificadorEquipo) {
		this.identificadorEquipo = identificadorEquipo;
	}
	
	
	//hashCode(), equals() & toString()
	
	@Override
	public int hashCode() {
		return Objects.hash(identificadorPiloto);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Piloto other = (Piloto) obj;
		return identificadorPiloto == other.identificadorPiloto;
	}

	@Override
	public String toString() {
		return "Piloto [identificadorPiloto=" + identificadorPiloto + ", nombrePiloto=" + nombrePiloto + ", pais="
				+ pais + ", puntos=" + puntos + ", identificadorEquipo=" + identificadorEquipo + "]";
	}
	
	
}
