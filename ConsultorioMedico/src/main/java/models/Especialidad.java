package models;

import java.util.List;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

public class Especialidad {
	
	//Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String idEspecialidad;
	private String nombre;
	private String descripcion;
	
	@OneToMany
	private List<Medico> medicos;

	//Constructors
	public Especialidad(String idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
	}

	public Especialidad(String idEspecialidad, String nombre, String descripcion, List<Medico> medicos) {
		this.idEspecialidad = idEspecialidad;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.medicos = medicos;
	}

	//Getters & Setters
	public String getIdEspecialidad() {
		return idEspecialidad;
	}

	public void setIdEspecialidad(String idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Medico> getMedicos() {
		return medicos;
	}

	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
	}

	//toString
	@Override
	public String toString() {
		return "Especialidad [idEspecialidad=" + idEspecialidad + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", medicos=" + medicos + "]";
	}
	
	



}
