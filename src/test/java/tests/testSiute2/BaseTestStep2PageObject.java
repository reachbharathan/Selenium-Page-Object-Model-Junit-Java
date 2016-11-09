package tests.testSiute2;

import com.thoughtworks.selenium.SeleniumException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import pages.ClientPage;
import pages.ClientsSearchPage;
import pages.HomePage;
import pages.LoginPage;
import util.PropertyReader;
import util.ScreenShotRule;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTestStep2PageObject {

  private static final Logger LOGGER = LogManager.getLogger(BaseTestStep2PageObject.class);
  protected static PropertyReader propertyReader;
  @Rule
  public ScreenShotRule screenShotRule;
  protected WebDriver driver;
  protected LoginPage loginPage;
  protected HomePage homePage;
  protected ClientPage clientPage;
  protected ClientsSearchPage clientSearchPage;

  public BaseTestStep2PageObject() {
    screenShotRule = new ScreenShotRule();
    propertyReader = new PropertyReader();
    setDriver();
    screenShotRule.setDriver(driver);
    loginPage = new LoginPage(driver);
    homePage = new HomePage(driver);
    clientPage = new ClientPage(driver);
    clientSearchPage = new ClientsSearchPage(driver);
    LOGGER.info("BaseTestStep2PageObject completed");
  }

  @Before
  public void setUp() {
    loadUrl();
  }

  @After
  public void tearDown() {
    driver.close();
    driver.quit();
  }

  public void setDriver() {
    String browser = propertyReader.readProperty("browser");
    switch (browser) {
      case "chrome":
        driver = new ChromeDriver();
        break;
      case "ie":
        driver = new InternetExplorerDriver();
        break;
      case "firefox":
        driver = new FirefoxDriver();
        break;
      default:
        throw new SeleniumException("Invalid browser");
    }
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.manage().window().maximize();
  }

  public void loadUrl() {
    try {
      URL baseUrl = new URL(propertyReader.readProperty("url"));
      HttpURLConnection connection = (HttpURLConnection) baseUrl.openConnection();
      connection.connect();
      if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
        System.out.println("Unable to make url connection");
        System.out.println("Response Code " + connection.getResponseCode());
        System.out.println("Response Code " + connection.getResponseMessage());
      }
      driver.get(propertyReader.readProperty("url"));
    } catch (IOException e) {
      System.out.println("Unable to make url connection");
      e.printStackTrace();
    }
  }
}
