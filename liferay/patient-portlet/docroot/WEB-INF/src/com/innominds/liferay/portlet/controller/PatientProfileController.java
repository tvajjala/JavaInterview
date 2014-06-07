package com.innominds.liferay.portlet.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.innominds.liferay.portlet.service.PatientProfileService;
import com.innominds.liferay.portlet.util.URLBuilder;
import com.innominds.liferay.portlet.util.UserType;
import com.innominds.liferay.portlet.vo.PatientProfile;
import com.innominds.portlets.service.model.NapierUser;
import com.innominds.portlets.service.service.NapierUserLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;

/**
 * 
 * @author tvajjala
 * 
 */
@Controller
public class PatientProfileController {

	private static Logger logger = Logger
			.getLogger(PatientProfileController.class.getSimpleName());

	@Autowired
	PatientProfileService patientProfileService;
	PropertyPlaceholderConfigurer c;

	@RenderMapping
	public String defaultView(Map<String, Object> map) {

		logger.info("logger test");

		return "login";
	}

	@ActionMapping(params = "action=login")
	public void login(ActionRequest actionRequest,
			ActionResponse actionResponse, Model model) throws IOException,
			PortletException {

		String username = ParamUtil.getString(actionRequest, "nh_username");
		String password = ParamUtil.getString(actionRequest, "nh_password");
		/*
		 * //converting actionRequest to servletRequest HttpServletRequest
		 * request = PortalUtil .getHttpServletRequest(actionRequest);
		 * 
		 * HttpServletResponse response = PortalUtil
		 * .getHttpServletResponse(actionResponse);
		 */
		try {
			// for custom finder method add your methods in XLocalServiceImpl
			// and run service builder required method signatures comes under
			// XLocalServiceUtil -trvajjala

			username = (username.trim().length() < 1) ? (null) : username;
			NapierUser napierUser = NapierUserLocalServiceUtil
					.getUserByCredentials(username, password);

			System.out.println(" user " + napierUser);

			if (napierUser != null) {

				String mrString = napierUser.getMrNumber();
				logger.info(" mr number " + mrString);

				PortletURL portletURL = URLBuilder.getRenderURL(actionRequest,
						"next", "patientInfo");
				portletURL.setParameter("MRNUM", mrString);

				actionResponse.sendRedirect(portletURL.toString());

			} else {
				throw new Exception("Authentication Failed");
			}

			/*
			 * Long companyId = CompanyThreadLocal.getCompanyId();
			 * 
			 * Map<String, Object> resultMap = new HashMap<String, Object>();
			 * 
			 * long loginStatus =
			 * UserLocalServiceUtil.authenticateByEmailAddress( companyId,
			 * username, password, null, null, resultMap);
			 * 
			 * if (Authenticator.SUCCESS == loginStatus) {
			 * 
			 * Long userId = (Long) resultMap.get("userId");
			 * 
			 * logger.info(" userId " + userId);
			 * 
			 * User user = UserLocalServiceUtil.getUser(userId);
			 * 
			 * PortletURL portletURL = URLBuilder.getRenderURL(actionRequest,
			 * "next", "patientInfo"); portletURL.setParameter("MRNUM",
			 * "MR201417Pal");
			 * 
			 * actionResponse.sendRedirect(portletURL.toString()); } else {
			 * throw new Exception("Authentication Failed"); }
			 */
		} catch (Exception e) {
			System.out.println(e.getMessage());
			SessionErrors.add(actionRequest, "login.fail");
			logger.info(" " + e.getMessage());
		}

	}

	@ActionMapping(params = "action=registerPatient")
	public void registerPatient(ActionRequest actionRequest,
			ActionResponse actionResponse, Model model) throws IOException,
			PortletException {

		String userType = ParamUtil.getString(actionRequest, "userType");
		String mrnumber = ParamUtil.getString(actionRequest, "mrnumber");
		String name = ParamUtil.getString(actionRequest, "name");
		String phone = ParamUtil.getString(actionRequest, "phone");
		String email = ParamUtil.getString(actionRequest, "email");

		logger.info(mrnumber + " userType " + userType + "name " + name);
		try {
			try {
				NapierUser napierUser = NapierUserLocalServiceUtil
						.getUserByMR(mrnumber);

				if (napierUser != null) {
					SessionErrors.add(actionRequest, "profile.exists");
					PortletURL portletURL = URLBuilder.getRenderURL(
							actionRequest, "next", "registration");
					actionResponse.sendRedirect(portletURL.toString());
					return;
				}
			} catch (Exception e) {
				// allow registration
			}

			PatientProfile patientProfile = null;
			try {
				patientProfile = patientProfileService.getProfile(mrnumber);

			} catch (Exception e) {
				// registration not done if MR number not found in the Napier DB
				SessionErrors.add(actionRequest, "profile.notfound");
				PortletURL portletURL = URLBuilder.getRenderURL(actionRequest,
						"next", "registration");
				actionResponse.sendRedirect(portletURL.toString());
				return;
			}

			long napierUserId = CounterLocalServiceUtil
					.increment(NapierUser.class.getName());
			NapierUser napierUser = NapierUserLocalServiceUtil
					.createNapierUser(napierUserId);
			napierUser.setAddress("Miaypur HYD AP INDIA ");

			napierUser.setUserType(userType);
			napierUser.setAge(55);
			napierUser.setLiferayUserId("");
			napierUser.setMrNumber(mrnumber);
			napierUser.setMobile(phone);
			napierUser.setEmail(email);

			napierUser.setFirstname(patientProfile.getFirstname());
			napierUser.setLastname(patientProfile.getLastname());

			napierUser.setUsername(mrnumber);
			napierUser.setPassword("1234");// generate randomly and send to
											// mobile

			NapierUserLocalServiceUtil.updateNapierUser(napierUser);
			PortletURL portletURL = URLBuilder.getRenderURL(actionRequest,
					"next", "patientInfo");
			portletURL.setParameter("MRNUM", mrnumber);

			actionResponse.sendRedirect(portletURL.toString());
		} catch (Exception e) {
			logger.info(e.getMessage());
			SessionErrors.add(actionRequest, "registration.failed");

			PortletURL portletURL = URLBuilder.getRenderURL(actionRequest,
					"next", "registration");
			actionResponse.sendRedirect(portletURL.toString());

		}

	}

	@RenderMapping(params = "next=patientInfo")
	public String patientInfo(RenderRequest renderRequest,
			RenderResponse renderResponse, Model model) throws IOException,
			PortletException {

		/*
		 * List<PatientProfile> list = patientProfileService.list();
		 * 
		 * model.addAttribute("patientList", list);
		 */
		logger.info(renderRequest.getParameter("MRNUM"));
		try {
			PatientProfile patientProfile = patientProfileService
					.getProfile(renderRequest.getParameter("MRNUM"));

			model.addAttribute("patientProfile", patientProfile);

		} catch (Exception e) {

		}

		logger.info(" *** patientInfo ***");
		return "patientInfo";
	}

	@RenderMapping(params = "next=registration")
	public String registration(RenderRequest renderRequest,
			RenderResponse renderResponse, Model model) throws IOException,
			PortletException {

		List<String> list = new ArrayList<String>();
		for (UserType userType : UserType.values()) {
			list.add(userType.getTitle());
		}
		model.addAttribute("userTypes", list);

		logger.info(" *** renderresponse ***");
		return "registration";
	}

	@RenderMapping(params = "action=forgotPassword")
	public ModelAndView forgotPassword(RenderRequest renderRequest,
			RenderResponse renderResponse, Model model) throws IOException,
			PortletException {
		logger.info(" forgot password ");

		return new ModelAndView("forgotPassword");

	}

	@ActionMapping(params = "action=add")
	public void addProfile(ActionRequest actionRequest,
			ActionResponse actionResponse, Model model,
			@ModelAttribute("patient") PatientProfile patient,
			BindingResult result) throws IOException, PortletException {

		logger.info("submission  "
				+ ParamUtil.getString(actionRequest, "firstname"));

		logger.info(" patient " + patient.getFirstname());

	}

	@ActionMapping(params = "action=delete")
	public void deleteProfile(@RequestParam("empId") Integer empId,
			ActionRequest actionRequest, ActionResponse actionResponse,
			Model model) throws IOException, PortletException {

		logger.info(" deleting " + empId);

	}

	@RenderMapping(params = "action=logout")
	public String logout(RenderRequest renderRequest,
			RenderResponse renderResponse, Model model) throws IOException,
			PortletException {

		return "login";
	}

	/*
	 * 
	 * long userId = CounterLocalServiceUtil.increment(User.class .getName());
	 * 
	 * User user = UserLocalServiceUtil.createUser(userId); Role role = null;
	 * 
	 * try { role = RoleLocalServiceUtil.getRole(
	 * CompanyThreadLocal.getCompanyId(), "PATIENT"); } catch (Exception e) {
	 * long roleId = CounterLocalServiceUtil.increment(Role.class .getName());
	 * role = RoleLocalServiceUtil.createRole(roleId); role.setTitle("PATINET");
	 * role.setName("PATINET");
	 * role.setDescription("Napier Patient will fall under this role "); role =
	 * RoleLocalServiceUtil.updateRole(role); }
	 * 
	 * user.setScreenName("Napier Patient"); user.setPassword("1234");
	 * user.setPasswordEncrypted(false); user.setDigest("1234");
	 * user.setAgreedToTermsOfUse(true);
	 * 
	 * user.setEmailAddress(name + "@napier.com");
	 * 
	 * // adding role to user UserLocalServiceUtil
	 * .addRoleUser(role.getRoleId(), user.getUserId());
	 * 
	 * List<Contact> contactList = ContactLocalServiceUtil.getContacts(0,
	 * ContactLocalServiceUtil.getContactsCount());
	 * 
	 * if (!contactList.isEmpty()) {
	 * user.setContactId(contactList.get(0).getContactId());// } ServiceContext
	 * serviceContext = ServiceContextFactory.getInstance( User.class.getName(),
	 * actionRequest); user.setExpandoBridgeAttributes(serviceContext);
	 * UserLocalServiceUtil.updateUser(user);
	 */
}