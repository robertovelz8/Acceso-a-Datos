package utilidades;

import java.util.Comparator;

import modelo.Perro;

public class ComparaPerrosPorNombres implements Comparator<Perro>{

	@Override
	public int compare(Perro o1, Perro o2) {
		return o1.getNombre().compareTo(o2.getNombre());
	}

}
