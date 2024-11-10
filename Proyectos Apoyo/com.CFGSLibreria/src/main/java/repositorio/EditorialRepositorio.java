package repositorio;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import excepciones.MiExcepcion;
import modelo.Editorial;

public class EditorialRepositorio {
	private Set<Editorial> editoriales;

	public EditorialRepositorio() {
		super();
		this.editoriales = new HashSet<Editorial>();
	}
	
	public Set<Editorial> getEditoriales()
	{
		return this.editoriales;
	}
	
	//Aquí no estoy haciendo la comprobación de si existe, lanzo excpeción porque se vea que no siempre tiene que ser así
	public void agregaEditorial(String cif, String nombre)
	{
		Editorial e = new Editorial(cif, nombre);
		this.editoriales.add(e);
	}
	
	//Aquí no estoy haciendo la comprobación de si existe, lanzo excpeción porque se vea que no siempre tiene que ser así
	public void agregaEditorial(String cif, String nombre, String direccion, String web, String email) 
	{
		Editorial e = new Editorial(cif,  nombre,  direccion,  web,  email) ;
		this.editoriales.add(e);
	}
	
	public Editorial buscar(String cif) throws MiExcepcion
	{
		Editorial devuelto = null;
		Editorial l1 = new Editorial(cif);
		if(!editoriales.contains(l1))
		{
			throw new MiExcepcion("Excepción buscando editorial:"+cif);
		}
		else
		{
			boolean encontrado = false;
			Iterator<Editorial> it = editoriales.iterator();
	
			while(it.hasNext() && !encontrado)
			{
				devuelto = it.next();
				if(devuelto.equals(l1))
				{
					encontrado  = true;
				}
			}
			if(!encontrado)
			{
				throw new MiExcepcion("Excepción buscando editorial:"+cif);
			}
		}
		
		return devuelto;
	}
	
	public void modificaEmailContacto(String cif, String nuevoEmail) throws MiExcepcion
	{
		Editorial e1 = new Editorial(cif);
		if(!this.editoriales.contains(e1))
		{
			throw new MiExcepcion("Error al modificar email contacto de la editorial: "+cif);
		}
		else
		{
			e1= this.buscar(cif);
			e1.setEmail(nuevoEmail);
			this.editoriales.add(e1);
		}
			
	}
	
	public void elimina(String cif) throws MiExcepcion
	{
		Editorial e1 = new Editorial(cif);
		if(!this.editoriales.contains(e1))
		{
			throw new MiExcepcion("Error al eliminar editorial que no existe con cif: "+cif);
		}
		else
		{
			this.editoriales.remove(e1);
		}
			
	}

}
