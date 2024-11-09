package modelo;

import java.util.Objects;

public class Productos {

	private String nombre;
	private double precio;
	private int cantidad;
	private Categoria categoriaProducto;

	public Productos(String nombre, double precio, int cantidad, Categoria categoriaProducto) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = cantidad;
		this.categoriaProducto = categoriaProducto;
	}

	public Productos() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Categoria getCategoriaProducto() {
		return categoriaProducto;
	}

	public void setCategoriaProducto(Categoria categoriaProducto) {
		this.categoriaProducto = categoriaProducto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cantidad, categoriaProducto, nombre, precio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Productos other = (Productos) obj;
		return cantidad == other.cantidad && categoriaProducto == other.categoriaProducto
				&& Objects.equals(nombre, other.nombre) && precio == other.precio;
	}

	@Override
	public String toString() {
		return "Productos [nombre=" + nombre + ", precio=" + precio + ", cantidad=" + cantidad + ", categoriaProducto="
				+ categoriaProducto + "]";
	}
}