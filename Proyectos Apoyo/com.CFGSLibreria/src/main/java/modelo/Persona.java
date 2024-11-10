package modelo;

import java.util.ArrayList;
import java.util.List;

public class Persona {
	private String nombre;
	List<Double> notas;

	/**
	 * @param nombre
	 * @param notas
	 */
	public Persona() {
		this.nombre = "";
		this.notas = new ArrayList<Double>();
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
	public String toString() {
		return "Persona [nombre=" + nombre + ", notas=" + notas + "]";
	}
}