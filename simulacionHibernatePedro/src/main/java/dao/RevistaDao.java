package dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;

import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import modelos.Articulo;
import modelos.Revista;
import utiles.AbstractDao;
import utiles.HibernateUtil;

public class RevistaDao extends AbstractDao<Revista> {

	public RevistaDao() {
		setClase(Revista.class);
	}
	
	/*Crea una consulta que muestre los datos de las revistas (nombre, fecha y número) que se han publicado antes de una fecha*/
	
	//QUERY
	
	public List<Object[]> getDatosRevistas(LocalDate fechaPublicacion){
		Session sesion = HibernateUtil.getFactoriaSession().openSession();
		String consulta ="SELECT revista.nombreRevista, revista.fecha, revista.numeroRevista " +
                "FROM Revista revista WHERE revista.fecha < :fechaPublicacion";
	    TypedQuery<Object[]> query = sesion.createQuery(consulta, Object[].class);
	    query.setParameter("fechaPublicacion", fechaPublicacion); // Vincula el parámetro correctamente
	    List<Object[]> resultados = query.getResultList();
		sesion.close();
	    return resultados;
	}
	
	//CRITERIABUILDER
	
	public List<Object[]> getDatosRevistasCriteria(LocalDate fechaPublicacion){
	    Session sesion = HibernateUtil.getFactoriaSession().openSession();
	    CriteriaBuilder cb = sesion.getCriteriaBuilder();
	    CriteriaQuery<Object[]> query = cb.createQuery(Object[].class);
	    Root<Revista> revista = query.from(Revista.class);
	    query.multiselect(revista.get("nombreRevista"),revista.get("fecha"),
	    		revista.get("numeroRevista"));
	    query.where(cb.lessThan(revista.get("fecha"), fechaPublicacion));
	    List<Object[]> resultados = sesion.createQuery(query).getResultList();
	    sesion.close();
	    return resultados;
	}
}
