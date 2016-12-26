package tests.testSuite1;

import org.junit.Test;
import org.openqa.selenium.By;
import tests.testSuite1.BaseTestStep1Simple;

public class Step3AccountDemo extends BaseTestStep1Simple {
  //separate the common to base step
  //have actions only related to steps

  @Test
  public void testEditAccount() {
    login("letslearnandshare@gmail.com","!abcd1234");
    selectClient("tcs");
    driver.findElement(By.linkText("Edit Client Details")).click();
    driver.findElement(By.id("client_contact_person_name")).clear();
    driver.findElement(By.id("client_contact_person_name")).sendKeys("Jaggu");
    driver.findElement(By.id("client_address")).sendKeys("Mantri Woodlands , near Arakere gate");
    driver.findElement(By.name("commit")).click();
  }

  @Test
  public void testAddQuotationForClient() {
    login("letslearnandshare@gmail.com","!abcd1234");
    selectClient("tcs");
    driver.findElement(By.linkText("Quotations")).click();
    driver.findElement(By.partialLinkText("Add New Quotation")).click();
    driver.findElement(By.id("quotation_order_placed_by")).sendKeys("Mr.Raju");
    driver.findElement(By.id("quotation_event_name")).sendKeys("Nasscom Product Conclave");
    driver.findElement(By.name("commit")).click();
  }
}
