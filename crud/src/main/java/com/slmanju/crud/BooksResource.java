package com.slmanju.crud;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Path("books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class BooksResource {

  @Inject
  private BookFacade bookFacade;
  @Resource
  private DataSource dataSource;
  @PersistenceContext
  private EntityManager entityManager;

  @GET
  public Response home() {
    Map<String, String> response = new HashMap<>();
    response.put("message", "Books API.");
    try (Connection connection = dataSource.getConnection()) {
      response.put("getSchema", connection.getSchema());
      response.put("getCatalog", connection.getCatalog());
      response.put("getDriverName", connection.getMetaData().getDriverName());
      response.put("getURL", connection.getMetaData().getURL());
      response.put("database", connection.getMetaData().getDatabaseProductName() + "-" + connection.getCatalog());
    } catch (SQLException e) {
      e.printStackTrace();
    }

    List<Book> resultList = bookFacade.findAll();
    int size = resultList.size();
    response.put("size", size + "");
    response.put("books", resultList.stream().map(Book::getTitle).collect(Collectors.joining(", ")));

    return Response.ok(response).build();
  }

  @POST
  public Response save(Book book) {
    bookFacade.save(book);
    return Response.ok(book).build();
  }

  @GET
  @Path("{id}")
  public Response getBook(@PathParam("id") Integer id) {
    Book book = bookFacade.findBook(id);
    return Response.ok(book).build();
  }

}
