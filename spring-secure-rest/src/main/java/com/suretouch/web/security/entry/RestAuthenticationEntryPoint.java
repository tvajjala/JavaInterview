package com.suretouch.web.security.entry;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {
	Logger logger = LoggerFactory.getLogger(RestAuthenticationEntryPoint.class);

	@Override
	public void commence(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException exception)
			throws IOException, ServletException {

		String msg="Full authentication is required to access this resource";
		msg=msg.equalsIgnoreCase(exception.getMessage())?"invalid token entered or token expire ":msg;
		
		response.setContentType("application/json");
		PrintWriter writer = response.getWriter();
		writer.write("{\"status\":\"200\",\"msg\":\""+msg+"\"}");
		writer.flush();

	}

}
