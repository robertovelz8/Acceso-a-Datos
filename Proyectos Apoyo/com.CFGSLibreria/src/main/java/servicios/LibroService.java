package servicios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import excepciones.MiExcepcion;
import modelo.Editorial;
import modelo.GeneroLibro;
import modelo.Libro;
import repositorio.LibroRepositorio;

public class LibroService {
	private static final Logger logger = LogManager.getLogger(LibroService.class);
	private LibroRepositorio repositorio;
	private EditorialService editorialService;

	public LibroService(EditorialService editorialServ) {
		super();
		this.repositorio = new LibroRepositorio();
		this.editorialService = editorialServ;
	}

	public boolean agregaLibro(String isbn, String titulo, String autor, int numeroEjemplares, GeneroLibro genero,
			int anyoPublicacion, String cif, String nombreEditorial) {
		boolean agregado = true;
		try {
			repositorio.agregaLibro(isbn, titulo, autor, numeroEjemplares, genero, anyoPublicacion, cif,
					nombreEditorial);
			editorialService.agregaEditorial(cif, nombreEditorial);
		} catch (MiExcepcion e1) {
			agregado = false;
		}

		return agregado;
	}

	public boolean agregaLibro(String isbn, String titulo, String autor, String cif, String nombreEditorial) {
		boolean agregado = true;
		try {
			repositorio.agregaLibro(isbn, titulo, autor, cif, nombreEditorial);
			editorialService.agregaEditorial(cif, nombreEditorial);
		} catch (MiExcepcion e1) {
			agregado = false;
		}
		return agregado;
	}

	public Libro recuperaLibro(String isbn) {
		Libro libro = null;
		try {
			libro = this.repositorio.buscar(isbn);
		} catch (MiExcepcion e) {
			logger.error(e.getMessage());
		}
		return libro;
	}

	public void imprimeDetalleLibros() {
		for (Libro l : this.repositorio.getLibros()) {
			logger.debug(l.toString());
		}
	}

	public void actualizaUnidadesLibro(String isbn, int numeroUnidades) {
		try {
			this.repositorio.actualizaNumUnidades(isbn, numeroUnidades);
		} catch (MiExcepcion e) {
			logger.error(e.getMessage());
		}
	}

	private List<Libro> getLibrosPorGenero(GeneroLibro genero) {
		List<Libro> listaFiltrada = new ArrayList<Libro>();
		Iterator<Libro> it = this.repositorio.getLibros().iterator();

		while (it.hasNext()) {
			Libro l = it.next();
			if (l.getGenero().equals(genero)) {
				listaFiltrada.add(l);
			}
		}
		return listaFiltrada;
	}

	public List<Libro> obtenerLibrosPorCif(String cif) {
		List<Libro> librosPorCif = new ArrayList<>();
		for (Libro libro : this.repositorio.getLibros()) {
			if (libro.getEditorial().getCif().equalsIgnoreCase(cif)) {
				librosPorCif.add(libro);
			}
		}
		return librosPorCif;
	}

	public List<Editorial> obtenerEditorialesOrdenadasPorNumeroLibros() {
		Map<Editorial, Integer> contadorLibros = new HashMap<>();

		for (Libro libro : this.repositorio.getLibros()) {
			contadorLibros.put(libro.getEditorial(), contadorLibros.getOrDefault(libro.getEditorial(), 0) + 1);
		}

		List<Editorial> listaEditoriales = new ArrayList<>(contadorLibros.keySet());
		Collections.sort(listaEditoriales, (e1, e2) -> {
			int cmp = Integer.compare(contadorLibros.get(e2), contadorLibros.get(e1));
			return cmp != 0 ? cmp : e1.getNombre().compareTo(e2.getNombre());
		});

		return listaEditoriales;
	}

	public Map<GeneroLibro, List<Libro>> MapaLibrosSegunGenero() {
		Map<GeneroLibro, List<Libro>> mapa = new HashMap<GeneroLibro, List<Libro>>();

		for (GeneroLibro genero : GeneroLibro.values()) {
			mapa.put(genero, this.getLibrosPorGenero(genero));
		}
		return mapa;
	}
}