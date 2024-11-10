package excepciones;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;




public class MiExcepcion extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3982301227413896185L;
	
	private static final Logger logger = LogManager.getLogger(MiExcepcion.class);

	public MiExcepcion(String message)
	{
		super(message);
		logger.error(message);
		
		
	}

}
