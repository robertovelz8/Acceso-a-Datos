package controladores;

import java.time.LocalDate;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.ArticuloDao;
import dao.AutorDao;
import dao.RevistaDao;
import modelos.Articulo;
import modelos.Autor;
import modelos.Revista;

public class GestionaArticulos {
	private static final Logger logger = LogManager.getLogger(GestionaArticulos.class);

	public static void main(String[] args) {
		AutorDao autorDao = new AutorDao();
        ArticuloDao articuloDao = new ArticuloDao();
        RevistaDao revistaDao = new RevistaDao();
        Autor a1 = new Autor("12345678C", "Pepa Flores", "flores@gmail.com");
        autorDao.create(a1);
        Autor a2 = new Autor("12345679E", "Ruperta Florero", "florero@gmail.com");
        autorDao.create(a2);
        Autor a3 = new Autor("1222679E", "Ramon Florito", "florito@gmail.com");
        autorDao.create(a3);

        Articulo ar1 = new Articulo("Seguridad en los datos", 10, 15);
        Articulo ar2 = new Articulo("Seguridad en la web", 5, 12);
        Articulo ar3 = new Articulo("Cifrado de datos", 10, 25);
        Articulo ar4 = new Articulo("Consumo de recursos por la IA", 7, 27);
        Articulo ar5 = new Articulo("IA: impacto en la escuela", 2, 4);
        Articulo ar6 = new Articulo("Pair programming", 8, 29);
        ar1.addAutor(a2);
        ar1.addAutor(a1);
        ar2.addAutor(a1);
        ar2.addAutor(a3);
        ar3.addAutor(a3);
        ar4.addAutor(a3);
        ar5.addAutor(a3);
        ar6.addAutor(a1);

        Revista r = new Revista("Revista 1", 1, LocalDate.now(), 179);
        revistaDao.create(r);
        r.addArticulo(ar2);
        r.addArticulo(ar1);
        revistaDao.mergeaObjeto(r);

        Revista r2 = new Revista("Revista 1", 2, LocalDate.now().minusDays(300), 180);
        revistaDao.create(r2);
        r2.addArticulo(ar3);
        r2.addArticulo(ar4);
        r2.addArticulo(ar5);
        r2.addArticulo(ar6);
        revistaDao.mergeaObjeto(r2);

        List<Autor> autores = autorDao.getAll();
        for (Autor a : autores) {
            logger.debug(a);
        }

        List<Articulo> articulos = articuloDao.getAll();
        for (Articulo a : articulos) {
            logger.debug(a);
        }
        
        //1. Diseña y codifica una consulta que devuelva, ordenada alfabéticamente por nombre de artículos, los artículos de un autor del que sabemos su nombre.
        logger.debug(articuloDao.getNombreByArticulo());
    	
        //2. Diseña y codifica una consulta que devuelva: el nombre del artículo y el número de páginas para aquellos artículos que tienen más de 6 páginas.
        articuloDao.getNombreWithNumPaginasByArticulo();
        
        //3. Modifica la consulta anterior para añadir, además, el nombre de la revista y la fecha de publicación.
        articuloDao.getNombreNumPaginasNombreRevistaAndFechaByArticulo();
        
    	//4. Muestra el número de artículos que tiene cada revista.
        revistaDao.getNumArticuloByRevista();
        
    	//5. Crea una consulta que muestre los datos de las revistas (nombre, fecha y número) que se han publicado antes de una fecha.
        revistaDao.getNombreFechaAndNumeroWithFechaByRevista();
	}
	
	

}
