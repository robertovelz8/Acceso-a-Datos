package models;

import java.util.Objects;

public class PuestoTrabajo {
	private String identificador;
	private String nombrePuesto;
	private String departamento;
	private double salario;
	
	
	public PuestoTrabajo(String identificador, String nombrePuesto, String departamento, double salario) {
		this.identificador = identificador;
		this.nombrePuesto = nombrePuesto;
		this.departamento = departamento;
		this.salario = salario;
	}
	
	
	public PuestoTrabajo() {
	}


	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	public String getNombrePuesto() {
		return nombrePuesto;
	}
	public void setNombrePuesto(String nombrePuesto) {
		this.nombrePuesto = nombrePuesto;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
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
		PuestoTrabajo other = (PuestoTrabajo) obj;
		return Objects.equals(identificador, other.identificador);
	}
	
	
}
