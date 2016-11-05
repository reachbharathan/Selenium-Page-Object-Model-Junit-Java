package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import util.PropertyReader;

import java.util.concurrent.TimeUnit;

public class BaseTestCaseWithReadingFromConfigFileStep4{

    WebDriver driver;
    PropertyReader propertyReader;

    @Before
    public void setUp(){

        propertyReader = new PropertyReader();
        driver = getAppropriateDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.navigate().to(propertyReader.readProperty("url"));
        driver.findElement(By.id("user_email")).sendKeys(propertyReader.readProperty("username"));
        driver.findElement(By.id("user_password")).sendKeys(propertyReader.readProperty("password"));
        driver.findElement(By.name("commit")).click();
    }

    @After
    public void tearDown(){

        driver.close();
        driver.quit();
    }

    protected WebDriver getAppropriateDriver()  {
        String browser = propertyReader.readProperty("browser");
        if(browser.equalsIgnoreCase("chrome")) return new ChromeDriver();
        if(browser.equalsIgnoreCase("firefox")) return new FirefoxDriver();
        return new FirefoxDriver();
    }

    protected void selectClient(String client) {
        driver.findElement(By.linkText("CLIENTS")).click();
        driver.findElement(By.id("search")).sendKeys(client);
        driver.findElement(By.className("searchBtn")).click();
        driver.findElement(By.linkText("Select Client")).click();
    }


}
