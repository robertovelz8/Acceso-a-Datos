package modelo;

import java.util.List;
import java.util.Objects;

public class Pedido {

	private String idPedido;
	private String nombreCliente;
	private List<Plato> platos;
	private double total;

	public Pedido(String idPedido, String nombreCliente, List<Plato> platos, double total) {
		super();
		this.idPedido = idPedido;
		this.nombreCliente = nombreCliente;
		this.platos = platos;
		this.total = total;
	}

	public Pedido() {
		super();
	}

	public String getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(String idPedido) {
		this.idPedido = idPedido;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public List<Plato> getPlatos() {
		return platos;
	}

	public void setPlatos(List<Plato> platos) {
		this.platos = platos;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idPedido, nombreCliente, platos, total);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(idPedido, other.idPedido) && Objects.equals(nombreCliente, other.nombreCliente)
				&& Objects.equals(platos, other.platos)
				&& Double.doubleToLongBits(total) == Double.doubleToLongBits(other.total);
	}

	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", nombreCliente=" + nombreCliente + ", platos=" + platos + ", total="
				+ total + "]";
	}
}