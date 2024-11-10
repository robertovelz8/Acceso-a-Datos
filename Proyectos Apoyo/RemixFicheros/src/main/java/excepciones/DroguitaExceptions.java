package excepciones;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DroguitaExceptions extends Exception{
	private static final Logger logger = LogManager.getLogger(DroguitaExceptions.class);
	private static final long serialVersionUID = 1L;

	//private static final long serialVersionUID = 123456789;
	public DroguitaExceptions(String message) {
		super(message);
		logger.error(message);
	}

}
