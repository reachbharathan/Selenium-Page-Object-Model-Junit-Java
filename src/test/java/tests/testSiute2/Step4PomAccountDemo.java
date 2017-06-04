package tests.testSiute2;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import tests.Regression;
import tests.Smoke;

public class Step4PomAccountDemo extends BaseTestStep4 {

    @Category(Smoke.class)
    @Test
    public void testEditAccount() {
        loginPage.login(propertyReader.readProperty("username"), propertyReader.readProperty("password"));
        homePage.selectClientsLink();
        clientSearchPage.searchAndSelectFirstClient("Thoughtworks");
        clientPage.editClientDetails("ThoughtworksNew", "twAddressNew");
    }

    @Category(Regression.class)
    @Test
    public void testAddQuotationForClient() {
        loginPage.login(propertyReader.readProperty("username"), propertyReader.readProperty("password"));
        homePage.selectClientsLink();
        clientSearchPage.searchAndSelectFirstClient("Thoughtworks");
        clientPage.addQuotation("Quotation1", "Event1", "01-30-2017");
    }
}
