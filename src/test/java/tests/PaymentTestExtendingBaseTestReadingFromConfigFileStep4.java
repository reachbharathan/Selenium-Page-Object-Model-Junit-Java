package tests;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;

public class PaymentTestExtendingBaseTestReadingFromConfigFileStep4 extends BaseTestCaseUsingPOStep5 {


    @Test
    @Category(Regression.class)
    public void testPaymentForAClient() {

        clientsHomePage.selectClient("tcs");
        driver.findElement(By.linkText("Payments")).click();
        driver.findElement(By.partialLinkText("Add New Payment")).click();
        driver.findElement(By.id("payment_received_by")).sendKeys("Jayadeep");
        driver.findElement(By.name("commit")).click();

    }


}
