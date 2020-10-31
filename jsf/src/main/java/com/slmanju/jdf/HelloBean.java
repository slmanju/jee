package com.slmanju.jdf;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class HelloBean {

  public String getHello() {
    return "Hello world, from JSF!";
  }

}
