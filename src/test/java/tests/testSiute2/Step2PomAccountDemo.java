package tests.testSiute2;

import org.junit.Test;
import org.openqa.selenium.By;
import tests.testSiute2.BaseTestStep2PageObject;

public class Step2PomAccountDemo extends BaseTestStep2PageObject {

  @Test
  public void testPaymentForAClient() {
    clientsHomePage.selectClient("tcs");
    driver.findElement(By.linkText("Payments")).click();
    driver.findElement(By.partialLinkText("Add New Payment")).click();
    driver.findElement(By.id("payment_received_by")).sendKeys("Jayadeep");
    driver.findElement(By.name("commit")).click();
  }
}
