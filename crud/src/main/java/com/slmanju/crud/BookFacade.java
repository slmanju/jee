package com.slmanju.crud;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class BookFacade {

  @Inject
  private BookService bookService;

  public void save(Book book) {
    bookService.save(book);
  }

  public Book findBook(Integer id) {
    return bookService.find(id);
  }

  public List<Book> findAll() {
    return bookService.findAll();
  }
}
