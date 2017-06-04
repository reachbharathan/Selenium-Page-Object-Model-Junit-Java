package tests.testSuite1;

import org.junit.Test;
import org.openqa.selenium.By;

public class Step3AccountDemo extends BaseTestStep1Simple {
    //separate the common to base step
    //have actions only related to steps

    @Test
    public void testEditAccount() {
        login("letslearnandshare@gmail.com", "!abcd1234");
        selectClient("Thoughtworks");
        driver.findElement(By.linkText("Edit Client Details")).click();
        driver.findElement(By.id("client_contact_person_name")).clear();
        driver.findElement(By.id("client_contact_person_name")).sendKeys("ThoughtworksNew");
        driver.findElement(By.id("client_address")).clear();
        driver.findElement(By.id("client_address")).sendKeys("twAddressNew");
        submit();
        logout();
    }

    @Test
    public void testAddQuotationForClient() {
        login("letslearnandshare@gmail.com", "!abcd1234");
        selectClient("Thoughtworks");
        driver.findElement(By.linkText("Quotations")).click();
        driver.findElement(By.partialLinkText("Add New Quotation")).click();
        driver.findElement(By.id("quotation_order_placed_by")).sendKeys("Quotation1");
        driver.findElement(By.id("quotation_event_name")).sendKeys("Event1");
        driver.findElement(By.id("quotation_event_date")).sendKeys("30-12-2016");
        submit();
        driver.switchTo().alert().accept();
        logout();
    }

    private void login(String userName, String password) {
        driver.findElement(By.id("user_email")).sendKeys(userName);
        driver.findElement(By.id("user_password")).sendKeys(password);
        driver.findElement(By.name("commit")).click();
    }

    private void logout() {
        driver.findElement(By.cssSelector("span.glyphicon-log-out")).click();
    }

    private void selectClient(String client) {
        driver.findElement(By.linkText("CLIENTS")).click();
        driver.findElement(By.id("search")).sendKeys(client);
        driver.findElement(By.className("searchBtn")).click();
        driver.findElement(By.linkText("Select Client")).click();
    }

    private void submit() {
        driver.findElement(By.name("commit")).click();
    }
}
