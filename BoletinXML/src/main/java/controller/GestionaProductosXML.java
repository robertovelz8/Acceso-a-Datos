package controller;

import utilesXML.ManejaFicherosXMLProducto;

public class GestionaProductosXML {
	public static void main(String[] args) {
		
		ManejaFicherosXMLProducto m1 = new ManejaFicherosXMLProducto();
		m1.actualizarProducto("Productos.xml", "Producto");
	}
}
