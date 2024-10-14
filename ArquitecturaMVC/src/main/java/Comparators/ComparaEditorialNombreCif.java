package Comparators;

import java.util.Comparator;

import modelo.Editorial;

public class ComparaEditorialNombreCif implements Comparator<Editorial> {

	@Override
	public int compare(Editorial e1, Editorial e2) {
		int resultado = 0;
		resultado = e1.getNombre().compareTo(e2.getNombre());
		
		if(resultado == 0) {
			resultado = e1.getCif().compareTo(e2.getCif());
		}
		return resultado;
	}

}
