package Controlador;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Modelo.Empleado;
import Modelo.Puesto;
import Utilidades.EmpleadoXMLUtil;

public class App {

	private static final Logger logger = LogManager.getLogger(App.class);

	public static void main(String[] args) {
		EmpleadoXMLUtil util = new EmpleadoXMLUtil();

		// Crear un objeto Empleado con múltiples puestos
		Empleado empleado = new Empleado();
		empleado.setId("1");
		empleado.setNombreApellidos("Juan Pérez");
		empleado.setEdad(35);
		empleado.setEmpresa("Empresa");

		// Crear y añadir puestos al empleado
		Puesto puesto1 = new Puesto();
		puesto1.setId("p102");
		puesto1.setNombrePuesto("Analista de Marketing");
		puesto1.setDepartamento("Marketing");
		puesto1.setSalario(35000);

		Puesto puesto2 = new Puesto();
		puesto2.setId("p103");
		puesto2.setNombrePuesto("Responsable de equipo");
		puesto2.setDepartamento("Marketing");
		puesto2.setSalario(3000);

		empleado.addPuesto(puesto1);
		empleado.addPuesto(puesto2);

		// Generar archivo XML para el empleado
		String rutaXML = "empleado.xml";
		util.generarXML(empleado, rutaXML);

		// Leer empleados desde el archivo XML generado
		List<Empleado> empleados = util.leerEmpleadosDesdeXML(rutaXML);
		for (Empleado emp : empleados) {
			logger.error("Empleado: " + emp.getNombreApellidos());
			for (Puesto p : emp.getPuestos()) {
				logger.error("Puesto: " + p.getNombrePuesto() + ", Salario: " + p.getSalario());
			}
		}
	}
}