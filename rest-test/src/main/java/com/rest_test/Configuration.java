package com.rest_test;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class Configuration {

  public static String environment;


  @BeforeSuite
  @Parameters({"environment"})
  public void initializeEnvironment(String environment) {

    this.environment = environment;

  }

  public static Properties loadProperties(String fileName, Properties properties)
      throws IOException {

    final String fileLocation = System.getProperty("user.dir") + "/resources/properties/"
        + environment + "-" + fileName + "-" + "properties";
    final FileReader reader = new FileReader(fileLocation);
    properties = new Properties();
    properties.load(reader);
    return properties;
  }
}