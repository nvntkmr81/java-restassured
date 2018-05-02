package utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Utils {

  static Properties properties;

  public static String getPropertyValue(String key) {
    try {
      final File file = new File(
          "D:/Personal/Navneet/Regression Suit/Programs/src/resources/properties/data.properties");
      final FileReader reader = new FileReader(file);
      properties = new Properties();
      properties.load(reader);

    } catch (final FileNotFoundException e) {
      e.printStackTrace();
    } catch (final IOException e) {
      e.printStackTrace();
    }
    return properties.getProperty(key);
  }
}

