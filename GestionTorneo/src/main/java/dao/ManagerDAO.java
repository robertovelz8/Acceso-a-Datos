package dao;

import models.Manager;
import utilesDAO.AbstractDAO;

/**
 * La clase {@link ManagerDAO} extiende {@link AbstractDAO} y proporciona la implementación
 * específica de las operaciones CRUD para la entidad {@link Manager}. Esta clase maneja
 * la interacción con la base de datos para crear, leer, actualizar y eliminar registros
 * de managers.
 */
public class ManagerDAO extends AbstractDAO<Manager> {

    /**
     * Constructor que establece la clase {@link Manager} para este DAO.
     */
    public ManagerDAO() {
        setClase(Manager.class);
    }
}
