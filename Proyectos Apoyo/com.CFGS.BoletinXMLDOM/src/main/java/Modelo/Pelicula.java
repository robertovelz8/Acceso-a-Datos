package Modelo;

import java.util.List;

public class Pelicula {
	private String titulo;
	private String fecha;
	private String director;
	private List<String> actores;

	public Pelicula(String titulo, String fecha, String director, List<String> actores) {
		super();
		this.titulo = titulo;
		this.fecha = fecha;
		this.director = director;
		this.actores = actores;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public List<String> getActores() {
		return actores;
	}

	public void setActores(List<String> actores) {
		this.actores = actores;
	}

}