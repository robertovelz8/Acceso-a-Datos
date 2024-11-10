package repositorio;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import excepciones.MiExcepcion;
import modelo.GeneroLibro;
import modelo.Libro;

public class LibroRepositorio {
	private Set<Libro> libros ;

	public LibroRepositorio() {
		super();
		this.libros = new HashSet<Libro>();
	}
	
	public Libro buscar(String isbn) throws MiExcepcion
	{
		Libro devuelto = null;
		Libro l1 = new Libro(isbn);
		if(!libros.contains(l1))
		{
			throw new MiExcepcion("Excepción buscando libro:"+isbn);
		}
		else
		{
			boolean encontrado = false;
			Iterator<Libro> it = libros.iterator();
	
			while(it.hasNext() && !encontrado)
			{
				devuelto = it.next();
				if(devuelto.equals(l1))
				{
					encontrado  = true;
				}
			}
			if(!encontrado)
			{
				throw new MiExcepcion("Excepción buscando libro:"+isbn);
			}
		}
		
		return devuelto;
	}
	
	public void elimina(String isbn) throws MiExcepcion
	{
		Libro l1 = new Libro(isbn);
		if(!this.libros.remove(l1))
		{
			throw new MiExcepcion("Error al eliminar elemento: "+isbn);
		}
	}
	
	public void agregaLibro(String isbn, String titulo, String autor, int numUnidades, GeneroLibro genero, int anyo, String cif, String nombreEditorial) throws MiExcepcion
	{
		Libro l1 = new Libro(isbn, titulo, autor, numUnidades, genero, anyo,cif, nombreEditorial);
		if(!this.libros.contains(l1))
		{
			this.libros.add(l1);
		}
		else
		{
			throw new MiExcepcion("Error al agregar elemento: "+isbn);
		}
	}
	
	
	public void agregaLibro(String isbn, String titulo, String autor, String cifEditorial, String nombreEditorial) throws MiExcepcion
	{
		Libro l1 = new Libro(isbn, titulo, autor,cifEditorial, nombreEditorial);
		if(!this.libros.contains(l1))
		{
			this.libros.add(l1);
		}
		else
		{
			throw new MiExcepcion("Error al agregar elemento: "+isbn);
		}
	}
	
	public void actualizaNumUnidades(String isbn, int unidades) throws MiExcepcion
	{
		
		Libro l1 = new Libro(isbn);
		if(this.libros.contains(l1))
		{
			l1 = this.buscar(isbn);
			l1.setNumeroEjemplares(unidades);
			this.libros.add(l1); // Como ya existía me lo va a actualizar
		}
		else
		{
			throw new MiExcepcion("Error al agregar elemento: "+isbn);
		}
	}
	
	public Set<Libro> getLibros()
	{
		return this.libros;
	}
	
}
