package data;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
    private static WebDriver driver;
    private Driver() {

    }

    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static void driverClose() {
        System.out.print("close(): ");
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
