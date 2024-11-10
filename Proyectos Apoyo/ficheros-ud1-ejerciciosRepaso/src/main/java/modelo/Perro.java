package modelo;

import java.util.Comparator;

import com.google.gson.annotations.Expose;

/**
 * Clase que representa a una persona con un nombre y una lista de notas.
 */
//Para comparar nombres usamos Comparator en una clase externa en utilidades
public class Perro implements Comparable<Perro>{
	/**
	 * Identificador del perro.
	 */
	@Expose
	private String identificador;

	/**
	 * Nombre del perro.
	 */
	@Expose
	private String nombre;

	/**
	 * Sexo del perro.
	 */
	@Expose
	private String sexo;

	/**
	 * Raza del perro.
	 */
	@Expose
	private String raza;

	/**
	 * Color del perro.
	 */
	@Expose
	private String color;

	/**
	 * Edad del perro.
	 */
	@Expose
	private int edad;

	/**
	 * Peso del perro.
	 */
	@Expose
	private int peso;

	/**
	 * Perro vacunado: true or false
	 */
	private boolean vacunado;

	/**
	 * 
	 */
	public Perro() {
		super();
	}

	/**
	 * @param identificador
	 * @param nombre
	 * @param sexo
	 * @param raza
	 * @param color
	 * @param edad
	 * @param peso
	 */
	public Perro(String identificador, String nombre, String sexo, String raza, String color, int edad, int peso,
			boolean vacunado) {
		super();
		this.identificador = identificador;
		this.nombre = nombre;
		this.sexo = sexo;
		this.raza = raza;
		this.color = color;
		this.edad = edad;
		this.peso = peso;
		this.vacunado = true;
	}

	/**
	 * @return the identificador
	 */
	public String getIdentificador() {
		return identificador;
	}

	/**
	 * @param identificador the identificador to set
	 */
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the sexo
	 */
	public String getSexo() {
		return sexo;
	}

	/**
	 * @param sexo the sexo to set
	 */
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	/**
	 * @return the raza
	 */
	public String getRaza() {
		return raza;
	}

	/**
	 * @param raza the raza to set
	 */
	public void setRaza(String raza) {
		this.raza = raza;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the edad
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * @param edad the edad to set
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}

	/**
	 * @return the peso
	 */
	public int getPeso() {
		return peso;
	}

	/**
	 * @param peso the peso to set
	 */
	public void setPeso(int peso) {
		this.peso = peso;
	}

	/**
	 * @return the vacunado
	 */
	public boolean isVacunado() {
		return vacunado;
	}

	/**
	 * @param vacunado the vacunado to set
	 */
	public void setVacunado(boolean vacunado) {
		this.vacunado = vacunado;
	}

	public String toString() {
		return "Perro [identificador=" + identificador + ", nombre=" + nombre + ", sexo=" + sexo + ", raza=" + raza
				+ ", color=" + color + ", edad=" + edad + ", peso=" + peso + ", vacunado=" + vacunado + "]";
	}

	//Utilizamos el compareTo al implementar Comparable para ordenar por edad. COMPARETO SOLO USA INT PARA COMPARAR Y DEVOLVER
	@Override
	public int compareTo(Perro o) {
		return Integer.compare(this.getEdad(), o.getEdad());
	}
	//Usamos Compare al implementar Comparator para ordenar por otras cosas, como String. Esto lo debemos hacer en una clase externa.  
	/*@Override
	public int compare(Perro o1, Perro o2) {
		return o1.getNombre().compareTo(o2.getNombre());
		 
	}*/

	/*
	 * Para JSON: Usa .excludeFieldsWithoutExposeAnnotation() con Gson o @Expose
	 * para controlar la inclusión de campos. Para XML: Usa anotaciones
	 * como @XmlTransient con JAXB o @JsonIgnore con Jackson. Para CSV: Usa
	 * anotaciones como @CsvIgnore con OpenCSV o @JsonIgnore con Jackson CSV.
	 */
}
