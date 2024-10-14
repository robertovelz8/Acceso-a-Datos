package app;

import java.time.LocalDate;
import java.util.Set;

public class Prestamo {
	
	//Attributes	
	private LocalDate fechaPrestamo;
	private LocalDate fechaDevolucion;
	
	//Permite flexibilidad a la hora de añadir o remover libros y usuarios
	private Set<Libro> libros;
	private Set<Usuario> usuarios;
	
	
	//Constructor
	public Prestamo(LocalDate fechaPrestamo, LocalDate fechaDevolucion, Set<Libro> libros, Set<Usuario> usuarios) {
		this.fechaPrestamo = fechaPrestamo;
		this.fechaDevolucion = fechaDevolucion;
		this.libros = libros;
		this.usuarios = usuarios;
	}


	//Getters & Setters
	public LocalDate getFechaPrestamo() {
		return fechaPrestamo;
	}


	public void setFechaPrestamo(LocalDate fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}


	public LocalDate getFechaDevolucion() {
		return fechaDevolucion;
	}


	public void setFechaDevolucion(LocalDate fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}


	public Set<Libro> getLibros() {
		return libros;
	}


	public void setLibros(Set<Libro> libros) {
		this.libros = libros;
	}


	public Set<Usuario> getUsuarios() {
		return usuarios;
	}


	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	
	
	

}
