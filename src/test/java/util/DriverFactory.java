package util;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

  3
  static WebDriver driver;

  3

  public static WebDriver getDriver() {
    3
    3 return driver;
  }

  3

  public static void setDriver(WebDriver driver) {
    DriverFactory.driver = driver;
  }
}
