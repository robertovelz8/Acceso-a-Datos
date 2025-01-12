package modelos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Autor {

	//Attributes
	@Id
	private String dni;
	private String nombre;
	private String email;
	
	@ManyToMany (mappedBy = "autores", fetch = FetchType.EAGER)
	private List<Articulo> articulos = new ArrayList<Articulo>();

	//Constructors
	public Autor(String dni, String nombre, String email) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.email = email;
	}

	public Autor () {
		super();
	}
	
	public Autor(String dni) {
		super();
		this.dni = dni;
	}
	
	//Getters & Setters
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Articulo> getArticulos() {
		return articulos;
	}

	public void setArticulos(List<Articulo> articulos) {
		this.articulos = articulos;
	}

	public void addArticulo (Articulo a) {
		this.articulos.add(a);
		if (!a.getAutores().contains(this)) {
            a.getAutores().add(this);
        }
	}
	
	//toString, equals & hashCode
	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Autor other = (Autor) obj;
		return Objects.equals(dni, other.dni);
	}

	public List<Integer> getArticulosId () {
		List<Integer> articulosId = new ArrayList<Integer>();
		for (Articulo articulo : this.articulos) {
			articulosId.add(articulo.getIdArticulo());
		}
		return articulosId;
	}
	
	@Override
	public String toString() {
		return "Autor [dni=" + dni + ", nombre=" + nombre + ", email=" + email + ", articulos=" + getArticulosId() + "]";
	}
	
	
	
	
}
