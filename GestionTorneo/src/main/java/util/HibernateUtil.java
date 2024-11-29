package util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	private static StandardServiceRegistry registro;
	private static SessionFactory factoriaSession;
	
	public static SessionFactory getFactoriaSession() {
		if(factoriaSession == null)		{
			registro = new StandardServiceRegistryBuilder().configure().build();
			MetadataSources sources = new MetadataSources(registro);
			Metadata metadatos = sources.getMetadataBuilder().build();
			factoriaSession = metadatos.buildSessionFactory();
		}
		return factoriaSession;
	}
	
	public static void shutdown()
	{
		if(registro != null)		{
			StandardServiceRegistryBuilder.destroy(registro);	}
	}
}
