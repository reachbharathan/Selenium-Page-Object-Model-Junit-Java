package tests.testSiute2;

import entities.ClientDetails;
import entities.QuotationDetails;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import tests.Regression;
import tests.Smoke;

public class Step2PomAccountDemoEntityApproach extends BaseTestStep2PageObject {

  @Test
  //Adding category
  @Category(Smoke.class)
  public void testEditAccount() {
    //creating a business object
    // this is called as business entity
    // we have create a business object/entity for clientdetails
    ClientDetails clientDetails1 = new ClientDetails("Jaggu", "Mantri Woodlands , near Arakere gate");
    loginPage.login(propertyReader.readProperty("username"), propertyReader.readProperty("password"));
    homePage.selectClientsLink();
    clientSearchPage.searchAndSelectFirstClient("tcs");
    clientPage.editClientDetails(clientDetails1);
  }

  @Test
  @Category(Regression.class)
  public void testAddQuotationForClient() {
    QuotationDetails quotationDetails1 = new QuotationDetails("Mr.Raju", "Nasscom Product Conclave");
    loginPage.login(propertyReader.readProperty("username"), propertyReader.readProperty("password"));
    homePage.selectClientsLink();
    clientSearchPage.searchAndSelectFirstClient("tcs");
    clientPage.addQuotation(quotationDetails1);
  }
}
