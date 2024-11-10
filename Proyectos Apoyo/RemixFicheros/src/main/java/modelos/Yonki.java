package modelos;

public class Yonki {
	public enum Genero{HOMBRE, MUJER}
	private int detenciones;
	private String nombre;
	private int edad;
	private String ciudadDeProcedencia;
	private String adiccion;
	private boolean proyectoHombre;
	private double dineroInvertido;
	private Genero genero;
	
	public Yonki() {
		
	}
	
	public Yonki(int detenciones, String nombre, int edad, String ciudadDeProcedencia, String adiccion,
			boolean proyectoHombre, double dineroInvertido, modelos.Yonki.Genero genero) {
		super();
		this.detenciones = detenciones;
		this.nombre = nombre;
		this.edad = edad;
		this.ciudadDeProcedencia = ciudadDeProcedencia;
		this.adiccion = adiccion;
		this.proyectoHombre = proyectoHombre;
		this.dineroInvertido = dineroInvertido;
		this.genero = genero;
	}

	public int getDetenciones() {
		return detenciones;
	}

	public void setDetenciones(int detenciones) {
		this.detenciones = detenciones;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getCiudadDeProcedencia() {
		return ciudadDeProcedencia;
	}

	public void setCiudadDeProcedencia(String ciudadDeProcedencia) {
		this.ciudadDeProcedencia = ciudadDeProcedencia;
	}

	public String getAdiccion() {
		return adiccion;
	}

	public void setAdiccion(String adiccion) {
		this.adiccion = adiccion;
	}

	public boolean isProyectoHombre() {
		return proyectoHombre;
	}

	public void setProyectoHombre(boolean proyectoHombre) {
		this.proyectoHombre = proyectoHombre;
	}

	public double getDineroInvertido() {
		return dineroInvertido;
	}

	public void setDineroInvertido(double dineroInvertido) {
		this.dineroInvertido = dineroInvertido;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	
	
}
