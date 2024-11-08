package controller;

import utilesXML.ManejaFicherosXMLReceta;

public class GestionaRecetaXML {

	public static void main(String[] args) {
		ManejaFicherosXMLReceta m1 = new ManejaFicherosXMLReceta();
		
		String[] ingredientes = {"Arroz", "Pollo"};	
		String[] cantidad = {"2 puñaos", "100g"} ;
		m1.creaRecetaXML("Arroz con pollo", ingredientes, cantidad, "Asar el pollo y echarle especias", "2 horas");
	}

}
