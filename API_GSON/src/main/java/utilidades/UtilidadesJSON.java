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

import models.Empleado;

public class UtilidadesJSON {

	private static final Logger logger = LogManager.getLogger(UtilidadesJSON.class);

	private static final String rutaResources = "C:\\Users\\EQUIPO\\Desktop\\2 DAM\\Acceso a Datos\\API_GSON\\src\\main\\resources\\";

	public Empleado getEmpleado(String nombreFichero) {
		Empleado e = null;

		try {
			FileReader fichero = new FileReader(rutaResources + nombreFichero);
			Gson gson = new Gson();
			e = gson.fromJson(fichero, Empleado.class);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return e;
	}
	
	public List<Empleado> getEmpleados(String nombreFichero) {
		Empleado[] e = null;
		List<Empleado> empleados = new ArrayList<Empleado>();
		try {
			FileReader fichero = new FileReader(rutaResources + nombreFichero);
			Gson gson = new Gson();
			e = gson.fromJson(fichero, Empleado[].class);
			empleados = Arrays.asList(e);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return empleados;
	}
	

	
	private String generaCabecera(String nombreFichero) {
		return "Identificador, nombre y apellidos, edad, empresa";
	}
	
	public void escriboCSV (List<Empleado> empleados, String nombreFichero) {
		PrintWriter pw = null;
		try {
			FileWriter ficheroSalida = new FileWriter(rutaResources+nombreFichero);
			pw = new PrintWriter(ficheroSalida);
			pw.printf(generaCabecera(nombreFichero));
			for (Empleado empleado : empleados) {
				pw.printf("%n%s, %s, %d, %s",empleado.getIdentificador(),empleado.getNombreApellido()
				,empleado.getEdad(),empleado.getEmpresa());
			}
			
		}catch(IOException e) {
			logger.error("No se ha encontrado la ruta del fichero: "+nombreFichero);
		}finally {
			if (pw != null) {
				pw.close();
			}
		}
	}
}
