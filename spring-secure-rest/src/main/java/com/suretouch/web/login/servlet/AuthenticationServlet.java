package com.suretouch.web.login.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.suretouch.core.exceptions.ServiceException;
import com.suretouch.core.rest.model.LoginRequest;
import com.suretouch.core.rest.model.LoginResponse;
import com.suretouch.core.rest.model.UserVO;
import com.suretouch.core.service.UserService;
import com.suretouch.web.security.util.TokenUtils;

/**
 * @author tvajjala
 * 
 *         Servlet implementation class AuthenticationServlet which will set
 *         security context for the subsequent calls and generates token
 */
@WebServlet("/st_login")
public class AuthenticationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger logger = LoggerFactory.getLogger(AuthenticationServlet.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AuthenticationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		logger.info("*******************************");
		logger.info(" content type  " + request.getContentType());

		ObjectMapper mapper = new ObjectMapper();

		if ((request.getContentType() == null)
				|| (!"application/json".equalsIgnoreCase(request
						.getContentType()))) {

			out.write(mapper.writeValueAsString("invalid content type"));
			out.flush();
			out.close();
			return;
		}

		String json = request.getReader().readLine();
		logger.info("PAYLOAD  " + json);

		LoginRequest loginRequest = mapper.readValue(json, LoginRequest.class);

		logger.info(loginRequest.getSt_username() + " : "
				+ loginRequest.getSt_password());

		WebApplicationContext context = WebApplicationContextUtils
				.getRequiredWebApplicationContext(request.getServletContext());

		UserService userService = (UserService) context.getBean("userService");

		AuthenticationManager authenticationManager = (AuthenticationManager) context
				.getBean("authenticationManager");

		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
				loginRequest.getSt_username(), loginRequest.getSt_password());
		Authentication authentication = authenticationManager
				.authenticate(authenticationToken);
		SecurityContextHolder.getContext().setAuthentication(authentication);

		logger.info("  authentication  " + authentication);

		LoginResponse loginResponse = new LoginResponse();

		UserVO userDetails = (UserVO) userService
				.loadUserByUsername(loginRequest.getSt_username());

		for (GrantedAuthority authority : userDetails.getAuthorities()) {
			loginResponse.getRoles().add(authority.getAuthority());
		}

		int expiryMinutes = 55;// configurable

		String token = TokenUtils.createToken(userDetails, expiryMinutes);
		long llt = userDetails.getLastLoginTime();

		userDetails.setAccessToken(token);

		try {
			userDetails.setLastLoginTime(System.currentTimeMillis());
			userService.updateUser(userDetails);
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		loginResponse.setLastLoginTime(llt);
		loginResponse.setAccessToken(token);
		loginResponse.setExpiryTime(expiryMinutes + " mins");

		loginResponse.setUsername(userDetails.getUsername());

		out.write(mapper.writeValueAsString(loginResponse));
		out.flush();
		out.close();

	}

}
