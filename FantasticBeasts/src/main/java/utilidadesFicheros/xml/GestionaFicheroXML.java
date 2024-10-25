package utilidadesFicheros.xml;

import models.Criatura;
import models.Empleado;
import models.Tipo;

public class GestionaFicheroXML{
	public static void main(String[] args) {
		Empleado e1 = new Empleado("12345", "Wanillo Kokunero", 23, "empresa1 S.L.");
		ManejaFicheroEmpleadoXML manejaEmpleados = new ManejaFicheroEmpleadoXML();
		manejaEmpleados.escribeModeloEnXML("empleado.xml", e1);
		
		Criatura cr1 = new Criatura("Unicornio", Tipo.BESTIA, false, 23, 12);
		ManejaFicheroCriaturaXML manejaCriaturas = new ManejaFicheroCriaturaXML();
		manejaCriaturas.escribeModeloEnXML("criatura.xml", cr1);
	}
}
