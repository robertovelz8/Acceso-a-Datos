package dao;

import java.util.List;

import org.hibernate.Session;

import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Subquery;
import modelos.Articulo;
import modelos.Autor;
import modelos.Revista;
import utiles.AbstractDao;
import utiles.HibernateUtil;

public class ArticuloDao extends AbstractDao<Articulo> {

	public ArticuloDao() {
		setClase(Articulo.class);
	}
	
	/*Diseña y codifica una consulta que devuelva, ordenada alfabéticamente por nombre de artículos, 
	 * los artículos de un autor del que sabemos su nombre
*/
	
	//QUERY
	
	public List<Articulo> getArticulosAutorOrdenados(String nombreAutor){
	    String dniAutor = getAutorDni(nombreAutor);
	    Session sesion = HibernateUtil.getFactoriaSession().openSession();
	    String consulta = "SELECT articulo FROM " + Articulo.class.getName() + " articulo " + 
	                      "WHERE :dniAutor IN (SELECT autor.dni FROM articulo.autores autor WHERE autor.dni = :dniAutor) " + 
	                      "ORDER BY articulo.titulo";
	    TypedQuery<Articulo> query = sesion.createQuery(consulta, Articulo.class);
	    query.setParameter("dniAutor", dniAutor);
	    List<Articulo> articulos = query.getResultList();
	    sesion.close();
	    return articulos;
	}
	private String getAutorDni(String nombre) {
		Session sesion = HibernateUtil.getFactoriaSession().openSession();
	    String consulta = "SELECT dni FROM " + Autor.class.getName() + " WHERE nombre = :nombre";
	    TypedQuery<String> query = sesion.createQuery(consulta, String.class);
        query.setParameter("nombre", nombre); 
	    return query.getSingleResult();
	}
	
	//CRITERIA
	
	public List<Articulo> getArticulosAutorOrdenadosCriteria(String nombreAutor){
	    // Obtener el DNI del autor usando su nombre
	    String dniAutor = getAutorDniCriteria(nombreAutor);
	    Session sesion = HibernateUtil.getFactoriaSession().openSession();
	    CriteriaBuilder cb = sesion.getCriteriaBuilder();
	    CriteriaQuery<Articulo> query = cb.createQuery(Articulo.class);
	    Root<Articulo> articulo = query.from(Articulo.class);
	    
	    Subquery<String> subquery = query.subquery(String.class);
	    Root<Articulo> articuloSubquery = subquery.from(Articulo.class);
	    Join<Articulo, Autor> autorJoin = articuloSubquery.join("autores"); // Relación con autores

	    subquery.select(autorJoin.get("dni")) // Seleccionamos el DNI del autor
	            .where(cb.equal(autorJoin.get("dni"), dniAutor),
	                   cb.equal(articuloSubquery, articulo));
	    
	    query.select(articulo);
	    query.where(cb.exists(subquery));
	    query.orderBy(cb.asc(articulo.get("titulo")));
	    
	    List<Articulo> articulos = sesion.createQuery(query).getResultList();
	    sesion.close();
	    return articulos;
	    }
	
	private String getAutorDniCriteria(String nombre) {
	    Session sesion = HibernateUtil.getFactoriaSession().openSession();
	    CriteriaBuilder cb = sesion.getCriteriaBuilder();
	    CriteriaQuery<String> query = cb.createQuery(String.class);
	    Root<Autor> autor = query.from(Autor.class);
		query.where(cb.equal(autor.get("nombre"), nombre));
		query.select(autor.get("dni"));
		String resultado = sesion.createQuery(query).getSingleResult();		
		return resultado;
	}
	
	/*Diseña y codifica una consulta que devuelva: el nombre del artículo y 
	 * el número de páginas para aquellos artículos que tienen más de 6 páginas.
	 * 
	 * Modifica la consulta anterior para añadir, además, el nombre de la revista y la fecha de publicación.*/

	//QUERY
	
	public List<Object[]> articulosMayorDeSeisPag() {
		Session sesion = HibernateUtil.getFactoriaSession().openSession();
	    String consulta = "SELECT articulo.titulo, (articulo.numPaginaFin - articulo.numPaginaInicio), articulo.revista.nombreRevista, articulo.revista.fecha FROM " + Articulo.class.getName() + " articulo " + 
                "WHERE (articulo.numPaginaFin - articulo.numPaginaInicio) > 6";  // Ordena los artículos por título
				
	    List<Object[]> resultados = sesion.createQuery(consulta).getResultList();
	    return resultados;
	}
	
	//CRITERIA
	
	public List<Object[]> articulosMayorDeSeisPagCriteria() {
	    Session sesion = HibernateUtil.getFactoriaSession().openSession();
	    CriteriaBuilder cb = sesion.getCriteriaBuilder();
	    CriteriaQuery<Object[]> query = cb.createQuery(Object[].class);
	    Root<Articulo> articulo = query.from(Articulo.class);
	    Join<Articulo,Revista> revista = articulo.join("revista");
	    query.multiselect(articulo.get("titulo"),
	            cb.diff(articulo.get("numPaginaFin"), articulo.get("numPaginaInicio")),
	            revista.get("nombreRevista"),
	            revista.get("fecha"));
	    query.where(cb.gt(cb.diff(articulo.get("numPaginaFin"),articulo.get("numPaginaInicio")),6));
	    List<Object[]> resultados = sesion.createQuery(query).getResultList();
	    sesion.close();
	    return resultados;
	}
	
	/*Muestra el número de artículos que tiene cada revista*/
	
	//QUERY
	
	public List<Object[]> getNumeroArticulosPorRevista(){
		Session sesion = HibernateUtil.getFactoriaSession().openSession();
		String consulta = "SELECT revista.nombreRevista, COUNT(articulo.idArticulo) " +
                "FROM " + Articulo.class.getName() + " articulo " +
                "JOIN articulo.revista revista " +
                "GROUP BY revista.idRevista";
	    TypedQuery<Object[]> query = sesion.createQuery(consulta, Object[].class);
		List<Object[]> resultados = query.getResultList();
		return resultados;
	}
	
	//CRITERIA
	
	public List<Object[]> getNumeroArticulosPorRevistaCriteria() {
	    Session sesion = HibernateUtil.getFactoriaSession().openSession();
	    CriteriaBuilder cb = sesion.getCriteriaBuilder();
	    CriteriaQuery<Object[]> query = cb.createQuery(Object[].class);
	    Root<Articulo> articulo = query.from(Articulo.class);
	    Join<Articulo, Revista> revista = articulo.join("revista");
	    query.multiselect(revista.get("nombreRevista"), cb.count(articulo.get("idArticulo")))
	         .groupBy(revista.get("idRevista"));
	    List<Object[]> resultados = sesion.createQuery(query).getResultList();
	    sesion.close();
	    return resultados;
	}

}