package app;

import java.util.Set;

public class Libro {
	
	//Attributes
	private int id;
	private String titulo;
	private String autor;
	private  int anioPublicacion;
	private GeneroLibro genero;
	private int ejemplaresDisponibles;
	
	//Constructors
	
	public Libro() {
		
	}
	
	public Libro(int id, String titulo, String autor, int anioPublicacion, GeneroLibro genero,
			int ejemplaresDisponibles) {
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.anioPublicacion = anioPublicacion;
		this.genero = genero;
		this.ejemplaresDisponibles = ejemplaresDisponibles;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getAnioPublicacion() {
		return anioPublicacion;
	}

	public void setAnioPublicacion(int anioPublicacion) {
		this.anioPublicacion = anioPublicacion;
	}

	public GeneroLibro getGenero() {
		return genero;
	}

	public void setGenero(GeneroLibro genero) {
		this.genero = genero;
	}

	public int getEjemplaresDisponibles() {
		return ejemplaresDisponibles;
	}

	public void setEjemplaresDisponibles(int ejemplaresDisponibles) {
		this.ejemplaresDisponibles = ejemplaresDisponibles;
	}
	
	enum GeneroLibro {
		INFANTIL,
		DRAMA,
		ROMANTICO,
		TERROR,
		HISTORICO
	}
	
	//Methods

	/*
	 * 	public Libro agregarLibro(int id, String titulo, String autor, int anioPublicacion, GeneroLibro genero,
			int ejemplaresDisponibles) {
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.anioPublicacion = anioPublicacion;
		this.genero = genero;
		this.ejemplaresDisponibles = ejemplaresDisponibles;

		return null;
	}
	 */

	

}
