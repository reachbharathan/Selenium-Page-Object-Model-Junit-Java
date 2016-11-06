package pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
  public WebDriver webDriver;

  public void navigateToLoginPage(String url) {
    webDriver.navigate().to(url);
  }
}
