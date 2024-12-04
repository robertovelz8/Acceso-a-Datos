package models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Representa un estadio deportivo.
 * Contiene información básica del estadio, como su nombre, capacidad y ubicación.
 */
@Entity
public class Estadio {

    // Attributes

    /**
     * Identificador único del estadio.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_estadio")
    private int idEstadio;

    /**
     * Nombre del estadio.
     */
    private String nombre;

    /**
     * Capacidad del estadio, representada como el número de espectadores que puede albergar.
     */
    private int capacidad;

    /**
     * Ubicación geográfica del estadio.
     */
    private String ubicacion;

    // Constructors

    /**
     * Crea un nuevo estadio con los datos especificados.
     *
     * @param nombre el nombre del estadio.
     * @param capacidad la capacidad del estadio.
     * @param ubicacion la ubicación del estadio.
     */
    public Estadio(String nombre, int capacidad, String ubicacion) {
        super();
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.ubicacion = ubicacion;
    }

    /**
     * Constructor por defecto. Crea un estadio sin inicializar los atributos.
     */
    public Estadio() {
    }

    // Getters & Setters

    /**
     * Obtiene el identificador único del estadio.
     *
     * @return el ID del estadio.
     */
    public int getIdEstadio() {
        return idEstadio;
    }

    /**
     * Establece el identificador único del estadio.
     *
     * @param idEstadio el nuevo ID del estadio.
     */
    public void setIdEstadio(int idEstadio) {
        this.idEstadio = idEstadio;
    }

    /**
     * Obtiene el nombre del estadio.
     *
     * @return el nombre del estadio.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del estadio.
     *
     * @param nombre el nuevo nombre del estadio.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la capacidad del estadio.
     *
     * @return la capacidad del estadio.
     */
    public int getCapacidad() {
        return capacidad;
    }

    /**
     * Establece la capacidad del estadio.
     *
     * @param capacidad la nueva capacidad del estadio.
     */
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    /**
     * Obtiene la ubicación del estadio.
     *
     * @return la ubicación del estadio.
     */
    public String getUbicacion() {
        return ubicacion;
    }

    /**
     * Establece la ubicación del estadio.
     *
     * @param ubicacion la nueva ubicación del estadio.
     */
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * Devuelve una representación en forma de cadena del estadio,
     * incluyendo sus atributos.
     *
     * @return una cadena con la información del estadio.
     */
    @Override
    public String toString() {
        return "Estadio [idEstadio=" + idEstadio + ", nombre=" + nombre + ", capacidad=" + capacidad + ", ubicacion="
                + ubicacion + "]";
    }
}
