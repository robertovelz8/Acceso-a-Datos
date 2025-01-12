package dao;

import java.time.LocalDate;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import jakarta.persistence.TypedQuery;
import modelos.Revista;
import utiles.AbstractDao;
import utiles.HibernateUtil;

public class RevistaDao extends AbstractDao<Revista> {
	private static final Logger logger = LogManager.getLogger(RevistaDao.class);

	public RevistaDao() {
		setClase(Revista.class);
	}
	
	//Muestra el número de artículos que tiene cada revista.
	public void getNumArticuloByRevista() {
    	Session sesion = HibernateUtil.getFactoriaSession().openSession();
    	String queryString =  "SELECT r.idRevista, COUNT(a.idArticulo) FROM " + Revista.class.getName()+" r " + "INNER JOIN r.articulos a GROUP BY r.idRevista";
    	TypedQuery<Object[]> query = sesion.createQuery(queryString, Object[].class);
    	List<Object[]> revistas = query.getResultList();
    	
    	for (Object[] revista : revistas) {
    		logger.debug("ID Revista: "+revista[0]);
    		logger.debug("Número de artículos: "+revista[1]);
    	}
	}
	
	//Crea una consulta que muestre los datos de las revistas (nombre, fecha y número) que se han publicado antes de una fecha.
	public void getNombreFechaAndNumeroWithFechaByRevista() {
    	Session sesion = HibernateUtil.getFactoriaSession().openSession();
    	String queryString =  "SELECT r.nombreRevista, r.fecha, r.unidadesImpresas FROM " + Revista.class.getName()+" r " + "WHERE r.fecha < :fechaParametro";
    	TypedQuery<Object[]> query = sesion.createQuery(queryString, Object[].class);
    	query.setParameter("fechaParametro", LocalDate.of(2025, 01, 12));
    	List<Object[]> revistas = query.getResultList();
    	for (Object[] revista : revistas) {
    		logger.debug("Nombre de la revista: "+revista[0]);
    		logger.debug("Fecha: "+revista[1]);
    		logger.debug("Unidades impresas: "+revista[2]);
    	}
	}
}
