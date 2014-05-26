package com.innominds.liferay.portlet.service;

import java.util.List;

import com.innominds.liferay.portlet.vo.Employee;
/**
 * 
 * @author tvajjala
 *
 */
public interface EmployeeService {
	public void addEmployee(Employee employee) ;
	
	public List<Employee> list();
	public void deleteEmployee(Integer id);
}
