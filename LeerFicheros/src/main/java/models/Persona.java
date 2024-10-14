package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Persona {
	private String nombre;
	List<Double> notas;
	
	

	public Persona() {
		super();
		this.nombre = "";
		notas = new ArrayList<Double>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Double> getNotas() {
		return notas;
	}

	public void setNotas(List<Double> notas) {
		this.notas = notas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre, notas);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(nombre, other.nombre) && Objects.equals(notas, other.notas);
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", notas=" + notas + "]";
	}
	
	
}
