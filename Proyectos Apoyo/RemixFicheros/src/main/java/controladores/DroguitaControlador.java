package controladores;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modelos.Droguita;
import modelos.Yonki;
import servicios.DroguitaServicio;
import utilidades.ManejaFicheroXMLDroguitas;
import utilidades.ManejaJsonCSVDroguitas;

public class DroguitaControlador {
	private static final Logger logger = LogManager.getLogger(DroguitaControlador.class);



	public static void main(String[] args) {
		ManejaFicheroXMLDroguitas maneja = new ManejaFicheroXMLDroguitas();
		ManejaJsonCSVDroguitas manejaJsonCSV = new ManejaJsonCSVDroguitas();
		 DroguitaServicio servicio = new DroguitaServicio();
		 //Rutas de origen y destino de cada archivo
		String rutaXMLOrigen = ("src\\main\\resources\\droguitasXML.xml");
		String rutaOrigenJson = ("src\\main\\resources\\droguitasJSON.json");
		String rutaOrigenJsonY = ("src\\main\\resources\\yonkisJSON.json");
		String rutaXMLOrigenY = ("src\\main\\resources\\yonkisXML.xml");
		String rutaOrigenCSV = ("src\\main\\resources\\droguitasCSV.csv");
		String rutaOrigenCSVY = ("src\\main\\resources\\yonkisCSV.csv");
		String rutaDestinoDroguisJson = ("src\\main\\resources\\droguitasDestinoJson.json");
		String rutaXMLDestino = ("src\\main\\resources\\droguitasXMLCreado.xml");
		String rutaDestinoDroguisCSV = ("src\\main\\resources\\droguitasDestinoCSV.csv");
		String rutaDestinoYonkisCSV = ("src\\main\\resources\\yonkisDestinoCSV.csv");
		String rutaXMLDestinoPruebasDroguis = ("src\\main\\resources\\droguitasXMLPruebas.xml");
		String rutaXMLDestinoPruebasYonkis = ("src\\main\\resources\\yonkisXMLPruebas.xml");
		
		//Listas sacadas de diferentes formatos de archivos
		List<Droguita> listaDroguis = maneja.getDroguitasFromXML(rutaXMLOrigen);
		List<Yonki> listaenganchaitos = maneja.getYonkisFromXML(rutaXMLOrigenY);
		List<Droguita> listaDroguisJson = manejaJsonCSV.getDroguitasJson(rutaOrigenJson);
		List<Yonki> listaEnganchaitosJson = manejaJsonCSV.getYonkisJson(rutaOrigenJsonY);
		List<Droguita>listaDroguisCSV = manejaJsonCSV.leeDroguitasDeFicheroCsv(rutaOrigenCSV);
		List<Yonki> listaYonkisCSV = manejaJsonCSV.leeYonkisDeFicheroCsv(rutaOrigenCSVY);
	try {
		//Asignar yonkis a cada droguita con Json
		servicio.droguitasYYonkis(listaDroguisJson, listaEnganchaitosJson);
		//Sacar las droguitas en formato Json
		manejaJsonCSV.escribeDroguitasJson(listaDroguisJson, rutaDestinoDroguisJson);
		//Probar la lectura y escritura de csv
		manejaJsonCSV.escribeDroguitasCSV(listaDroguisCSV, rutaDestinoDroguisCSV);
		manejaJsonCSV.escribeYonkisCSV(listaYonkisCSV, rutaDestinoYonkisCSV);
		//Asignar yonkis a cada droguita XML
		servicio.droguitasYYonkis(listaDroguis, listaenganchaitos);
		maneja.escribeModeloEnXML(rutaXMLDestino, listaDroguis);
		//prueba de los diferentes métodos de servicio
		//maneja.escribeModeloEnXML(rutaXMLDestinoPruebasDroguis, servicio.droguitasMortales(listaDroguis, false));
		//maneja.escribeModeloEnXML(rutaXMLDestinoPruebasDroguis, servicio.ordenaDroguitasPorEnganchaos(listaDroguis));
		//maneja.escribeYonkisEnXML(rutaXMLDestinoPruebasYonkis, servicio.filtrarYonkisPorGenero(listaenganchaitos, Yonki.Genero.HOMBRE));
		maneja.escribeYonkisEnXML(rutaXMLDestinoPruebasYonkis, servicio.yonkisConMasDetencionesQue(listaenganchaitos, 5));


	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
