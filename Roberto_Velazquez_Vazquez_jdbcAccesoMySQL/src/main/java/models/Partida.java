package models;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Partida {
	
	//Attributes
	private int id;
	
	
	private Jugador narrador;
	
	
	private LocalDate fecha;
	
	
	private Resultado resultado;
	
	public void setId(int id) {
	this.id = id;
	}
}
