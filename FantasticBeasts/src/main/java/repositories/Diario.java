package repositories;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import exceptions.CriaturaException;
import models.Criatura;
import models.Tipo;

public class Diario {

	// Attributes

	private Map<LocalDate, Criatura> criaturas;

	// Constructor
	public Diario() {
		super();
		this.criaturas = new HashMap<LocalDate, Criatura>();
	}

	// Getters & Setters
	public Map<LocalDate, Criatura> getCriaturas() {
		return criaturas;
	}
	

	public void setCriaturas(Map<LocalDate, Criatura> criaturas) {
		this.criaturas = criaturas;
	}

	public void addEntrada(LocalDate fecha, Criatura criatura) throws CriaturaException {
		if (!(this.criaturas.containsKey(fecha) && this.criaturas.containsValue(criatura))) {
			criaturas.put(fecha, criatura);
		} else {
			throw new CriaturaException("Excepción al añadir la criatura: " + criatura.getNombre());
		}
	}

	public void eliminarEntrada(LocalDate fecha) throws CriaturaException {

		if (this.criaturas.containsKey(fecha)) {
			this.criaturas.remove(fecha);
		} else {
			throw new CriaturaException("Excepción al eliminar la criatura con fecha: " + criaturas.get(fecha));
		}
	}

	public void eliminarEntrada(Criatura criatura) throws CriaturaException {
		LocalDate fechaEliminar = null;
		boolean flag = true;
		while (flag) {
			for (Map.Entry<LocalDate, Criatura> entry : this.criaturas.entrySet()) {
				if (entry.getValue().equals(criatura)) {
					fechaEliminar = entry.getKey();
					flag = false;
				}
			}
		}
		if (fechaEliminar != null) {
			this.criaturas.remove(fechaEliminar);
		} else {
			throw new CriaturaException("No se ha podido eliminar la entrada de la criatura: " + criatura.getNombre());
		}
	}

	public List<Criatura> obtenerCriaturasDeTipo(Tipo tipoDeCriatura) throws CriaturaException {
		List<Criatura> CriaturaDelMismoTipo = new ArrayList<Criatura>();
		for (Map.Entry<LocalDate, Criatura> entry : criaturas.entrySet()) {
			if (entry.getValue().getTipo().equals(tipoDeCriatura)) {
				CriaturaDelMismoTipo.add(entry.getValue());
			}
		}
		if(CriaturaDelMismoTipo.size() == 0) {
			throw new CriaturaException("Excepción al encontrar la criatura de tipo: "+tipoDeCriatura);
		}
		return CriaturaDelMismoTipo;
	}
	
	public Criatura obtenerDetalleCriatura (String nombre, Tipo tipo) throws CriaturaException{
		Criatura cr1 = null;
		for(Map.Entry<LocalDate, Criatura> entry : criaturas.entrySet()) {
			if(entry.getValue().getNombre().equals(nombre) && entry.getValue().getTipo().equals(tipo)) {
				cr1 = entry.getValue();
			}
		}
		if(cr1 == null) {
			throw new CriaturaException("Excepción al encontrar la criatura de nombre: "+nombre+" y tipo: " +tipo);
		}
		return cr1;
	}
}
