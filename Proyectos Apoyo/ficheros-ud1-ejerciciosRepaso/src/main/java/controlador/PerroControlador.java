/**
 * 
 */
package controlador;

import java.util.List;

import modelo.Perro;
import servicio.ServicioFicheroPerro;
import utilidades.ManejaPerroDomXml;
import utilidades.UtilidadesJson;

/**
 * 
 */
public class PerroControlador {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Leer archivo JSON con la lista de perros

		UtilidadesJson utilidadesJSON = new UtilidadesJson();

		List<Perro> perros = utilidadesJSON.getPerrosJson("perros.json");

		// Fichero XML
		ServicioFicheroPerro servicio = new ServicioFicheroPerro();

		// Crea el documento XML para cada sexo de perros
		try {
			servicio.generarArchivosPorSexo(perros);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Generar la lista de perros modificados
		servicio.generarModeloModificado(perros, "listaPerrosVacunados.xml");

		ManejaPerroDomXml utilidadesXML = new ManejaPerroDomXml();
		// Leer los modelos del XML
		List<Perro> listaPerrosJson = utilidadesXML.getModelosFromXML("listaPerrosMachos.xml", "ListaPerros");

		// Escribir los perros leídos en un archivo JSON
		utilidadesJSON.escribePerros(listaPerrosJson, "src\\main\\resources\\listaPerrosMachos.json");
		//Escribir los perros que empiezan por una letra
		try {
			servicio.generarArchivosPorLetra("perretesPorM.xml", perros, 'm');
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Lista de perros ordenada alfabeticamente
		servicio.generarArchivoOrdenadoAlf("perretesOrdenados.xml", perros);
		//perros ordenados por edad
		servicio.generarArchivoOrdenadoPorEdad("perretesOrdenadosEdad.xml", perros);
		//perros ordenados por edad y alfabéticamente
		servicio.generarArchivoOrdenadoPorEdadPRO("perretesOrdenadosPRO.xml", perros);
	}

}