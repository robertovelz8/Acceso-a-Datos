package models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Jugador {
	
	//Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_jugador")
	private int idJugador;
	private String nombre;
	private String posicion;
	private String fechaNacimiento;
	private int dorsal;
	


	//Constructors
	public Jugador(String nombre, String posicion, String fechaNacimiento, int dorsal) {
		this.nombre = nombre;
		this.posicion = posicion;
		this.fechaNacimiento = fechaNacimiento;
		this.dorsal = dorsal;

	}

	
	public Jugador() {
	}

	//Getters & Setters
	public int getIdJugador() {
		return idJugador;
	}

	public void setIdJugador(int idJugador) {
		this.idJugador = idJugador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}


	@Override
	public String toString() {
		return "Jugador [idJugador=" + idJugador + ", nombre=" + nombre + ", posicion=" + posicion
				+ ", fechaNacimiento=" + fechaNacimiento + ", dorsal=" + dorsal + "]";
	}

	
	
	
}
