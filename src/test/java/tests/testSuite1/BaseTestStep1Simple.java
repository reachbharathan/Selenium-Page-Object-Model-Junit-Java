package tests.testSuite1;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class BaseTestStep1Simple {

  ChromeDriver driver;

  @Before
  public void setUp() {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.navigate().to("http://accountsdemo.herokuapp.com");
  }

  @After
  public void tearDown() {
    driver.close();
    driver.quit();
  }

  protected void login(String userName,String password) {
    driver.findElement(By.id("user_email")).sendKeys(userName);
    driver.findElement(By.id("user_password")).sendKeys(password);
    driver.findElement(By.name("commit")).click();
  }

  protected void selectClient(String client) {

    driver.findElement(By.linkText("CLIENTS")).click();
    driver.findElement(By.id("search")).sendKeys(client);
    driver.findElement(By.className("searchBtn")).click();
    driver.findElement(By.linkText("Select Client")).click();
  }
}
