package ud3;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Reunion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idReunion;
	private LocalDateTime fecha;
	private String asunto;
	
	
	//Constructor
	public Reunion() {
	}


	//Getters & Setters
	
	public int getIdReunion() {
		return idReunion;
	}


	public void setIdReunion(int idReunion) {
		this.idReunion = idReunion;
	}


	public LocalDateTime getFecha() {
		return fecha;
	}


	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}


	public String getAsunto() {
		return asunto;
	}


	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}


	@Override
	public String toString() {
		return "Reunion [idReunion=" + idReunion + ", fecha=" + fecha + ", asunto=" + asunto + "]";
	}
	
	
	
}
