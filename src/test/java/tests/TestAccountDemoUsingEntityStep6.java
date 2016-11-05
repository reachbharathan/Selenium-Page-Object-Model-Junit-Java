package tests;

import entities.ClientDetails;
import entities.QuotationDetails;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import pages.ClientPage;

public class TestAccountDemoUsingEntityStep6 extends BaseTestCaseUsingPOStep5 {





    @Test
    @Category(Smoke.class)
    public void testEditAccount() {
        ClientPage clientPage = clientsHomePage.selectClient("tcs");
        ClientDetails details = new ClientDetails("Jaggu" , "Mantri Woodlands , near Arakere gate");
        clientPage.editClientDetails(details);
    }

    @Test
    @Category(Smoke.class)
    public void testAddQuotationForClient() {

        ClientPage clientPage = clientsHomePage.selectClient("tcs");
        QuotationDetails qDetails = new QuotationDetails("Mr.Raju" , "Nasscom Product Conclave");
        clientPage.addQuotation(qDetails);
    }


}
