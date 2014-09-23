package com.adaequare.testng.adtf.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.adaequare.testng.adtf.exceptions.UserDataAlreadyExistsException;
import com.adaequare.testng.adtf.hbm.Employee;
import com.adaequare.testng.adtf.service.EmployeeService;

@Controller
@SessionAttributes("adminInfoForm")
public class AdminPersonalInfoController {

	public Logger logger = Logger.getRootLogger();
	@Autowired
	EmployeeService employeeService;

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@RequestMapping(value = "/admin/updateInfo.htm", method = RequestMethod.GET)
	public String showAdminInfo(ModelMap model, HttpServletRequest request) {

		Employee employee = (Employee) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();

		logger.info("show user form method");
		model.put("employee", employee);
		model.put("isUserEnabled", employee.isEnabled());

		model.put("ORGANIZATION_LIST", employeeService.getOrganizations());


		return "update-admin";
	}

	@RequestMapping(value = "/admin/updateAdmin.htm", method = RequestMethod.POST)
	@SuppressWarnings("all")
	public String processAdminInfo(Map model,HttpServletRequest result) {

		try {
			
		} catch (UserDataAlreadyExistsException alreadyExistsException) {
			logger.info(alreadyExistsException.getMessage());
			return "update-admin";
		} catch (Exception e) {
			logger.info(e.getMessage());

			return "update-admin";
		}

		return "update-admin";
	}

}
