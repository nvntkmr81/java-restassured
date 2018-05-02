package com.rest_test;

import org.testng.annotations.BeforeClass;

public class BaseTest {
  protected ObjectFactory api;

  @BeforeClass
  public void initializeObjectFactory() {
    api = new ObjectFactory();
  }

}
