package ejercicioChat.services;

import java.time.LocalDate;

import ejercicioChat.models.Conversacion;
import ejercicioChat.models.Conversacion.TipoAgente;

public class ConversacionServiceImpl implements IConversacionService {
	
	//Attributes
	private double valoracionMediaParaHumanos;
	private double valoracionMediaParaBots;

	@Override
	public boolean registraNuevaConversacion(TipoAgente tipo, String pregunta, String respuesta) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Conversacion getRecuperaConversacion(TipoAgente tipo, String pregunta, LocalDate fecha) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eliminaConversacion(LocalDate fecha, TipoAgente tipo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean incrementaNumeroValoraciones(LocalDate fecha, TipoAgente tipo, String pregunta) {
		// TODO Auto-generated method stub
		return false;
	}

	//Getters
	
	public double getValoracionMediaParaHumanos() {
		return valoracionMediaParaHumanos;
	}

	public double getValoracionMediaParaBots() {
		return valoracionMediaParaBots;
	}
	
	
}
