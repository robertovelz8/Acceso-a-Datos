package modelos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Articulo {

	//Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_articulo")
	private int idArticulo;
	
	private String titulo;
	
	@Column (name = "pagina_inicio")
	private int numPaginaInicio;
	
	@Column (name = "pagina_fin")
	private int numPaginaFin;
	
	@ManyToOne (cascade = CascadeType.ALL)
	@JoinColumn (name = "revista_id")
	private Revista revista;
	
	@ManyToMany (fetch = FetchType.EAGER)
	@JoinTable(
	        name = "autor_articulo", 
	        joinColumns = @JoinColumn(name = "articulo_id"), 
	        inverseJoinColumns = @JoinColumn(name = "autor_id"))
	private List<Autor> autores = new ArrayList<Autor>();	
	

	//Constructors
	
	public Articulo(String titulo, int numPaginaInicio, int numPaginaFin) {
		super();
		this.titulo = titulo;
		this.numPaginaInicio = numPaginaInicio;
		this.numPaginaFin = numPaginaFin;
	}

	public Articulo (String titulo) {
		super();
		this.titulo = titulo;
	}
	
	public Articulo() {
		super();
	}
	
	//Getters & Setters

	public int getIdArticulo() {
		return idArticulo;
	}

	public void setIdArticulo(int idArticulo) {
		this.idArticulo = idArticulo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getNumPaginaFin() {
		return numPaginaFin;
	}

	public void setNumPaginaFin(int numPaginaFin) {
		this.numPaginaFin = numPaginaFin;
	}

	public Revista getRevista() {
		return revista;
	}

	public void setRevista(Revista revista) {
		this.revista = revista;
	}
	
	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

	public void addAutor (Autor a) {
		this.autores.add(a);
		if (!a.getArticulos().contains(this)) {
            a.getArticulos().add(this);
        }
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(idArticulo, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Articulo other = (Articulo) obj;
		return idArticulo == other.idArticulo && Objects.equals(titulo, other.titulo);
	}

	private List<String> getAutoresId () {
		List<String> autoresId = new ArrayList<String>();
		for (Autor autor : this.autores) {
			autoresId.add(autor.getDni());
		}
		return autoresId;
	}
	
	@Override
	public String toString() {
		return "Articulo [idArticulo=" + idArticulo + ", titulo=" + titulo + ", numPaginaFin=" + numPaginaFin
				+ ", revista=" + revista.getIdRevista() + ", autores=" + this.getAutoresId() + "]";
	}
}
