package com.adaequare.testng.adtf.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;

import automation.scripts.ReportGenerator;

import com.adaequare.testng.adtf.parser.XMLParser;
import com.adaequare.testng.adtf.testng.beans.Configuration;
import com.adaequare.testng.adtf.testng.beans.Reports;
import com.adaequare.testng.adtf.testng.beans.TestSteps;
import com.adaequare.testng.adtf.testng.beans.TestSuite;

@Controller
public class TesterController {/*

	public Logger logger = Logger.getRootLogger();
	@Autowired
	XMLParser xmlParser;

	@RequestMapping(value = "/tester/home.htm", method = RequestMethod.GET)
	public String tester(ModelMap model, HttpServletRequest request) {

		return "tester-home";

	}

	@RequestMapping(value = "/tester/createObjectIdsPage.htm", method = RequestMethod.GET)
	public String createObjectIds(ModelMap model, HttpServletRequest request) {

		String realPath = request.getSession().getServletContext()
				.getRealPath("");

		Set<String> projects = xmlParser.getProjects(realPath);
		// this has to be changed after assign project work is done.

		if (projects.isEmpty()) {
			model.put("msg", "Please Create Project Before Module Creation  ");
			return "objectId-createpage";
		}
		String projectName = projects.toArray()[0].toString();
//		Set<String> modules = xmlParser.getCategories(realPath, projectName);
//		request.getSession().setAttribute("PROJECT_MODULES", modules);

		request.getSession().setAttribute("PROJECT_NAME", projectName);

		return "objectId-createpage";
	}

	@RequestMapping(value = "/tester/saveObjectIds.htm", method = RequestMethod.POST)
	public String saveObjectIds(ModelMap model, HttpServletRequest request) {
		

//		String module = "";//request.getParameter("project_module");
//
//		if ((module == null) || (module.trim().length() < 1)) {
//			model.put("msg", " Please Select Module ");
//			return "objectId-createpage";
//		}

		String realPath = request.getSession().getServletContext()
				.getRealPath("");
		Map<String, String> objectMap = new HashMap<String, String>();

		Map<String, String[]> params = request.getParameterMap();

		String project_name = request.getParameter("project_name");

		String objName = "";
		String objId = "";

		for (int i = 1; i < params.size(); i++) {

			objName = request.getParameter("objname" + i);
			objId = request.getParameter("objid" + i);

			if ((objName != null) && (objId != null)) {

				if (!("".equals(objName)) && !("".equals(objId))) {
					objectMap.put(objName, objId);

					System.out.println(objName + " = " + objId);
				}
			}
		}

		int flag = xmlParser.updateObjectReferecesFile(realPath, project_name,
				 objectMap);

		if (flag < 0) {
			model.put("msg", "Object References Not Updated, Try Again Later ");
		} else if (flag == 0) {
			model.put("msg", "Object References Updated Successfully ");
		} else if (flag == 1) {
			model.put("msg",
					"Some Object References Already Exists, Please Verify ");
		}
		return "objectId-createpage";
	}

	@RequestMapping(value = "/tester/viewObjectIds.htm", method = RequestMethod.GET)
	public String viewObjectIds(ModelMap model, HttpServletRequest request) {

		String realPath = request.getSession().getServletContext()
				.getRealPath("");
		Set<String> projects = xmlParser.getProjects(realPath);
		// this has to be changed after assign project work is done.
		String projectName = projects.toArray()[0].toString();
		Set<String> modules = xmlParser.getCategories(realPath, projectName);
		request.getSession().setAttribute("PROJECT_MODULES", modules);
		request.getSession().setAttribute("PROJECT_NAME", projectName);
		request.getSession().setAttribute("moduleName", "");
		return "objectId-viewpage";
	}

	@RequestMapping(value = "/tester/editObjectIds.htm", method = RequestMethod.POST)
	public String editObjectIds(ModelMap model, HttpServletRequest request) {
		// Map<String, String> objectMap = new HashMap<String, String>();

		String realPath = request.getSession().getServletContext()
				.getRealPath("");
		Set<String> projects = xmlParser.getProjects(realPath);
		Map<String, String> objIds = new HashMap<String, String>();
		// this has to be changed after assign project work is done.
		String projectName = projects.toArray()[0].toString();
		Set<String> modules = xmlParser.getCategories(realPath, projectName);
		request.getSession().setAttribute("PROJECT_MODULES", modules);
		request.getSession().setAttribute("PROJECT_NAME", projectName);

		String module = request.getParameter("project_module");

		if ((module == null) || (module.trim().length() < 1)) {
			model.put("msg", " Please Select Module ");

		} else {

			String action = request.getParameter("setIds");
			if (action != null && action.equals("Update")) {

				try {
					if (xmlParser.deleteObjectReferencesFile(realPath)) {
						logger.info("Object Reference File Deleted Successfully for Project:"
								+ projectName + "; Module:" + module);
					}
					saveObjectIds(model, request);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			objIds = xmlParser.getObjectReferences(realPath, projectName);
		}
		// get the existing objects as array and pass
		request.getSession().setAttribute("vObjectIds", objIds);
		request.getSession().setAttribute("moduleName", module);
		return "objectId-viewpage";
	}

	@RequestMapping(value = "/tester/createMessages.htm", method = RequestMethod.GET)
	public String createMessages(ModelMap model, HttpServletRequest request) {

		String realPath = request.getSession().getServletContext()
				.getRealPath("");

		Set<String> projects = xmlParser.getProjects(realPath);
		if (projects.isEmpty()) {
			model.put("msg", "Please Create Project Before Module Creation  ");
			return "message-createpage";
		}
		// this has to be changed after assign project work is done.
		String projectName = projects.toArray()[0].toString();
//		Set<String> modules = xmlParser.getCategories(realPath, projectName);
//		request.getSession().setAttribute("PROJECT_MODULES", modules);

		request.getSession().setAttribute("PROJECT_NAME", projectName);

		return "message-createpage";
	}

	@RequestMapping(value = "/tester/viewMessages.htm", method = RequestMethod.GET)
	public String viewMessages(ModelMap model, HttpServletRequest request) {

		String realPath = request.getSession().getServletContext()
				.getRealPath("");
		Set<String> projects = xmlParser.getProjects(realPath);
		// this has to be changed after assign project work is done.
		String projectName = projects.toArray()[0].toString();
		Set<String> modules = xmlParser.getCategories(realPath, projectName);
		request.getSession().setAttribute("PROJECT_MODULES", modules);
		request.getSession().setAttribute("PROJECT_NAME", projectName);
		request.getSession().setAttribute("moduleName", "");
		return "message-viewpage";
	}

	@RequestMapping(value = "/tester/editMessages.htm", method = RequestMethod.POST)
	public String editMessages(ModelMap model, HttpServletRequest request) {

		String realPath = request.getSession().getServletContext()
				.getRealPath("");
		Map<String, String> objIds = new HashMap<String, String>();
		Set<String> projects = xmlParser.getProjects(realPath);
		// this has to be changed after assign project work is done.
		String projectName = projects.toArray()[0].toString();
		Set<String> modules = xmlParser.getCategories(realPath, projectName);
		request.getSession().setAttribute("PROJECT_MODULES", modules);
		request.getSession().setAttribute("PROJECT_NAME", projectName);
		String module = request.getParameter("project_module");

		if ((module == null) || (module.trim().length() < 1)) {
			model.put("msg", " Please Select Module ");

		} else {

			String action = request.getParameter("getMsgs");
			if (action != null && action.equals("Update")) {
				String path = realPath + File.separator + "data"
						+ File.separator + "projects" + File.separator
						+ projectName + File.separator + "test-input"
						+ File.separator + module;
				try {
					if (xmlParser.deleteMessagesFile(path)) {
						logger.info("Messages File Deleted Successfully for Project:"
								+ projectName + "; Module:" + module);
					}
					xmlParser.createMessagesFile(path);
					updateMessages(model, request);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			objIds = xmlParser.getMessageInfo(realPath, projectName);
		}
		// get the existing objects as array and pass
		request.getSession().setAttribute("vMessages", objIds);
		request.getSession().setAttribute("moduleName", module);

		return "message-viewpage";
	}

	@RequestMapping(value = "/tester/updateMessages.htm", method = RequestMethod.POST)
	public String updateMessages(ModelMap model, HttpServletRequest request) {

//		String module = "";//request.getParameter("project_module");
//
//		if ((module == null) || (module.trim().length() < 1)) {
//			model.put("msg", " Please Select Module ");
//			return "message-createpage";
//		}

		String realPath = request.getSession().getServletContext()
				.getRealPath("");
		Map<String, String> messageMap = new HashMap<String, String>();

		Map<String, String[]> params = request.getParameterMap();

		String project_name = request.getParameter("project_name");

		String msgName = "";
		String msgId = "";

		for (int i = 1; i < params.size(); i++) {

			msgName = request.getParameter("msgname" + i);
			msgId = request.getParameter("msgid" + i);

			if ((msgName != null) && (msgId != null)) {

				if (!("".equals(msgName)) && !("".equals(msgId))) {
					messageMap.put(msgName, msgId);

					System.out.println(msgName + " = " + msgId);
				}
			}
		}

		int flag = xmlParser.updateMessageReferenceFile(realPath, project_name,
				 messageMap);

		if (flag < 0) {
			model.put("msg", "Message References Not Updated, Try Again Later ");
		} else if (flag == 0) {
			model.put("msg", "Message References Updated Successfully ");
		} else if (flag == 1) {
			model.put("msg",
					"Some Message References Already Exists, Please Verify ");
		}

		return "message-createpage";
	}

	@RequestMapping(value = "/tester/createTestSteps.htm", method = RequestMethod.GET)
	public String createTestSteps(ModelMap model, HttpServletRequest request) {

		String realPath = request.getSession().getServletContext()
				.getRealPath("");

		Set<String> projects = xmlParser.getProjects(realPath);
		Set<String> actionSet = new HashSet<String>();
		Set<String> objNameSet = new HashSet<String>();
		Set<String> msgNameSet = new HashSet<String>();
		// this has to be changed after assign project module is done.
		String projectName = projects.toArray()[0].toString();
//		Set<String> modules = xmlParser.getCategories(realPath, projectName);
//
//		String module_name = request.getParameter("module_name");

//		if ((module_name == null) || (module_name.trim().length() < 1)) {
//			// module_name = modules.toArray()[0].toString();
//			model.put("msg", " Please Select Module ");
//		} else {

			actionSet = xmlParser.getActionList(realPath);
			objNameSet = xmlParser.getObjectReferences(realPath, projectName).keySet();
			msgNameSet = xmlParser.getMessageInfo(realPath, projectName).keySet();
//		}
//		request.getSession().setAttribute("SELECTED_MODULE", module_name);
		request.getSession().setAttribute("ACTION_SET", actionSet);
		request.getSession().setAttribute("OBJ_NAMESET", objNameSet);
		request.getSession().setAttribute("MSG_NAMESET", msgNameSet);

//		request.getSession().setAttribute("PROJECT_MODULES", modules);
		request.getSession().setAttribute("PROJECT_NAME", projectName);

		return "teststeps-createpage";
	}

	@RequestMapping(value = "/tester/viewTestSteps.htm", method = RequestMethod.GET)
	public String viewTestSteps(ModelMap model, HttpServletRequest request) {
		String realPath = request.getSession().getServletContext()
				.getRealPath("");
		Set<String> projects = xmlParser.getProjects(realPath);
		String projectName = projects.toArray()[0].toString();
		Set<String> modules = xmlParser.getCategories(realPath, projectName);
		request.getSession().setAttribute("PROJECT_MODULES", modules);
		request.getSession().setAttribute("PROJECT_NAME", projectName);
		request.getSession().setAttribute("moduleName", "");
		request.getSession().setAttribute("ACTION_SET", null);
		request.getSession().setAttribute("OBJ_NAMESET", null);
		request.getSession().setAttribute("MSG_NAMESET", null);
		request.getSession().setAttribute("TESTSTEPS_LIST", null);
		request.getSession().setAttribute("StepsData", null);
		request.getSession().setAttribute("selected_step", "");
		return "teststeps-viewpage";
	}

	@RequestMapping(value = "/tester/editTestSteps.htm", method = RequestMethod.POST)
	public String editTestSteps(ModelMap model, HttpServletRequest request) {
		String realPath = request.getSession().getServletContext()
				.getRealPath("");
		Map<String, Object> objData = null;
		Set<String> projects = xmlParser.getProjects(realPath);
		// this has to be changed after assign project work is done.
		Set<String> actionSet = new HashSet<String>();
		Set<String> objNameSet = new HashSet<String>();
		Set<String> msgNameSet = new HashSet<String>();
		List<String> testSteps = new ArrayList<String>();
		String selected_step = "";
		String projectName = projects.toArray()[0].toString();
		Set<String> modules = xmlParser.getCategories(realPath, projectName);
		String module_name = request.getParameter("project_module");

		if ((module_name == null) || (module_name.trim().length() < 1)) {
			model.put("msg", " Please Select Module ");

		} else {

			selected_step = request.getParameter("teststep_name");

			if ((module_name == null) || (module_name.trim().length() < 1)) {
				model.put("msg", " Please Select Module ");

			} else {

				actionSet = xmlParser.getActionList(realPath);
				objNameSet = xmlParser.getObjectReferences(realPath,
						projectName).keySet();
				msgNameSet = xmlParser.getMessageInfo(realPath, projectName
						).keySet();
				testSteps = xmlParser.getTestSteps(realPath, projectName
						);

				if ((selected_step == null)
						|| (selected_step.trim().length() < 1)) {
					model.put("msg", " Please Select Step ");
				} else {
					String repeat_count = request.getParameter("repeat_count");
					if ((repeat_count == null)
							|| (repeat_count.trim().length() < 1)) {
						model.put("msg", "Please Enter Repeat Count Value ");

					} else {

						String action = request.getParameter("setSteps");
						if (action != null && action.equals("Update")) {
							xmlParser.removeTestStepNode(realPath, projectName,
									module_name, selected_step);
							String updation = request.getParameter("choice");
							if (updation.equals("none")) {
								// done updation of existing records only

								updateTestSteps(model, request);
								// } else {
								//
								// String msg = addRemoveTestSteps(request,
								// realPath,
								// projectName, module_name,
								// selected_step, repeat_count);
								// model.put("msg",msg);
							}
						}
					}
					objData = xmlParser.getTestSteps(realPath, projectName,
							module_name, selected_step);
				}
			}
			// get steps to display of selected_step
		}
		request.getSession().setAttribute("StepsData", objData);
		request.getSession().setAttribute("selected_step", selected_step);
		request.getSession().setAttribute("moduleName", module_name);
		request.getSession().setAttribute("ACTION_SET", actionSet);
		request.getSession().setAttribute("OBJ_NAMESET", objNameSet);
		request.getSession().setAttribute("MSG_NAMESET", msgNameSet);
		request.getSession().setAttribute("TESTSTEPS_LIST", testSteps);
		request.getSession().setAttribute("PROJECT_MODULES", modules);
		request.getSession().setAttribute("PROJECT_NAME", projectName);

		return "teststeps-viewpage";
	}

	private List<TestSteps> getStepsFromRequest(HttpServletRequest request) {
		List<TestSteps> steps = new ArrayList<TestSteps>();
		Map<String, String[]> params = request.getParameterMap();
		String compName, action, msg;

		for (int i = 1; i < params.size(); i++) {
			compName = request.getParameter("comp" + i);
			action = request.getParameter("action" + i);
			msg = request.getParameter("msg" + i);
			if ((compName != null) && (action != null) && (msg != null)) {
				if (!("".equals(compName)) && !("".equals(action))
						&& !("".equals(msg))) {
					TestSteps data = new TestSteps();
					data.setActionName(action);
					data.setComponentName(compName);
					data.setMessageName(msg);
					steps.add(data);
				}
			}
		}

		return steps;
	}

	@RequestMapping(value = "/tester/createTestCases.htm", method = RequestMethod.GET)
	public String createTestCases(ModelMap model, HttpServletRequest request) {

		String realPath = request.getSession().getServletContext()
				.getRealPath("");

		Set<String> projects = xmlParser.getProjects(realPath);
		List<String> testSteps = new ArrayList<String>();
		// this has to be changed after assign project module is done.
		String projectName = projects.toArray()[0].toString();
		Set<String> modules = xmlParser.getCategories(realPath, projectName);

		String module_name = request.getParameter("module_name");

		if ((module_name == null) || (module_name.trim().length() < 1)) {
			// module_name = modules.toArray()[0].toString();
			model.put("msg", " Please Select Module ");
		} else {

			testSteps = xmlParser.getTestSteps(realPath, projectName);
		}
		request.getSession().setAttribute("SELECTED_MODULE", module_name);

		request.getSession().setAttribute("PROJECT_MODULES", modules);
		request.getSession().setAttribute("PROJECT_NAME", projectName);
		request.getSession().setAttribute("TESTSTEPS_LIST", testSteps);

		return "testcase-createpage";
	}

	@RequestMapping(value = "/tester/updateTestCases.htm", method = RequestMethod.POST)
	public String updateTestCases(ModelMap model, HttpServletRequest request) {

		String realPath = request.getSession().getServletContext()
				.getRealPath("");

		String module = request.getParameter("project_module");

		String testcase_name = request.getParameter("testcase_name");

		String project_name = request.getParameter("project_name");

		Set<String> modules = xmlParser.getCategories(realPath, project_name);

		List<String> testSteps = new ArrayList<String>();

		if ((module == null) || (module.trim().length() < 1)) {
			model.put("msg", " Please Select Module ");
			return "testcase-createpage";
		}

		if ((testcase_name == null) || (testcase_name.trim().length() < 1)) {
			model.put("msg", " Please Enter TestCase Name ");
			return "testcase-createpage";
		}

		String tsteps = "";

		Map<String, String[]> params = request.getParameterMap();
		for (int i = 1; i < params.size(); i++) {

			tsteps = request.getParameter("tsteps" + i);

			if ((tsteps != null)) {

				if (!"".equals(tsteps)) {

					testSteps.add(tsteps);
				}
			}
		}
		int flag = xmlParser.updateTestCasesFiles(realPath, project_name,
				module, testSteps, testcase_name);
		List<String> testStepsList = xmlParser.getTestSteps(realPath,
				project_name);
		if (flag < 0) {
			model.put("msg", "Object References Not Updated, Try Again Later ");
		} else if (flag == 0) {
			model.put("msg", "Object References Updated Successfully ");
		} else if (flag == 1) {
			model.put("msg",
					"Some Object References Already Exists, Please Verify ");
		}
		request.getSession().setAttribute("SELECTED_MODULE", module);
		request.getSession().setAttribute("PROJECT_MODULES", modules);
		request.getSession().setAttribute("PROJECT_NAME", project_name);
		request.getSession().setAttribute("TESTSTEPS_LIST", testStepsList);

		return "testcase-createpage";
	}

	@RequestMapping(value = "/tester/viewTestCases.htm", method = RequestMethod.GET)
	public String viewTestCases(ModelMap model, HttpServletRequest request) {

		String realPath = request.getSession().getServletContext()
				.getRealPath("");
		Set<String> projects = xmlParser.getProjects(realPath);
		// this has to be changed after assign project module is done.
		String projectName = projects.toArray()[0].toString();
		Set<String> modules = xmlParser.getCategories(realPath, projectName);
		request.getSession().setAttribute("PROJECT_MODULES", modules);
		request.getSession().setAttribute("PROJECT_NAME", projectName);
		request.getSession().setAttribute("SELECTED_MODULE", "");
		request.getSession().setAttribute("SelTestCase", "");
		request.getSession().setAttribute("SelCaseSteps", null);
		return "testcase-viewpage";
	}

	@RequestMapping(value = "/tester/editTestCases.htm", method = RequestMethod.POST)
	public String editTestCases(ModelMap model, HttpServletRequest request) {

		String realPath = request.getSession().getServletContext()
				.getRealPath("");
		String project_name = request.getParameter("project_name");
		String module = request.getParameter("project_module");
		Set<String> modules = xmlParser.getCategories(realPath, project_name);
		List<String> testStepsList = new ArrayList<String>();

		String testcase_name = request.getParameter("testcase_name");
		Set<String> testCases = new HashSet<String>();
		List<String> selCaseSteps = new ArrayList<String>();
		if ((module == null) || (module.trim().length() < 1)) {
			model.put("msg", " Please Select Module ");

		} else {
			testStepsList = xmlParser.getTestSteps(realPath, project_name);
			if ((testcase_name == null) || (testcase_name.trim().length() < 1)) {
				model.put("msg", " Please Select TestCase Name ");

			} else {

				String action = request.getParameter("setCases");
				if (action != null && action.equals("Update")) {
					if (request.getParameter("scount") != null) {
						int scount = Integer.parseInt(request
								.getParameter("scount"));
						for (int i = 1; i < scount; i++) {
							selCaseSteps
									.add(request.getParameter("tsteps" + i));
							// System.out.println(">"
							// + request.getParameter("tsteps" + i));
						}
						int flag = xmlParser.updateTestCasesFiles(realPath,
								project_name, module, selCaseSteps,
								testcase_name);
						if (flag < 0) {
							model.put("msg",
									"Object References Not Updated, Try Again Later ");
						} else if (flag == 0) {
							model.put("msg",
									"Object References Updated Successfully ");
						} else if (flag == 1) {
							model.put("msg",
									"Some Object References Already Exists, Please Verify ");
						}

					}
					// updateTestCases(model, request);
					// add updated one.
				}

				selCaseSteps = xmlParser.getSelCaseSteps(realPath,
						project_name, module, testcase_name);

			}
			testCases = xmlParser.getTestCases(realPath, project_name, module);
		}

		request.getSession().setAttribute("SelCaseSteps", selCaseSteps);
		request.getSession().setAttribute("SelTestCase", testcase_name);
		request.getSession().setAttribute("TESTCASES", testCases);
		request.getSession().setAttribute("SELECTED_MODULE", module);
		request.getSession().setAttribute("PROJECT_MODULES", modules);
		request.getSession().setAttribute("PROJECT_NAME", project_name);
		request.getSession().setAttribute("TESTSTEPS_LIST", testStepsList);

		return "testcase-viewpage";
	}

	@RequestMapping(value = "/tester/updateTestSteps.htm", method = RequestMethod.POST)
	public String updateTestSteps(ModelMap model, HttpServletRequest request) {

//		String module = request.getParameter("project_module");

		String teststep_name = request.getParameter("teststep_name");

		String repeat_count = request.getParameter("repeat_count");
//		if ((module == null) || (module.trim().length() < 1)) {
//			model.put("msg", " Please Select Module ");
//			return "teststeps-createpage";
//		}

		if ((teststep_name == null) || (teststep_name.trim().length() < 1)) {
			model.put("msg", " Please Enter TestStep Name ");
			return "teststeps-createpage";
		}

		if ((repeat_count == null) || (repeat_count.trim().length() < 1)) {
			model.put("msg", " Please Enter Repeat Count Value ");
			return "teststeps-createpage";
		}

		String realPath = request.getSession().getServletContext()
				.getRealPath("");

		List<TestSteps> testSteps = new ArrayList<TestSteps>();

		Map<String, String[]> params = request.getParameterMap();

		String project_name = request.getParameter("project_name");

		String compName = "";
		String action = "";
		String msg = "";

		TestSteps steps = null;

		for (int i = 1; i < params.size(); i++) {

			compName = request.getParameter("comp" + i);
			action = request.getParameter("action" + i);
			msg = request.getParameter("msg" + i);

			if ((compName != null) && (action != null) && (msg != null)) {

				if (!("".equals(compName)) && !("".equals(action))
						&& !("".equals(msg))) {
					steps = new TestSteps();
					steps.setActionName(action);
					steps.setComponentName(compName);
					steps.setMessageName(msg);
					testSteps.add(steps);
				}
			}
		}
		// System.out.println("testSteps " + testSteps.size());
		int flag = xmlParser.updateTestSteps(realPath, project_name,
				testSteps, teststep_name, repeat_count);

		if (flag < 0) {
			model.put("msg", "TestSteps  Not Updated, Try Again Later ");
		} else if (flag == 0) {
			model.put("msg", "TestSteps References Updated Successfully ");
		} else if (flag == 1) {
			model.put("msg",
					"Some TestSteps References Already Exists, Please Verify ");
		}

		return "teststeps-createpage";
	}

	@RequestMapping(value = "/tester/createTestSuite.htm", method = RequestMethod.GET)
	public String createTestSuite(ModelMap model, HttpServletRequest request) {

		String realPath = request.getSession().getServletContext()
				.getRealPath("");
		Set<String> projects = xmlParser.getProjects(realPath);

		if (projects.isEmpty()) {
			model.put("msg",
					"Please Create Project Before Configuration Creation  ");
			return "testsuite-createpage";
		}

		// this has to be changed after assign project work is done.
		String projectName = projects.toArray()[0].toString();
		Map<String, Set<String>> modulesTestList = xmlParser
				.getCategoriesTestList(realPath, projectName);
		request.getSession().setAttribute("PROJECT_MODULES",
				modulesTestList.entrySet());
		request.getSession().setAttribute("PROJECT_NAME", projectName);
		request.getSession().setAttribute("PROJECT_LIST", projects);

		return "testsuite-createpage";
	}

	@RequestMapping(value = "/tester/updateTestSuite.htm", method = RequestMethod.POST)
	public String updateTestSuite(ModelMap model, HttpServletRequest request) {

		String realPath = request.getSession().getServletContext()
				.getRealPath("");
		Set<String> projects = xmlParser.getProjects(realPath);

		String projectName = request.getParameter("project_name");

		logger.error("projectName : " + projectName);

		String testsuite_name = request.getParameter("testsuite_name");

		logger.error("testsuite_name : " + testsuite_name);

		Map<String, Set<String>> modulesTestList = xmlParser
				.getCategoriesTestList(realPath, projectName);

		Set<Entry<String, Set<String>>> moduleSet = modulesTestList.entrySet();
		List<TestSuite> testSuites = new ArrayList<TestSuite>();
		TestSuite suite = null;

		for (Entry<String, Set<String>> entry : moduleSet) {
			String module = entry.getKey();
			String suite_url = module + "_url";
			String suite_sb = module + "_sb";
			String[] testCases = request.getParameterValues(suite_sb);

			if (testCases != null) {
				suite = new TestSuite();
				String url = request.getParameter(suite_url);
				suite.setTestCases(testCases);
				suite.setUrl(url);
				suite.setModule(module);
				testSuites.add(suite);
			}
		}

		request.getSession().setAttribute("PROJECT_MODULES",
				modulesTestList.entrySet());
		request.getSession().setAttribute("PROJECT_NAME", projectName);
		request.getSession().setAttribute("PROJECT_LIST", projects);

		int flag = xmlParser.updateTestSuiteInfo(realPath, projectName,
				testsuite_name, testSuites);

		if (flag < 0) {
			model.put("msg", "Test Suite Not updated,Try Again later.");
		} else if (flag == 0) {
			model.put("msg", "Test Suite <" + testsuite_name
					+ "> Updated Successfully.");
		} else if (flag == 1) {
			model.put("msg", "Test Suite Already Exists, Please Verify. ");
		}
		return "testsuite-createpage";
	}

	@RequestMapping(value = "/tester/createConfiguration.htm", method = RequestMethod.GET)
	public String createConfiguration(ModelMap model, HttpServletRequest request) {
		String realPath = request.getSession().getServletContext()
				.getRealPath("");

		Set<String> projects = xmlParser.getProjects(realPath);

		if (projects.isEmpty()) {
			model.put("msg",
					"Please Create Project Before Configuration Creation  ");
			return "testconfig-createpage";
		}

		Map<String, String> browserTypes = new HashMap<String, String>();
		browserTypes.put("*firefox", "FireFox");
		browserTypes.put("*iehta", "Internet Explorer");

		request.getSession().setAttribute("BROWSER_TYPES", browserTypes);
		request.getSession().setAttribute("PROJECT_LIST", projects);
		request.getSession()
				.setAttribute("PROJECT_NAME", projects.toArray()[0]);

		return "testconfig-createpage";
	}

	@RequestMapping(value = "/tester/updateTestConfig.htm", method = RequestMethod.POST)
	public String updateTestConfig(ModelMap model, HttpServletRequest request) {
		String realPath = request.getSession().getServletContext()
				.getRealPath("");
		String project_name = request.getParameter("project_name");
		if ((project_name == null) || (project_name.trim().length() < 1)) {
			model.put("msg", " Please Select Project ");
			return "testconfig-createpage";
		}

		String config_name = request.getParameter("config_name");

		if ((config_name == null) || (config_name.trim().length() < 1)) {
			model.put("msg", " Please Enter Valid Configuration name ");
			return "testconfig-createpage";
		}

		String host_name = request.getParameter("host_name");
		if ((host_name == null) || (host_name.trim().length() < 1)) {
			model.put("msg", " Please Enter Valid Host name ");
			return "testconfig-createpage";
		}

		String browserType = request.getParameter("browserType");

		if ((browserType == null) || (browserType.trim().length() < 1)) {
			model.put("msg", " Please Select Browser  Type ");
			return "testconfig-createpage";
		}
		String bversion = request.getParameter("bversion");

		if ((bversion == null) || (bversion.trim().length() < 1)) {
			model.put("msg", " Please Enter Browser  Version ");
			return "testconfig-createpage";
		}

		int flag = xmlParser.updateTestConfiguration(realPath, project_name,
				config_name, host_name, browserType, bversion);
		if (flag < 0) {
			model.put("msg", "Test Configuration Not updated,Try Again later");
		} else if (flag == 0) {
			model.put("msg", "Test Configuration Updated Successfully ");
		} else if (flag == 1) {
			model.put("msg",
					"Some Test Configuration Already Exists, Please Verify ");
		}

		return "testconfig-createpage";
	}

	@RequestMapping(value = "/tester/viewReports.htm", method = RequestMethod.GET)
	public String viewReports(ModelMap model, HttpServletRequest request) {

		String realPath = request.getSession().getServletContext()
				.getRealPath("");

		Set<String> projects = xmlParser.getProjects(realPath);

		if (projects.isEmpty()) {
			model.put("msg",
					"Please Create Project Before Configuration Creation  ");
			return "execute-tests";
		}

		String projectName = projects.toArray()[0].toString();
		User user = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();

		String iReportPath = request.getContextPath() + "/" + "data" + "/"
				+ "projects" + "/" + projectName + "/" + "test-output" + "/"
				+ user.getUsername() + "/" + "TestSuiteSummary.html";
		String tngReport = request.getContextPath() + "/" + "data" + "/"
				+ "projects" + "/" + projectName + "/" + "test-output" + "/"
				+ user.getUsername();
		String eMailReport = request.getContextPath() + "/" + "data" + "/"
				+ "projects" + "/" + projectName + "/" + "test-output" + "/"
				+ user.getUsername() + "/" + "emailable-report.html";

		String logReport = request.getContextPath() + "/" + "data" + "/"
				+ "reports" + "/" + "log.html";
		List<Reports> reports = new ArrayList<Reports>();
		Reports report = null;

		for (String suiteName : reportList) {

			report = new Reports();
			report.setSuiteName(suiteName);
			report.setiReport(iReportPath);
			report.setLogger(logReport);
			report.settNGReport(tngReport + "/" + suiteName + "/"
					+ "index.html");
			report.setMailReport(eMailReport);
			reports.add(report);

		}

		request.setAttribute("TESNGREPORTS", reports);

		return "view-reports";
	}

	@RequestMapping(value = "/tester/executeTestCases.htm", method = RequestMethod.GET)
	public String executeTestCases(ModelMap model, HttpServletRequest request) {

		String realPath = request.getSession().getServletContext()
				.getRealPath("");

		Set<String> projects = xmlParser.getProjects(realPath);

		if (projects.isEmpty()) {
			model.put("msg",
					"Please Create Project Before Configuration Creation  ");
			return "execute-tests";
		}

		String projectName = projects.toArray()[0].toString();

		request.getSession().setAttribute("PROJECT_NAME", projectName);

		request.getSession().setAttribute("CONFIG_LIST",
				xmlParser.getConfigurations(realPath, projectName));
		request.getSession().setAttribute("SUITE_LIST",
				xmlParser.getTestSuites(realPath, projectName).keySet());

		return "execute-tests";
	}

	ITestResult iTestResult;
	List<String> reportList = new ArrayList<String>();

	@RequestMapping(value = "/tester/runExectution.htm", method = RequestMethod.POST)
	public void runExectution(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		PrintWriter out = null;
		try {
			String realPath = request.getSession().getServletContext()
					.getRealPath("");

			Set<String> projects = xmlParser.getProjects(realPath);

			String configs = request.getParameter("cname");
			String suites = request.getParameter("sname");

			String execution_type = request.getParameter("etype");

			System.out.println("suites " + suites + configs + execution_type);
			String projectName = projects.toArray()[0].toString();

			Map<String, TestSuite> testSuiteMap = xmlParser.getTestSuites(
					realPath, projectName);
			Map<String, Configuration> configMap = xmlParser.getConfigurations(
					realPath, projectName);
			List<String> suiteFilesList = new ArrayList<String>();

			reportList.clear();
			TestSuite testSuite = null;
			Configuration configuration = null;
			for (String suite : suites.split(",")) {
				for (String config : configs.split(",")) {

					configuration = configMap.get(config);
					testSuite = testSuiteMap.get(suite);
					if ((configuration != null) && (testSuite != null)) {
						xmlParser.prepareTestNGSuite(realPath, projectName,
								testSuite, configuration, suite, config,
								suiteFilesList, reportList);

					}
				}

			}

			out = response.getWriter();

			if (suiteFilesList.isEmpty()) {
				out.write("Please Select Suite & Configuration");
				return;
			}

			logger.error("Started Execution " + suiteFilesList.size());

			User user = (User) SecurityContextHolder.getContext()
					.getAuthentication().getPrincipal();
			List listener = new ArrayList();
			listener.add(ReportGenerator.class);
			TestListenerAdapter tla = new TestListenerAdapter();
			TestNG testng = new TestNG();
			testng.setListenerClasses(listener);
			testng.setTestSuites(suiteFilesList);

			String outputDir = realPath + File.separator + "data"
					+ File.separator + "projects" + File.separator
					+ projectName + File.separator + "test-output"
					+ File.separator + user.getUsername();

			System.out.println(outputDir);
			testng.setOutputDirectory(outputDir);
			testng.addListener(tla);
			testng.run();

			List<ITestResult> configFailsList = tla.getConfigurationFailures();
			StringBuffer errorMessage = new StringBuffer();

			if (!configFailsList.isEmpty()) {
				iTestResult = configFailsList.get(0);
				if (iTestResult.getThrowable() instanceof UnreachableBrowserException) {
					errorMessage
							.append("selenium server not started at host machine.\n");
					errorMessage.append("Error Message:: "
							+ iTestResult.getThrowable().getCause()
									.getMessage());
					out.write(errorMessage.toString());
					return;
				}
			}
			errorMessage.append("### Execution Finished ###\n");

			if (!tla.getFailedTests().isEmpty()) {
				errorMessage.append("Total " + tla.getFailedTests().size()
						+ "Test Cases Failed.\n");
			}

			if (!tla.getSkippedTests().isEmpty()) {
				errorMessage.append("Total " + tla.getFailedTests().size()
						+ "Test Cases Skipped.\n");
			}

			out.write(errorMessage.toString());
			return;

		} catch (IOException ioException) {
			ioException.printStackTrace();
		} finally {

			try {
				out.flush();
				out.close();
			} catch (Exception e) {

			}

		}

	}

	@RequestMapping(value = "/tester/arTestCase.htm", method = RequestMethod.POST)
	public String addRemoveTestCases(ModelMap model, HttpServletRequest request) {

		String realPath = request.getSession().getServletContext()
				.getRealPath("");

		String module = request.getParameter("project_module");

		String testcase_name = request.getParameter("testcase_name");

		String project_name = request.getParameter("project_name");

		Set<String> modules = xmlParser.getCategories(realPath, project_name);
		Set<String> testCases = new HashSet<String>();
		List<String> testSteps = new ArrayList<String>();

		if ((module == null) || (module.trim().length() < 1)) {
			model.put("msg", " Please Select Module ");

		}
		if ((testcase_name == null) || (testcase_name.trim().length() < 1)) {
			model.put("msg", " Please Enter TestCase Name ");
		}

		String tsteps = "";

		Map<String, String[]> params = request.getParameterMap();
		for (int i = 1; i < params.size(); i++) {

			tsteps = request.getParameter("tsteps" + i);

			if ((tsteps != null)) {

				if (!"".equals(tsteps)) {

					testSteps.add(tsteps);
				}
			}
		}

		// get choice
		String choice = request.getParameter("choice");
		int position = Integer.parseInt(request.getParameter("position"));
		if (position > 0) {
			if (choice.equals("add")) {
				testSteps.add(position - 1, "");
			}
			if (choice.equals("remove")) {
				testSteps.remove(position - 1);
			}
		}

		testCases = xmlParser.getTestCases(realPath, project_name, module);
		List<String> testStepsList = xmlParser.getTestSteps(realPath,
				project_name);
		request.getSession().setAttribute("SelCaseSteps", testSteps);
		request.getSession().setAttribute("SelTestCase", testcase_name);
		request.getSession().setAttribute("TESTCASES", testCases);
		request.getSession().setAttribute("SELECTED_MODULE", module);
		request.getSession().setAttribute("PROJECT_MODULES", modules);
		request.getSession().setAttribute("PROJECT_NAME", project_name);
		request.getSession().setAttribute("TESTSTEPS_LIST", testStepsList);

		return "testcase-viewpage";

	}

	@RequestMapping(value = "/tester/arTestSteps.htm", method = RequestMethod.POST)
	public String addRemoveTestSteps(ModelMap model, HttpServletRequest request) {

		String realPath = request.getSession().getServletContext()
				.getRealPath("");
		Map<String, Object> objData = new HashMap<String, Object>();
		Set<String> projects = xmlParser.getProjects(realPath);

		Set<String> actionSet = new HashSet<String>();
		Set<String> objNameSet = new HashSet<String>();
		Set<String> msgNameSet = new HashSet<String>();
		List<String> testSteps = new ArrayList<String>();
		List<TestSteps> testStepsData = new ArrayList<TestSteps>();
		String selected_step = "";
		String projectName = projects.toArray()[0].toString();
		Set<String> modules = xmlParser.getCategories(realPath, projectName);

		String module_name = request.getParameter("project_module");

		if ((module_name == null) || (module_name.trim().length() < 1)) {
			model.put("msg", " Please Select Module ");

		} else {

			selected_step = request.getParameter("teststep_name");

			if ((module_name == null) || (module_name.trim().length() < 1)) {
				model.put("msg", " Please Select Module ");

			} else {

				actionSet = xmlParser.getActionList(realPath);
				objNameSet = xmlParser.getObjectReferences(realPath,
						projectName).keySet();
				msgNameSet = xmlParser.getMessageInfo(realPath, projectName
						).keySet();
				testSteps = xmlParser.getTestSteps(realPath, projectName);

				if ((selected_step == null)
						|| (selected_step.trim().length() < 1)) {
					model.put("msg", " Please Select Step ");
				} else {
					String repeat_count = request.getParameter("repeat_count");
					if ((repeat_count == null)
							|| (repeat_count.trim().length() < 1)) {
						model.put("msg", "Please Enter Repeat Count Value ");

					} else {

						Map<String, String[]> params = request
								.getParameterMap();

						String compName = "";
						String action = "";
						String msg = "";

						TestSteps steps = null;

						for (int i = 1; i < params.size(); i++) {

							compName = request.getParameter("comp" + i);
							action = request.getParameter("action" + i);
							msg = request.getParameter("msg" + i);

							if ((compName != null) && (action != null)
									&& (msg != null)) {

								if (!("".equals(compName))
										&& !("".equals(action))
										&& !("".equals(msg))) {
									steps = new TestSteps();
									steps.setActionName(action);
									steps.setComponentName(compName);
									steps.setMessageName(msg);
									testStepsData.add(steps);
								}
							}
						}

						String choice = request.getParameter("choice");
						int position = Integer.parseInt(request
								.getParameter("position"));
						if (position > 0) {
							if (choice.equals("add")) {
								testStepsData
										.add(position - 1, new TestSteps());
							}
							if (choice.equals("remove")) {
								testStepsData.remove(position - 1);
							}
						}

					}
					objData.put("count", repeat_count);
					objData.put("name", selected_step);
					objData.put("data", testStepsData);

				}
			}
			// get steps to display of selected_step
		}
		request.getSession().setAttribute("StepsData", objData);
		request.getSession().setAttribute("selected_step", selected_step);
		request.getSession().setAttribute("moduleName", module_name);
		request.getSession().setAttribute("ACTION_SET", actionSet);
		request.getSession().setAttribute("OBJ_NAMESET", objNameSet);
		request.getSession().setAttribute("MSG_NAMESET", msgNameSet);
		request.getSession().setAttribute("TESTSTEPS_LIST", testSteps);
		request.getSession().setAttribute("PROJECT_MODULES", modules);
		request.getSession().setAttribute("PROJECT_NAME", projectName);

		return "teststeps-viewpage";

	}

	@RequestMapping(value = "/tester/viewXMLs.htm", method = RequestMethod.GET)
	public String viewXMLs(ModelMap model, HttpServletRequest request) {

		String realPath = request.getSession().getServletContext()
				.getRealPath("");
		Set<String> projects = xmlParser.getProjects(realPath);
		String projectName = projects.toArray()[0].toString();
		Set<String> modules = xmlParser.getCategories(realPath, projectName);
		// String module = request.getParameter("project_module");
		request.getSession().setAttribute("PROJECT_MODULES", modules);
		request.getSession().setAttribute("PROJECT_NAME", projectName);
		request.getSession().setAttribute("SELECTED_MODULE", "");
		return "viewxmls";
	}

	@RequestMapping(value = "/tester/editXMLs.htm", method = RequestMethod.POST)
	public String editXMLs(ModelMap model, HttpServletRequest request) {
		boolean fdisplay = false;
		List<String> modfiles = new ArrayList<String>();
		List<String> prjfiles =  new ArrayList<String>();
		String filedata = "";
		String sel_fil = "";
		String filePlace ="";
		String realPath = request.getSession().getServletContext()
				.getRealPath("");
		Set<String> projects = xmlParser.getProjects(realPath);
		String projectName = projects.toArray()[0].toString();
		Set<String> modules = xmlParser.getCategories(realPath, projectName);
		String module = request.getParameter("project_module");
		if ((module == null) || (module.trim().length() < 1)) {
			// module_name = modules.toArray()[0].toString();
			model.put("msg", " Please Select Module ");
		} else {
			modfiles = xmlParser.getModuleFiles(realPath, projectName, module);
			prjfiles = xmlParser.getProjectFiles(realPath, projectName, module);
			sel_fil = request.getParameter("fname");
			if ((sel_fil == null) || (sel_fil.trim().length() < 1)) {
				model.put("msg", " Please Select File ");
			} else {
				filePlace = request.getParameter("filePlace");
				if ((filePlace == null)||filePlace.length()<1)  filePlace ="";
				String action = request.getParameter("fileAct");
				if ((action != null) && action.equals("Save")) {
					// write the file and set msg as updated file
					String data = request.getParameter("fileArea");
					if (data == null || data.length() < 1) {
						model.put("msg", " File Data is Empty ");
					} else {
						int flag = xmlParser.setFileData(realPath, projectName,
								module, sel_fil, data,filePlace);
						if (flag == 0)
							model.put("msg", " File updated Successfully ");
						if (flag == -1)
							model.put("msg", " File updation Failed Try Again ");
					}

				}
				filedata = xmlParser.getFileData(realPath, projectName, module,
						sel_fil,filePlace);
				fdisplay = true;
			}

		}
		request.setAttribute("SEL_FILE", filedata.trim());
		request.setAttribute("FILE_PLACE", filePlace);
		request.getSession().setAttribute("FileAreaDisplay", fdisplay);
		request.getSession().setAttribute("SelFileName", sel_fil);
		request.getSession().setAttribute("SELECTED_MODULE", module);
		request.setAttribute("PROJECT_FILES", prjfiles);
		request.setAttribute("MODULE_FILES", modfiles);
		request.getSession().setAttribute("PROJECT_MODULES", modules);
		request.getSession().setAttribute("PROJECT_NAME", projectName);
		return "viewxmls";
	}

*/}
