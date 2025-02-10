package models;

import java.time.LocalDate;

public class Partida {
	
	//Attributes
	private int id;
	private Jugador narrador;
	private LocalDate fecha;
	private Resultado resultado;
	
	//Constructors
	public Partida(int id, Jugador narrador, LocalDate fecha, Resultado resultado) {
		this.id = id;
		this.narrador = narrador;
		this.fecha = fecha;
		this.resultado = resultado;
	}

	public Partida() {
	}

	//Getters & Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Jugador getNarrador() {
		return narrador;
	}

	public void setNarrador(Jugador narrador) {
		this.narrador = narrador;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Resultado getResultado() {
		return resultado;
	}

	public void setResultado(Resultado resultado) {
		this.resultado = resultado;
	}

	@Override
	public String toString() {
		return "Partida [id=" + id + ", narrador=" + narrador + ", fecha=" + fecha + ", resultado=" + resultado + "]";
	}
	
	
	
	
}
