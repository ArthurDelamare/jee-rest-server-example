package com.test;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.test.model.SimpleObject;

@Path("/MyRestService")
@ApplicationPath("/resources")
public class RestService extends Application {

	@GET
	@Path("/sayHello")
	public String getHelloWorld() {
		return "Hello World";
	}
	
	@GET
	@Path("echo")
	public Response getEchoMessage(@QueryParam("message") String message) {
		return Response.ok("Your message was: " + message).build();
	}
	
	@GET
	@Path("simpleObject")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public SimpleObject getSimpleObject() {
		return new SimpleObject(1, "toto");
	}
}
