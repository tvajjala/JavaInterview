package com.innominds.liferay.portlet.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.innominds.liferay.portlet.vo.Employee;
/**
 * 
 * @author tvajjala
 *
 */
@SuppressWarnings("all")
@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Employee> list() {

		return sessionFactory.getCurrentSession().createQuery("from Employee")
				.list();
	}

	@Override
	public void addEmployee(Employee employee) {
		sessionFactory.getCurrentSession().save(employee);
	}

	@Override
	public void deleteEmployee(Integer id) {
		Employee employee = (Employee) sessionFactory.getCurrentSession().load(
				Employee.class, id);

		if (null != employee) {
			sessionFactory.getCurrentSession().delete(employee);
		}

	}

}
