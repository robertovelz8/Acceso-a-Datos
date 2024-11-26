package models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Medico {
	
	//Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMedico;
	private String nombre;
	
	
	private String telefono;
	
	@OneToMany
	private List<Paciente> pacientes; 
	
	//Constructor
	public Medico(int idMedico, String nombre, String telefono, List<Paciente> pacientes) {
		this.idMedico = idMedico;
		this.nombre = nombre;
		this.telefono = telefono;
		this.pacientes = pacientes;
	}
	
	public Medico(int idMedico) {
		this.idMedico = idMedico;
	}


	//Getters & Setters
	
	public int getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(int idMedico) {
		this.idMedico = idMedico;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	//toString
	@Override
	public String toString() {
		return "Medico [idMedico=" + idMedico + ", nombre=" + nombre + ", telefono="
				+ telefono + ", pacientes=" + pacientes + "]";
	}
	
	
	
	
}
