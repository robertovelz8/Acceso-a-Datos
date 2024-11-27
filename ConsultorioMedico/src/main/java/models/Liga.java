package models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Liga {
	
	//Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JoinColumn(name = "id_liga")
	private int idLiga;
	private String nombre;
	private String pais;
	private String nivel;
	@OneToMany (mappedBy = "liga", cascade = CascadeType.ALL)
	private List<Equipo> equipos;
	@OneToMany (mappedBy = "liga", cascade = CascadeType.ALL)
	private List<Partido> partidos;
	
	//Constructors
	public Liga(int idLiga, String nombre, String pais, String nivel, List<Equipo> equipos, List<Partido> partidos) {
		super();
		this.idLiga = idLiga;
		this.nombre = nombre;
		this.pais = pais;
		this.nivel = nivel;
		this.equipos = equipos;
		this.partidos = partidos;
	}

	public Liga(int idLiga) {
		super();
		this.idLiga = idLiga;
	}

	//Getters & Setters
	
	public int getIdLiga() {
		return idLiga;
	}

	public void setIdLiga(int idLiga) {
		this.idLiga = idLiga;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public List<Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(List<Equipo> equipos) {
		this.equipos = equipos;
	}

	public List<Partido> getPartidos() {
		return partidos;
	}

	public void setPartidos(List<Partido> partidos) {
		this.partidos = partidos;
	}

	@Override
	public String toString() {
		return "Liga [idLiga=" + idLiga + ", nombre=" + nombre + ", pais=" + pais + ", nivel=" + nivel + ", equipos="
				+ equipos + ", partidos=" + partidos + "]";
	}
	
	
	
	
	
	
	
	
	
}
