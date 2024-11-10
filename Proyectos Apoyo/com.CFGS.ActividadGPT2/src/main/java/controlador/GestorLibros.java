package controlador;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modelo.Genero;
import repositorio.RepositorioLibro;
import utiles.UtilesLibros;

public class GestorLibros {

	private static final Logger logger = LogManager.getLogger(GestorLibros.class);

	public static void main(String[] args) {
		RepositorioLibro rl = new RepositorioLibro();
		UtilesLibros ul = new UtilesLibros(rl);

		// Agregar un libro de ejemplo al catálogo
		rl.agregarLibro("Dragon Ball", "Akira Tori Yama", 41332, Genero.COMEDIA);
		logger.debug("Libros agregados: " + rl.getCatalogoLibros());

		// Cargar libros desde el archivo XML
		ul.cargarLibros();
		logger.debug("Libros cargados desde el archivo XML: " + rl.getCatalogoLibros());

		// Escribir y Guardar el catálogo actualizado en el archivo XML
		ul.escribeCatalogoLibros();

		// Muestra de todos los libros que hay cargados en el archivo XML de "x" genero
		rl.mostrarLibrosPorGenero(Genero.COMEDIA);

		// Muestra de todos los libros que hay cargados en el archivo XML de "x" genero
		rl.mostrarLibrosPorLetra('H');

		ul.escribeCatalogoLibrosFiltradoGenero("catalogoLibrosXMLFiltradoGenero.xml");

		ul.escribeCatalogoLibrosFiltradoLetra("catalogoLibrosFiltradoLetraXML.xml");
	}
}