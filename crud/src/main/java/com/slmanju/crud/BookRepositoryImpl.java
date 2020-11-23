package com.slmanju.crud;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class BookRepositoryImpl implements BookRepository {

  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public void save(Book book) {
    entityManager.persist(book);
  }

  @Override
  public Book find(Integer id) {
    return entityManager.find(Book.class, id);
  }

  @Override
  public List<Book> findAll() {
    return entityManager.createNamedQuery("Book.findAll", Book.class).getResultList();
  }

}
