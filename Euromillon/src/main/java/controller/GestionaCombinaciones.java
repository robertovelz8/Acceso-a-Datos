package controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import repositories.HistoricoCombinaciones;
import services.CombinacionService;
import services.GestionaHistorico;

public class GestionaCombinaciones {

	private static final Logger logger = LogManager.getLogger(GestionaCombinaciones.class);
	private static final String DIRECTORIO = "C:\\Users\\rober\\Desktop\\2 DAM\\Acceso-a-Datos\\Euromillon\\src\\main\\resources\\";
	public static void main(String[] args) {
		HistoricoCombinaciones historico = new HistoricoCombinaciones();
		logger.debug(historico.leerCsvCombinaciones(DIRECTORIO+"Euromillones 2004 a 2023 (1).csv"));

        CombinacionService servicio = new CombinacionService(historico);
        GestionaHistorico gestiona = new GestionaHistorico(servicio);

        gestiona.generarFicheroResumen(DIRECTORIO+"resumenEuromillones.txt");
    }

}
