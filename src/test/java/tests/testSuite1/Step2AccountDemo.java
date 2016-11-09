package tests.testSuite1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Step2AccountDemo {
  //gropu out the common
  //inititalize or declare at class leve
  //separate the common before and after actions

  ChromeDriver driver;

  @Before
  public void setUp() {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.navigate().to("http://accountsdemo.herokuapp.com/");
    driver.findElement(By.id("user_email")).sendKeys("letslearnandshare@gmail.com");
    driver.findElement(By.id("user_password")).sendKeys("!abcd1234");
    driver.findElement(By.name("commit")).click();
  }

  @Test
  public void testEditAccount() {
    login("letslearnandshare@gmail.com", "!abcd1234");
    selectClient("tcs");
    driver.findElement(By.linkText("Edit Client Details")).click();
    driver.findElement(By.id("client_contact_person_name")).clear();
    driver.findElement(By.id("client_contact_person_name")).sendKeys("Jaggu");
    driver.findElement(By.id("client_address")).sendKeys("Mantri Woodlands , near Arakere gate");
    driver.findElement(By.name("commit")).click();
  }

  @Test
  public void testAddQuotationForClient() {
    login("letslearnandshare@gmail.com", "!abcd1234");
    selectClient("tcs");
    driver.findElement(By.linkText("Quotations")).click();
    driver.findElement(By.partialLinkText("Add New Quotation")).click();
    driver.findElement(By.id("quotation_order_placed_by")).sendKeys("Mr.Raju");
    driver.findElement(By.id("quotation_event_name")).sendKeys("Nasscom Product Conclave");
    driver.findElement(By.name("commit")).click();
  }

  @After
  public void tearDown() {
    driver.close();
    driver.quit();
  }

  private void selectClient(String client) {
    driver.findElement(By.linkText("CLIENTS")).click();
    driver.findElement(By.id("search")).sendKeys(client);
    driver.findElement(By.className("searchBtn")).click();
    driver.findElement(By.linkText("Select Client")).click();
  }

  protected void login(String userName, String password) {
    driver.findElement(By.id("user_email")).sendKeys(userName);
    driver.findElement(By.id("user_password")).sendKeys(password);
    driver.findElement(By.name("commit")).click();
  }
}
