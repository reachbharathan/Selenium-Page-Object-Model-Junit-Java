package tests;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class PaymentTestSetUpAndTearDownStep2 {

    ChromeDriver driver;



    @Test
    public void testPaymentForAClient() {

        selectClient("tcs");
        driver.findElement(By.linkText("Payments")).click();
        driver.findElement(By.partialLinkText("Add New Payment")).click();
        driver.findElement(By.id("payment_received_by")).sendKeys("Jayadeep");
        driver.findElement(By.name("commit")).click();

    }

    private void selectClient(String client) {
        driver.findElement(By.linkText("CLIENTS")).click();
        driver.findElement(By.id("search")).sendKeys(client);
        driver.findElement(By.className("searchBtn")).click();
        driver.findElement(By.linkText("Select Client")).click();
    }


    @After
    public void tearDown(){

        driver.close();
        driver.quit();

    }
}
