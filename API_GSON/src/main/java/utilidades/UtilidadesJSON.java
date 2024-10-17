package utilidades;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

import models.Empleado;

public class UtilidadesJSON {

	private static final String rutaResources = "C:\\Users\\EQUIPO\\eclipse-workspace\\API_GSON\\src\\main\\resources\\";

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
}
