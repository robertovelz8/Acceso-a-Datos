package models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Estadio {
	
	//Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_estadio")
	private int idEstadio;
	private String nombre;
	private int capacidad;
	private String ubicacion;
	
	//Constructors
	public Estadio(String nombre, int capacidad, String ubicacion) {
		super();
		this.nombre = nombre;
		this.capacidad = capacidad;
		this.ubicacion = ubicacion;

	}
	
	
	public Estadio() {
	}
	//Getters & Setters
	public int getIdEstadio() {
		return idEstadio;
	}
	public void setIdEstadio(int idEstadio) {
		this.idEstadio = idEstadio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}


	@Override
	public String toString() {
		return "Estadio [idEstadio=" + idEstadio + ", nombre=" + nombre + ", capacidad=" + capacidad + ", ubicacion="
				+ ubicacion + "]";
	}

	
	
	
}
