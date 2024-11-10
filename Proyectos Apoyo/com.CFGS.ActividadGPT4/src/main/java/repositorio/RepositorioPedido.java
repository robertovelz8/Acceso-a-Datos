package repositorio;

import java.util.ArrayList;
import java.util.List;

import modelo.Pedido;
import modelo.Plato;

public class RepositorioPedido {
	private List<Pedido> catalogoPedido = new ArrayList<>();

	// Nos permite obtener los estudiates de nuestra lista de estudiantes
	public List<Pedido> catalogoPedido() {
		return catalogoPedido;
	}

	// Agrega Esudiantes a la lista que luego se cargara en el XML
	public void agregarPedido(String idPedido, String nombreCliente, List<Plato> platos, double total) {
		Pedido p1 = new Pedido(idPedido, nombreCliente, platos, total);
		this.catalogoPedido.add(p1);
	}
}
