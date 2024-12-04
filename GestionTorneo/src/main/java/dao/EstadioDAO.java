package dao;

import models.Estadio;
import utilesDAO.AbstractDAO;

/**
 * La clase {@link EstadioDAO} extiende {@link AbstractDAO} y proporciona la implementación
 * específica de las operaciones CRUD para la entidad {@link Estadio}. Esta clase maneja
 * la interacción con la base de datos para crear, leer, actualizar y eliminar registros
 * de estadios.
 */
public class EstadioDAO extends AbstractDAO<Estadio> {

    /**
     * Constructor que establece la clase {@link Estadio} para este DAO.
     */
    public EstadioDAO() {
        setClase(Estadio.class);
    }
}
