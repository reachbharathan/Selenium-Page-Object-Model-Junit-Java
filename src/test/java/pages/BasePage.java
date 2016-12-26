package pages;

import org.openqa.selenium.WebDriver;
import util.PropertyReader;

public class BasePage {

  public WebDriver webDriver;
  protected static PropertyReader propertyReader;

  public void navigateToLoginPage(String url) {
    webDriver.navigate().to(url);
  }
}
