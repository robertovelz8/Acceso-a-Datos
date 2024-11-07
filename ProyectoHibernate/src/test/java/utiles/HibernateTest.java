package utiles;

import java.time.LocalDateTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;

import ud3.Reunion;

public class HibernateTest {
	
	private static final Logger logger = LogManager.getLogger(HibernateTest.class);

	@Test
	void testRetrieveReunion() {
		Session sesion = HibernateUtil.getFactoriaSession().openSession();
		Reunion r = sesion.find(Reunion.class, 12345);
		logger.debug("El asunto es: "+r.getAsunto());
		sesion.close();
	}
	
	//Crear reunion
	@Test
	void testCreateReunion() {
		Session sesion = HibernateUtil.getFactoriaSession().openSession();
		//Registramos una transacción
		sesion.beginTransaction();
		Reunion reunion = new Reunion();
		reunion.setAsunto("mi reunion de hoy");
		reunion.setFecha(LocalDateTime.now());
		
		sesion.persist(reunion);
		sesion.getTransaction().commit();
		sesion.close();
		
	}
	
	@Test
	void testUpdateReunion() {
		Session sesion = HibernateUtil.getFactoriaSession().openSession();
		Reunion r = sesion.find(Reunion.class, 12345);
		sesion.beginTransaction();
		r.setAsunto("Nuevo Asunto --");
		sesion.getTransaction().commit();
		sesion.close();
	}
	@Test
	void testDeleteReunion() {
		Session sesion = HibernateUtil.getFactoriaSession().openSession();
		sesion.beginTransaction();
		sesion.remove(sesion.find(Reunion.class, 52));
		sesion.getTransaction().commit();
		sesion.close();	
	}

	
	

}
