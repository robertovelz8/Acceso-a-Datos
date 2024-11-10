package Modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Biblioteca {
	private List<Libros> libros;

	public Biblioteca() {
		libros = new ArrayList<>();
	}

	public void addLibro(Libros libro) {
		libros.add(libro);
	}

	public List<Libros> getLibros() {
		return libros;
	}

	public void ordenarLibrosPorTitulo() {
		Collections.sort(libros, new Comparator<Libros>() {
			@Override
			public int compare(Libros l1, Libros l2) {
				return l1.getTitulo().compareTo(l2.getTitulo());
			}
		});
	}

	public List<Libros> filtrarLibrosPorPrecio(double maxPrecio) {
		List<Libros> librosFiltrados = new ArrayList<>();
		for (Libros libro : libros) {
			if (libro.getPrecio() < maxPrecio) {
				librosFiltrados.add(libro);
			}
		}
		return librosFiltrados;
	}
}