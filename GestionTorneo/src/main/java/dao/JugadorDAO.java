package dao;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import jakarta.persistence.TypedQuery;
import models.Jugador;
import util.HibernateUtil;
import utilesDAO.AbstractDAO;

/**
 * La clase {@link JugadorDAO} extiende {@link AbstractDAO} y proporciona la implementación
 * específica de las operaciones CRUD para la entidad {@link Jugador}. Esta clase maneja
 * la interacción con la base de datos para crear, leer, actualizar y eliminar registros
 * de jugadores.
 */
public class JugadorDAO extends AbstractDAO<Jugador> {

    private static final Logger logger = LogManager.getLogger(JugadorDAO.class);

    /**
     * Constructor que establece la clase {@link Jugador} para este DAO.
     */
    public JugadorDAO() {
        setClase(Jugador.class);
    }
    

    /**
     * Recupera y muestra la fecha de nacimiento y la posición de todos los jugadores en la base de datos.
     * 
     * Este método ejecuta una consulta que selecciona las columnas `fechaNacimiento` y `posicion` 
     * de la entidad {@link Jugador} y luego registra los resultados utilizando el logger.
     */
    public void findFechaNacimientoAndPosicionByJugador () {
    	Session sesion = HibernateUtil.getFactoriaSession().openSession();
    	String queryString = "SELECT fechaNacimiento, posicion FROM "+ Jugador.class.getName();
    	TypedQuery<Object[]> query = sesion.createQuery(queryString, Object[].class);
    	List<Object[]> fechaPosicion = query.getResultList();
    	for (Object[] o: fechaPosicion) {
    		logger.debug("Fecha de nacimiento: "+o[0]);
    		logger.debug("Posición: "+o[1]);
    	}
    }
    
    /**
     * Busca jugadores que tienen un dorsal específico y los ordena por su nombre en orden descendente.
     * 
     * @return una lista de objetos {@link Jugador} que cumplen con el filtro de dorsal y están ordenados por nombre.
     */
    public List<Jugador> findJugadoresJugadoresByFilterAndOrderBy () {
    	Session sesion = HibernateUtil.getFactoriaSession().openSession();
    	String queryString = "FROM " + Jugador.class.getName() + " WHERE dorsal = :dorsalParametro ORDER BY nombre DESC";
    	TypedQuery<Jugador> query = sesion.createQuery(queryString, Jugador.class);
    	query.setParameter("dorsalParametro", 7);
    	List<Jugador> jugadoresOrdenadosYFiltrados = query.getResultList();
    	return jugadoresOrdenadosYFiltrados;
    }
}
