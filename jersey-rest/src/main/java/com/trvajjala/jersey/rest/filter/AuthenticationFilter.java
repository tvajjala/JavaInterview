package com.trvajjala.jersey.rest.filter;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;

public class AuthenticationFilter implements ContainerRequestFilter {

	@Override
	public ContainerRequest filter(ContainerRequest request) {

		if (request.getMethod().equals("PUT")) {
			request.setMethod("POST");
		}
		
		System.out.println("getUserPrincipal : "
				+ request.getUserPrincipal());
		System.out.println(" request filter  invoked ");
		
		return request;
	}

}
