package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import pages.ClientsHomePage;

public class AccountDemoTestExtendingBaseTestStep3 extends BaseTestCaseStep3 {


    @Test
    public void testEditAccount() {

        selectClient("tcs");
        driver.findElement(By.linkText("Edit Client Details")).click();
        driver.findElement(By.id("client_contact_person_name")).clear();
        driver.findElement(By.id("client_contact_person_name")).sendKeys("Jaggu");
        driver.findElement(By.id("client_address")).sendKeys("Mantri Woodlands , near Arakere gate");
        driver.findElement(By.name("commit")).click();
    }

    @Test
    public void testAddQuotationForClient() {

        selectClient("tcs");
        driver.findElement(By.linkText("Quotations")).click();
        driver.findElement(By.partialLinkText("Add New Quotation")).click();
        driver.findElement(By.id("quotation_order_placed_by")).sendKeys("Mr.Raju");
        driver.findElement(By.id("quotation_event_name")).sendKeys("Nasscom Product Conclave");
        driver.findElement(By.name("commit")).click();

    }


}
