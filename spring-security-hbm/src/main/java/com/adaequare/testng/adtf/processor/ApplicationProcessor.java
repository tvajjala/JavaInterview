package com.adaequare.testng.adtf.processor;

import java.util.HashSet;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.adaequare.testng.adtf.hbm.Authority;
import com.adaequare.testng.adtf.hbm.Employee;
import com.adaequare.testng.adtf.hbm.Organization;
import com.adaequare.testng.adtf.service.EmployeeService;

public class ApplicationProcessor implements ApplicationContextAware {

	public Logger logger = Logger.getRootLogger();

	EmployeeService employeeService;

	@Override
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {

		employeeService = (EmployeeService) context.getBean("employeeService");

		if (employeeService.getAllUsers().isEmpty()) {
			initData(context);
		}

		System.out.println(" ======   ======   =======  =======");
		System.out.println(" ||   || ||    ||     ||    ||     ");
		System.out.println(" ======  ||    ||     ||    ||====");
		System.out.println(" ||   || ||    ||     ||    ||     ");
		System.out.println("          ======      ||    ||     ");

		System.out.println("Application Ready to Use");

	}

	private void initData(ApplicationContext context) {

		try {
			System.out.println("######  INITILIZING DEFAULT DATA ##########");

			Authority authority = new Authority("ROLE_ADMIN", "ADMINSTRATOR");
			employeeService.saveAuthority(authority);

			employeeService.saveAuthority(new Authority("ROLE_TESTER",
					"TEST ENGINEER"));
			logger.info("ROLES CREATED");

			Organization organization = new Organization("CORELOGIC");
			employeeService.saveOrganization(organization);

			logger.info("ORGANIZATIONS CREATED");

			Employee details = new Employee();
			details.setUsername("admin");
			details.setPassword("1234");
			details.setAccountNonExpired(true);
			details.setAccountNonLocked(true);
			details.setCredentialsNonExpired(true);

			details.setEnabled(true);
			details.setFirstname("ThirupathiReddy");
			details.setLastname("Vajjala");
			details.setPhone("9000211024");
			details.setEmail("trvajjala@adaequare.com");
			details.setDesignation("Sr.Software Engineer");

			details.setAuthorities(new HashSet<Authority>());
			details.getAuthorities().add(authority);

			details.setOrganizations(new HashSet<Organization>());
			details.getOrganizations().add(organization);

			employeeService.saveEmployee(details);

		} catch (Exception e) {

		}

	}

}
