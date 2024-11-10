package utilidades;

import java.util.Comparator;

import modelos.Droguita;

public class ComparaDroguitasPorAdictos implements Comparator<Droguita>{



	//Este método compara droguitas por enganchaos  y si son iguales(0) entonces los compara por nombre
	@Override
	public int compare(Droguita o1, Droguita o2) {
		if(o1.getEnganchaos().size()==o2.getEnganchaos().size()) {
			return o2.getNombre().compareTo( o1.getNombre()); // si ponemos así invierte el orden y al hacer el reverse() aparece bien
		}
		else{
			return Integer.compare(o2.getEnganchaos().size(),o1.getEnganchaos().size());
		}
	}
}


