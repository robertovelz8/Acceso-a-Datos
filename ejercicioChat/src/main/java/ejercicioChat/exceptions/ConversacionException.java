package ejercicioChat.exceptions;

public class ConversacionException extends Exception{

	public ConversacionException(String message) {
		super("Excepción generada en la clase Modelo: "+message);
	}
	
	

}
