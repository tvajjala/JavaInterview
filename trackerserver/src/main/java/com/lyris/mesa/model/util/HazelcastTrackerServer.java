/**
 * 
 */
package com.lyris.mesa.model.util;


import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Viraj
 * 
 */
public class HazelcastTrackerServer {

	private static Logger logger = Logger
			.getLogger(HazelcastTrackerServer.class.getSimpleName());

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		logger.info(" starting the server ");
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"tracker-server.xml");
		QueueManager qm = new QueueManager(ctx);
		Thread th = new Thread(qm);
		th.start();
	}

}
