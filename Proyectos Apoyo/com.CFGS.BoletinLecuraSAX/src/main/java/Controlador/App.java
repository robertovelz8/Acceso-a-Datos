package Controlador;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Modelo.Libros;
import Servicios.BibliotecaService;

public class App {

	private static final Logger logger = LogManager.getLogger(App.class);

	public static void main(String[] args) {
		BibliotecaService servicioBiblioteca = new BibliotecaService();

		// Ruta relativa del archivo XML
		String rutaArchivo = "src/main/resources/biblioteca.xml";

		// Cargar la biblioteca desde el archivo XML
		servicioBiblioteca.cargaBiblioteca(rutaArchivo);

		// Ordenar los libros por título y mostrar los resultados
		servicioBiblioteca.ordenarLibrosPorTitulo();
		for (Libros libro : servicioBiblioteca.biblioteca.getLibros()) {
			logger.debug("Título: " + libro.getTitulo());
		}

		// Filtrar libros por precio y mostrar los resultados
		double precioMaximo = 20.0;
		List<Libros> librosFiltrados = servicioBiblioteca.filtrarLibrosPorPrecio(precioMaximo);
		logger.debug("\nLibros con precio menor a " + precioMaximo + ":");
		for (Libros libro : librosFiltrados) {
			logger.debug("Título: " + libro.getTitulo() + ", Precio: " + libro.getPrecio());
		}
	}
}
