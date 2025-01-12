package dao;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import jakarta.persistence.TypedQuery;
import modelos.Articulo;
import utiles.AbstractDao;
import utiles.HibernateUtil;

public class ArticuloDao extends AbstractDao<Articulo> {

	private static final Logger logger = LogManager.getLogger(ArticuloDao.class);



	public ArticuloDao() {
		setClase(Articulo.class);
	}
	
	//Diseña y codifica una consulta que devuelva, ordenada alfabéticamente por nombre de artículos, los artículos de un autor del que sabemos su nombre.
	public List<Articulo> getNombreByArticulo () {
    	Session sesion = HibernateUtil.getFactoriaSession().openSession();
    	String queryString =  "FROM " + Articulo.class.getName() + " INNER JOIN autores a WHERE a.nombre = :nombreAutor ORDER BY titulo ASC";
    	TypedQuery<Articulo> query = sesion.createQuery(queryString, Articulo.class);
    	query.setParameter("nombreAutor", "Pepa Flores");
    	List<Articulo> articulos = query.getResultList();
    	return articulos;
	}
	
	//Diseña y codifica una consulta que devuelva: el nombre del artículo y el número de páginas para aquellos artículos que tienen más de 6 páginas.
	public void getNombreWithNumPaginasByArticulo () {
    	Session sesion = HibernateUtil.getFactoriaSession().openSession();
    	String queryString = "SELECT titulo, (numPaginaFin - numPaginaInicio + 1) AS numero_paginas FROM "+ Articulo.class.getName() + " WHERE (numPaginaFin - numPaginaInicio + 1) > :numero_paginas";
    	TypedQuery<Object[]> query = sesion.createQuery(queryString, Object[].class);
    	query.setParameter("numero_paginas", 6);
    	List<Object[]> articulos = query.getResultList();
    	
    	for (Object[] articulo : articulos) {
    		logger.debug("Título: "+articulo[0]);
    		logger.debug("Número de páginas: "+articulo[1]);
    	}
	}
	
	//Modifica la consulta anterior para añadir, además, el nombre de la revista y la fecha de publicación.
	public void getNombreNumPaginasNombreRevistaAndFechaByArticulo() {
    	Session sesion = HibernateUtil.getFactoriaSession().openSession();
    	String queryString = "SELECT titulo, (numPaginaFin - numPaginaInicio + 1) AS numero_paginas, r.nombreRevista, r.fecha FROM "+ Articulo.class.getName() + " INNER JOIN revista r WHERE (numPaginaFin - numPaginaInicio + 1) > :numero_paginas";
    	TypedQuery<Object[]> query = sesion.createQuery(queryString, Object[].class);
    	query.setParameter("numero_paginas", 6);
    	List<Object[]> articulosAndRevista = query.getResultList();
    	
    	for (Object[] articuloRevista : articulosAndRevista) {
    		logger.debug("Título: "+articuloRevista[0]);
    		logger.debug("Número de páginas: "+articuloRevista[1]);
    		logger.debug("Nombre de revista: "+articuloRevista[2]);
    		logger.debug("Fecha de publicación: "+articuloRevista[3]);
    	}
	}
}