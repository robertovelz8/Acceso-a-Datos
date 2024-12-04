package models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

/**
 * Representa un manager asociado a un jugador. 
 * Contiene información personal del manager y una relación uno a uno con un jugador.
 */
@Entity
public class Manager {

    // Attributes

    /**
     * Identificador único del manager.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_manager")
    private int idManager;

    /**
     * Nombre del manager.
     */
    private String nombre;

    /**
     * Apellido del manager.
     */
    private String apellido;

    /**
     * Nacionalidad del manager.
     */
    private String nacionalidad;

    /**
     * Relación uno a uno con un jugador.
     */
    @OneToOne
    @JoinColumn(name = "id_jugador")
    private Jugador jugador;

    // Constructors

    /**
     * Crea un nuevo manager con los datos especificados.
     *
     * @param idManager     el identificador único del manager.
     * @param nombre        el nombre del manager.
     * @param apellido      el apellido del manager.
     * @param nacionalidad  la nacionalidad del manager.
     * @param jugador       el jugador asociado al manager.
     */
    public Manager(int idManager, String nombre, String apellido, String nacionalidad, Jugador jugador) {
        super();
        this.idManager = idManager;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nacionalidad = nacionalidad;
        this.jugador = jugador;
    }

    /**
     * Constructor por defecto. Crea un manager sin inicializar los atributos.
     */
    public Manager() {
        super();
    }

    // Getters & Setters

    /**
     * Obtiene el identificador único del manager.
     *
     * @return el ID del manager.
     */
    public int getIdManager() {
        return idManager;
    }

    /**
     * Establece el identificador único del manager.
     *
     * @param idManager el nuevo ID del manager.
     */
    public void setIdManager(int idManager) {
        this.idManager = idManager;
    }

    /**
     * Obtiene el nombre del manager.
     *
     * @return el nombre del manager.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del manager.
     *
     * @param nombre el nuevo nombre del manager.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido del manager.
     *
     * @return el apellido del manager.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Establece el apellido del manager.
     *
     * @param apellido el nuevo apellido del manager.
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Obtiene la nacionalidad del manager.
     *
     * @return la nacionalidad del manager.
     */
    public String getNacionalidad() {
        return nacionalidad;
    }

    /**
     * Establece la nacionalidad del manager.
     *
     * @param nacionalidad la nueva nacionalidad del manager.
     */
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    /**
     * Obtiene el jugador asociado al manager.
     *
     * @return el jugador asociado.
     */
    public Jugador getJugador() {
        return jugador;
    }

    /**
     * Establece el jugador asociado al manager.
     *
     * @param jugador el nuevo jugador asociado.
     */
    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    // Overrides

    /**
     * Devuelve una representación en forma de cadena del manager,
     * incluyendo los atributos principales y el nombre del jugador asociado.
     *
     * @return una cadena con la información del manager.
     */
    @Override
    public String toString() {
        return "Manager [idManager=" + idManager + ", nombre=" + nombre + ", apellido=" + apellido 
               + ", nacionalidad=" + nacionalidad + ", jugador=" + jugador.getNombre() + "]";
    }
}
