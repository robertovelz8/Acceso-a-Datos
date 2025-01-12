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
		System.out.println("Articulos de un autor");
		for(Articulo a:articuloDao.getArticulosAutorOrdenados("Pepa Flores")) {
			logger.debug(a.toString());
		}
		/*for(Object[] o: articuloDao.articulosMayorDeSeisPagCriteria()) {
			logger.debug("título: " + o[0] + " páginas: " + o[1] + " revista: " + o[2] + " fecha de publicación:" + o[3]);
		}*/
		/*for(Object[] o: articuloDao.getNumeroArticulosPorRevista()) {
			logger.debug("título: " + o[0] + " número de artículos: " + o[1]);
		}*/
		/*for(Object[] o: articuloDao.getNumeroArticulosPorRevistaCriteria()) {
			logger.debug("título: " + o[0] + " número de artículos: " + o[1]);
		}*/
		/*for(Object[] o: revistaDao.getDatosRevistas(LocalDate.of(2025, 1, 1))) {
			logger.debug("nombre de la revista: " + o[0] + " fecha: " + o[1] + " número: " + o[2]);
		}*/
	}

}
/*1. Relación Uno a Uno (@OneToOne)
Unidireccional:

Es posible y común cuando solo una entidad necesita conocer a la otra.
Ejemplo: Una persona tiene un pasaporte, pero no necesitas que el pasaporte conozca a la persona.
java
Copiar código
@Entity
public class Persona {
    @OneToOne
    @JoinColumn(name = "pasaporte_id")
    private Pasaporte pasaporte;
}
Bidireccional:

Es posible cuando ambas entidades necesitan conocerse.
Ejemplo: Un pasaporte debe conocer a la persona a la que pertenece.
java
Copiar código
@Entity
public class Pasaporte {
    @OneToOne(mappedBy = "pasaporte")
    private Persona persona;
}
2. Relación Uno a Muchos (@OneToMany)
Unidireccional:

Es posible, pero puede ser menos eficiente porque requiere una tabla intermedia para mapear la relación.
Ejemplo: Una revista tiene una lista de artículos, pero los artículos no necesitan conocer la revista.
java
Copiar código
@Entity
public class Revista {
    @OneToMany
    @JoinColumn(name = "revista_id") // Genera una columna en la tabla de artículos
    private List<Articulo> articulos;
}
Bidireccional:

Es común y más eficiente cuando necesitas navegar en ambas direcciones.
Ejemplo: Los artículos necesitan conocer a la revista a la que pertenecen.
java
Copiar código
@Entity
public class Articulo {
    @ManyToOne
    @JoinColumn(name = "revista_id")
    private Revista revista;
}
3. Relación Muchos a Uno (@ManyToOne)
Unidireccional:

Es el caso más común, ya que muchas entidades suelen relacionarse con una entidad principal.
Ejemplo: Muchos artículos pertenecen a una revista, pero la revista no necesita conocer a los artículos.
java
Copiar código
@Entity
public class Articulo {
    @ManyToOne
    @JoinColumn(name = "revista_id")
    private Revista revista;
}
Bidireccional:

Es posible si necesitas que la entidad principal también conozca las entidades relacionadas.
Ejemplo: Una revista conoce todos los artículos asociados.
java
Copiar código
@Entity
public class Revista {
    @OneToMany(mappedBy = "revista")
    private List<Articulo> articulos;
}
4. Relación Muchos a Muchos (@ManyToMany)
Unidireccional:

Es posible cuando solo una de las entidades necesita conocer la relación.
Ejemplo: Los artículos tienen varios autores, pero los autores no necesitan conocer los artículos.
java
Copiar código
@Entity
public class Articulo {
    @ManyToMany
    @JoinTable(
        name = "articulo_autor",
        joinColumns = @JoinColumn(name = "articulo_id"),
        inverseJoinColumns = @JoinColumn(name = "autor_id")
    )
    private List<Autor> autores;
}
Bidireccional:

Es común cuando ambas entidades necesitan conocer la relación.
Ejemplo: Los autores conocen los artículos en los que han trabajado.
java
Copiar código
@Entity
public class Autor {
    @ManyToMany(mappedBy = "autores")
    private List<Articulo> articulos;
}*/
