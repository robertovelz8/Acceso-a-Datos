package utilesDAO;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.Transaction;

import jakarta.persistence.TypedQuery;
import util.HibernateUtil;

/**
 * La clase AbstractDAO proporciona implementaciones genéricas para las operaciones CRUD
 * utilizando Hibernate. Esta clase se utiliza como base para las implementaciones de DAO
 * específicas para cada entidad.
 *
 * @param <T> el tipo de la entidad que maneja este DAO.
 */
public abstract class AbstractDAO<T> implements IDAO<T> {

    /**
     * La clase de la entidad que este DAO maneja.
     */
    private Class<T> clase;

    /**
     * Crea una nueva instancia de la entidad.
     *
     * @param t la entidad a crear.
     */
    @Override
    public void create(T t) {
        executeInsideTransaction(t);
    }

    /**
     * Obtiene una entidad por su ID.
     *
     * @param id el ID de la entidad.
     * @return un Optional que contiene la entidad si se encuentra, o está vacío si no.
     */
    @Override
    public Optional<T> get(int id) {
        Session sesion = HibernateUtil.getFactoriaSession().openSession();
        return Optional.ofNullable(sesion.find(clase, id));
    }

    /**
     * Obtiene todas las entidades de la clase asociada.
     *
     * @return una lista de todas las entidades.
     */
    @Override
    public List<T> getAll() {
        Session sesion = HibernateUtil.getFactoriaSession().openSession();
        String queryString = "FROM " + clase.getName();
        TypedQuery<T> query = sesion.createQuery(queryString, clase);
        List<T> resultados = query.getResultList();
        return resultados;
    }

    /**
     * Actualiza una entidad en la base de datos.
     *
     * @param t la entidad a actualizar.
     */
    @Override
    public void update(T t) {
        Session sesion = HibernateUtil.getFactoriaSession().openSession();
        executeInsideTransaction(sesion, sesion.merge(t));
    }

    /**
     * Elimina una entidad de la base de datos.
     *
     * @param t la entidad a eliminar.
     */
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

    /**
     * Ejecuta una transacción que persiste una nueva entidad en la base de datos.
     *
     * @param sesion la sesión de Hibernate.
     * @param objecto la entidad a persistir.
     */
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

    /**
     * Ejecuta una transacción para persistir una nueva entidad en la base de datos.
     *
     * @param objecto la entidad a persistir.
     */
    private void executeInsideTransaction(T objecto) {
        executeInsideTransaction(HibernateUtil.getFactoriaSession().openSession(), objecto);
    }

    /**
     * Obtiene la clase asociada a este DAO.
     *
     * @return la clase de la entidad que este DAO maneja.
     */
    public Class<T> getClase() {
        return clase;
    }

    /**
     * Establece la clase de la entidad que este DAO maneja.
     *
     * @param clase la clase de la entidad a establecer.
     */
    public void setClase(Class<T> clase) {
        this.clase = clase;
    }
}
