package com.suretouch.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.suretouch.hbm.Authority;
import com.suretouch.hbm.Employee;
import com.suretouch.hbm.Organization;

public interface EmployeeService extends UserDetailsService{

	void saveEmployee(Employee employee);

	void saveAuthority(Authority authority);

	void saveOrganization(Organization organization);

	List<Employee> getAllUsers();

	Employee getEmployeeDetails(String username);

	List<Authority> getAuthorities();

	List<Organization> getOrganizations();

	void updateEmployee(Employee employee);

	Employee getEmployeeByMail(String email);
	Employee getEmployeeById(String userId);

}
