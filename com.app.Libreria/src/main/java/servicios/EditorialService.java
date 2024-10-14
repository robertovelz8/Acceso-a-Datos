package servicios;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import excepciones.MiExcepcion;
import modelo.Editorial;
import repositorio.EditorialRepositorio;

public class EditorialService {
	private static final Logger logger = LogManager.getLogger(EditorialService.class);
	private EditorialRepositorio repoEditorial;

	public EditorialService() {
		super();
		this.repoEditorial = new EditorialRepositorio();
	}
	
	public boolean agregaEditorial(String cif, String nombre)
	{
		boolean agregado = true;
		this.repoEditorial.agregaEditorial(cif, nombre);
		
		return agregado;
	}

	
	public boolean agregaEditorial(String cif, String nombre, String direccion, String web, String email) 
	{
		boolean agregado = true;
		this.repoEditorial.agregaEditorial(cif,  nombre,  direccion,  web,  email) ;
		
		return agregado;
	}
	
	public boolean modificaEmailEditorial(String cif, String email)
	{
		boolean agregado = true;
		try {
			this.repoEditorial.modificaEmailContacto(cif, email);
		} catch (MiExcepcion e) {
			agregado = false;
			this.logger.error(e.getMessage());
		}
			
			return agregado;
	}
	
	public boolean elimina(String cif)
	{
		boolean eliminado = true;
		try {
			this.repoEditorial.elimina(cif);
		} catch (MiExcepcion e) {
			eliminado = false;
			this.logger.error(e.getMessage());
		}
			
			return eliminado;
	}
	
	public Editorial recuperaEditorial(String cif)
	{
		Editorial e = null;
		try {
			e= this.repoEditorial.buscar(cif);
		} catch (MiExcepcion ex) {
			// TODO Auto-generated catch block
			this.logger.error(ex.getMessage());
		}
		return e;
	}
	
	public void imprimeDetalleEditoriales()
	{
		for(Editorial e: this.repoEditorial.getEditoriales())
		{
			logger.debug(e.toString());
		}
	}
}
