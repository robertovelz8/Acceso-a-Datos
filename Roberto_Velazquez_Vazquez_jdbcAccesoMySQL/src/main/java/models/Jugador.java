package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Jugador {
	
	//Attributes
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
