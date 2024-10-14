package ejercicioChat.controllers;

import java.time.LocalDate;

import ejercicioChat.models.Conversacion;
import ejercicioChat.models.Conversacion.TipoAgente;
import ejercicioChat.repositories.ConversacionRepository;

public class GesticionaPeticionesAChat {
	public static void main(String[] args) {
		
		//Conversacion
		Conversacion c1 = new Conversacion (TipoAgente.HUMANO, "¿Cómo vas?", "Bien");
		Conversacion c2 = new Conversacion (TipoAgente.IA, "¿Cómo NO vas?", "Mal", LocalDate.now(), 10);
		
		System.out.println(c1.toString());
		System.out.println(c2.toString());
		
		//equals
		
		System.out.println(c1.equals(c2));
		
		//ConversacionRepository
		ConversacionRepository cr1 = new ConversacionRepository ();
		cr1.agregaConversacion(TipoAgente.HUMANO, "¿Qué estás escuchando?", "El nuevo disco de Anuel");
		System.out.println();
		ConversacionRepository cr2 = new ConversacionRepository ();
		cr2.agregaConversacion(TipoAgente.HUMANO, "¿Qué estás escuchando?", "El nuevo disco de Anuel");

	}

}
