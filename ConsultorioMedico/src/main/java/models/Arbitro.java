package models;

import java.util.List;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

public class Arbitro {

	//Attributes
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idArbitro;
	private String nombre;
	private String nacionalidad;
	private String experiencia;
	
	@OneToMany
	private List<Partido> partidos;

	//Constructors
	public Arbitro(int idArbitro, String nombre, String nacionalidad, String experiencia, List<Partido> partidos) {
		super();
		this.idArbitro = idArbitro;
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.experiencia = experiencia;
		this.partidos = partidos;
	}

	public Arbitro(int idArbitro) {
		super();
		this.idArbitro = idArbitro;
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

	//toString
	@Override
	public String toString() {
		return "Arbitro [idArbitro=" + idArbitro + ", nombre=" + nombre + ", nacionalidad=" + nacionalidad
				+ ", experiencia=" + experiencia + ", partidos=" + partidos + "]";
	}
	
	
}
