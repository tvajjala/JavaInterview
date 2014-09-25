package com.trvajjala.ws;

import java.net.MalformedURLException;
import java.net.URL;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.namespace.QName;
import javax.xml.ws.Endpoint;
import javax.xml.ws.Service;

@WebService
public class SimpleWebService {

	public static void main(String[] args) throws MalformedURLException {
		SimpleWebService implementor = new SimpleWebService();
		Endpoint wsEndpoint = Endpoint.publish(
				"http://127.0.0.1:8080/SimpleWebService", implementor);

		System.out.println("ws published ? " + wsEndpoint.isPublished());

		Service service = Service.create(new URL(
				"http://127.0.0.1:8080/SimpleWebService?wsdl"), new QName(
				"http://ws.trvajjala.com/", "SimpleWebServiceService"));

		System.out.println(service);

	}

	@WebMethod
	public String greeting(String name) {

		return "Hello " + name;
	}

}
