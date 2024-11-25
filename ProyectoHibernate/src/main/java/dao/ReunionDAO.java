package dao;

import java.util.List;

import org.hibernate.Session;

import jakarta.persistence.TypedQuery;
import ud3.Reunion;
import utiles.HibernateUtil;
import utilesDAO.AbstractDAO;

public class ReunionDAO extends AbstractDAO<Reunion>{
	public ReunionDAO() {
		setClase(Reunion.class);
	}
	
	//HQL
	public List<Reunion> getAllReuniones() {
		Session sesion = HibernateUtil.getFactoriaSession().openSession();
		String queryString = "FROM "+ Reunion.class.getName();
		TypedQuery<Reunion> query = sesion.createQuery(queryString, Reunion.class);
		List<Reunion> reuniones = query.getResultList();
		return reuniones;
	}
}
