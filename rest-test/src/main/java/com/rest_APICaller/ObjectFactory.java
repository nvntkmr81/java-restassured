package com.rest_APICaller;

import com.rest_test.base.API;

public class ObjectFactory {

  private API testApi;

  public API api() {
    if (testApi == null) {
      testApi = new API();
    }
    return testApi;
  }

}
