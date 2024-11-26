package models;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

public class Cita {
	//Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JoinColumn(name = "id_cita")
	private int idCita;
	private Date fecha;
	private Time hora;
	private String motivo;
	
	@OneToOne
	private Paciente paciente;

	//Constructors
	public Cita(int idCita, Date fecha, Time hora, String motivo, Paciente paciente) {
		this.idCita = idCita;
		this.fecha = fecha;
		this.hora = hora;
		this.motivo = motivo;
		this.paciente = paciente;
	}

	public Cita(int idCita) {
		this.idCita = idCita;
	}

	//Getters & Setters
	public int getIdCita() {
		return idCita;
	}

	public void setIdCita(int idCita) {
		this.idCita = idCita;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	@Override
	public String toString() {
		return "Cita [idCita=" + idCita + ", fecha=" + fecha + ", hora=" + hora + ", motivo=" + motivo + ", paciente="
				+ paciente + "]";
	}
	
	
}
