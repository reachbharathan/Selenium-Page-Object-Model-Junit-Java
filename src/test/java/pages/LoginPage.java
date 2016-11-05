package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static junit.framework.Assert.assertTrue;

/**
 * Created by jbalacha on 15/10/15.
 */
public class LoginPage {

    private WebDriver webDriver;

    @FindBy(id = "user_email")
    private WebElement user_name_field;

    @FindBy(id = "user_password")
    private WebElement password_field;

    @FindBy(name = "commit")
    private WebElement login;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }


    public void navigateToLoginPage(String url) {
        webDriver.navigate().to(url);
    }

    public ClientsHomePage login(String username, String password) {
        user_name_field.sendKeys(username);
        password_field.sendKeys(password);
        login.click();
        ClientsHomePage clientsHomePage =  new ClientsHomePage(webDriver);
        return clientsHomePage;
    }

}
