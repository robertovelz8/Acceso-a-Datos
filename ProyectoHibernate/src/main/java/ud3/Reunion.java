package ud3;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.criteria.Fetch;

@Entity
public class Reunion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idReunion;
	private LocalDateTime fecha;
	private String asunto;
	
	@ManyToOne
	@JoinColumn(name = "id")
	private Sala sala;
	
	
	//Constructor
	public Reunion() {
	}

	

	public Reunion(LocalDateTime fecha, String asunto, Sala sala) {
		this.fecha = fecha;
		this.asunto = asunto;
		this.sala = sala;
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


	public Sala getSala() {
		return sala;
	}


	public void setSala(Sala sala) {
		this.sala = sala;
	}


	@Override
	public String toString() {
		return "Reunion [idReunion=" + idReunion + ", fecha=" + fecha + ", asunto=" + asunto + ", sala=" + sala.getNombre() + "]";
	}
	
	
	
}
