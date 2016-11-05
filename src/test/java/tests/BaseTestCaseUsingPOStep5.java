package tests;

import org.junit.Before;
import org.junit.Rule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.ClientsHomePage;
import pages.LoginPage;
import util.PropertyReader;
import util.ScreenShotRule;

import java.util.concurrent.TimeUnit;

public class BaseTestCaseUsingPOStep5 {

    protected WebDriver driver;
    static PropertyReader propertyReader;
    protected LoginPage loginPage;
    protected ClientsHomePage clientsHomePage;

    @Rule
    public ScreenShotRule screenShotRule = new ScreenShotRule();

    @Before
    public void setUpForTest(){
        propertyReader = new PropertyReader();
        setAppropriateDriver();
        screenShotRule.setDriver(driver);
        loginPage = new LoginPage(driver);
        loginPage.navigateToLoginPage(propertyReader.readProperty("url"));
        clientsHomePage = loginPage.login(propertyReader.readProperty("username") ,propertyReader.readProperty("password"));
    }

    public  void setAppropriateDriver() {

        String browser = propertyReader.readProperty("browser");
        if(browser.equalsIgnoreCase("chrome")) {
            driver =  new ChromeDriver();
        }
        if(browser.equalsIgnoreCase("firefox")){
            driver =  new FirefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

}
