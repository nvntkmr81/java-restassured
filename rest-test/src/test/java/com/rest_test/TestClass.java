package com.rest_test;

import static org.testng.Reporter.log;
import org.testng.annotations.Test;
import utility.Log;


public class TestClass extends BaseTest {

  @Test
  public void sampleTest() {

    Log.info("This is log4j logger");
    log("This is TestNg logger");
    System.out.println(System.getProperty("user.dir") + "/resources/properties/" + "qa" + "-"
        + "test"
        + "-" + "properties");

  }

}
