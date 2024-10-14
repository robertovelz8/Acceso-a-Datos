package files;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ManejoFicheros {
	private static final Logger logger = LogManager.getLogger(Ficheros.class);
	
	public String getDetalleFichero(File fichero) {
		String cadena = "";
		cadena = "Nombre: " + fichero.getName() + ", tamaño: " + fichero.length() + ", directorio padre: "
				+ fichero.getParent() + ", ruta absoluta: " + fichero.getAbsolutePath() + ", ruta relativa: "
				+ fichero.getPath();
		return cadena;
	}

	public void creaDirectorio(String ruta, String nombreDirectorio) {
		File directorioPadre = new File(ruta);
		if (directorioPadre.exists()) {
			File miDirectorio = new File(directorioPadre, nombreDirectorio);
			miDirectorio.mkdir();
		}
	}

	public void creaFichero(String ruta, String nombreFichero, boolean soloLectura) {
		File fichero = new File(ruta, nombreFichero);
		try {
			fichero.createNewFile();
			fichero.setReadable(soloLectura);
		} catch (IOException e) {
			e.getMessage();
		}
	}

	public String mostrarPermisos(String ruta, String nombreFichero) {
		File fichero = new File(ruta, nombreFichero);
		String cadena = "";
		if (fichero.exists()) {
			cadena = "Nombre: " + nombreFichero + ", permiso de lectura: " + fichero.canRead()
					+ ", permiso de escritura: " + fichero.canWrite() + ", permiso de ejecución: "
					+ fichero.canExecute();
		} else {
			cadena = "No existe el fichero";
		}

		return cadena;
	}

	public String renombrarFichero(String ruta, String nombreFichero, String nombreNuevo) {
		File fichero = new File(ruta, nombreFichero);
		File ficheroNuevo = new File(ruta, nombreNuevo);
		String resultado = "";
		if (!fichero.exists()) {
			resultado = "El archivo original no existe";
		} else {
			fichero.renameTo(ficheroNuevo);
			resultado = "Nombre del archivo cambiado a "+ficheroNuevo.getName();
		}
		return resultado;
	}
	
	public String borrarArchivo(String ruta, String nombreFichero) {
		File fichero = new File(ruta, nombreFichero);
		String resultado = "";
		if(!fichero.exists()) {
			resultado = "El fichero no existe.";
		}else {
			fichero.delete();
			resultado = "El fichero "+ fichero.getName()+" ha sido borrado correctamente.";
		}
		return resultado;
	}
	
	public void listarDirectorio(File f) {
		if (!f.isDirectory()) {
			logger.debug("Fichero: " + f.getAbsolutePath());
		}else {
			logger.debug("Directorio "+f.getAbsolutePath());
			for(File archivo : f.listFiles()) {
				listarDirectorio(archivo);
			}
		}
	}
}
