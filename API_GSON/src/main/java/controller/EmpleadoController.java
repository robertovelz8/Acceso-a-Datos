package controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import models.Empleado;
import utilidades.UtilidadesJSON;

public class EmpleadoController {

	private static final Logger logger = LogManager.getLogger(EmpleadoController.class);

	public static void main(String[] args) {
		UtilidadesJSON utilidades = new UtilidadesJSON();
		logger.debug(utilidades.getEmpleado("empleado.json"));
		List<Empleado> empleados = utilidades.getEmpleados("empleados.json");
		utilidades.escriboCSV(empleados, "empleados.csv");
	}

}
