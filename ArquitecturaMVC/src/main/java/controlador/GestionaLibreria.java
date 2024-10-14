package controlador;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modelo.GeneroLibro;
import modelo.Libro;
import servicios.EditorialService;
import servicios.LibroService;


public class GestionaLibreria {
	private static final Logger logger = LogManager.getLogger(GestionaLibreria.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EditorialService editorialServ = new EditorialService();
		LibroService servicio = new LibroService(editorialServ);		

		servicio.agregaLibro("9788401328510", "Los Pilares de la Tierra", "Ken Follett", 3, GeneroLibro.FICCION, 1989,  "B91234567", "PLAZA&JANES");
		servicio.agregaLibro("9788498387940", "Animales fantásticos y dónde encontralos", "J.K Rowling", 6, GeneroLibro.FICCION, 2016, "B30234567", "Salamandra");
		servicio.agregaLibro("9788418050350", "Redes (Invisible 2)", "Eloy Moreno", 2, GeneroLibro.ROMANTICA, 2016, "B12544567" , "Nube de Tinta");
		servicio.agregaLibro("9780807286005", "Harry Potter y la piedra filosofal", "J.K Rowling", 2, GeneroLibro.ROMANTICA, 2016, "B12542222" , "B12542222");
		servicio.agregaLibro("9780061565571", "Las luces de septiembre", "Carlos Ruíz Zafón", 2, GeneroLibro.FICCION, 2016, "B12542222" , "Planeta");
		
		Libro l = servicio.recuperaLibro("9780061565571");	
		//logger.debug(l.toString());
		
		servicio.eliminaLibro("9780061565571");
		servicio.imprimeDetalleLibros();
		
		editorialServ.modificaEmailEditorial("B12542222", "planetaEmail@gmailcom");
		
		editorialServ.imprimeDetalleEditoriales();
		
		System.out.println(servicio.calculaMapaGeneros());

	}

}
