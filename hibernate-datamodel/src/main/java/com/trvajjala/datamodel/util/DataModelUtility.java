package com.trvajjala.datamodel.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class DataModelUtility {

	public static void main(String[] args) throws Exception {

		SessionFactory sessionFactory = getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		/*
		 * UserEntity userEntity=new UserEntity();
		 * userEntity.setEmail("dfsd22f.com");
		 * userEntity.setFirstName("dsfd222sfsdfdsfds");
		 * userEntity.setPhoneNumber("4444444");
		 * userEntity.setCustomerID(555555); userEntity.setEnabled(true);
		 * userEntity.setRegisteredCountry(Country.US);
		 * session.save(userEntity);
		 */

		transaction.commit();
		session.close();
		sessionFactory.close();
	}

	public static SessionFactory getSessionFactory() {
		try {

			Configuration cfg = new Configuration().configure();
			StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
			sb.applySettings(cfg.getProperties());
			StandardServiceRegistry standardServiceRegistry = sb.build();
			SessionFactory sessionFactory = cfg
					.buildSessionFactory(standardServiceRegistry);

			return sessionFactory;

		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

}
