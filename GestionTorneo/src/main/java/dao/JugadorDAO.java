package dao;

import models.Jugador;
import utilesDAO.AbstractDAO;

/**
 * La clase {@link JugadorDAO} extiende {@link AbstractDAO} y proporciona la implementación
 * específica de las operaciones CRUD para la entidad {@link Jugador}. Esta clase maneja
 * la interacción con la base de datos para crear, leer, actualizar y eliminar registros
 * de jugadores.
 */
public class JugadorDAO extends AbstractDAO<Jugador> {

    /**
     * Constructor que establece la clase {@link Jugador} para este DAO.
     */
    public JugadorDAO() {
        setClase(Jugador.class);
    }
}
