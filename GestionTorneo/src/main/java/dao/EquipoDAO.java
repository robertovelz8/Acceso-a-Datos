package dao;

import org.hibernate.Session;

import jakarta.persistence.TypedQuery;
import models.Equipo;
import util.HibernateUtil;
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
    
    /**
     * Método que busca y devuelve un equipo desde la base de datos.
     * <p>
     * Este método utiliza Hibernate para abrir una sesión y ejecutar una consulta 
     * que obtiene una lista de todos los equipos en la base de datos. 
     * Se devuelve el primer equipo de la lista obtenida.
     * </p>
     * 
     * @return un objeto {@link Equipo} que representa el primer equipo en la lista de resultados.
     * 
     * @throws org.hibernate.HibernateException si ocurre un error al abrir la sesión o al ejecutar la consulta.
     * @throws IndexOutOfBoundsException si la lista de resultados está vacía.
     */
    public Equipo findEquipo() {
        Session sesion = HibernateUtil.getFactoriaSession().openSession();
        String queryString = "FROM " + Equipo.class.getName();
        TypedQuery<Equipo> query = sesion.createQuery(queryString, Equipo.class);
        Equipo equipo = query.getResultList().get(0);
        return equipo;
    }

}
