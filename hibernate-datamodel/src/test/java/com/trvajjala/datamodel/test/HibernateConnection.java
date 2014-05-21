/**
 * 
 */
package com.trvajjala.datamodel.test;

import org.apache.log4j.Logger;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author tvajjala
 *
 */
public class HibernateConnection {

	private static Logger logger = Logger.getLogger(HibernateConnection.class
			.getSimpleName());

	static SessionFactory sessionFactory;
	Session session;
	Transaction transaction;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		Configuration cfg = new Configuration().configure();
		StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
		sb.applySettings(cfg.getProperties());
		StandardServiceRegistry standardServiceRegistry = sb.build();
		sessionFactory = cfg.buildSessionFactory(standardServiceRegistry);
		logger.info("setUpBeforeClass");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {

		sessionFactory.close();
		logger.info("tearDownAfterClass");
	}

	@Before
	public void setUp() throws Exception {
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		logger.info("setUp");
	}

	@After
	public void tearDown() throws Exception {
		session.close();
		transaction.commit();
		logger.info("tearDown");
	}
	
	
	@Test
	public void all_db_cleanUp() {
		SQLQuery query = session.createSQLQuery("DELETE FROM USER");
		query.executeUpdate();


		query = session.createSQLQuery("DELETE FROM USERGROUP");
		query.executeUpdate();
		
		query = session.createSQLQuery("DELETE FROM ROLE");
		query.executeUpdate();

	}


}
