package dao;

import models.Liga;
import utilesDAO.AbstractDAO;

/**
 * La clase {@link LigaDAO} extiende {@link AbstractDAO} y proporciona la implementación
 * específica de las operaciones CRUD para la entidad {@link Liga}. Esta clase maneja
 * la interacción con la base de datos para crear, leer, actualizar y eliminar registros
 * de ligas.
 */
public class LigaDAO extends AbstractDAO<Liga> {

    /**
     * Constructor que establece la clase {@link Liga} para este DAO.
     */
    public LigaDAO() {
        setClase(Liga.class);
    }
}
