package ud3;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Sala {
	
	//Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int capacidad;
	private String nombre;
	
	@OneToMany(mappedBy = "sala", cascade = CascadeType.ALL)
	private List<Reunion> reuniones;
	
	//Constructor
	public Sala() {
	}

	public Sala(String nombre, int capacidad) {
		this.nombre = nombre;
		this.capacidad = capacidad;
		this.reuniones = new ArrayList<Reunion>();
	}



	//Getters & Setters
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Reunion> getReuniones() {
		return reuniones;
	}

	public void setReuniones(List<Reunion> reuniones) {
		this.reuniones = reuniones;
	}

	@Override
	public String toString() {
		return "Sala [id=" + id + ", capacidad=" + capacidad + ", nombre=" + nombre + ", reuniones=" + this.reuniones + "]";
	}
	
	public void addReunion (Reunion r) {
		this.reuniones.add(r);
		r.setSala(this);
	}
	
}
