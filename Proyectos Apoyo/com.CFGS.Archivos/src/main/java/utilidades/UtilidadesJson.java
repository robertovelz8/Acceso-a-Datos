package utilidades;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;

import modelo.Empleado;

public class UtilidadesJson {

	private static final Logger logger = LogManager.getLogger(UtilidadesJson.class);
	private static final String rutaResources = "C:\\Users\\EQUIPO\\eclipse-workspace\\com.CFGS.Json\\src\\main\\resources\\";

	public Empleado getEmpleadoJson(String nombreFichero) {
		Empleado e = null;

		try {
			FileReader fichero = new FileReader(rutaResources + nombreFichero);
			Gson gson = new Gson();
			e = gson.fromJson(fichero, Empleado.class);

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		return e;
	}

	public Empleado[] getEmpleadosJson(String nombreFichero) {

		Empleado[] e = null;
		List<Empleado> empleados = new ArrayList<Empleado>();

		try {
			FileReader fichero = new FileReader(rutaResources + nombreFichero);
			Gson gson = new Gson();
			e = gson.fromJson(fichero, Empleado[].class);
			empleados = Arrays.asList(e);

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		return e;
	}

	public void escriboCSV(List<Empleado> empleados, String nombreFichero) {
		PrintWriter out = null;
		try {
			FileWriter ficheroSalida;
			ficheroSalida = new FileWriter(rutaResources + nombreFichero);
			// Se abre el fichero
			out = new PrintWriter(ficheroSalida);
			// Se recorren los empleados
			out.printf(generaCabecera() + "\n");
			for (Empleado e : empleados) {
				logger.debug("Empleado :%s,%s,%d,%s,%n ", e.getIdentificador(), e.getNombreApellido(), e.getEdad(),
						e.getEmpresa());
			}
		} catch (IOException e) {
			logger.info("Error");

		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

	private String generaCabecera() {
		return "identificador,nombreApellido,edad,empresa";

	}
}