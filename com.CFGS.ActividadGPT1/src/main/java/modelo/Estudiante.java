package modelo;

public class Estudiante {

	private String nombre;
	private int edad;
	private String idEstudiante;
	private String curso;

	public Estudiante(String nombre, int edad, String idEstudiante, String curso) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.idEstudiante = idEstudiante;
		this.curso = curso;
	}

	public Estudiante() {
		super();
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

	public String getIdEstudiante() {
		return idEstudiante;
	}

	public void setIdEstudiante(String idEstudiante) {
		this.idEstudiante = idEstudiante;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	@Override
	public String toString() {
		return "Estudiante [nombre=" + nombre + ", edad=" + edad + ", idEstudiante=" + idEstudiante + ", curso=" + curso
				+ "]";
	}
}