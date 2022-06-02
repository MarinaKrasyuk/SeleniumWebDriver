package data;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Driver {
    private static WebDriver driver;
    private Driver() {

    }

    public static WebDriver getDriver() throws MalformedURLException {
        if (driver == null) {
            FirefoxOptions opt=new FirefoxOptions();
            opt.setCapability("browserVersion", "99.0");
            opt.setCapability("enableVNC",true);

            driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),opt);

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
