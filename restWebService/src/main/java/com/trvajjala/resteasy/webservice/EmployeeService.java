package com.trvajjala.resteasy.webservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import com.sun.jersey.spi.resource.Singleton;

@Singleton
@Path("/empService")
public class EmployeeService {

	// below static block creates test data for the application
	private static Map<String, Employee> employees = new HashMap<String, Employee>();

	static {

		Employee employee1 = new Employee();
		employee1.setEmployeeId("1");
		employee1.setEmployeeName("ThirupathiReddy");
		employee1.setDesignation("Associate Architect");
		employee1.setPhone("9000211024");
		employees.put(employee1.getEmployeeId(), employee1);

		Employee employee2 = new Employee();
		employee2.setEmployeeId("2");
		employee2.setEmployeeName("Bhanu Charan");
		employee2.setDesignation("Business Analyst");
		employee2.setPhone("9000211024");
		employees.put(employee2.getEmployeeId(), employee2);

	}

	
 //  url to call this method --> 	http://localhost:8080/restWebService/rest/empService/employees
		
	@GET
	@Path("/employees")
	@Produces("application/xml")  // producer annotation tells the server that send response as xml
	public List<Employee> listEmployees() {

		return new ArrayList<Employee>(employees.values());
	}

	
//  to get a single request  -->  	http://localhost:8080/restWebService/rest/empService/employee/1
	@GET
	@Path("/employee/{employeeid}")
	@Produces("application/xml")
	public Employee getEmployee(@PathParam("employeeid") String employeeId) {

		return employees.get(employeeId);
	}

// to get json format of respose --> http://localhost:8080/restWebService/rest/empService/json/employees	
	@GET
	@Path("/json/employees/")
	@Produces("application/json")
	public List<Employee> listEmployeesJSON() {

		return new ArrayList<Employee>(employees.values());
	}

	
//   to get json of single request -->	http://localhost:8080/restWebService/rest/empService/json/employee/1
	@GET
	@Path("/json/employee/{employeeid}")
	@Produces("application/json")
	public Employee getEmployeeJSON(@PathParam("employeeid") String employeeId) {
		return employees.get(employeeId);
	}

	
	// this method called from index.jsp to add new record  -->  http://localhost:8080/restWebService/index.jsp
	static int i = 2;

	// form to submit information
	@POST
	@Path("/add")
	public Response addUser(@FormParam("name") String name,
			@FormParam("job") String job, @FormParam("phone") String phone) {

		System.out.println("  adding PUT method  ");
		Employee employee2 = new Employee();
		employee2.setEmployeeId(String.valueOf(i++));
		employee2.setEmployeeName(name);
		employee2.setDesignation(job);
		employee2.setPhone(phone);
		employees.put(employee2.getEmployeeId(), employee2);

		return Response
				.status(200)
				.entity("user Created with details --> name : " + name
						+ ", job : " + job + ", phone :" + phone).build();

	}

	// this is parh paramters to pass dynamically
	//  http://localhost:8080/restWebService/rest/empService/2011;author=thirupathiReddy;country=india
	@GET
	@Path("{year}")
	public Response getBooks(@PathParam("year") String year,
			@MatrixParam("author") String author,
			@MatrixParam("country") String country) {

		return Response
				.status(200)
				.entity("you requested following book details: published year " + year + ", author : "
						+ author + ", country : " + country).build();

	}

//      http://localhost:8080/restWebService/rest/empService/query?from=100&to=200&orderBy=age&orderBy=name&orderBy=date&orderBy=year
	@GET
	@Path("/query")
	public Response getUsers(@QueryParam("from") int from,
			@QueryParam("to") int to,
			@QueryParam("orderBy") List<String> orderBy) {

		return Response
				.status(200)
				.entity(" list of information from : " + from + ", to : " + to
						+ ", orderBy" + orderBy.toString()).build();

	}

	// employee details as string 
//  	http://localhost:8080/restWebService/rest/empService/1
	@GET
	@Path("{id}")
	@Produces("text/plain")
	public String pathParamEx(@PathParam("id") String id) {

		return "result " + employees.get(id).toString();

	}

	// plain text you can take control
	// http://localhost:8080/restWebService/rest/empService/hello
	@GET
	@Path("/hello")
	@Produces("text/plain")
	public String hello() {
		return "Hello World";
	}

	//  http://localhost:8080/restWebService/rest/empService/echo/hello
	@GET
	@Path("/echo/{message}")
	@Produces("text/plain")
	public String echo(@PathParam("message") String message) {
		return "echo from server  :  "+message;
	}

}