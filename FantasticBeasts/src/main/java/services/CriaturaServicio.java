package services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import exceptions.CriaturaException;
import models.Criatura;
import models.Tipo;
import repositories.Diario;

public class CriaturaServicio {
	
	//Attributes
	private Diario diario;
	private static final Logger logger = LogManager.getLogger(CriaturaServicio.class);


	//Constructor
	public CriaturaServicio() {
		super();
		this.diario = new Diario();
	}
	
	//Methods
	public void addEntrada (LocalDate fecha, Criatura criatura) {
		try {
			this.diario.addEntrada(fecha, criatura);
		} catch (CriaturaException e) {
			logger.error("Excepción al añadir la criatura: " + criatura.getNombre()+". "+e.getMessage());
		}
	}
	
	public void eliminarEntrada (LocalDate fecha) {
		try {
			this.diario.eliminarEntrada(fecha);
		} catch (CriaturaException e) {
			logger.error("Excepción al eliminar la criatura con fecha: " + diario.getCriaturas().get(fecha)+". "+e.getMessage());
		}
	}
	
	public void eliminarEntrada(Criatura criatura) {
		try {
			this.diario.eliminarEntrada(criatura);
		} catch (CriaturaException e) {
			logger.error("No se ha podido eliminar la entrada de la criatura: " + criatura.getNombre());
		}
	}
	
	public List<Criatura> obtenerCriaturasDeTipo(Tipo tipoDeCriatura) {
		List<Criatura> criaturas = new ArrayList<Criatura>();
		try {
			criaturas = this.diario.obtenerCriaturasDeTipo(tipoDeCriatura);
		} catch (CriaturaException e) {
			logger.error("Excepción al encontrar la criatura de tipo: "+tipoDeCriatura);
		}
		return criaturas;
	}
	
	public Criatura obtenerDetalleCriatura (String nombre, Tipo tipo) {
		Criatura criatura = null;
		try {
			criatura = this.diario.obtenerDetalleCriatura(nombre, tipo);
		} catch (CriaturaException e) {
			logger.error("Excepción al encontrar la criatura de nombre: "+nombre+" y tipo: " +tipo);
		}
		return criatura;
	}
	
	public Map<LocalDate, Criatura> getCriaturas() {
		return this.diario.getCriaturas();
	}
	
}
