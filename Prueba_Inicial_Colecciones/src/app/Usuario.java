package app;

public class Usuario {
	
	//Attributes
	private String id;
	private String nombre;
	private String apellidos;
	private String correoElectronico;
	private String numeroTelefonico;
	
	//Constructor
	public Usuario(String id, String nombre, String apellidos, String correoElectronico, String numeroTelefonico) {
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.correoElectronico = correoElectronico;
		this.numeroTelefonico = numeroTelefonico;
	} 
	
	
	//Getters & Setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getNumeroTelefonico() {
		return numeroTelefonico;
	}

	public void setNumeroTelefonico(String numeroTelefonico) {
		this.numeroTelefonico = numeroTelefonico;
	}
	
	//Methods 
	
	public String calculaId() {
		return null;
	}
	
	
	
	
	
	

}
