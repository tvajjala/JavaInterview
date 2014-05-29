package com.jersey.test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.container.grizzly2.GrizzlyServerFactory;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.jersey.multipart.FormDataBodyPart;
import com.sun.jersey.multipart.FormDataMultiPart;

public class ResourceTest {
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
	public void uploadResource() throws Exception {

		String fileName = "2.jpg";
		Client client = Client.create(new DefaultClientConfig());
		WebResource webResource = client.resource(getBaseURI());
		FormDataMultiPart form = new FormDataMultiPart();
		form.field("fileName", fileName);
		
		InputStream content = getClass().getClassLoader().getResourceAsStream(fileName);

		Assert.assertNotNull(" Invalid File Location " + fileName, content);

		FormDataBodyPart fdp = new FormDataBodyPart("content", content,	MediaType.MULTIPART_FORM_DATA_TYPE);
		form.bodyPart(fdp);
		
		String responseJson = webResource.path("rest").path("imageService")
				.path("upload").type(MediaType.MULTIPART_FORM_DATA_TYPE)
				.post(String.class, form);
		
		
		content.close();
		System.out.println(responseJson);
		
		
		
		

	}
}
