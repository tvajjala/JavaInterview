package com.trvajjala.jersey.rest.server;

import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import org.glassfish.grizzly.http.server.HttpServer;

import com.sun.jersey.api.container.grizzly2.GrizzlyServerFactory;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;

public class Server {

	static final URI BASE_URI = getBaseURI();

	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost/").port(9998).build();
	}

	public static void main(String[] args) throws Exception {
		ResourceConfig rc = new PackagesResourceConfig(
				"com.trvajjala.jersey.rest.webservice");

		HttpServer server = GrizzlyServerFactory.createHttpServer(BASE_URI
				+ "rest/", rc);
		
		System.out
		.println(String
				.format("Jersey app started with WADL available at "
						+ "%srest/application.wadl\nTry out %strvajjala\nHit enter to stop it...",
						BASE_URI, BASE_URI));
		System.in.read();
		server.stop();
		System.out.println(" Stopped ");
	}
}
