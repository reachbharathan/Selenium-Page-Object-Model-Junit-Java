package workflows;

import entities.ClientDetails;
import entities.QuotationDetails;
import org.openqa.selenium.WebDriver;
import pages.ClientPage;
import pages.ClientsHomePage;
import pages.LoginPage;

/**
 * Created by jbalacha on 15/10/15.
 */
public class ClientWorkflows {

    WebDriver driver ;
    ClientsHomePage homePage;

    public ClientWorkflows(WebDriver driver) {
        this.driver = driver;
        homePage = new ClientsHomePage(driver);
    }

    public void editClient(String clientName, ClientDetails newClientDetails){
        ClientPage clientPage = homePage.selectClient(clientName);
        clientPage.editClientDetails(newClientDetails);
    }

    public void AddQuotation(String clientName, QuotationDetails quotationDetails) {
        ClientPage clientPage = homePage.selectClient(clientName);
        clientPage.addQuotation(quotationDetails);
    }
}
