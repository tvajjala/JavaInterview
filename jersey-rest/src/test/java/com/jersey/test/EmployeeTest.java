package com.jersey.test;

import java.io.IOException;
import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.container.grizzly2.GrizzlyServerFactory;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;

public class EmployeeTest {

	static final URI BASE_URI = getBaseURI();
	static HttpServer server;

	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost/").port(9998).build();
	}

	@BeforeClass
	public static void startServer() throws IOException {
		System.out.println("Starting grizzly...");

		ResourceConfig rc = new PackagesResourceConfig(
				"com.trvajjala.jersey.rest.webservice");

		server = GrizzlyServerFactory.createHttpServer(BASE_URI + "rest/", rc);

		System.out.println(String.format(
				"Jersey app started with WADL available at "
						+ "%srest/application.wadl\nTry out %strvajjala\n",
				BASE_URI, BASE_URI));
	}

	@AfterClass
	public static void stopServer() {
		server.stop();
		System.out.println(" Grizzly Server Stopped... ");
	}

	@Test
	public void configTest() throws IOException {
		Client client = Client.create(new DefaultClientConfig());
		WebResource service = client.resource(getBaseURI());
		ClientResponse resp = service.path("rest").path("trvajjala")
				.accept(MediaType.TEXT_PLAIN).get(ClientResponse.class);
		
		
		Assert.assertEquals(200, resp.getStatus());
		
		String text = resp.getEntity(String.class);
		
		System.out.println("Got stuff: " + text);
		Assert.assertEquals("You Have Configured Grizzly Server Successfully.",
				text);
	}

	@Test
	public void testGetDefaultUser() throws IOException {
		Client client = Client.create(new DefaultClientConfig());
		WebResource service = client.resource(getBaseURI());
		ClientResponse resp = service.path("rest").path("empService")
				.path("employees").accept(MediaType.APPLICATION_JSON)
				.get(ClientResponse.class);
		Assert.assertEquals(200, resp.getStatus());
		String text = resp.getEntity(String.class);
		System.out.println("Got stuff: " + text);
		Assert.assertNotEquals("", text);
	}
}
