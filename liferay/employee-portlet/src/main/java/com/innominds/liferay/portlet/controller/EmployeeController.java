package com.innominds.liferay.portlet.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.innominds.liferay.portlet.service.EmployeeService;
import com.innominds.liferay.portlet.vo.Employee;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;

/**
 * 
 * @author tvajjala
 *
 */
@Controller
public class EmployeeController {

	private static Logger logger = Logger.getLogger(EmployeeController.class
			.getSimpleName());

	@Autowired
	EmployeeService employeeService;

	@RenderMapping
	public String employeeForm(Map<String, Object> map) {
		map.put("employee", new Employee());

		logger.info("rendering employee Form ");

		List<Employee> el = employeeService.list();

		try {

			// to demonstrate to use existing services from custom portlet
			int count = UserLocalServiceUtil.getUsersCount();

			System.out.println(" total count " + count);

			// leverage existing liferay login portlet services inside custom
			// portlet
			List<User> list = UserLocalServiceUtil.getUsers(0, count);

			if (el.isEmpty()) {
				for (Iterator<User> iterator = list.iterator(); iterator
						.hasNext();) {
					User user = iterator.next();
					System.out.println(user.getFullName());
					Employee employee = new Employee();
					employee.setFirstname(user.getFirstName());
					employee.setLastname(user.getLastName());
					employee.setEmail(user.getEmailAddress());
					
					 if (user.isActive())
						el.add(employee);
				}
			}
		} catch (SystemException e) {

		}

		map.put("employeeList", el);
		return "createEmployee";
	}

	@ActionMapping(params = "action=add")
	public void addEmployee(ActionRequest actionRequest,
			ActionResponse actionResponse, Model model,
			@ModelAttribute("employee") Employee employee, BindingResult result)
			throws IOException, PortletException {

		logger.info("submission  "
				+ ParamUtil.getString(actionRequest, "firstname"));

		employeeService.addEmployee(employee);
		logger.info("employee" + employee.getFirstname());

	}

	@ActionMapping(params = "action=delete")
	public void deleteEmployee(@RequestParam("empId") Integer empId,
			ActionRequest actionRequest, ActionResponse actionResponse,
			Model model) throws IOException, PortletException {

		logger.info(" deleting " + empId);
		employeeService.deleteEmployee(empId);

	}

}