package dao;

import models.Arbitro;
import utilesDAO.AbstractDAO;

/**
 * La clase {@link ArbitroDAO} extiende {@link AbstractDAO} y proporciona la implementación
 * específica de las operaciones CRUD para la entidad {@link Arbitro}. Esta clase maneja
 * la interacción con la base de datos para crear, leer, actualizar y eliminar registros
 * de árbitros.
 */
public class ArbitroDAO extends AbstractDAO<Arbitro> {

    /**
     * Constructor que establece la clase {@link Arbitro} para este DAO.
     */
    public ArbitroDAO() {
        setClase(Arbitro.class);
    }
}
