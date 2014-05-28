package com.trvajjala.jersey.rest.webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.sun.jersey.spi.resource.Singleton;

@Singleton
@Path("/trvajjala")
public class TestService {

	//this is just let you know configuration success
	@GET
	@Produces("text/plain")
	public String hello() {
		return "You Have Configured Grizzly Server Successfully.";
	}
}
