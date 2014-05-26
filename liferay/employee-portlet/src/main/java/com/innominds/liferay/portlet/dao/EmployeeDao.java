package com.innominds.liferay.portlet.dao;

import java.util.List;

import com.innominds.liferay.portlet.vo.Employee;
/**
 * 
 * @author tvajjala
 *
 */
public interface EmployeeDao {

	public List<Employee> list();

	public void addEmployee(Employee employee);

	public void deleteEmployee(Integer id);
}
