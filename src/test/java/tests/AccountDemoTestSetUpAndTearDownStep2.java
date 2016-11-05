package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AccountDemoTestSetUpAndTearDownStep2 {

    ChromeDriver driver;

    @Before
    public void setUp(){

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.navigate().to("http://accountsdemo.herokuapp.com/");
        driver.findElement(By.id("user_email")).sendKeys("jbalacha@thoughtworks.com");
        driver.findElement(By.id("user_password")).sendKeys("vijay!123");
        driver.findElement(By.name("commit")).click();
    }

    @Test
    public void testEditAccount() {

        selectClient("tcs");
        driver.findElement(By.linkText("Edit Client Details")).click();
        driver.findElement(By.id("client_contact_person_name")).clear();
        driver.findElement(By.id("client_contact_person_name")).sendKeys("Jaggu");
        driver.findElement(By.id("client_address")).sendKeys("Mantri Woodlands , near Arakere gate");
        driver.findElement(By.name("commit")).click();

    }

    private void selectClient(String client) {
        driver.findElement(By.linkText("CLIENTS")).click();
        driver.findElement(By.id("search")).sendKeys(client);
        driver.findElement(By.className("searchBtn")).click();
        driver.findElement(By.linkText("Select Client")).click();
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

    @After
    public void tearDown(){

        driver.close();
        driver.quit();

    }

}
