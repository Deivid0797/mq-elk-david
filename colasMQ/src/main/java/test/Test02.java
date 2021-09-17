package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Test02 {

	public static void main(String[] args) {
		//Logger log = LogManager.getLogger("Logger that references elasticsearchAsyncBatch");
		//		log.info("Hello, World!");
		
		Logger logger = LogManager.getLogger("test");
		logger.info("Hello World");

	}

}
