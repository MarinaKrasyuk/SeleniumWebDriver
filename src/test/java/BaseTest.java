import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeEach
    public void init(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver=new ChromeDriver();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));

    }
    @AfterEach
    void cleanUp(){

        driver.quit();
    }
}
