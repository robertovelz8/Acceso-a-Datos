package utiles;

import org.hibernate.Session;
import org.junit.jupiter.api.Test;

import ud3.Reunion;

class PruebaConexionHibernate {

	@Test
	void test() {
		Session sesion = HibernateUtil.getFactoriaSession().openSession();
		sesion.beginTransaction();
		Reunion reunion = sesion.find(Reunion.class, 12345);
		System.out.println(reunion.getAsunto());
		sesion.close();
	}

}
