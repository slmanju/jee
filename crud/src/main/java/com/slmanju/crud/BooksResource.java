package com.slmanju.crud;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;

import static java.util.Collections.singletonMap;

@Path("books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class BooksResource {

  @Inject
  private BookFacade bookFacade;

  @GET
  public Response home() {
    Map<String, String> response = singletonMap("message", "Books API.");
    return Response.ok(response).build();
  }

  @POST
  public Response save(Book book) {
    book = bookFacade.save(book);
    return Response.ok(book).build();
  }

  @GET
  @Path("{id}")
  public Response getBook(@PathParam("id") Integer id) {
    Book book = bookFacade.findBook(id);
    return Response.ok(book).build();
  }

}
