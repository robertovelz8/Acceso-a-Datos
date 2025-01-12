package dao;

import org.hibernate.Session;

import jakarta.persistence.TypedQuery;
import models.Arbitro;
import models.Equipo;
import util.HibernateUtil;
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
    
    /**
     * Método que busca el nombre del árbitro.
     * <p>
     * Este método utiliza Hibernate para abrir una sesión y ejecutar una consulta 
     * que obtiene el nombre del árbitro desde la base de datos. 
     * La consulta se construye utilizando la clase {@link Equipo}.
     * </p>
     * 
     * @return el nombre del árbitro como una cadena de texto. Si no hay resultados,
     *         el método podría lanzar una excepción {@link IndexOutOfBoundsException}.
     * 
     * @throws org.hibernate.HibernateException si ocurre un error al abrir la sesión o al ejecutar la consulta.
     * @throws IndexOutOfBoundsException si la lista de resultados está vacía.
     */
    public String findNombreByArbitro() {
        Session sesion = HibernateUtil.getFactoriaSession().openSession();
        String queryString = "SELECT nombre FROM " + Arbitro.class.getName();
        TypedQuery<String> query = sesion.createQuery(queryString, String.class);
        String nombreArbitro = query.getResultList().get(0);
        return nombreArbitro;
    }

}
