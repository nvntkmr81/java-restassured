package com.rest_test;

import static com.rest_APICaller.Configuration.loadProperties;

import java.io.IOException;
import java.util.Properties;


public class API extends BaseAPI {

  Properties testProperties = null;

  public API() {
    if(testProperties==null){
      try {
        testProperties = loadProperties("test", testProperties);
      } catch (final IOException e) {
        e.printStackTrace();
      }

    }
  }
}
