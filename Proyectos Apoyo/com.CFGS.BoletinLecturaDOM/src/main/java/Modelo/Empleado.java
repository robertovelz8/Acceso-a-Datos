package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Empleado {
	private String id;
	private String nombreApellidos;
	private int edad;
	private String empresa;
	private List<Puesto> puestos;

	public Empleado() {
		puestos = new ArrayList<>();
	}

	// Getters y Setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombreApellidos() {
		return nombreApellidos;
	}

	public void setNombreApellidos(String nombreApellidos) {
		this.nombreApellidos = nombreApellidos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public List<Puesto> getPuestos() {
		return puestos;
	}

	public void addPuesto(Puesto puesto) {
		this.puestos.add(puesto);
	}
}