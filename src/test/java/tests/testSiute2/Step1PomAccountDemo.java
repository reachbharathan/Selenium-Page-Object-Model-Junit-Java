package tests.testSiute2;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class Step1PomAccountDemo extends BaseTestStep2PageObject {

  ChromeDriver driver;

  @Test
  public void testEditAccount() {
    loginPage.login(propertyReader.readProperty("username"), propertyReader.readProperty("password"));
    homePage.selectClientsLink();
    clientSearchPage.searchAndSelectFirstClient("tcs");
    clientPage.editClientDetails("Jaggu", "Mantri Woodlands , near Arakere gate");
  }

  @Test
  public void testAddQuotationForClient() {
    loginPage.login(propertyReader.readProperty("username"), propertyReader.readProperty("password"));
    homePage.selectClientsLink();
    clientSearchPage.searchAndSelectFirstClient("tcs");
    clientPage.addQuotation("Mr.Raju", "Nasscom Product Conclave");
  }
}
