package models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Arbitro {

	//Attributes
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_arbitro")
	private int idArbitro;
	private String nombre;
	private String nacionalidad;
	private String experiencia;
	
	@ManyToMany
	@JoinTable(
		    name = "equipo_partido", 
		    joinColumns = @JoinColumn(name = "id_equipo"), 
		    inverseJoinColumns = @JoinColumn(name = "id_partido")) 
	private List<Partido> partidos;
	

	//Constructors
	public Arbitro(String nombre, String nacionalidad, String experiencia, List<Partido> partidos) {
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.experiencia = experiencia;
		this.partidos = new ArrayList<Partido>();
	}


	public Arbitro() {
	}

	//Getters & Setters
	public int getIdArbitro() {
		return idArbitro;
	}

	public void setIdArbitro(int idArbitro) {
		this.idArbitro = idArbitro;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(String experiencia) {
		this.experiencia = experiencia;
	}


	public List<Partido> getPartidos() {
		return partidos;
	}


	public void setPartidos(List<Partido> partidos) {
		this.partidos = partidos;
	}


	@Override
	public String toString() {
		return "Arbitro [idArbitro=" + idArbitro + ", nombre=" + nombre + ", nacionalidad=" + nacionalidad
				+ ", experiencia=" + experiencia + ", partidos=" + partidos + "]";
	}
	
	

	
}
