package servicios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import excepciones.DroguitaExceptions;
import modelos.Droguita;
import modelos.Yonki;
import repositorios.DroguitaRepositorio;
import utilidades.ComparaDroguitasPorAdictos;

public class DroguitaServicio {
private DroguitaRepositorio repos;

public void droguitasYYonkis(List<Droguita> drogass, List<Yonki> enganchaitos ) {
	for(Droguita droguita: drogass) {
		for(Yonki engancheta: enganchaitos) {
			if(droguita.getNombre().equals(engancheta.getAdiccion())) {
				droguita.getEnganchaos().add(engancheta);
			}
		}
	}
}
public List<Droguita> droguitasMortales(List<Droguita>drogass, boolean mortal){
	List<Droguita> tusDroguis = new ArrayList<>();
	for(Droguita droguita: drogass) {
		if(droguita.isMortal()==(mortal)) {
			tusDroguis.add(droguita);
		}
	}
	return tusDroguis;
}
public List<Droguita> ordenaDroguitasPorEnganchaos(List<Droguita> drogass){
	Collections.sort(drogass, new ComparaDroguitasPorAdictos());
	return drogass; 
}
public List<Yonki> yonkisConMasDetencionesQue(List<Yonki> yonkesitos, int detenciones) throws DroguitaExceptions{
	List<Yonki> losElegidos = new ArrayList<>();
	try {
	for(Yonki junkee:yonkesitos) {
		if(junkee.getDetenciones()>=detenciones) {
			losElegidos.add(junkee);
		}
	}
	if(losElegidos.isEmpty()) {
		throw new DroguitaExceptions("No hay nadie con tantas detenciones");
	}
	}catch (Exception e) {
		throw new DroguitaExceptions("Ocurrió un error");
	}
	return losElegidos;

}
public List<Yonki> filtrarYonkisPorGenero(List<Yonki> yonkesitos, Yonki.Genero genero) throws DroguitaExceptions{
	List<Yonki> losElegidos = new ArrayList<>();
	try {
	for(Yonki junkee:yonkesitos) {
		if(junkee.getGenero().equals(genero)) {
			losElegidos.add(junkee);
		}
	}

	}catch (Exception e) {
		throw new DroguitaExceptions("Ocurrió un error");
	}
	return losElegidos;
}
	
}
