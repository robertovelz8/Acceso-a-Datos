package dao;

import models.Equipo;
import utilesDAO.AbstractDAO;

/**
 * La clase {@link EquipoDAO} extiende {@link AbstractDAO} y proporciona la implementación
 * específica de las operaciones CRUD para la entidad {@link Equipo}. Esta clase maneja
 * la interacción con la base de datos para crear, leer, actualizar y eliminar registros
 * de equipos.
 */
public class EquipoDAO extends AbstractDAO<Equipo> {

    /**
     * Constructor que establece la clase {@link Equipo} para este DAO.
     */
    public EquipoDAO() {
        setClase(Equipo.class);
    }
}
