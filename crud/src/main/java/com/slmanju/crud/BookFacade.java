package com.slmanju.crud;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class BookFacade {

  @Inject
  private BookRepository bookRepository;

  public Book save(Book book) {
    return bookRepository.save(book);
  }

  public Book findBook(Integer id) {
    return bookRepository.findBook(id);
  }

}
