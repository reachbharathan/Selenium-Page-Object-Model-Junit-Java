package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(id = "user_email")
    private WebElement user_name_textbox;

    @FindBy(id = "user_password")
    private WebElement password_textbox;

    @FindBy(name = "commit")
    private WebElement login_btn;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void login(String username, String password) {
        user_name_textbox.sendKeys(username);
        password_textbox.sendKeys(password);
        login_btn.click();
    }
}
