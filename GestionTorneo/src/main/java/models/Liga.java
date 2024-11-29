package models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_liga")
	private int idLiga;
	private String nombre;
	private String pais;
	private String nivel;
	@OneToMany (mappedBy = "liga", cascade = CascadeType.ALL)
	private List<Equipo> equipos;
	
	@OneToMany (cascade = CascadeType.ALL)
	@JoinColumn(name = "liga_id", referencedColumnName = "id_liga")
	private List<Arbitro> arbitros;
	
	//Constructors
	public Liga(String nombre, String pais, String nivel, List<Equipo> equipos, List<Arbitro> arbitros) {
		super();
		this.nombre = nombre;
		this.pais = pais;
		this.nivel = nivel;
		this.equipos = new ArrayList<Equipo>();
		this.arbitros = new ArrayList<Arbitro>();
	}

	
	public Liga() {
		super();
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

	public List<Arbitro> getArbitros() {
		return arbitros;
	}

	public void setArbitros(List<Arbitro> arbitros) {
		this.arbitros = arbitros;
	}

	@Override
	public String toString() {
		return "Liga [idLiga=" + idLiga + ", nombre=" + nombre + ", pais=" + pais + ", nivel=" + nivel + ", equipos="
				+ equipos + ", arbitros=" + arbitros + "]";
	}

	

}
