package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.CriteriaUpdate;
import jakarta.persistence.criteria.Root;
import models.Manager;
import util.HibernateUtil;
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
    
    /**
     * Actualiza la nacionalidad de un manager específico en la base de datos.
     * 
     * Este método utiliza una consulta de actualización basada en Criteria API para cambiar 
     * la nacionalidad de un manager con un ID específico (en este caso, ID 2) a "alemán". 
     * 
     * En caso de error, la transacción se revierte.
     */
    public void actualizarNacionalidad() {
        Session sesion = HibernateUtil.getFactoriaSession().openSession();
        Transaction transaction = null;

        try {
            transaction = sesion.beginTransaction();

            CriteriaBuilder cb = sesion.getCriteriaBuilder();

            CriteriaUpdate<Manager> update = cb.createCriteriaUpdate(Manager.class);

            Root<Manager> root = update.from(Manager.class);

            update.set(root.get("nacionalidad"), "alemán");

            update.where(cb.equal(root.get("idManager"), "2"));

            sesion.createQuery(update).executeUpdate();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            sesion.close();
        }
    }
    
    /**
     * Elimina un manager específico de la base de datos.
     * 
     * Este método utiliza una consulta de eliminación basada en Criteria API para borrar 
     * al manager con un ID específico (en este caso, ID 3).
     * 
     * En caso de error, la transacción se revierte.
     */
    public void eliminarManager() {
        Session sesion = HibernateUtil.getFactoriaSession().openSession();
        Transaction transaction = null;

        try {
            transaction = sesion.beginTransaction();

            CriteriaBuilder cb = sesion.getCriteriaBuilder();

            CriteriaDelete<Manager> delete = cb.createCriteriaDelete(Manager.class);

            Root<Manager> root = delete.from(Manager.class);

            delete.where(cb.equal(root.get("idManager"), "3"));
            
            sesion.createQuery(delete).executeUpdate();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            sesion.close();
        }
    }
}
