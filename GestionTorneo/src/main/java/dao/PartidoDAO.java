package dao;

import models.Partido;
import utilesDAO.AbstractDAO;

/**
 * La clase {@link PartidoDAO} extiende {@link AbstractDAO} y proporciona la implementación
 * específica de las operaciones CRUD para la entidad {@link Partido}. Esta clase maneja
 * la interacción con la base de datos para crear, leer, actualizar y eliminar registros
 * de partidos.
 */
public class PartidoDAO extends AbstractDAO<Partido> {

    /**
     * Constructor que establece la clase {@link Partido} para este DAO.
     */
    public PartidoDAO() {
        setClase(Partido.class);
    }
}
