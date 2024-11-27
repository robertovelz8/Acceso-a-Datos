package models;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Jugador {
	
	//Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JoinColumn(name = "id_jugador")
	private int idJugador;
	private String nombre;
	private String posicion;
	private Date fechaNacimiento;
	private int dorsal;
	
	@ManyToOne
	private Equipo equipo;

	//Constructors
	public Jugador(int idJugador, String nombre, String posicion, Date fechaNacimiento, int dorsal, Equipo equipo) {
		super();
		this.idJugador = idJugador;
		this.nombre = nombre;
		this.posicion = posicion;
		this.fechaNacimiento = fechaNacimiento;
		this.dorsal = dorsal;
		this.equipo = equipo;
	}

	public Jugador(int idJugador) {
		super();
		this.idJugador = idJugador;
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

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	@Override
	public String toString() {
		return "Jugador [idJugador=" + idJugador + ", nombre=" + nombre + ", posicion=" + posicion
				+ ", fechaNacimiento=" + fechaNacimiento + ", dorsal=" + dorsal + ", equipo=" + equipo + "]";
	}
	
	
	
}
