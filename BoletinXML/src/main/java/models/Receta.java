package models;

import java.util.List;

public class Receta {
	
	//Attribute
	private String titulo;
	private List<String> ingredientes;
	private String procedimiento;
	private String tiempo;
	private List<String> cantidad;
	
	
	//Constructors

	public Receta(String titulo, List<String> ingredientes, String procedimiento, String tiempo,
			List<String> cantidad) {
		super();
		this.titulo = titulo;
		this.ingredientes = ingredientes;
		this.procedimiento = procedimiento;
		this.tiempo = tiempo;
		this.cantidad = cantidad;
	}

	public Receta() {
		super();
	}

	//Getters & Setters
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<String> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(List<String> ingredientes) {
		this.ingredientes = ingredientes;
	}

	public String getProcedimiento() {
		return procedimiento;
	}

	public void setProcedimiento(String procedimiento) {
		this.procedimiento = procedimiento;
	}

	public String getTiempo() {
		return tiempo;
	}

	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}

	public List<String> getCantidad() {
		return cantidad;
	}

	public void setCantidad(List<String> cantidad) {
		this.cantidad = cantidad;
	}
}
