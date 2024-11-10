package repositorio;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modelo.Genero;
import modelo.Libro;

public class RepositorioLibro {

	private static final Logger logger = LogManager.getLogger(RepositorioLibro.class);
	private List<Libro> catalogoLibros = new ArrayList<>();
	private List<Libro> catalogoLibrosFiltradosGenero = new ArrayList<>();
	private List<Libro> catalogoLibrosFiltradosLetra = new ArrayList<>();

	// Nos permite obtener los estudiates de nuestra lista de estudiantes
	public List<Libro> getCatalogoLibros() {
		return catalogoLibros;
	}

	public List<Libro> getCatalogoLibrosFiltradosGenero() {
		return catalogoLibrosFiltradosGenero;
	}

	public List<Libro> getCatalogoLibrosFiltradosLetra() {
		return catalogoLibrosFiltradosLetra;
	}

	// Agrega Esudiantes a la lista que luego se cargara en el XML
	public void agregarLibro(String titulo, String autor, int iSBN, Genero generolibro) {
		Libro e1 = new Libro(titulo, autor, iSBN, generolibro);
		this.catalogoLibros.add(e1);
	}

	public void mostrarLibrosPorGenero(Genero genero) {
		for (Libro libro : catalogoLibros) {
			if (libro.getGeneroLibro().equals(genero)) {
				catalogoLibrosFiltradosGenero.add(libro);
				logger.debug(libro);
			}
		}
	}

	public void mostrarLibrosPorLetra(Character letra) {
		char letraMayuscula = Character.toUpperCase(letra);
		for (Libro libro : catalogoLibros) {
			if (libro.getTitulo().toUpperCase().charAt(0) == letraMayuscula) {
				catalogoLibrosFiltradosLetra.add(libro);
				logger.debug(libro);
			}
		}
	}
}
