package models;

import java.util.Objects;

public class Criatura {
	
	//Attributes
	private String nombre;
	private Tipo tipo;
	private boolean inmortal;
	private int magia;
	private int peligrosidad;
	
	//Constructors
	public Criatura(String nombre, Tipo tipo, boolean inmortal, int magia, int peligrosidad) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.inmortal = inmortal;
		this.magia = magia;
		this.peligrosidad = peligrosidad;
	}
	public Criatura(String nombre, Tipo tipo) {
		this.nombre = nombre;
		this.tipo = tipo;
	}
	
	
	public Criatura() {
		super();
	}
	//Getters & Setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	public boolean isInmortal() {
		return inmortal;
	}
	public void setInmortal(boolean inmortal) {
		this.inmortal = inmortal;
	}
	public int getMagia() {
		return magia;
	}
	public void setMagia(int magia) {
		this.magia = magia;
	}
	public int getPeligrosidad() {
		return peligrosidad;
	}
	public void setPeligrosidad(int peligrosidad) {
		this.peligrosidad = peligrosidad;
	}
	
	//HashCode & Equals
	@Override
	public int hashCode() {
		return Objects.hash(nombre, tipo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Criatura other = (Criatura) obj;
		return Objects.equals(nombre, other.nombre) && tipo == other.tipo;
	}
	
	//toString
	@Override
	public String toString() {
		return "Criatura [nombre=" + nombre + ", tipo=" + tipo + ", inmortal=" + inmortal + ", magia=" + magia
				+ ", peligrosidad=" + peligrosidad + "]";
	}
	
}
