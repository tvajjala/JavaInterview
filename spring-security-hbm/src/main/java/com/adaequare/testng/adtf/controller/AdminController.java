package com.adaequare.testng.adtf.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.Log4jConfigListener;

import com.adaequare.testng.adtf.exceptions.UserDataAlreadyExistsException;
import com.adaequare.testng.adtf.hbm.Employee;
import com.adaequare.testng.adtf.parser.XMLParser;
import com.adaequare.testng.adtf.service.EmployeeService;

@Controller
public class AdminController {

    public Logger logger = Logger.getRootLogger();

    @Autowired
    EmployeeService employeeService;
    
    @Autowired
    XMLParser xmlParser;

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /*
     * @RequestMapping(value = "/admin/createModules.htm", method = RequestMethod.GET) public String createModules(ModelMap model, HttpServletRequest request,
     * HttpServletResponse response) {
     * 
     * String realPath = request.getSession().getServletContext() .getRealPath(""); Set<String> projects = xmlParser.getProjects(realPath);
     * 
     * if (projects.isEmpty()) { model.put("msg", "Please Create Project Before Module Creation  "); } request.getSession().setAttribute("PROJECTS_LIST",
     * projects); return "create-modules"; }
     * 
     * @RequestMapping(value = "/admin/createProject.htm", method = RequestMethod.GET) public String createProject(ModelMap model, HttpServletRequest request,
     * HttpServletResponse response) {
     * 
     * return "create-projects"; }
     * 
     * @RequestMapping(value = "/admin/addProject.htm", method = RequestMethod.POST) public String addProject(ModelMap model, HttpServletRequest request) {
     * 
     * String projectName = request.getParameter("pname");
     * 
     * if ((projectName == null) || (projectName.trim().length() < 3)) { model.put("msg", "Enter Valid Project Name  "); return "create-projects"; }
     * 
     * String realPath = request.getSession().getServletContext() .getRealPath("");
     * 
     * System.out.println("" + realPath);
     * 
     * int flag = xmlParser.createProjects(realPath, projectName); if (flag < 0) { model.put("msg", "Project Not Created, Try Again Later "); } else if (flag ==
     * 0) { model.put("msg", "Project Create Successfully "); } else if (flag == 1) { model.put("msg", "Project Already Exists, Please Verify "); }
     * 
     * return "create-projects"; }
     * 
     * @RequestMapping(value = "/admin/addCategory.htm", method = RequestMethod.POST) public String addCategory(ModelMap model, HttpServletRequest request) {
     * 
     * String projectName = request.getParameter("pname"); String module = request.getParameter("pmodule");
     * 
     * if ((projectName == null) || (projectName.trim().length() < 1)) { model.put("msg", " Please Select Project "); return "create-modules"; }
     * 
     * if ((module == null) || (module.trim().length() <= 3)) { model.put("msg", "Enter Valid Module Name  "); return "create-modules"; }
     * 
     * String realPath = request.getSession().getServletContext() .getRealPath("");
     * 
     * System.out.println("" + realPath);
     * 
     * int flag = xmlParser.createCategory(realPath, projectName, module); if (flag < 0) { model.put("msg", "Module Not Created, Try Again Later "); } else if
     * (flag == 0) { model.put("msg", "Module Create Successfully "); } else if (flag == 1) { model.put("msg", "Module Already Exists, Please Verify "); }
     * return "create-modules"; }
     */

    @RequestMapping(value = "/admin/showAllUsers.htm", method = RequestMethod.GET)
    public String displayUsers(ModelMap model, HttpServletRequest request, HttpServletResponse response) {

        logger.info("show user form method");

        request.getSession().setAttribute("USERS_LIST", employeeService.getAllUsers());
        request.getSession().setAttribute("ORGANIZATION_LIST", employeeService.getOrganizations());
        request.getSession().setAttribute("AUTHORITIES_LIST", employeeService.getAuthorities());

        return "user-mgmt";
    }

    @RequestMapping(value = "/admin/createUser.htm", method = RequestMethod.GET)
    public String createUser(ModelMap model, HttpServletRequest request) {

        logger.info("show user form method");

        request.getSession().setAttribute("ORGANIZATION_LIST", employeeService.getOrganizations());
        request.getSession().setAttribute("AUTHORITIES_LIST", employeeService.getAuthorities());

        return "create-user";
    }

    @RequestMapping(value = "/admin/saveUser.htm", method = RequestMethod.POST)
    @SuppressWarnings("all")
    public String processUserForm(Map model, HttpServletRequest request) {

        return "create-user";
    }

    @RequestMapping(value = "/admin/updateUserInfo.htm", method = RequestMethod.GET)
    public String updateUserInfo(@RequestParam(value = "uid", required = true) String uid, ModelMap model, HttpServletRequest request) {

        logger.error("username : " + uid);

        Employee employee = employeeService.getEmployeeById(uid);

        logger.info("update user form method ");

        request.getSession().setAttribute("UPDATE_EMP", employee);
        request.getSession().setAttribute("ORGANIZATION_LIST", employeeService.getOrganizations());
        request.getSession().setAttribute("AUTHORITIES_LIST", employeeService.getAuthorities());

        return "update_userdata";
    }

    @RequestMapping(value = "/admin/processUserData.htm", method = RequestMethod.POST)
    @SuppressWarnings("all")
    public String processUserInformation(Map model, HttpServletRequest request) {

        try {

            Employee employee = new Employee();
            employeeService.updateEmployee(employee);

        } catch (UserDataAlreadyExistsException alreadyExistsException) {
            logger.info(alreadyExistsException.getMessage());
            return "create-user";
        }

        return "redirect:/admin/showAllUsers.htm";
    }

}
