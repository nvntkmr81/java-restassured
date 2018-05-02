package com.rest_test.base;

import static com.rest_test.Configuration.loadProperties;
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
