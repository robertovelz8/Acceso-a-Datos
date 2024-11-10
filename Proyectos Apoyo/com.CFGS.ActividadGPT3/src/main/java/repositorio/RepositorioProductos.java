package repositorio;

import java.util.ArrayList;
import java.util.List;

import modelo.Categoria;
import modelo.Productos;

public class RepositorioProductos {

	private List<Productos> catalogoProductos = new ArrayList<>();

	// Nos permite obtener los estudiates de nuestra lista de estudiantes
	public List<Productos> catalogoProductos() {
		return catalogoProductos;
	}

	// Agrega Esudiantes a la lista que luego se cargara en el XML
	public void agregarProducto(String nombre, double precio, int cantidad, Categoria categoriaProducto) {
		Productos p1 = new Productos(nombre, precio, cantidad, categoriaProducto);
		this.catalogoProductos.add(p1);
	}
}