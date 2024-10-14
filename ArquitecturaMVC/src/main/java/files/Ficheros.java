package files;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Ficheros {
	private static final Logger logger = LogManager.getLogger(Ficheros.class);
	private static final String rutaBase = "C:\\Users\\EQUIPO\\Desktop\\";
	
	public static void main(String[] args) {
		String nombreDirectorio = rutaBase+"HLC\\practica-1";
		
		
		ManejoFicheros utilidades = new ManejoFicheros();	

		File directorio = new File(nombreDirectorio);
		if (directorio.exists()) {
			File[] archivos = directorio.listFiles();
			for (int i = 0; i < archivos.length; i++) {
				logger.debug(utilidades.getDetalleFichero(archivos[i]));

			}
		} else {
			logger.debug("No existen ficheros.");
		}
		
		
		logger.debug("Numero de archivos: "+directorio.listFiles().length);
		utilidades.creaDirectorio(nombreDirectorio, "miDirectorio");
		logger.debug("Numero de archivos: "+directorio.listFiles().length);
		
		utilidades.creaFichero(nombreDirectorio, "fichero.txt", false);
		utilidades.creaFichero(nombreDirectorio, "fichero2.txt", true);
		
		logger.debug("Numero de archivos: "+directorio.listFiles().length);
		logger.debug(utilidades.mostrarPermisos(nombreDirectorio, "fichero2.txt"));
		logger.debug(utilidades.renombrarFichero(nombreDirectorio, "fichero.txt", "archivoRenombrado"));
		logger.debug(utilidades.borrarArchivo(nombreDirectorio, "fichero2.txt"));
		
		File directorio1 = new File(nombreDirectorio);
		utilidades.listarDirectorio(directorio1);
	}
}
