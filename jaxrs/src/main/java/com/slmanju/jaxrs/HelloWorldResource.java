package com.slmanju.jaxrs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;

import static java.util.Collections.singletonMap;

@Path("hello")
public class HelloWorldResource {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response helloWorld() {
    Map<String, String> response = singletonMap("message", "Hello World. This is jaxrs with JakartaEE.");
    return Response.ok(response).build();
  }

}
