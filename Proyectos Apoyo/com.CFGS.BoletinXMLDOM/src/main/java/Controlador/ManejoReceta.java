package Controlador;

import Utilidades.UtilidadesRecetaDOM;

public class ManejoReceta {

	public static void main(String[] args) {
		UtilidadesRecetaDOM utilidadesRecetaDOM = new UtilidadesRecetaDOM();
		String[] ingredientes = { "Huevos", "Patatas" };
		String[] cantidades = { "6", "4" };

		utilidadesRecetaDOM.crearRecetaXML("Tortilla de Patatas", ingredientes, cantidades,
				"Mezcla los ingredientes y a la olla hasta que este hecha.", "10 minutos");
	}
}