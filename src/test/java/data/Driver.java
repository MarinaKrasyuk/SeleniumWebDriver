package data;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class Driver {
    private static WebDriver driver;
    private Driver() {

    }

    public static WebDriver getDriver() {
        if (driver == null) {
            //ChromeOptions opt = new ChromeOptions();
            //opt.addExtensions(new File("path for crx file of the extension"));
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(ChromeOptions.CAPABILITY,true);
            capabilities.setCapability(CapabilityType.BROWSER_NAME, "CH");
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
