package loggerTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jDemo {

	private static final Logger logger = LogManager.getLogger(Log4jDemo.class.getName());

	public static void main(String[] args) {

		System.out.println("\n Hello World...!  \n");

		logger.trace("This is a trace message");
		logger.info("This is information message");
		logger.error("This is an error message");
		logger.warn("This is a warning message");
		logger.fatal("This is a fatal message");

		System.out.println("\n Completed");

	}

}
