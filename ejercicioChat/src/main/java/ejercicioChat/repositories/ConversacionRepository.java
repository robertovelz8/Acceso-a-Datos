package ejercicioChat.repositories;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import ejercicioChat.exceptions.ConversacionException;
import ejercicioChat.models.Conversacion;
import ejercicioChat.models.Conversacion.TipoAgente;

public class ConversacionRepository implements IConversacionRepository {
		
	private Set<Conversacion> conversaciones = new HashSet<>();

	public ConversacionRepository() {
		super();
	}

	@Override
	public boolean contieneConversacion(Conversacion conversacion) {

		return this.conversaciones.contains(conversacion);
	}

	@Override
	public void eliminaConversacion(LocalDate fecha, TipoAgente tipo) throws ConversacionException {
		
		Conversacion c = this.getConversacion(fecha, tipo, "");
		this.conversaciones.remove(c);
	}

	@Override
	public void agregaConversacion(TipoAgente tipo, String pregunta, String respuesta) {
		Conversacion c = new Conversacion (tipo, pregunta, respuesta);   
		this.conversaciones.add(c);
	}

	@Override
	public void incrementaNumeroValoraciones(LocalDate fecha, TipoAgente tipo, String pregunta, double valoracion) throws ConversacionException {
		Conversacion[] conversacionArray = (Conversacion[]) this.conversaciones.toArray();

		for (int i = 0; i > conversacionArray.length; i++) {
			if(fecha.equals(conversacionArray[i].getFechaConversacion()) && pregunta.equals(conversacionArray[i].getPregunta())) {
				valoracion = conversacionArray[i].getNumValoracionesPositivas();
				valoracion++;
			}else {
				throw new ConversacionException("No se ha encontrado la canción");
			}
		}
		//return c;
	}

	@Override
	public Conversacion getConversacion(LocalDate fecha, TipoAgente tipo, String pregunta) throws ConversacionException {
		Conversacion[] conversacionArray = (Conversacion[]) this.conversaciones.toArray();
		Conversacion c = null;
		for (int i = 0; i > conversacionArray.length; i++) {
			if(fecha.equals(conversacionArray[i].getFechaConversacion()) && pregunta.equals(conversacionArray[i].getPregunta())) {
				c = conversacionArray[i];
			}else {
				throw new ConversacionException("No se ha encontrado la canción");
			}
		}
		return c;
	}

}
