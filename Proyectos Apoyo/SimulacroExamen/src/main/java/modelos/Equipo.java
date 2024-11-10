package modelos;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Equipo implements Comparable<Equipo>{
	private int identificador;
	private String nombreEquipo;
	private int puntos;
	private Map<Integer, Piloto> pilotos;
	
	public Equipo() {
		this.pilotos = new HashMap<>();
	}
	
	public Equipo(int identificador, String nombreEquipo, int puntos) {
		super();
		this.identificador = identificador;
		this.nombreEquipo = nombreEquipo;
		this.puntos = puntos;
		this.pilotos = new HashMap<>();
	}
	public int getIdentificador() {
		return identificador;
	}
	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
	public String getNombreEquipo() {
		return nombreEquipo;
	}
	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	public Map<Integer, Piloto> getPilotos() {
		return pilotos;
	}
	public void setPilotos(Map<Integer, Piloto> pilotos) {
		this.pilotos = pilotos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(identificador);
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
		return identificador == other.identificador;
	}



	@Override
	public int compareTo(Equipo o) {
		// TODO Auto-generated method stub
		return Integer.compare(this.getPuntos(), o.getPuntos());
	}
	

}
