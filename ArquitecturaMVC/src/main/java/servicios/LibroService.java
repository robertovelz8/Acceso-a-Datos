package servicios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import excepciones.MiExcepcion;
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
			int anyoPublicacion, String cif, String nombreEditorial)
	{
		boolean agregado = true;
		try {
			repositorio.agregaLibro(isbn, titulo, autor, numeroEjemplares, genero, anyoPublicacion, cif, nombreEditorial);
			editorialService.agregaEditorial(cif, nombreEditorial);
		} catch (MiExcepcion e1) {
			agregado = false;
		}
		
		return agregado;
	}

	public boolean agregaLibro(String isbn, String titulo, String autor, String cif, String nombreEditorial)
	{
		boolean agregado = true;
		try {
			repositorio.agregaLibro(isbn, titulo, autor, cif, nombreEditorial);
			editorialService.agregaEditorial(cif, nombreEditorial);
		} catch (MiExcepcion e1) {
			agregado = false;
		}
		return agregado;
	}
	
	public Libro recuperaLibro(String isbn)
	{
		Libro libro = null;
		try {
			libro = this.repositorio.buscar(isbn);
		} catch (MiExcepcion e) {
			// TODO Auto-generated catch block
			logger.error( e.getMessage());
		}
		return libro;
	}
	
	public void imprimeDetalleLibros()
	{
		for(Libro l: this.repositorio.getLibros())
		{
			logger.debug(l.toString());
		}
	}

	
	public void eliminaLibro(String isbn)
	{
		try {
			this.repositorio.elimina(isbn);
		} catch (MiExcepcion e) {
			logger.error( e.getMessage());
		}
	}
	
	public List<Libro> getLibroPorGenero(GeneroLibro genero) {
        List<Libro> librosPorGenero = new ArrayList<>();
        for (Libro libro : this.repositorio.getLibros()) {
            if (libro.getGenero().equals(genero)) {
                librosPorGenero.add(libro);
            }
        }
        return librosPorGenero;
	}
	
	public List<Libro> getLibroPorCifEditoriaLibros (String cif) {
		List<Libro> librosPorCifEditorial = new ArrayList<Libro>();
		for (Libro libro : this.repositorio.getLibros()) {
			if (libro.getEditorial().getCif().equals(cif)) {
				librosPorCifEditorial.add(libro);
			}
		}
		return librosPorCifEditorial;
	}
	
	private List<Libro> getListaLibrosGenero (GeneroLibro genero) {
		List<Libro> libros = new ArrayList<Libro>();
		Iterator<Libro> it = this.repositorio.getLibros().iterator();
		while (it.hasNext()) {
			Libro l = it.next();
			if(l.getGenero().equals(genero)) {
				libros.add(l);
			}
		}
		return libros;
	}
	
	public Map<GeneroLibro, List<Libro>> calculaMapaGeneros() {
		Map<GeneroLibro, List<Libro>> mapa = new HashMap<GeneroLibro, List<Libro>>();
		
		for (GeneroLibro genero : GeneroLibro.values()) {
			mapa.put(genero, this.getLibroPorGenero(genero));
		}
		return mapa;
	}
	
	
}
