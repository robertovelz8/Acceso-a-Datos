package ejercicioChat.repositories;

import java.time.LocalDate;

import ejercicioChat.exceptions.ConversacionException;
import ejercicioChat.models.Conversacion;
import ejercicioChat.models.Conversacion.TipoAgente;

public interface IConversacionRepository {
	public boolean contieneConversacion (Conversacion conversacion);
	public void eliminaConversacion (LocalDate fecha, TipoAgente tipo) throws ConversacionException;
	public void agregaConversacion (TipoAgente tipo, String pregunta, String respuesta);
	public void incrementaNumeroValoraciones (LocalDate fecha, TipoAgente tipo, String pregunta, double valoracion) throws ConversacionException;
	public Conversacion getConversacion (LocalDate fecha, TipoAgente tipo, String pregunta) throws ConversacionException;
}
