package Modelo;

public class Productos {

	private String nombre;
	private float precio;
	private int strock;

	public Productos(String nombre, float precio, int strock) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.strock = strock;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getStrock() {
		return strock;
	}

	public void setStrock(int strock) {
		this.strock = strock;
	}

}