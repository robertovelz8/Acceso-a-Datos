package utiles;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;

import ud3.Persona;

public class HibernateTestPersona {
	private static final Logger logger = LogManager.getLogger(HibernateTestPersona.class);

	@Test
	void testRetrievePersona() {
		Session sesion = HibernateUtil.getFactoriaSession().openSession();
		Persona p = sesion.find(Persona.class, "44332211D");
		logger.debug("El nombre y apellido es: " + p.getNombreApellido());
		sesion.close();
	}

	/*
	// Crear Persona
	@Test
	void testCreatePersona() {
		Session sesion = HibernateUtil.getFactoriaSession().openSession();
		// Registramos una transacción
		sesion.beginTransaction();
		Persona Persona = new Persona();
		Persona.setDni("48124834W");
		Date fechaNac = new Date(2005, 01, 24);
		Persona.setFechaNacimiento();

		sesion.persist(Persona);
		sesion.getTransaction().commit();
		sesion.close();

	}

	@Test
	void testUpdatePersona() {
		Session sesion = HibernateUtil.getFactoriaSession().openSession();
		Persona r = sesion.find(Persona.class, 12345);
		sesion.beginTransaction();
		r.setAsunto("Nuevo Asunto --");
		sesion.getTransaction().commit();
		sesion.close();
	}

	@Test
	void testDeletePersona() {
		Session sesion = HibernateUtil.getFactoriaSession().openSession();
		sesion.beginTransaction();
		sesion.remove(sesion.find(Persona.class, 52));
		sesion.getTransaction().commit();
		sesion.close();
	}
	*/
}
