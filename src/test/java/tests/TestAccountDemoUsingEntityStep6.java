package tests;

import entities.ClientDetails;
import entities.QuotationDetails;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import pages.ClientPage;
import tests.testSiute2.BaseTestStep2PageObject;

public class TestAccountDemoUsingEntityStep6 extends BaseTestStep2PageObject {

  @Test
  @Category(Smoke.class)
  public void testEditAccount() {

    ClientPage clientPage = clientsHomePage.selectClient("tcs");
    ClientDetails details = new ClientDetails("Jaggu", "Mantri Woodlands , near Arakere gate");
    clientPage.editClientDetails(details);
  }

  @Test
  @Category(Smoke.class)
  public void testAddQuotationForClient() {
    ClientPage clientPage = clientsHomePage.selectClient("tcs");
    QuotationDetails qDetails = new QuotationDetails("Mr.Raju", "Nasscom Product Conclave");
    clientPage.addQuotation(qDetails);
  }
}
