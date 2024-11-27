package models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Partido {
	
	//Attributes
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JoinColumn(name = "id_partido")
	private int idPartido;
	private String fecha;
	private String resultado;
	private int jornada;
	
	@OneToMany (mappedBy = "partido")
	private List<Equipo> equipos;
	
	@OneToOne
	private Partido partido;

	//Constructors
	public Partido(int idPartido, String fecha, String resultado, int jornada, List<Equipo> equipos, Partido partido) {
		super();
		this.idPartido = idPartido;
		this.fecha = fecha;
		this.resultado = resultado;
		this.jornada = jornada;
		this.equipos = equipos;
		this.partido = partido;
	}

	public Partido(int idPartido) {
		super();
		this.idPartido = idPartido;
	}

	//Getters & Setters
	public int getIdPartido() {
		return idPartido;
	}

	public void setIdPartido(int idPartido) {
		this.idPartido = idPartido;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public int getJornada() {
		return jornada;
	}

	public void setJornada(int jornada) {
		this.jornada = jornada;
	}

	public List<Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(List<Equipo> equipos) {
		this.equipos = equipos;
	}

	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}

	@Override
	public String toString() {
		return "Partido [idPartido=" + idPartido + ", fecha=" + fecha + ", resultado=" + resultado + ", jornada="
				+ jornada + ", equipos=" + equipos + ", partido=" + partido + "]";
	}
	
	
}
