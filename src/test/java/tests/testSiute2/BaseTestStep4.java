/**/

package tests.testSiute2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import pages.ClientPage;
import pages.ClientsSearchPage;
import pages.HomePage;
import pages.LoginPage;
import util.JunitListener;
import util.PropertyReader;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTestStep4 {

    public static PropertyReader propertyReader;
    private static Logger LOGGER = null;
    @Rule
    public JunitListener junitListener;
    public WebDriver driver;
    public LoginPage loginPage;
    public HomePage homePage;
    public ClientPage clientPage;
    public ClientsSearchPage clientSearchPage;

    public BaseTestStep4() {
        junitListener = new JunitListener();
        propertyReader = new PropertyReader();
        LOGGER = LogManager.getLogger(BaseTestStep4.class);
        LOGGER.info("BaseTestStep4 completed");
    }

    @Before
    public void setUp() {
        LOGGER.info("SetUp");
        setDriver();
        junitListener.setDriver(driver);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        clientPage = new ClientPage(driver);
        clientSearchPage = new ClientsSearchPage(driver);
        loadUrl();
    }

    @After
    public void tearDown() {
        LOGGER.info("TearDown");
    }

    public void setDriver() {
        String browser = propertyReader.readProperty("browser");
        long implicitWait = Integer.parseInt(propertyReader.readProperty("implicitWaitInSeconds"));
        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", propertyReader.readProperty("macChromeDriver"));
                driver = new ChromeDriver();
                break;
            case "ie":
                driver = new InternetExplorerDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                throw new WebDriverException();
        }
        driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public void loadUrl() {
        URL baseUrl;
        HttpURLConnection connection = null;
        try {
            baseUrl = new URL(propertyReader.readProperty("url"));
            connection = (HttpURLConnection) baseUrl.openConnection();
            connection.connect();
            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                LOGGER.error("Unable to connect to the url connection");
                LOGGER.error("Response Code " + connection.getResponseCode());
                LOGGER.error("Response Message " + connection.getResponseMessage());
            }
            driver.get(propertyReader.readProperty("url"));
        } catch (IOException e) {
            LOGGER.error("URL connection error");
            e.printStackTrace();
        }
    }
}
