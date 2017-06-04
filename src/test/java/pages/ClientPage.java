package pages;

import entities.ClientDetails;
import entities.QuotationDetails;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

public class ClientPage extends BasePage {

    @FindBy(linkText = "Edit Client Details")
    private WebElement edit_clients_details_link;

    @FindBy(id = "client_contact_person_name")
    private WebElement client_contact_textbox;

    @FindBy(id = "client_address")
    private WebElement client_address_textbox;

    @FindBy(name = "commit")
    private WebElement update_button;

    @FindBy(linkText = "Quotations")
    private WebElement quotations_link;

    @FindBy(partialLinkText = "Add New Quotation")
    private WebElement add_new_quotation_link;

    @FindBy(id = "quotation_order_placed_by")
    private WebElement quotation_order_placed_by_textbox;

    @FindBy(id = "quotation_event_name")
    private WebElement quotation_event_name_textbox;

    @FindBy(id = "quotation_event_date")
    private WebElement quotation_event_date_calendar;

    public ClientPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void verifyClientDetails(ClientDetails details) {
        List<WebElement> rows = webDriver.findElement(By.className("table-bordered")).findElements(By.tagName("tr"));
        for (Iterator<WebElement> iterator = rows.iterator(); iterator.hasNext(); ) {
            WebElement row = iterator.next();
            List<WebElement> columns = row.findElements(By.tagName("td"));
            String label = columns.get(0).getText();
            String value = columns.get(1).getText();
            if (label.equals("Contact Person Name:")) {
                assertTrue("Expected Contact Person name :" + details.getContact() + " Actual: " + value, value.equals(details.getContact()));
            }
            if (label.equals("Address:")) {
                assertTrue("Expected Address : " + details.getAddress() + " Actual : " + value, value.equals(details.getAddress()));
            }
        }
    }

    public void editClientDetails(String contact, String address) {
        edit_clients_details_link.click();
        client_contact_textbox.clear();
        client_contact_textbox.sendKeys(contact);
        client_address_textbox.clear();
        client_address_textbox.sendKeys(address);
        update_button.click();
    }

    public void editClientDetails(ClientDetails clientDetails) {
        editClientDetails(clientDetails.getContact(), clientDetails.getAddress());
    }

    public void addQuotation(String client_contact, String address, String eventDate) {
        quotations_link.click();
        add_new_quotation_link.click();
        quotation_order_placed_by_textbox.clear();
        quotation_order_placed_by_textbox.sendKeys(client_contact);
        quotation_event_name_textbox.clear();
        quotation_event_name_textbox.sendKeys(address);
        quotation_event_date_calendar.sendKeys(eventDate);
        update_button.click();
        new WebDriverWait(webDriver, 10).until(ExpectedConditions.alertIsPresent());
        webDriver.switchTo().alert().accept();
    }

    public void addQuotation(QuotationDetails quotationDetails) {
        addQuotation(quotationDetails.getContact(), quotationDetails.getAddress(), quotationDetails.getEventDate());
    }
}
