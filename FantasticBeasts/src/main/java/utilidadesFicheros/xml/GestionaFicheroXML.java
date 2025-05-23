package utilidadesFicheros.xml;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import models.Criatura;
import models.Pelicula;
import models.PuestoTrabajo;
import models.Tipo;

public class GestionaFicheroXML{
	private static final Logger logger = LogManager.getLogger(GestionaFicheroXML.class);

	public static void main(String[] args) {
		
		PuestoTrabajo p1 = new PuestoTrabajo("1", "puesto 1", "dept 1", 1884.2);
		Pelicula e1 = new Pelicula("12345", "Hola", 23, "empresa1 S.L.", p1);
		ManejaFicheroEmpleadoXML manejaEmpleados = new ManejaFicheroEmpleadoXML();
		manejaEmpleados.escribeModeloEnXML("empleado.xml", e1);
		logger.debug("Se ha ejecutado.");
		Criatura cr1 = new Criatura("Unicornio", Tipo.BESTIA, false, 23, 12);
		ManejaFicheroCriaturaXML manejaCriaturas = new ManejaFicheroCriaturaXML();
		manejaCriaturas.escribeModeloEnXML("criatura.xml", cr1);
	}
}
