package models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

/**
 * Representa un partido de fútbol, incluyendo detalles como la fecha, 
 * resultado, jornada y los árbitros asignados.
 */
@Entity
public class Partido {

    // Attributes

    /**
     * Identificador único del partido.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_partido")
    private int idPartido;

    /**
     * Fecha en la que se jugó el partido.
     */
    private String fecha;

    /**
     * Resultado del partido.
     */
    private String resultado;

    /**
     * Jornada a la que pertenece el partido.
     */
    private int jornada;

    /**
     * Lista de árbitros asignados al partido.
     * Relación de muchos a muchos con la entidad Arbitro.
     */
    @ManyToMany
    private List<Arbitro> arbitros;

    // Constructors

    /**
     * Crea un nuevo partido con los detalles especificados.
     *
     * @param fecha     la fecha del partido.
     * @param resultado el resultado del partido.
     * @param jornada   la jornada del partido.
     * @param arbitros  la lista de árbitros asignados al partido.
     */
    public Partido(String fecha, String resultado, int jornada, List<Arbitro> arbitros) {
        super();
        this.fecha = fecha;
        this.resultado = resultado;
        this.jornada = jornada;
        this.arbitros = arbitros;
    }

    /**
     * Constructor por defecto. Crea un partido sin inicializar los atributos.
     */
    public Partido() {
    }

    // Getters & Setters

    /**
     * Obtiene el identificador único del partido.
     *
     * @return el ID del partido.
     */
    public int getIdPartido() {
        return idPartido;
    }

    /**
     * Establece el identificador único del partido.
     *
     * @param idPartido el nuevo ID del partido.
     */
    public void setIdPartido(int idPartido) {
        this.idPartido = idPartido;
    }

    /**
     * Obtiene la fecha del partido.
     *
     * @return la fecha del partido.
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha del partido.
     *
     * @param fecha la nueva fecha del partido.
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene el resultado del partido.
     *
     * @return el resultado del partido.
     */
    public String getResultado() {
        return resultado;
    }

    /**
     * Establece el resultado del partido.
     *
     * @param resultado el nuevo resultado del partido.
     */
    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    /**
     * Obtiene la jornada a la que pertenece el partido.
     *
     * @return la jornada del partido.
     */
    public int getJornada() {
        return jornada;
    }

    /**
     * Establece la jornada a la que pertenece el partido.
     *
     * @param jornada la nueva jornada del partido.
     */
    public void setJornada(int jornada) {
        this.jornada = jornada;
    }

    /**
     * Obtiene la lista de árbitros asignados al partido.
     *
     * @return la lista de árbitros.
     */
    public List<Arbitro> getArbitros() {
        return arbitros;
    }

    /**
     * Establece la lista de árbitros asignados al partido.
     *
     * @param arbitros la nueva lista de árbitros.
     */
    public void setArbitros(List<Arbitro> arbitros) {
        this.arbitros = arbitros;
    }

    // Overrides

    /**
     * Devuelve una representación en forma de cadena del partido,
     * incluyendo los detalles principales y los IDs de los árbitros asignados.
     *
     * @return una cadena con la información del partido.
     */
    @Override
    public String toString() {
        List<Integer> arbitroIds = new ArrayList<>();
        for (Arbitro arbitro : arbitros) {
            arbitroIds.add(arbitro.getIdArbitro());
        }
        return "Partido [idPartido=" + idPartido + ", fecha=" + fecha + ", resultado=" + resultado
                + ", jornada=" + jornada + ", arbitros=" + arbitroIds.toString() + "]";
    }
}
