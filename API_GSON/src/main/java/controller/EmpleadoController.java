package controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import utilidades.UtilidadesJSON;

public class EmpleadoController {

	private static final Logger logger = LogManager.getLogger(EmpleadoController.class);

	public static void main(String[] args) {
		UtilidadesJSON utilidades = new UtilidadesJSON();
		logger.debug(utilidades.getEmpleado("empleado.json"));
		logger.debug(utilidades.getEmpleados("empleados.json"));
	}

}
