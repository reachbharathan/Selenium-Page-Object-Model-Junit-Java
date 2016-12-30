package tests.testSiute2;

import org.junit.Test;

public class Step1PomAccountDemo extends BaseTestStep4 {

  @Test
  public void testEditAccount() {
    loginPage.login(propertyReader.readProperty("username"), propertyReader.readProperty("password"));
    homePage.selectClientsLink();
    clientSearchPage.searchAndSelectFirstClient("Thoughtworks");
    clientPage.editClientDetails("ThoughtworksNew", "twAddressNew");
  }

  @Test
  public void testAddQuotationForClient() {
    loginPage.login(propertyReader.readProperty("username"), propertyReader.readProperty("password"));
    homePage.selectClientsLink();
    clientSearchPage.searchAndSelectFirstClient("Thoughtworks");
    clientPage.addQuotation("Quotation1", "Event1", "01-3-2017");
  }
}
