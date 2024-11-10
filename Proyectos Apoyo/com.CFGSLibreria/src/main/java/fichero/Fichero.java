package fichero;

import java.io.File;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Fichero {
	private static final Logger logger = LogManager.getLogger(Fichero.class);

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		logger.debug("Introduce por consola la ruta deseada: ");
		String rutaDirectorio = sc.next();
		File directorio = new File(rutaDirectorio);
		ManejoFicheros utilidades = new ManejoFicheros();
		sc.close();

		if (directorio.exists()) {
			File[] ficheros = directorio.listFiles();
			int numFicheros = ficheros.length;
			logger.debug("Numero de Ficheros: " + numFicheros);

			for (File fichero : ficheros) {
				logger.debug(utilidades.getDetalleFichero(fichero));
			}
		} else {
			logger.debug("El directorio no existe");
		}

		logger.debug("Numero de archivos: " + directorio.listFiles().length);
		utilidades.crearUnDirectorio(rutaDirectorio, "miDirectorio");
		logger.debug("Numero de archivos: " + directorio.listFiles().length);

		utilidades.crearUnFichero(rutaDirectorio, "miDirectorio", true);

		File directorioFile = new File(rutaDirectorio);
		utilidades.imprimeListaDirectorio(directorioFile);

		ManejaContenidoPersona.leerPersonasFicheroCsv(rutaDirectorio);
	}
}