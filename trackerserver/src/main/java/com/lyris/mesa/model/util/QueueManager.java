/**
 * 
 */
package com.lyris.mesa.model.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.management.JMX;
import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import javax.management.openmbean.CompositeData;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

import org.apache.activemq.broker.jmx.BrokerViewMBean;
import org.apache.activemq.broker.jmx.QueueViewMBean;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;

import com.hazelcast.core.IMap;

/**
 * @author Viraj
 * 
 */
public class QueueManager implements Runnable, Constants {

	private static Logger logger = Logger
			.getLogger(HazelcastTrackerServer.class.getSimpleName());

	private ApplicationContext context;

	public QueueManager(ApplicationContext context) {
		this.context = context;
	}

	@SuppressWarnings("all")
	public void run() {

		logger.info("waiting ...");

		while (true) {
			// map will manage JMS Queue Names KEY=Queue name VALUE=true/false
			IMap<String, Object> qMap = (IMap) context.getBean(TMP_QUEUE_NAME);
			IMap<String, Object> qMsgMap = (IMap) context
					.getBean(JOB_TRACKER_NAME);

			try {
				manageJMSQueues(qMap);

				manageQueueMessages("demo", qMsgMap);// reading messages from
														// QUEUE =demo

				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				logger.debug(e);
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		}

	}

	/**
	 * 
	 * @param qMap
	 * @throws Exception
	 */
	public void manageJMSQueues(IMap<String, Object> qMap) throws Exception {

		logger.info("connecting to JMS Broker Object " + brokerObject);

		ObjectName activeMq = new ObjectName(brokerObject);

		BrokerViewMBean brokerViewMBean = JMX.newMBeanProxy(getConnection(),
				activeMq, BrokerViewMBean.class);

		logger.info("------------------------------------------");
		logger.info(" Available JMS Queues in ActiveMQ Broker ");

		ObjectName[] result = brokerViewMBean.getQueues();
		for (ObjectName on : result) {
			logger.info(" Queue ::  " + on);
		}
		logger.info("------------------------------------------");

		List<String> quesToDelete = getQueueToDelete(qMap, brokerViewMBean);

		logger.info(quesToDelete.size() + "/" + result.length
				+ " temp queues will be deleted.");

		/* Deleting Queue From ActiveMQ Broker */
		for (String queue : quesToDelete) {
			try {
				brokerViewMBean.removeQueue(queue);
				logger.info(queue + "deleted successfully.");
			} catch (Exception e) {
				logger.warn("Queue " + queue + " could not be deleted.");
				continue;
			}
		}

		// deleting from hazelcast cache and mysql
		for (String key : quesToDelete) {
			Object obj = qMap.remove(key);
			logger.info(key + " removed from hazelcast cache ." + obj);
		}

		jmxc.close();

	}

	/**
	 * 
	 * @param queueName
	 * @param map
	 * @throws Exception
	 */
	public void manageQueueMessages(String queueName, IMap<String, Object> map)
			throws Exception {

		Set<Entry<String, Object>> msgSet = map.entrySet();

		for (Iterator<Entry<String, Object>> iterator = msgSet.iterator(); iterator
				.hasNext();) {
			Entry<String, Object> entry = iterator.next();
			logger.info(entry.getKey() + " = " + entry.getValue());
		}

		ObjectName activeMq = new ObjectName(QueueObject + queueName);
		QueueViewMBean queueViewMBean = JMX.newMBeanProxy(getConnection(),
				activeMq, QueueViewMBean.class);

		CompositeData[] compdatalist = queueViewMBean.browse();

		int messageCount = compdatalist.length;

		String[] messageIDs = new String[messageCount];

		logger.info("Text Messages From Queue " + queueName);

		for (int i = 0; i < messageCount; i++) {
			CompositeData cdata = compdatalist[i];
			String messageID = (String) cdata.get("JMSMessageID");
			String textMessage = (String) cdata.get("Text");

			logger.info("TextMessage=[" + textMessage + "] , messageID=["
					+ messageID + "]");

			map.put(messageID, textMessage);

			messageIDs[i] = messageID;
		}

		jmxc.close();

	}

	/**
	 * 
	 * @return JMXConnection Object
	 * @throws Exception
	 */
	public MBeanServerConnection getConnection() throws Exception {

		try {
			logger.info(" JMX URL: " + serviceURL);
			JMXServiceURL url = new JMXServiceURL(serviceURL);
			Map<String, String[]> env = new HashMap<String, String[]>();

			/* requires only when authentication enabled in activemq.bat file */

			env.put(JMXConnector.CREDENTIALS, creds);

			jmxc = JMXConnectorFactory.connect(url, env);

			MBeanServerConnection conn = jmxc.getMBeanServerConnection();
			return conn;

		} catch (IOException e) {
			throw new Exception(
					" Unable to Establish JMX connection with ActiveMQ : "
							+ e.getCause().getCause().getMessage()
							+ "\n. Make sure ActiceMQ up and running on the specified host ");
		}

	}

	/**
	 * 
	 * @param qMap
	 * @param bvBean
	 * @return list of Queue names to be deleted
	 */
	public List<String> getQueueToDelete(IMap<String, Object> qMap,
			BrokerViewMBean bvBean) {

		List<String> quesToDelete = new ArrayList<String>();
		for (Iterator<Entry<String, Object>> iterator = qMap.entrySet()
				.iterator(); iterator.hasNext();) {
			Entry<String, Object> entry = iterator.next();

			boolean value = false;
			try {
				value = Boolean.valueOf(entry.getValue().toString());

				if (!value) {
					bvBean.addQueue(entry.getKey());// creating new Queue if the
													// value is false
				}

			} catch (Exception e) {
				logger.info(" error:  " + e.getMessage());
			}

			if (value) {
				logger.info(entry.getKey()
						+ "  will be deleted from the Broker ");
				quesToDelete.add(entry.getKey());
			}
		}

		return quesToDelete;
	}

	JMXConnector jmxc;

}
