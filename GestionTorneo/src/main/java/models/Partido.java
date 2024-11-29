package models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Partido {
	
	//Attributes
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_partido")
	private int idPartido;
	private String fecha;
	private String resultado;
	private int jornada;
	@ManyToMany
	private List<Arbitro> arbitros;
	

	//Constructors
	public Partido(String fecha, String resultado, int jornada, List<Arbitro> arbitros) {
		super();
		this.fecha = fecha;
		this.resultado = resultado;
		this.jornada = jornada;
		this.arbitros = arbitros;
	}


	public Partido() {
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

	public List<Arbitro> getArbitros() {
		return arbitros;
	}


	public void setArbitros(List<Arbitro> arbitros) {
		this.arbitros = arbitros;
	}


	@Override
	public String toString() {
		return "Partido [idPartido=" + idPartido + ", fecha=" + fecha + ", resultado=" + resultado + ", jornada="
				+ jornada + ", arbitros=" + arbitros + "]";
	}
	
}
