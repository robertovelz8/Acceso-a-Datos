package controlador;

import repositorio.RepositorioPedido;
import repositorio.RepositorioPlato;
import utiles.UtilidadesPedido;

public class GestorPedidos {
	public static void main(String[] args) {
		RepositorioPedido rp = new RepositorioPedido();
		RepositorioPlato rp2 = new RepositorioPlato();
		UtilidadesPedido up = new UtilidadesPedido(rp);

		rp2.agregarPlato("Kebab", 7);
		rp2.agregarPlato("Patatas Fritas", 5);

		rp.agregarPedido("1242315", "Sergio Turrillo", rp2.listaPlatos(), rp2.getPrecioTotal());

		up.cargarPedidos();

		up.escribeCatalogoPedidos("NuevoXML.xml");

		System.out.println("Total price: " + rp2.getPrecioTotal());

		;
	}

}
