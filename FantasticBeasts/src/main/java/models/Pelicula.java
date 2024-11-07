package models;

public class Pelicula {
	
	//Attributes
	private String identificador;
	private String nombreApellido;
	private int edad;
	private String empresa;
	private PuestoTrabajo puesto;
	
	
	//Constructor
	public Pelicula(String identificador, String nombreApellido, int edad, String empresa, PuestoTrabajo puesto) {
		this.identificador = identificador;
		this.nombreApellido = nombreApellido;
		this.edad = edad;
		this.empresa = empresa;
		this.puesto = puesto;
	}

	public Pelicula() {
		this.puesto = new PuestoTrabajo();
	}

	//Getters & Setters
	public String getNombreApellido() {
		return nombreApellido;
	}
	
	public PuestoTrabajo getPuesto() {
		return puesto;
	}

	public void setPuesto(PuestoTrabajo puesto) {
		this.puesto = puesto;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public void setNombreApellido(String nombreApellido) {
		this.nombreApellido = nombreApellido;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public String getEmpresa() {
		return empresa;
	}


	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	@Override
	public String toString() {
		return "Empleado [identificador=" + identificador + ", nombreApellido=" + nombreApellido + ", edad=" + edad
				+ ", empresa=" + empresa + ", puesto=" + puesto + "]";
	}
	
	
	
}
