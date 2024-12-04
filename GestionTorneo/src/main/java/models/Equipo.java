package models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

/**
 * Representa un equipo de una liga deportiva.
 * Contiene información básica del equipo, como su nombre, año de fundación y la liga a la que pertenece.
 */
@Entity
public class Equipo {

    // Attributes

    /**
     * Identificador único del equipo.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_equipo")
    private int idEquipo;

    /**
     * Nombre del equipo.
     */
    private String nombre;

    /**
     * Año de fundación del equipo.
     */
    private String fundacion;

    /**
     * Liga a la que pertenece el equipo.
     * Relación unidireccional con la clase {@link Liga}.
     */
    @ManyToOne
    private Liga liga;

    // Constructors

    /**
     * Crea un nuevo equipo con los datos especificados.
     *
     * @param nombre el nombre del equipo.
     * @param fundacion el año de fundación del equipo.
     * @param liga la liga a la que pertenece el equipo.
     */
    public Equipo(String nombre, String fundacion, Liga liga) {
        this.nombre = nombre;
        this.fundacion = fundacion;
        this.liga = liga;
    }

    /**
     * Constructor por defecto. Crea un equipo sin inicializar los atributos.
     */
    public Equipo() {
    }

    // Getters & Setters

    /**
     * Obtiene el identificador único del equipo.
     *
     * @return el ID del equipo.
     */
    public int getIdEquipo() {
        return idEquipo;
    }

    /**
     * Establece el identificador único del equipo.
     *
     * @param idEquipo el nuevo ID del equipo.
     */
    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    /**
     * Obtiene el nombre del equipo.
     *
     * @return el nombre del equipo.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del equipo.
     *
     * @param nombre el nuevo nombre del equipo.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el año de fundación del equipo.
     *
     * @return el año de fundación.
     */
    public String getFundacion() {
        return fundacion;
    }

    /**
     * Establece el año de fundación del equipo.
     *
     * @param fundacion el nuevo año de fundación.
     */
    public void setFundacion(String fundacion) {
        this.fundacion = fundacion;
    }

    /**
     * Obtiene la liga a la que pertenece el equipo.
     *
     * @return la liga del equipo.
     */
    public Liga getLiga() {
        return liga;
    }

    /**
     * Establece la liga a la que pertenece el equipo.
     *
     * @param liga la nueva liga del equipo.
     */
    public void setLiga(Liga liga) {
        this.liga = liga;
    }

    /**
     * Devuelve una representación en forma de cadena del equipo,
     * incluyendo sus atributos y el nombre de la liga a la que pertenece.
     *
     * @return una cadena con la información del equipo.
     */
    @Override
    public String toString() {
        return "Equipo [idEquipo=" + idEquipo + ", nombre=" + nombre + ", fundacion=" + fundacion + ", liga=" + liga.getNombre()
                + "]";
    }
}
