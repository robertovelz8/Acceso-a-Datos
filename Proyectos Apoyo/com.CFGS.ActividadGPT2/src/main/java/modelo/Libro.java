package modelo;

import java.util.Objects;

public class Libro {

	private String titulo;
	private String autor;
	private int ISBN;
	private Genero generoLibro;

	public Libro(String titulo, String autor, int ISBN, Genero generoLibro) {
		this.titulo = titulo;
		this.autor = autor;
		this.ISBN = ISBN;
		this.generoLibro = generoLibro;
	}

	public Libro() {
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

	public int getISBN() {
		return ISBN;
	}

	public void setISBN(int ISBN) {
		this.ISBN = ISBN;
	}

	public Genero getGeneroLibro() {
		return generoLibro;
	}

	public void setGeneroLibro(Genero generoLibro) {
		this.generoLibro = generoLibro;
	}

	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", autor=" + autor + ", ISBN=" + ISBN + ", generoLibro=" + generoLibro + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(ISBN, autor, generoLibro, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return ISBN == other.ISBN && Objects.equals(autor, other.autor) && generoLibro == other.generoLibro
				&& Objects.equals(titulo, other.titulo);
	}
}