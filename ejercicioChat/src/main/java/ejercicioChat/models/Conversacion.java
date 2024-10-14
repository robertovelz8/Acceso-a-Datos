package ejercicioChat.models;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Conversacion {
	private String identificador;
	private String pregunta;
	private String respuesta;
	private LocalDate fechaConversacion;
	private int numValoracionesPositivas;
	public enum TipoAgente {
		IA,
		HUMANO
	}
	
	//Constructors
	public Conversacion(TipoAgente tipo, String pregunta, String respuesta) {
		super();
		this.fechaConversacion = LocalDate.now();
		this.identificador = calculaIdentificador();
		this.pregunta = pregunta;
		this.respuesta = respuesta;
	}
		
	public Conversacion(TipoAgente tipo, String peticion, String respuesta, LocalDate fechaConversacion, int numValoracionesPositivas) {
		super();		
		this.fechaConversacion = LocalDate.now();
		this.identificador = calculaIdentificador();
		this.pregunta = peticion;
		this.respuesta = respuesta;
		this.numValoracionesPositivas = numValoracionesPositivas;
	}





	//Getters & Setters
		
		
	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	public String getPregunta() {
		return pregunta;
	}
	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}
	public String getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	public LocalDate getFechaConversacion() {
		return fechaConversacion;
	}
	public void setFechaConversacion(LocalDate fechaConversacion) {
		this.fechaConversacion = fechaConversacion;
	}
	public int getNumValoracionesPositivas() {
		return numValoracionesPositivas;
	}
	public void setNumValoracionesPositivas(int numValoracionesPositivas) {
		this.numValoracionesPositivas = numValoracionesPositivas;
	}


	
	//toString()
	
	@Override
	public String toString() {
		return "Conversacion [identificador=" + identificador + ", pregunta="
				+ pregunta + ", respuesta=" + respuesta + ", fechaConversacion=" + fechaConversacion
				+ ", numValoracionesPositivas=" + numValoracionesPositivas + "]";
	}

	//hashCode()
	@Override
	public int hashCode() {
		return Objects.hash(identificador);
	}
	
	
	//Equals()	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conversacion other = (Conversacion) obj;
		return Objects.equals(identificador, other.identificador);
	}
	
	//Methods
	
	public String calculaIdentificador() {
		return fechaConversacion.toString() + Math.random();
	}
}
