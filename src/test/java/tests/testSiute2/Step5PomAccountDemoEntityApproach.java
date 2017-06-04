package tests.testSiute2;

import entities.ClientDetails;
import entities.QuotationDetails;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import tests.Regression;
import tests.Smoke;

public class Step5PomAccountDemoEntityApproach extends BaseTestStep4 {
  /*creating a business object
    this is called as business entity
    we have create a business object/entity for client and quotation details*/


    @Test
    @Category(Smoke.class)
    public void testEditAccount() {
        ClientDetails clientDetails1 = new ClientDetails("Jaggu", "Mantri Woodlands , near Arakere gate");
        loginPage.login(propertyReader.readProperty("username"), propertyReader.readProperty("password"));
        homePage.selectClientsLink();
        clientSearchPage.searchAndSelectFirstClient("Thoughtworks");
        clientPage.editClientDetails(clientDetails1);
    }

    @Test
    @Category(Regression.class)
    public void testAddQuotationForClient() {
        QuotationDetails quotationDetails1 = new QuotationDetails("Quotation1", "Event1", "01-30-2017");
        loginPage.login(propertyReader.readProperty("username"), propertyReader.readProperty("password"));
        homePage.selectClientsLink();
        clientSearchPage.searchAndSelectFirstClient("Thoughtworks");
        clientPage.addQuotation(quotationDetails1);
    }
}
