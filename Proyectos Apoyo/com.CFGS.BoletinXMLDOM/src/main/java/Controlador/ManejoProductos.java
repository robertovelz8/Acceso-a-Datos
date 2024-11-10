package Controlador;

import Utilidades.UtilidadesProductos;

public class ManejoProductos {

	public static void main(String[] args) {

		UtilidadesProductos utilidadesProductos = new UtilidadesProductos();

		utilidadesProductos.actualizarAtributo("Productos.xml", "Producto");
	}
}