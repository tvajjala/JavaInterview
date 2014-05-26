package com.innominds.liferay.portlet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.innominds.liferay.portlet.dao.EmployeeDao;
import com.innominds.liferay.portlet.vo.Employee;

/**
 * 
 * @author tvajjala
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Transactional
	public void addEmployee(Employee employee) {
		employeeDao.addEmployee(employee);
	}

	@Transactional
	public List<Employee> list() {
		return employeeDao.list();
	}

	@Transactional
	public void deleteEmployee(Integer id) {

		employeeDao.deleteEmployee(id);
	}
}
