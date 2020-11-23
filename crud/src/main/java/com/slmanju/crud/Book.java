package com.slmanju.crud;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.io.Serializable;

@Entity
@NamedQueries({
    @NamedQuery(name = "Book.findOne", query = "select p from Book p where p.id = :id"),
    @NamedQuery(name = "Book.findAll", query = "select p from Book p")
}
)
public class Book implements Serializable {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String title;
  private String author;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }
}
