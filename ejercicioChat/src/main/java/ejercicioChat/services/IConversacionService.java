package ejercicioChat.services;

import java.time.LocalDate;

import ejercicioChat.models.Conversacion;
import ejercicioChat.models.Conversacion.TipoAgente;

public interface IConversacionService {
	
	public boolean registraNuevaConversacion(TipoAgente tipo, String pregunta, String respuesta);
	public Conversacion getRecuperaConversacion (TipoAgente tipo, String pregunta, LocalDate fecha);
	public boolean eliminaConversacion (LocalDate fecha, TipoAgente tipo);
	public boolean incrementaNumeroValoraciones (LocalDate fecha, TipoAgente tipo, String pregunta);
}
