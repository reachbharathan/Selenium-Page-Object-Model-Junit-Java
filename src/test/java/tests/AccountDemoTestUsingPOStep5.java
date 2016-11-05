package tests;

import org.junit.Test;

public class AccountDemoTestUsingPOStep5 extends BaseTestCaseUsingPOStep5 {


    @Test
    public void testEditAccount() {

        clientsHomePage.selectClient("tcs").editClientDetails("Jaggu" , "Mantri Woodlands , near Arakere gate");
    }

    @Test
    public void testAddQuotationForClient() {

        clientsHomePage.selectClient("tcs").addQuotation("Mr.Raju" , "Nasscom Product Conclave");
    }


}
