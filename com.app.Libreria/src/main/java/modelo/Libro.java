package modelo;

import java.util.Objects;

public class Libro {
	private String isbn;
	private String titulo;
	private String autor;
	private int numeroEjemplares;
	private GeneroLibro genero;
	private int anyoPublicacion;
	private Editorial editorial;
	
	
	public Libro(String isbn) {
		super();
		this.isbn = isbn;
	}
	
	
		
	public Libro(String isbn, String titulo, String autor, int numeroEjemplares, GeneroLibro genero,
			int anyoPublicacion, Editorial e) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.numeroEjemplares = numeroEjemplares;
		this.genero = genero;
		this.anyoPublicacion = anyoPublicacion;
		this.editorial = e;
	}

	
	public Libro(String isbn, String titulo, String autor,  String cif) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = new Editorial(cif);
	}

	public Libro(String isbn, String titulo, String autor,  String cif, String nombreEditorial) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = new Editorial(cif, nombreEditorial);
	}
	
public Libro(String isbn, String titulo, String autor, int numeroEjemplares, GeneroLibro genero,
		int anyoPublicacion, String cifEditorial) {
	super();
	this.isbn = isbn;
	this.titulo = titulo;
	this.autor = autor;
	this.numeroEjemplares = numeroEjemplares;
	this.genero = genero;
	this.anyoPublicacion = anyoPublicacion;
	Editorial e = new Editorial(cifEditorial);
	this.editorial = e;
}

public Libro(String isbn, String titulo, String autor, int numeroEjemplares, GeneroLibro genero,
		int anyoPublicacion, String cifEditorial, String nombre) {
	super();
	this.isbn = isbn;
	this.titulo = titulo;
	this.autor = autor;
	this.numeroEjemplares = numeroEjemplares;
	this.genero = genero;
	this.anyoPublicacion = anyoPublicacion;
	Editorial e = new Editorial(cifEditorial, nombre);
	this.editorial = e;
}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
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



	public int getNumeroEjemplares() {
		return numeroEjemplares;
	}



	public void setNumeroEjemplares(int numeroEjemplares) {
		this.numeroEjemplares = numeroEjemplares;
	}



	public GeneroLibro getGenero() {
		return genero;
	}



	public void setGenero(GeneroLibro genero) {
		this.genero = genero;
	}



	public int getAnyoPublicacion() {
		return anyoPublicacion;
	}



	public void setAnyoPublicacion(int anyoPublicacion) {
		this.anyoPublicacion = anyoPublicacion;
	}



	@Override
	public String toString() {
		return "Libro [isbn=" + isbn + ", titulo=" + titulo + ", autor=" + autor + ", numeroEjemplares="
				+ numeroEjemplares + ", genero=" + genero + ", anyoPublicacion=" + anyoPublicacion + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(isbn);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return Objects.equals(isbn, other.isbn);
	}
	

}
