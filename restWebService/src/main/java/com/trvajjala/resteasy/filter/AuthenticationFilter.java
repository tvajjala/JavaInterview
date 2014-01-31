package com.trvajjala.resteasy.filter;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;

public class AuthenticationFilter implements ContainerRequestFilter {

	@Override
	public ContainerRequest filter(ContainerRequest requestContext) {

		if (requestContext.getMethod().equals("PUT")) {
			requestContext.setMethod("POST");
		}
		
		System.out.println("getUserPrincipal : "
				+ requestContext.getUserPrincipal());
		System.out.println(" request filter  invoked ");
		
		return requestContext;
	}

}
