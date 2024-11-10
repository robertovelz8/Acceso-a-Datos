/**
 * 
 */
package servicio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import modelo.Perro;
import utilidades.ComparaPerrosPorEdadyNombre;
import utilidades.ComparaPerrosPorNombres;
import utilidades.ManejaPerroDomXml;

/**
 * 
 */
public class ServicioFicheroPerro {

	/**
	 * Genera archivos XML separados por género: "machos.xml" y "hembras.xml".
	 *
	 * @param listaPerros Lista de objetos Perro a procesar
	 * @throws Exception Si ocurre un error al crear o escribir el documento XML
	 */
	public void generarArchivosPorSexo(List<Perro> listaPerros) throws Exception {
		// Crear una lista vacía para almacenar solo los perros machos
		List<Perro> machos = new ArrayList<>();

		// Recorrer la lista de todos los perros
		for (Perro perro : listaPerros) {
			// Verificar si el sexo del perro es "macho" (ignora mayúsculas)
			if ("macho".equalsIgnoreCase(perro.getSexo())) {
				// Si es macho, añadirlo a la lista de machos
				machos.add(perro);
			}
		}
		// Crear una lista vacía para almacenar solo los perros hembras
		List<Perro> hembras = new ArrayList<>();

		// Recorrer la lista de todos los perros
		for (Perro perro : listaPerros) {
			// Verificar si el sexo del perro es "hembra" (ignora mayúsculas)
			if ("hembra".equalsIgnoreCase(perro.getSexo())) {
				// Si es macho, añadirlo a la lista de hembras
				hembras.add(perro);
			}
		}

		// Crear los documentos XML
		ManejaPerroDomXml utilidadesXML = new ManejaPerroDomXml();
		utilidadesXML.escribeModelosEnXML("listaPerrosMachos.xml", machos, "ListaPerros", "perro");
		utilidadesXML.escribeModelosEnXML("listaPerrosHembras.xml", hembras, "ListaPerros", "perro");
	}
	public void generarArchivosPorLetra(String ficheroDestino, List<Perro> listaPerros, char letrita) throws Exception {
		List<Perro> perretesEmpiezanPorLetrita = new ArrayList<>();

		// Recorrer la lista de todos los perros
		for (Perro perro : listaPerros) {
			// Verificar si la primera letra es la que hemos añadido (ignora mayúsculas)
			if ((perro.getNombre().toLowerCase().startsWith(String.valueOf(letrita)))) {
				// Si empieza por la letra, añadirlo a la lista
				perretesEmpiezanPorLetrita.add(perro);
			}
		}
		// Crear los documentos XML
		ManejaPerroDomXml utilidadesXML = new ManejaPerroDomXml();
		utilidadesXML.escribeModelosEnXML(ficheroDestino, perretesEmpiezanPorLetrita, "ListaPerros", "perro");
	}
	public void generarArchivoOrdenadoAlf(String ficheroDestino, List<Perro> listaPerros) {
		//Aquí ordenamos la lista por nombres alfabéticamente, tal y como hemos especificado en la clase ComparaPerrosPorNombres
		Collections.sort(listaPerros, new ComparaPerrosPorNombres());
		// Crear los documentos XML
		ManejaPerroDomXml utilidadesXML = new ManejaPerroDomXml();
		utilidadesXML.escribeModelosEnXML(ficheroDestino, listaPerros, "ListaPerros", "perro");
	}
	public void generarArchivoOrdenadoPorEdad(String ficheroDestino, List<Perro> listaPerros) {
		//Ordenamos la lista por edad usando Comparable que hemos implementado en Perro
		Collections.sort(listaPerros);
		// Crear los documentos XML
		ManejaPerroDomXml utilidadesXML = new ManejaPerroDomXml();
		utilidadesXML.escribeModelosEnXML(ficheroDestino, listaPerros, "ListaPerros", "perro");
	}
	public void generarArchivoOrdenadoPorEdadPRO(String ficheroDestino, List<Perro> listaPerros) {
		//Ordenamos la lista por edad usando ComparaPerrosPorEdadyNombre para que se ordene por edad y alfabéticamente
		Collections.sort(listaPerros, new ComparaPerrosPorEdadyNombre());
		// Crear los documentos XML
		ManejaPerroDomXml utilidadesXML = new ManejaPerroDomXml();
		utilidadesXML.escribeModelosEnXML(ficheroDestino, listaPerros, "ListaPerros", "perro");
	}
	/**
	 * Método que genera un archivo XML con los datos de perros actualizados
	 * 
	 * @param archivoEntrada nombre del archivo JSON original de entrada
	 * @param archivoSalida  nombre del archivo XML donde se guardarán los datos
	 *                       actualizados
	 */
	public void generarModeloModificado(List<Perro> listaPerros, String archivoSalida) {
		// Crear una instancia de ManejaPerroDomXml para gestionar la lectura/escritura
		// de perros
		ManejaPerroDomXml manejaPerro = new ManejaPerroDomXml();

		// Procesar cada perro, aumentando su edad y estableciendo el atributo vacunado
		List<Perro> listaPerrosModificados = listaPerros.stream().map(perro -> {
			perro.setEdad(perro.getEdad() + 1); // Aumentar la edad en 1 año
			perro.setVacunado(perro.getEdad() > 4); // Vacunado si edad > 4
			return perro;
		}).collect(Collectors.toList());

		// Escribir la lista de perros modificados al archivo XML de salida
		manejaPerro.escribeModelosModificadosEnXML(archivoSalida, listaPerrosModificados, "Perros", "Perro");
	}

}
