package com.slmanju.crud;

import java.util.List;

public interface BookRepository {

  void save(Book book);

  Book find(Integer id);

  List<Book> findAll();

}
