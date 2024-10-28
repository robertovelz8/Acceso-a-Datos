package models;

import java.util.ArrayList;
import java.util.List;

public class EmpleadoMultipuestos {
	
	//Attributes
	private String identificador;
	private String nombreApellido;
	private int edad;
	private String empresa;
	private List<PuestoTrabajo> puestos;
	
	//Constructors
	public EmpleadoMultipuestos(String identificador, String nombreApellido, int edad, String empresa,
			List<PuestoTrabajo> puestos) {
		this.identificador = identificador;
		this.nombreApellido = nombreApellido;
		this.edad = edad;
		this.empresa = empresa;
		this.puestos = new ArrayList<PuestoTrabajo>();
	}
	
	

	public EmpleadoMultipuestos(List<PuestoTrabajo> puestos) {
		this.puestos = new ArrayList<PuestoTrabajo>();
	}



	//Getters & Setters
	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getNombreApellido() {
		return nombreApellido;
	}

	public void setNombreApellido(String nombreApellido) {
		this.nombreApellido = nombreApellido;
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

	public List<PuestoTrabajo> getPuesto() {
		return puestos;
	}

	public void setPuesto(List<PuestoTrabajo> puesto) {
		this.puestos = puesto;
	}
	
	
	
}
