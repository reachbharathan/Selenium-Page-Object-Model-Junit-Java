package util;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
    static WebDriver driver;

    public static void setDriver(WebDriver driver) {
        DriverFactory.driver = driver;
    }

    public static WebDriver getDriver(){
        return driver;
    }
}
