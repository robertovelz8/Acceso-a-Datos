package models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Jugador {
	
	//Attributes
	@Setter(AccessLevel.NONE)
	private int id;
	
	@NonNull
	private String nombre;
	
	@NonNull
	private String email;
	
	@NonNull
	private int puntosTotales;
	
	public void setId(int id) {
	this.id = id;
	}
}
