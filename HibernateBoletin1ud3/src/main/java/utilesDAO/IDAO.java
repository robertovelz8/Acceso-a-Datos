package utilesDAO;

import java.util.List;

/**
* Esta interfaz contiene las operaciones del CRUD
* Create a element T
* Retrieve a element and all elements: get
* Update a element T
* Delete a element T
* @param <T>
*/
public interface IDAO<T> {
	void create(T t);
	//Optional<T> get(int id); //Usamos Optional porque la consulta puede no devolver nada
	List<T> getAll();
	void update(T t);
	void delete(T t);
}
