package com.suretouch.web.security.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.GenericFilterBean;

import com.suretouch.core.exceptions.ServiceException;
import com.suretouch.core.service.UserService;
import com.suretouch.web.security.util.TokenUtils;

public class RestAuthenticationFilter extends GenericFilterBean {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private AuthenticationEntryPoint authenticationEntryPoint;

	Logger logger = LoggerFactory.getLogger(RestAuthenticationFilter.class);

	@Autowired
	UserService userService;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = this.getAsHttpRequest(request);

		String authToken = extractAuthTokenFromRequest(httpRequest);

		if (!httpRequest.getRequestURI().endsWith("st_login")) {
			if ((authToken != null)) {
				UserDetails userDetails = null;

				try {
					userDetails = userService.getByToken(authToken);

					if (TokenUtils.validateToken(authToken, userDetails)) {
						UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
								userDetails, null, userDetails.getAuthorities());
						authentication
								.setDetails(new WebAuthenticationDetailsSource()
										.buildDetails(httpRequest));
						SecurityContextHolder.getContext().setAuthentication(
								authentication);
					}

				} catch (ServiceException e) {
					SecurityContextHolder.clearContext();
					
					//e.printStackTrace();

				}

			}
		}

		chain.doFilter(request, response);
	}

	private HttpServletRequest getAsHttpRequest(ServletRequest request) {
		if (!(request instanceof HttpServletRequest)) {
			throw new RuntimeException("Expecting an HTTP request");
		}

		return (HttpServletRequest) request;
	}

	private String extractAuthTokenFromRequest(HttpServletRequest httpRequest) {
		/* Get token from header */
		String authToken = httpRequest.getHeader("x-auth-token");

		if (authToken == null) {
			authToken = httpRequest.getHeader("X-Auth-Token");
		}
		/* If token not found get it from request parameter */
		if (authToken == null) {
			authToken = httpRequest.getParameter("authToken");
		}

		return authToken;

	}

}
