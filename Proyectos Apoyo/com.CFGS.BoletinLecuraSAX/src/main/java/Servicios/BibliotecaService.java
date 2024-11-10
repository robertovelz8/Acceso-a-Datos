package Servicios;

import java.util.List;

import Modelo.Biblioteca;
import Modelo.Libros;
import Utilidades.BibliotecaXMLUtil;

public class BibliotecaService {
	public Biblioteca biblioteca;

	public BibliotecaService() {
		biblioteca = new Biblioteca();
	}

	/**
	 * Carga los libros desde el archivo XML y los almacena en el objeto Biblioteca.
	 * 
	 * @param rutaArchivo Ruta del archivo XML a cargar.
	 */
	public void cargaBiblioteca(String rutaArchivo) {
		BibliotecaXMLUtil xmlUtil = new BibliotecaXMLUtil();
		List<Libros> libros = xmlUtil.getModeloFromXML(rutaArchivo);
		for (Libros libro : libros) {
			biblioteca.addLibro(libro);
		}
	}

	/**
	 * Ordena los libros por título.
	 */
	public void ordenarLibrosPorTitulo() {
		biblioteca.ordenarLibrosPorTitulo();
	}

	/**
	 * Filtra los libros que tienen un precio menor al especificado.
	 * 
	 * @param maxPrecio Precio máximo.
	 * @return Lista de libros con precio menor al especificado.
	 */
	public List<Libros> filtrarLibrosPorPrecio(double maxPrecio) {
		return biblioteca.filtrarLibrosPorPrecio(maxPrecio);
	}
}