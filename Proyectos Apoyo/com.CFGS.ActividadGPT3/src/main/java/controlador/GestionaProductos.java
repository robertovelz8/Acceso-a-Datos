package controlador;

import repositorio.RepositorioProductos;
import utiles.UtilidadesProductos;

public class GestionaProductos {
	public static void main(String[] args) {
		RepositorioProductos rp = new RepositorioProductos();
		UtilidadesProductos up = new UtilidadesProductos(rp);

		up.leerProductosXML();

		// rp.agregarProducto("Armario Vintage", 200.00, 5, Categoria.Hogar);
		up.escribeCatalogoProductos();

		up.modificaProductoAModificarCantidad("Armario Negro", 5);
		up.escribeProductosJSON("catalogo_productos.json");

	}
}