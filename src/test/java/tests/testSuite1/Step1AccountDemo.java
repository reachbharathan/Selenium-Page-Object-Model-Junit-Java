package tests.testSuite1;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Step1AccountDemo {
  // Code duplication
  // Lengthy
  // Hard to maintain

  @Test
  public void testEditAccount() {
    ChromeDriver driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.navigate().to("http://accountsdemo.herokuapp.com/");
    driver.findElement(By.id("user_email")).sendKeys("letslearnandshare@gmail.com");
    driver.findElement(By.id("user_password")).sendKeys("!abcd1234");
    driver.findElement(By.name("commit")).click();
    driver.findElement(By.linkText("CLIENTS")).click();
    driver.findElement(By.id("search")).sendKeys("tcs");
    driver.findElement(By.className("searchBtn")).click();
    driver.findElement(By.linkText("Select Client")).click();
    driver.findElement(By.linkText("Edit Client Details")).click();
    driver.findElement(By.id("client_contact_person_name")).clear();
    driver.findElement(By.id("client_contact_person_name")).sendKeys("Jaggu");
    driver.findElement(By.id("client_address")).sendKeys("Mantri Woodlands , near Arakere gate");
    driver.findElement(By.name("commit")).click();
  }

  @Test
  public void testAddQuotationForClient() {
    ChromeDriver driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.navigate().to("http://accountsdemo.herokuapp.com/");
    driver.findElement(By.id("user_email")).sendKeys("letslearnandshare@gmail.com");
    driver.findElement(By.id("user_password")).sendKeys("vijay!123");
    driver.findElement(By.name("commit")).click();
    driver.findElement(By.linkText("CLIENTS")).click();
    driver.findElement(By.id("search")).sendKeys("tcs");
    driver.findElement(By.className("searchBtn")).click();
    driver.findElement(By.linkText("Select Client")).click();
    driver.findElement(By.linkText("Quotations")).click();
    driver.findElement(By.partialLinkText("Add New Quotation")).click();
    driver.findElement(By.id("quotation_order_placed_by")).sendKeys("Mr.Raju");
    driver.findElement(By.id("quotation_event_name")).sendKeys("Nasscom Product Conclave");
    driver.findElement(By.name("commit")).click();
  }
}
