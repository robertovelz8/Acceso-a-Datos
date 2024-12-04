package utilesDAO;

import java.util.List;
import java.util.Optional;

/**
 * Esta interfaz define las operaciones CRUD (Crear, Leer, Actualizar, Eliminar)
 * genéricas para la gestión de entidades en una base de datos. Cada clase que implemente
 * esta interfaz proporcionará su propia implementación de estas operaciones.
 *
 * @param <T> El tipo de entidad que el DAO maneja.
 */
public interface IDAO<T> {

    /**
     * Crea una nueva entidad en la base de datos.
     *
     * @param t La entidad que se va a crear.
     */
    void create(T t);

    /**
     * Obtiene una entidad de la base de datos mediante su ID.
     * Utiliza {@link Optional} porque la consulta puede no devolver ningún resultado.
     *
     * @param id El ID de la entidad que se quiere recuperar.
     * @return Un Optional que contiene la entidad si existe, o está vacío si no se encuentra.
     */
    Optional<T> get(int id);

    /**
     * Obtiene todas las entidades de la base de datos.
     *
     * @return Una lista con todas las entidades.
     */
    List<T> getAll();

    /**
     * Actualiza una entidad en la base de datos.
     *
     * @param t La entidad con los nuevos valores a actualizar.
     */
    void update(T t);

    /**
     * Elimina una entidad de la base de datos.
     *
     * @param t La entidad que se desea eliminar.
     */
    void delete(T t);
}
