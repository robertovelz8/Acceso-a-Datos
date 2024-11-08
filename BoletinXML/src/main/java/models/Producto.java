package models;

public class Producto {
	
	//Attributes
	private String nombre;
	private double precio;
	private int stock;
	private int id;
	private boolean aLaVenta;
	
	//Constructors
	

	public Producto() {
		super();
	}

	public Producto(String nombre, double precio, int stock, int id, boolean aLaVenta) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
		this.id = id;
		this.aLaVenta = aLaVenta;
	}

	//Getters & Setters
	
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

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isaLaVenta() {
		return aLaVenta;
	}

	public void setaLaVenta(boolean aLaVenta) {
		this.aLaVenta = aLaVenta;
	}

	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", precio=" + precio + ", stock=" + stock + "]";
	}
	
	
	

}
