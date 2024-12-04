package models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

/**
 * Representa una liga deportiva que incluye equipos y árbitros.
 * Contiene información sobre el nombre, país, nivel de la liga, y las listas
 * de equipos y árbitros asociados.
 */
@Entity
public class Liga {

    // Attributes

    /**
     * Identificador único de la liga.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_liga")
    private int idLiga;

    /**
     * Nombre de la liga.
     */
    private String nombre;

    /**
     * País donde se desarrolla la liga.
     */
    private String pais;

    /**
     * Nivel competitivo de la liga (e.g., profesional, amateur).
     */
    private String nivel;

    /**
     * Lista de equipos que participan en la liga.
     * Relación uno a muchos con la clase {@link Equipo}.
     */
    @OneToMany(mappedBy = "liga", cascade = CascadeType.ALL)
    private List<Equipo> equipos;

    /**
     * Lista de árbitros asignados a la liga.
     * Relación uno a muchos con la clase {@link Arbitro}.
     */
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "liga_id", referencedColumnName = "id_liga")
    private List<Arbitro> arbitros;

    // Constructors

    /**
     * Crea una nueva liga con los datos especificados.
     *
     * @param nombre  el nombre de la liga.
     * @param pais    el país donde se desarrolla la liga.
     * @param nivel   el nivel competitivo de la liga.
     * @param equipos la lista de equipos que participan en la liga.
     * @param arbitros la lista de árbitros asignados a la liga.
     */
    public Liga(String nombre, String pais, String nivel, List<Equipo> equipos, List<Arbitro> arbitros) {
        this.nombre = nombre;
        this.pais = pais;
        this.nivel = nivel;
        this.equipos = new ArrayList<>();
        this.arbitros = new ArrayList<>();
    }

    /**
     * Constructor por defecto. Crea una liga sin inicializar los atributos.
     */
    public Liga() {
        super();
    }

    // Getters & Setters

    /**
     * Obtiene el identificador único de la liga.
     *
     * @return el ID de la liga.
     */
    public int getIdLiga() {
        return idLiga;
    }

    /**
     * Establece el identificador único de la liga.
     *
     * @param idLiga el nuevo ID de la liga.
     */
    public void setIdLiga(int idLiga) {
        this.idLiga = idLiga;
    }

    /**
     * Obtiene el nombre de la liga.
     *
     * @return el nombre de la liga.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la liga.
     *
     * @param nombre el nuevo nombre de la liga.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el país donde se desarrolla la liga.
     *
     * @return el país de la liga.
     */
    public String getPais() {
        return pais;
    }

    /**
     * Establece el país donde se desarrolla la liga.
     *
     * @param pais el nuevo país de la liga.
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * Obtiene el nivel competitivo de la liga.
     *
     * @return el nivel de la liga.
     */
    public String getNivel() {
        return nivel;
    }

    /**
     * Establece el nivel competitivo de la liga.
     *
     * @param nivel el nuevo nivel de la liga.
     */
    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    /**
     * Obtiene la lista de equipos que participan en la liga.
     *
     * @return la lista de equipos.
     */
    public List<Equipo> getEquipos() {
        return equipos;
    }

    /**
     * Establece la lista de equipos que participan en la liga.
     *
     * @param equipos la nueva lista de equipos.
     */
    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }

    /**
     * Obtiene la lista de árbitros asignados a la liga.
     *
     * @return la lista de árbitros.
     */
    public List<Arbitro> getArbitros() {
        return arbitros;
    }

    /**
     * Establece la lista de árbitros asignados a la liga.
     *
     * @param arbitros la nueva lista de árbitros.
     */
    public void setArbitros(List<Arbitro> arbitros) {
        this.arbitros = arbitros;
    }

    /**
     * Devuelve una representación en forma de cadena de la liga,
     * incluyendo los atributos principales, los equipos y los IDs de los árbitros.
     *
     * @return una cadena con la información de la liga.
     */
    @Override
    public String toString() {
        List<Integer> arbitroIds = new ArrayList<>();

        for (Arbitro arbitro : arbitros) {
            arbitroIds.add(arbitro.getIdArbitro());
        }

        return "Liga [idLiga=" + idLiga + ", nombre=" + nombre + ", pais=" + pais + ", nivel=" + nivel
                + ", equipos=" + equipos + ", arbitros=" + arbitroIds.toString() + "]";
    }
}
