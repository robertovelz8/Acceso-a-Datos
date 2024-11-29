package models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Equipo {

	//Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_equipo")
	private int idEquipo;
	private String nombre;
	private String fundacion;
	
	
	@ManyToOne
	private Liga liga;

	// Constructors
	public Equipo(String nombre, String fundacion, Liga liga) {
		this.nombre = nombre;
		this.fundacion = fundacion;
		this.liga = liga;
	}

	public Equipo() {
	}

	public int getIdEquipo() {
		return idEquipo;
	}

	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFundacion() {
		return fundacion;
	}

	public void setFundacion(String fundacion) {
		this.fundacion = fundacion;
	}

	public Liga getLiga() {
		return liga;
	}

	public void setLiga(Liga liga) {
		this.liga = liga;
	}

	@Override
	public String toString() {
		return "Equipo [idEquipo=" + idEquipo + ", nombre=" + nombre + ", fundacion=" + fundacion + ", liga=" + liga
				+ "]";
	}

	
}
