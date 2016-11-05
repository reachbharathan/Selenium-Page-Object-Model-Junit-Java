package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class BaseTestCaseStep3 {

    ChromeDriver driver;

    @Before
    public void setUp(){

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        driver.navigate().to("http://accountsdemo.herokuapp.com/");
//        driver.findElement(By.id("user_email")).sendKeys("jbalacha@thoughtworks.com");
//        driver.findElement(By.id("user_password")).sendKeys("vijay!123");
//        driver.findElement(By.name("commit")).click();

        LoginPage lp = new LoginPage(driver);
        lp.navigateToLoginPage("http://accountsdemo.herokuapp.com");
        lp.login("jbalacha@thoughtworks.com" ,"vijay!123" );
    }

    @After
    public void tearDown(){

        driver.close();
        driver.quit();

    }

    protected void selectClient(String client) {
        driver.findElement(By.linkText("CLIENTS")).click();
        driver.findElement(By.id("search")).sendKeys(client);
        driver.findElement(By.className("searchBtn")).click();
        driver.findElement(By.linkText("Select Client")).click();
    }


}
