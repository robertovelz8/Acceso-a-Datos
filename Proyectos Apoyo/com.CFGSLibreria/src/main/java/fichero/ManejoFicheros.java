package fichero;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ManejoFicheros {
	private static final Logger logger = LogManager.getLogger(Fichero.class);

	public String getDetalleFichero(File ficheFile) {
		String cadena = "";
		try {
			cadena = ficheFile.getName() + ", tamaño: " + ficheFile.getTotalSpace() + ", absoluta: "
					+ ficheFile.getAbsolutePath() + ", relativa: " + ficheFile.getCanonicalPath();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return cadena;
	}

	public void crearUnDirectorio(String ruta, String nombreDirectorio) {
		File directorioPadre = new File(ruta);
		if (directorioPadre.exists()) {
			File miDirectorio = new File(directorioPadre, nombreDirectorio);
			miDirectorio.mkdir();
		}
	}

	public void crearUnFichero(String ruta, String nombreDirectorio, boolean soloLectura) {
		File diretorioPadre = new File(ruta);
		if (diretorioPadre.exists() && diretorioPadre.isDirectory()) {
			File nuevoDirectorio = new File(diretorioPadre, nombreDirectorio);
			if (nuevoDirectorio.exists() && nuevoDirectorio.isDirectory()) {
				File nuevoFichero = new File(nuevoDirectorio, "miArchivo.txt");
				try {
					if (nuevoFichero.createNewFile()) {
						logger.debug("Archivo creado: " + nuevoFichero.getAbsolutePath());
						if (soloLectura) {
							nuevoFichero.setReadOnly();
						}
					} else {
						logger.debug("El archivo ya existe: " + nuevoFichero.getAbsolutePath());
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				logger.debug("El directorio no existe: " + nuevoDirectorio.getAbsolutePath());
			}
		} else {
			logger.debug("La ruta proporcionada no es un directorio válido.");
		}
	}

	public void imprimeListaDirectorio(File f) {
		if (!f.isDirectory()) {
			logger.debug("Fichero " + f.getAbsolutePath());
		} else {
			logger.debug("Directorio: " + f.getAbsolutePath());
			for (File archivo : f.listFiles()) {
				imprimeListaDirectorio(archivo);
			}
		}

	}
}