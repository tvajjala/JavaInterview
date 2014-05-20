package com.lyris.mesa.model.util;

public interface Constants {

	String ACTIVEMQ_CONNECTOR_PORT = "1199";
	String ACTIVEMQ_HOST = "localhost";
	String TMP_QUEUE_NAME = "tmpQueueTracker";
	String JOB_TRACKER_NAME = "jobTracker";
	String ACTIVE_MQ_BROKER = "LyrisMQ";
	
	int sleepTime = 1 * 30 * 1000; // polling frequency every 1 Min

	String serviceURL = "service:jmx:rmi:///jndi/rmi://" + ACTIVEMQ_HOST + ":"
			+ ACTIVEMQ_CONNECTOR_PORT + "/jmxrmi";

	String brokerObject = "org.apache.activemq:BrokerName=" + ACTIVE_MQ_BROKER
			+ ",Type=Broker";
	
	String QueueObject = "org.apache.activemq:BrokerName=" + ACTIVE_MQ_BROKER
			+ ",Type=Queue,Destination=";
	
	String[] creds = { "admin", "admin"};// ActiveMQ Connection Credentials
	
}
