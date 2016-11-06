package tests.testSiute2;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Step1PomAccountDemo extends BaseTestStep2PageObject {

  ChromeDriver driver;

  @Test
  public void testPaymentForAClient() {
    loginPage.login(propertyReader.readProperty("username"), propertyReader.readProperty("password"));
    homePage.selectClientsLink();
    clientSearchPage.searchAndSelectClient("tcs");
    driver.findElement(By.linkText("Payments")).click();
    driver.findElement(By.partialLinkText("Add New Payment")).click();
    driver.findElement(By.id("payment_received_by")).sendKeys("Jayadeep");
    driver.findElement(By.name("commit")).click();
  }


}
