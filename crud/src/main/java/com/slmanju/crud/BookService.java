package com.slmanju.crud;

import java.util.List;

public interface BookService {

  void save(Book book);

  Book find(Integer id);

  List<Book> findAll();

}
