package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import models.Criatura;
import models.Tipo;
import services.CriaturaServicio;
import utilidadesFicheros.ManejaFicheroCriaturas;

public class GestionaDiarioCriaturas {

	private static final Logger logger = LogManager.getLogger(GestionaDiarioCriaturas.class);

	public static void main(String[] args) {
		Criatura cr1 = new Criatura("Unicornio", Tipo.BESTIA, false, 23, 12);
		Criatura cr2 = new Criatura("Centauro", Tipo.BESTIA, true, 63, 100);
		Criatura cr3 = new Criatura("Medusa", Tipo.SER, true, 98, 99);
		Criatura cr4 = new Criatura("Poltergeist", Tipo.ESPÍRITU, true, 100, 43);

		CriaturaServicio cs = new CriaturaServicio();

		cs.addEntrada(LocalDate.of(2013, 11, 23), cr1);
		logger.debug(cs.getCriaturas());
		cs.eliminarEntrada(LocalDate.of(2013, 11, 23));
		logger.debug(cs.getCriaturas());

		cs.addEntrada(LocalDate.of(2013, 11, 23), cr1);
		logger.debug(cs.getCriaturas());
		cs.eliminarEntrada(cr1);
		logger.debug(cs.getCriaturas());
		logger.debug("----------------------------");
		cs.addEntrada(LocalDate.of(2013, 11, 23), cr1);
		cs.addEntrada(LocalDate.of(2011, 11, 23), cr2);
		cs.addEntrada(LocalDate.of(2012, 11, 23), cr3);
		cs.addEntrada(LocalDate.of(2010, 11, 23), cr4);
		logger.debug(cs.obtenerCriaturasDeTipo(Tipo.BESTIA));
		logger.debug(cs.obtenerDetalleCriatura("Medusa", Tipo.SER));

		logger.debug("-------------FICHEROS-----------");
		
		 String ruta = "C:\\Users\\EQUIPO\\Desktop\\2 DAM\\Acceso a Datos\\FantasticBeasts\\src\\main\\resources\\";
		 ManejaFicheroCriaturas m1 = new ManejaFicheroCriaturas(); 
		 String rutaDirectorio = ruta+"criaturasfantasticas.csv";
		 String rutaCriaturaTipo = ruta+"criaturaPorTipo.txt";
		 List<Criatura> cr = m1.leoCSVCriatura(rutaDirectorio);
		 m1.imprimirCriaturasCSV(cr);
		 
		 List<Criatura> criaturas = new ArrayList<Criatura>();
		 criaturas.add(cr1);
		 criaturas.add(cr2);
		 criaturas.add(cr3);
		 criaturas.add(cr4);

		 m1.generaFicheroResumen(rutaCriaturaTipo, criaturas);
		 
	}

}
