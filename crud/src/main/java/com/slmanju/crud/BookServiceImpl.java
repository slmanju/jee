package com.slmanju.crud;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class BookServiceImpl implements BookService {

  @Inject
  private BookRepository bookRepository;

  @Override
  public void save(Book book) {
    bookRepository.save(book);
  }

  @Override
  public Book find(Integer id) {
    return bookRepository.find(id);
  }

  @Override
  public List<Book> findAll() {
    return bookRepository.findAll();
  }

}
