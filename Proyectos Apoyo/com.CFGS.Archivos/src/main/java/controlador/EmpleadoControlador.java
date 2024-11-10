package controlador;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modelo.Empleado;
import utilidades.UtilidadesJson;

public class EmpleadoControlador {

	private static final Logger logger = LogManager.getLogger(EmpleadoControlador.class);

	public static void main(String[] args) {
		UtilidadesJson utilidades = new UtilidadesJson();
		logger.info(utilidades.getEmpleadoJson("empleado.json"));
		logger.info(utilidades.getEmpleadosJson("empleados.json"));
		Empleado[] empleados = utilidades.getEmpleadosJson("empleados.json");
		for (Empleado e : empleados) {
			logger.info(e);
		}

	}

}
