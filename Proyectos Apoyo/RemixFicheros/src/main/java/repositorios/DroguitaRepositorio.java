package repositorios;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import excepciones.DroguitaExceptions;
import modelos.Droguita;

public class DroguitaRepositorio {
	private static final Logger logger = LogManager.getLogger(DroguitaRepositorio.class);

	private List<Droguita> listaDroguitas;
	
	public void addDroguita(Droguita d) throws DroguitaExceptions{
		if(!listaDroguitas.contains(d)) {
			listaDroguitas.add(d);
			logger.debug(d.getNombre() + " ha sido añadida");

		}
		throw new DroguitaExceptions("La droguita ya está en el repositorio");
		}
	public void deleteDroguita(String nombreDroguita) throws IllegalArgumentException{
		for(Droguita d: listaDroguitas) {
			if(d.getNombre().equals(nombreDroguita)) {
				logger.debug(d.getNombre() + " ha sido eliminada");
				listaDroguitas.remove(d);
			}
		throw new IllegalArgumentException("La droguita no se encontró");
		}
	}
	public Droguita getDroguita (String nombreDroguita) {
		Droguita encontrada = null;
		for(Droguita d: listaDroguitas) {
			if(d.getNombre().equals(nombreDroguita)) {
				encontrada = d;
			}
		}
		if(encontrada  == null) {
			throw new IllegalArgumentException("La droguita no se encontró");
		}
		return encontrada;
	}
	public void updateDroguita (String droguita,int nuevaDosis) {
		Droguita drogui = getDroguita(droguita);
		drogui.setDosis(nuevaDosis);
	}
	}


