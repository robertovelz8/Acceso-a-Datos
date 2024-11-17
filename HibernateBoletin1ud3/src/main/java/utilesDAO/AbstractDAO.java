package utilesDAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import jakarta.persistence.TypedQuery;
import models.Departamento;
import utiles.HibernateUtil;

public abstract class AbstractDAO<T> implements IDAO<T> {
	private Class<T> departamento;
	private Class<T> empleado;

	@Override
	public void create(T t) {
		executeInsideTransaction(t);
	}

	/*
	@Override
	public Optional<T> get(int id) {
		Session sesion = HibernateUtil.getFactoriaSession().openSession();
		return Optional.ofNullable(sesion.find(clase, id));
	}
	*/

	@Override
	public List<T> getAll() {
		Session sesion = HibernateUtil.getFactoriaSession().openSession();
		String queryString = "FROM " + departamento.getName();
		TypedQuery<T> query = sesion.createQuery(queryString, departamento);
		List<T> resultados = query.getResultList();
		return resultados;
	}

	@Override
	public void update(T t) {
		Session sesion = HibernateUtil.getFactoriaSession().openSession();
		executeInsideTransaction(sesion, sesion.merge(t));
	}

	@Override
	public void delete(T t) {
		Session sesion = HibernateUtil.getFactoriaSession().openSession();
		// Registramos una transacción
		Transaction tx = sesion.beginTransaction();
		try {
			sesion.remove(t);
			tx.commit();

		} catch (RuntimeException e) {
			tx.rollback();
			throw e;
		} finally {
			if (sesion != null) {
				sesion.close();
			}
		}

	}

	private void executeInsideTransaction(Session sesion, T objecto) {
		// Registramos una transacción
		Transaction tx = sesion.beginTransaction();
		try {
			sesion.persist(objecto);
			tx.commit();

		} catch (RuntimeException e) {
			tx.rollback();
			throw e;
		} finally {
			if (sesion != null) {
				sesion.close();
			}
		}
	}

	private void executeInsideTransaction(T objecto) {
		executeInsideTransaction(HibernateUtil.getFactoriaSession().openSession(), objecto);
	}

	public Class<T> getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Class<T> departamento) {
		this.departamento = departamento;
	}

	public Class<T> getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Class<T> empleado) {
		this.empleado = empleado;
	}
	
	
	
	
	
}
