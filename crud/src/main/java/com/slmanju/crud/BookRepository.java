package com.slmanju.crud;

import javax.enterprise.context.Dependent;
import java.util.ArrayList;
import java.util.List;

@Dependent
public class BookRepository {

  private List<Book> books = new ArrayList<>();

  public Book save(Book book) {
    book.setId(books.size() + 1);
    books.add(book);
    return book;
  }

  public Book findBook(Integer id) {
    return books.stream().filter(book -> book.getId() == id).findFirst().orElse(null);
  }

}
