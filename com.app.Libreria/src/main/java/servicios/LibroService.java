package servicios;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import excepciones.MiExcepcion;
import modelo.GeneroLibro;
import modelo.Libro;
import repositorio.EditorialRepositorio;
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

	
	public void actualizaUnidadesLibro(String isbn, int numeroUnidades)
	{
		try {
			this.repositorio.actualizaNumUnidades(isbn, numeroUnidades);
		} catch (MiExcepcion e) {
			logger.error( e.getMessage());
		}
	}
}
