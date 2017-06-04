package tests.testSuite1;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Step1AccountDemo {

    @Test
    public void testEditAccount() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.navigate().to("http://accountsdemo.herokuapp.com");
        driver.findElement(By.id("user_email")).sendKeys("letslearnandshare@gmail.com");
        driver.findElement(By.id("user_password")).sendKeys("!abcd1234");
        driver.findElement(By.name("commit")).click();
        driver.findElement(By.linkText("CLIENTS")).click();
        driver.findElement(By.id("search")).sendKeys("Thoughtworks");
        driver.findElement(By.className("searchBtn")).click();
        driver.findElement(By.linkText("Select Client")).click();
        driver.findElement(By.linkText("Edit Client Details")).click();
        driver.findElement(By.id("client_contact_person_name")).clear();
        driver.findElement(By.id("client_contact_person_name")).sendKeys("ThoughtworksNew");
        driver.findElement(By.id("client_address")).clear();
        driver.findElement(By.id("client_address")).sendKeys("twAddressNew");
        driver.findElement(By.name("commit")).click();
        driver.findElement(By.cssSelector("span.glyphicon-log-out")).click();
        driver.quit();
    }

    @Test
    public void testAddQuotationForClient() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to("http://accountsdemo.herokuapp.com");
        driver.findElement(By.id("user_email")).sendKeys("letslearnandshare@gmail.com");
        driver.findElement(By.id("user_password")).sendKeys("!abcd1234");
        driver.findElement(By.name("commit")).click();
        driver.findElement(By.linkText("CLIENTS")).click();
        driver.findElement(By.id("search")).sendKeys("Thoughtworks");
        driver.findElement(By.className("searchBtn")).click();
        driver.findElement(By.linkText("Select Client")).click();
        driver.findElement(By.linkText("Quotations")).click();
        driver.findElement(By.partialLinkText("Add New Quotation")).click();
        driver.findElement(By.id("quotation_order_placed_by")).sendKeys("Quotation1");
        driver.findElement(By.id("quotation_event_name")).sendKeys("Event1");
        driver.findElement(By.id("quotation_event_date")).sendKeys("30-12-2016");
        driver.findElement(By.name("commit")).click();
        driver.switchTo().alert().accept();
        driver.findElement(By.cssSelector("span.glyphicon-log-out")).click();
        driver.quit();
    }
}
