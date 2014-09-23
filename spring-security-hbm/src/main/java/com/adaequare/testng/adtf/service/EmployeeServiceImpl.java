package com.adaequare.testng.adtf.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.adaequare.testng.adtf.hbm.Authority;
import com.adaequare.testng.adtf.hbm.Employee;
import com.adaequare.testng.adtf.hbm.Organization;
import com.adaequare.testng.adtf.validators.EmailValidator;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private SessionFactory sessionFactory;
	Session session;
	Transaction transaction;
	public Logger logger = Logger.getRootLogger();

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {

		if (EmailValidator.validate(username)) {
			if (getEmployeeByMail(username) == null) {
				username = null;
			} else {
				username = getEmployeeByMail(username).getUsername();
			}
		}

		System.out.println("loadUserByUsername  :  " + username);
		session = sessionFactory.openSession();
		username = (username == null) ? "" : username;
		Query query = session
				.createQuery("from Employee where username=:username");
		query.setParameter("username", username);

		if (query.list().isEmpty()) {
			return null;
		}

		return (UserDetails) query.list().get(0);

	}

	public Employee getEmployeeDetails(String username) {
		session = sessionFactory.openSession();
		Query query = session
				.createQuery("from Employee where username=:username");
		query.setParameter("username", username);

		return (Employee) query.list().get(0);
	}

	public Employee getEmployeeByMail(String email) {
		try {
			session = sessionFactory.openSession();
			Query query = session
					.createQuery("from Employee where email=:email");
			query.setParameter("email", email);
			return (Employee) query.list().get(0);

		} catch (Exception e) {
			return null;
		}

	}

	public Employee getEmployeeById(String userId) {

		session = sessionFactory.openSession();
		Query query = session.createQuery("from Employee where userId=:userId");
		query.setParameter("userId", userId);

		return (Employee) query.list().get(0);

	}

	@SuppressWarnings("all")
	public List<Employee> getAllUsers() {
		session = sessionFactory.openSession();
		Query query = session.createQuery("from Employee ");
		return query.list();
	}

	public void saveEmployee(Employee employee) {

		try {

			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(employee);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		}

	}

	public void updateEmployee(Employee employee) {

		try {

			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(employee);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		}

	}

	public void saveAuthority(Authority authority) {
		try {

			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(authority);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		}

	}

	public void saveOrganization(Organization organization) {

		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(organization);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		}
	}

	@SuppressWarnings("all")
	public List<Organization> getOrganizations() {

		session = sessionFactory.openSession();
		Query query = session.createQuery("from Organization ");
		return query.list();
	}

	@SuppressWarnings("all")
	public List<Authority> getAuthorities() {

		session = sessionFactory.openSession();
		Query query = session.createQuery("from Authority ");
		return query.list();
	}

}
