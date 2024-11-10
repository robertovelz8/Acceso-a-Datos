package repositorio;

import java.util.ArrayList;
import java.util.List;

import modelo.Plato;

public class RepositorioPlato {

	List<Plato> listaPlatos = new ArrayList<Plato>();

	// Nos permite obtener los estudiates de nuestra lista de estudiantes
	public List<Plato> listaPlatos() {
		return listaPlatos;
	}

	public double getPrecioTotal() {
		double total = 0;
		for (int j = 0; j < listaPlatos.size(); j++) {
			total += listaPlatos.get(j).getPrecio();
		}
		return total;
	}

	// Agrega Esudiantes a la lista que luego se cargara en el XML
	public void agregarPlato(String nombre, double precio) {
		Plato p1 = new Plato(nombre, precio);
		this.listaPlatos.add(p1);
	}
}
