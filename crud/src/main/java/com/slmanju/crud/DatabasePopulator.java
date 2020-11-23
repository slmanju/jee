package com.slmanju.crud;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Startup
@Singleton
public class DatabasePopulator {

  @PersistenceContext
  private EntityManager entityManager;

  @PostConstruct
  @Transactional
  public void init() {
    Book book1 = new Book();
    book1.setAuthor("Manjula");
    book1.setTitle("Cat in Action");
    entityManager.persist(book1);

    Book book2 = new Book();
    book2.setAuthor("Jayawardana");
    book2.setTitle("JEE for Dummies");
    entityManager.persist(book2);
  }

}
