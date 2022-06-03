package data;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class Driver {
    private static WebDriver driver;
    private Driver() {

    }

    public static WebDriver getDriver() throws MalformedURLException {
        if (driver == null) {

            FirefoxOptions browserOptions = new FirefoxOptions();
            browserOptions.setPlatformName("Windows 8.1");
            browserOptions.setBrowserVersion("100");
            Map<String, Object> sauceOptions = new HashMap<>();
            browserOptions.setCapability("sauce:options", sauceOptions);
            URL url = new URL("https://oauth-marinakrasyuk-885c4:5edb7ae3-2576-467a-976e-349ccf75b270@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
            driver = new RemoteWebDriver(url, browserOptions);


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
