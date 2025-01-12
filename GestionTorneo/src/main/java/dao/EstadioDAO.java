package dao;

import java.util.List;

import org.hibernate.Session;

import jakarta.persistence.TypedQuery;
import models.Estadio;
import util.HibernateUtil;
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
    
    /**
     * Busca estadios cuya capacidad sea mayor que 30,000.
     * 
     * @return una lista de objetos {@link Estadio} que cumplen con el criterio de capacidad.
     */
    public List<Estadio> findEstadioByCapacidad() {
    	Session sesion = HibernateUtil.getFactoriaSession().openSession();
    	String queryString = "FROM "+ Estadio.class.getName() + " WHERE capacidad > :fechaParametro";
    	TypedQuery<Estadio> query = sesion.createQuery(queryString, Estadio.class);
    	query.setParameter("fechaParametro", 30000);
    	List<Estadio> estadios = query.getResultList();
    	return estadios;
    }
    
    /**
     * Busca estadios que estén ubicados en "Nervión".
     * 
     * @return una lista de objetos {@link Estadio} que cumplen con el criterio de ubicación.
     */
    public List<Estadio> findEstadioByUbicacion() {
    	Session sesion = HibernateUtil.getFactoriaSession().openSession();
    	String queryString = "FROM "+ Estadio.class.getName() + " WHERE ubicacion = :fechaParametro";
    	TypedQuery<Estadio> query = sesion.createQuery(queryString, Estadio.class);
    	query.setParameter("fechaParametro", "Nervión");
    	List<Estadio> estadios = query.getResultList();
    	return estadios;
    }
    
    /**
     * Calcula la cantidad total de estadios registrados en la base de datos.
     * 
     * @return el número total de estadios como un valor de tipo {@link Long}.
     */
    public Long findNumeroEstadiosByCount (){
    	Session sesion = HibernateUtil.getFactoriaSession().openSession();
    	String queryString = "SELECT COUNT (id) FROM "+ Estadio.class.getName();
    	TypedQuery<Long> query = sesion.createQuery(queryString, Long.class);
    	Long numeroEstadios = query.getSingleResult();
    	return numeroEstadios;
    }
    
    /**
     * Calcula el promedio de capacidad de los estadios registrados en la base de datos.
     * 
     * @return el promedio de la capacidad de los estadios como un valor de tipo {@link Double}.
     */
    public Double findPromedioCapacidadByAvg (){
    	Session sesion = HibernateUtil.getFactoriaSession().openSession();
    	String queryString = "SELECT AVG (capacidad) FROM "+ Estadio.class.getName();
    	TypedQuery<Double> query = sesion.createQuery(queryString, Double.class);
    	Double numeroEstadios = query.getSingleResult();
    	return numeroEstadios;
    }
}
