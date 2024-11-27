package models;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Equipo {
	
	//Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JoinColumn(name = "id_equipo")
	private int idEquipo;
	private String nombre;
	private Date fundacion;
	@ManyToOne 
	private Liga liga;
	@OneToMany (mappedBy = "equipo", cascade = CascadeType.ALL)
	private List<Jugador> jugadores;
	@OneToMany (mappedBy = "partido")
	private List<Partido> partidos;
	@ManyToMany
	@JoinTable(
			name = "equipoEstadio",
			joinColumns = @JoinColumn(name="id_equipo"),
			inverseJoinColumns = @JoinColumn(name="id_estadio"))
	private List<Estadio> estadios;
	
	//Constructors
	public Equipo(int idEquipo, String nombre, Date fundacion, Liga liga, List<Jugador> jugadores,
			List<Partido> partidos, List<Estadio> estadios) {
		super();
		this.idEquipo = idEquipo;
		this.nombre = nombre;
		this.fundacion = fundacion;
		this.liga = liga;
		this.jugadores = jugadores;
		this.partidos = partidos;
		this.estadios = estadios;
	}

	public Equipo(int idEquipo) {
		super();
		this.idEquipo = idEquipo;
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

	public Date getFundacion() {
		return fundacion;
	}

	public void setFundacion(Date fundacion) {
		this.fundacion = fundacion;
	}

	public Liga getLiga() {
		return liga;
	}

	public void setLiga(Liga liga) {
		this.liga = liga;
	}

	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public List<Partido> getPartidos() {
		return partidos;
	}

	public void setPartidos(List<Partido> partidos) {
		this.partidos = partidos;
	}

	public List<Estadio> getEstadios() {
		return estadios;
	}

	public void setEstadios(List<Estadio> estadios) {
		this.estadios = estadios;
	}

	@Override
	public String toString() {
		return "Equipo [idEquipo=" + idEquipo + ", nombre=" + nombre + ", fundacion=" + fundacion + ", liga=" + liga
				+ ", jugadores=" + jugadores + ", partidos=" + partidos + ", estadios=" + estadios + "]";
	}
	
	
	
	
}
