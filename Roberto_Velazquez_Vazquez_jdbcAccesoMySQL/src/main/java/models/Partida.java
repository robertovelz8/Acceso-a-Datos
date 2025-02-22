package models;

import java.time.LocalDate;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
@NoArgsConstructor
public class Partida {
	
	//Attributes
	@Setter(AccessLevel.NONE)
	private int id;
	
	@NonNull
	private Jugador narrador;
	
	@NonNull
	private LocalDate fecha;
	
	@NonNull
	private Resultado resultado;
	
	public void setId(int id) {
	this.id = id;
	}
}
