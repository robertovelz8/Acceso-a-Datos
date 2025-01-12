package modelos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Revista {

	//Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int idRevista;
	
	@Column(name = "nombre")
	private String nombreRevista;
	
	@Column(name = "numero")
	private int numeroRevista;
	private LocalDate fecha;
	
	@Column(name = "unidades_impresas")
	private int unidadesImpresas;
	
	@OneToMany(mappedBy = "revista", cascade = CascadeType.ALL, orphanRemoval = true) 
	private List<Articulo> articulos = new ArrayList<Articulo>();

	//Constructors
		public Revista() {
		super();
	}

	public Revista(String nombreRevista, int numeroRevista, LocalDate fecha, int unidadesImpresas) {
		super();
		this.nombreRevista = nombreRevista;
		this.numeroRevista = numeroRevista;
		this.fecha = fecha;
		this.unidadesImpresas = unidadesImpresas;
	}

	
	public Revista(String nombreRevista, int numeroRevista, LocalDate fecha) {
		super();
		this.nombreRevista = nombreRevista;
		this.numeroRevista = numeroRevista;
		this.fecha = fecha;
	}

	public int getIdRevista() {
		return idRevista;
	}

	public void setIdRevista(int idRevista) {
		this.idRevista = idRevista;
	}

	public String getNombreRevista() {
		return nombreRevista;
	}

	public void setNombreRevista(String nombreRevista) {
		this.nombreRevista = nombreRevista;
	}

	public int getNumeroRevista() {
		return numeroRevista;
	}

	public void setNumeroRevista(int numeroRevista) {
		this.numeroRevista = numeroRevista;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public int getUnidadesImpresas() {
		return unidadesImpresas;
	}

	public void setUnidadesImpresas(int unidadesImpresas) {
		this.unidadesImpresas = unidadesImpresas;
	}
	
	public List<Articulo> getArticulos() {
		return articulos;
	}

	public void setArticulos(List<Articulo> articulos) {
		this.articulos = articulos;
	}
	
	public void addArticulo (Articulo a) {
		this.articulos.add(a);
		a.setRevista(this);
	}

	public List<Integer> getArticulosId () {
		List<Integer> articulosId = new ArrayList<Integer>();
		for (Articulo articulo : this.articulos) {
			articulosId.add(articulo.getIdArticulo());
		}
		return articulosId;
	}
	
	//toString, hashCode & equals
	@Override
	public int hashCode() {
		return Objects.hash(idRevista);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Revista other = (Revista) obj;
		return idRevista == other.idRevista;
	}

	@Override
	public String toString() {
		return "Revista [idRevista=" + idRevista + ", nombreRevista=" + nombreRevista + ", numeroRevista="
				+ numeroRevista + ", fecha=" + fecha + ", unidadesImpresas=" + unidadesImpresas + ", articulos="
				+ getArticulosId() + "]";
	}
	
	
	
}
