package models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

/**
 * Representa a un árbitro en un sistema de gestión de partidos.
 * Contiene información personal del árbitro y una lista de partidos en los que ha participado.
 */
@Entity
public class Arbitro {

    // Attributes

    /** 
     * Identificador único del árbitro. 
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_arbitro")
    private int idArbitro;

    /** 
     * Nombre del árbitro. 
     */
    private String nombre;

    /** 
     * Nacionalidad del árbitro. 
     */
    private String nacionalidad;

    /** 
     * Experiencia del árbitro, expresada en años o como descripción. 
     */
    private String experiencia;

    /** 
     * Lista de partidos en los que el árbitro ha participado. 
     * Relación bidireccional con la clase {@link Partido}.
     */
    @ManyToMany(mappedBy = "arbitros", cascade = CascadeType.ALL)
    private List<Partido> partidos;

    // Constructors

    /**
     * Crea un nuevo árbitro con los datos especificados.
     *
     * @param nombre el nombre del árbitro.
     * @param nacionalidad la nacionalidad del árbitro.
     * @param experiencia la experiencia del árbitro.
     * @param partidos la lista de partidos en los que ha participado el árbitro.
     */
    public Arbitro(String nombre, String nacionalidad, String experiencia, List<Partido> partidos) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.experiencia = experiencia;
        this.partidos = new ArrayList<>();
    }

    /**
     * Constructor por defecto. Crea un árbitro sin inicializar los atributos.
     */
    public Arbitro() {
    }

    // Getters & Setters

    /**
     * Obtiene el identificador del árbitro.
     * @return el ID del árbitro.
     */
    public int getIdArbitro() {
        return idArbitro;
    }

    /**
     * Establece el identificador del árbitro.
     * @param idArbitro el nuevo ID del árbitro.
     */
    public void setIdArbitro(int idArbitro) {
        this.idArbitro = idArbitro;
    }

    /**
     * Obtiene el nombre del árbitro.
     * @return el nombre del árbitro.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del árbitro.
     * @param nombre el nuevo nombre del árbitro.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la nacionalidad del árbitro.
     * @return la nacionalidad del árbitro.
     */
    public String getNacionalidad() {
        return nacionalidad;
    }

    /**
     * Establece la nacionalidad del árbitro.
     * @param nacionalidad la nueva nacionalidad del árbitro.
     */
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    /**
     * Obtiene la experiencia del árbitro.
     * @return la experiencia del árbitro.
     */
    public String getExperiencia() {
        return experiencia;
    }

    /**
     * Establece la experiencia del árbitro.
     * @param experiencia la nueva experiencia del árbitro.
     */
    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    /**
     * Obtiene la lista de partidos en los que el árbitro ha participado.
     * @return la lista de partidos.
     */
    public List<Partido> getPartidos() {
        return partidos;
    }

    /**
     * Establece la lista de partidos en los que el árbitro ha participado.
     * @param partidos la nueva lista de partidos.
     */
    public void setPartidos(List<Partido> partidos) {
        this.partidos = partidos;
    }

    /**
     * Devuelve una representación en forma de cadena del árbitro,
     * incluyendo sus atributos y los identificadores de los partidos en los que ha participado.
     * 
     * @return una cadena con la información del árbitro.
     */
    @Override
    public String toString() {
        List<Integer> partidosIds = new ArrayList<>();
        for (Partido partido : partidos) {
            partidosIds.add(partido.getIdPartido());
        }
        return "Arbitro [idArbitro=" + idArbitro + ", nombre=" + nombre + ", nacionalidad=" + nacionalidad
                + ", experiencia=" + experiencia + ", partidos=" + partidosIds.toString() + "]";
    }
}
