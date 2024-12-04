package models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

/**
 * Representa un jugador de un equipo deportivo.
 * Contiene información personal del jugador, su posición en el campo,
 * número dorsal y el manager asignado.
 */
@Entity
public class Jugador {

    // Attributes

    /**
     * Identificador único del jugador.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_jugador")
    private int idJugador;

    /**
     * Nombre del jugador.
     */
    private String nombre;

    /**
     * Posición en el campo en la que juega el jugador.
     */
    private String posicion;

    /**
     * Fecha de nacimiento del jugador en formato String.
     */
    private String fechaNacimiento;

    /**
     * Número dorsal del jugador.
     */
    private int dorsal;

    /**
     * Manager asignado al jugador.
     * Relación uno a uno con la clase {@link Manager}.
     */
    @OneToOne
    @JoinColumn(name = "id_manager")
    private Manager manager;

    // Constructors

    /**
     * Crea un nuevo jugador con los datos especificados.
     *
     * @param nombre el nombre del jugador.
     * @param posicion la posición en el campo del jugador.
     * @param fechaNacimiento la fecha de nacimiento del jugador.
     * @param dorsal el número dorsal del jugador.
     * @param manager el manager asignado al jugador.
     */
    public Jugador(String nombre, String posicion, String fechaNacimiento, int dorsal, Manager manager) {
        this.nombre = nombre;
        this.posicion = posicion;
        this.fechaNacimiento = fechaNacimiento;
        this.dorsal = dorsal;
        this.manager = manager;
    }

    /**
     * Constructor por defecto. Crea un jugador sin inicializar los atributos.
     */
    public Jugador() {
    }

    // Getters & Setters

    /**
     * Obtiene el identificador único del jugador.
     *
     * @return el ID del jugador.
     */
    public int getIdJugador() {
        return idJugador;
    }

    /**
     * Establece el identificador único del jugador.
     *
     * @param idJugador el nuevo ID del jugador.
     */
    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    /**
     * Obtiene el nombre del jugador.
     *
     * @return el nombre del jugador.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del jugador.
     *
     * @param nombre el nuevo nombre del jugador.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la posición del jugador en el campo.
     *
     * @return la posición del jugador.
     */
    public String getPosicion() {
        return posicion;
    }

    /**
     * Establece la posición del jugador en el campo.
     *
     * @param posicion la nueva posición del jugador.
     */
    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    /**
     * Obtiene la fecha de nacimiento del jugador.
     *
     * @return la fecha de nacimiento.
     */
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece la fecha de nacimiento del jugador.
     *
     * @param fechaNacimiento la nueva fecha de nacimiento.
     */
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Obtiene el número dorsal del jugador.
     *
     * @return el número dorsal.
     */
    public int getDorsal() {
        return dorsal;
    }

    /**
     * Establece el número dorsal del jugador.
     *
     * @param dorsal el nuevo número dorsal.
     */
    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    /**
     * Obtiene el manager asignado al jugador.
     *
     * @return el manager del jugador.
     */
    public Manager getManager() {
        return manager;
    }

    /**
     * Establece el manager asignado al jugador.
     *
     * @param manager el nuevo manager del jugador.
     */
    public void setManager(Manager manager) {
        this.manager = manager;
    }

    /**
     * Devuelve una representación en forma de cadena del jugador,
     * incluyendo sus atributos y el nombre de su manager.
     *
     * @return una cadena con la información del jugador.
     */
    @Override
    public String toString() {
        return "Jugador [idJugador=" + idJugador + ", nombre=" + nombre + ", posicion=" + posicion
                + ", fechaNacimiento=" + fechaNacimiento + ", dorsal=" + dorsal + ", manager=" + manager.getNombre() + "]";
    }
}
