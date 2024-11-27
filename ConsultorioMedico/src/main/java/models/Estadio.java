package models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Estadio {
	
	//Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JoinColumn(name = "id_estadio")
	private int idEstadio;
	private String nombre;
	private int capacidad;
	private String ubicacion;
	@OneToOne
	private Partido partido;
	@ManyToMany (mappedBy = "estadio")
	private List<Equipo> equipos;
	
	//Constructors
	public Estadio(int idEstadio, String nombre, int capacidad, String ubicacion, Partido partido,
			List<Equipo> equipos) {
		super();
		this.idEstadio = idEstadio;
		this.nombre = nombre;
		this.capacidad = capacidad;
		this.ubicacion = ubicacion;
		this.partido = partido;
		this.equipos = equipos;
	}
	public Estadio(int idEstadio) {
		super();
		this.idEstadio = idEstadio;
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
	public Partido getPartido() {
		return partido;
	}
	public void setPartido(Partido partido) {
		this.partido = partido;
	}
	public List<Equipo> getEquipos() {
		return equipos;
	}
	public void setEquipos(List<Equipo> equipos) {
		this.equipos = equipos;
	}
	
	//toString
	@Override
	public String toString() {
		return "Estadio [idEstadio=" + idEstadio + ", nombre=" + nombre + ", capacidad=" + capacidad + ", ubicacion="
				+ ubicacion + ", partido=" + partido + ", equipos=" + equipos + "]";
	}
	
	
	
	
}
