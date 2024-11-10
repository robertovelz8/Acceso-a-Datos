package utilidades;

import java.util.Comparator;

import modelo.Perro;

public class ComparaPerrosPorEdadyNombre implements Comparator<Perro>{

	//Este método compara perros por edad  y si son iguales(0) entonces los compara por nombre
	@Override
	public int compare(Perro o1, Perro o2) {
		if(Integer.compare(o1.getEdad(),o2.getEdad())==0) {
			return o1.getNombre().compareTo(o2.getNombre());
		}
		else {
			return Integer.compare(o1.getEdad(),o2.getEdad());
		}
	}
}
