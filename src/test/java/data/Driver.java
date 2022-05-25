package data;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
    private WebDriver driver;
    private static Driver instanceOfDriver;

    private Driver() {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver=new ChromeDriver();
    }
    public static Driver getInstanceOfDriver()
    {
        if (instanceOfDriver == null)
            instanceOfDriver = new Driver();

        return instanceOfDriver;
    }
    public void driverClose(){
            System.out.print("close(): ");
            if (driver!=null) {
                driver.quit();
                instanceOfDriver = null;
            }

    }
    public WebDriver getDriver(){
        return driver;
    }
}
