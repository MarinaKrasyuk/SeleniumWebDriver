import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class DownloadTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void init(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver=new ChromeDriver();
        wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://demo.seleniumeasy.com/bootstrap-download-progress-demo.html");
    }
    @Test
    public void main() throws InterruptedException {
        WebElement downloadButton = driver.findElement(By.cssSelector("#cricle-btn"));
        downloadButton.click();
        WebElement percent = driver.findElement(By.cssSelector(".percenttext"));
        wait.until(ExpectedConditions.textToBePresentInElement(percent,"50%"));
        Thread.sleep(1000);
        driver.navigate().refresh();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".percenttext")));
        Assertions.assertTrue(percent.getText().equals("0%"));
    }
    @AfterEach
    void cleanUp(){
         driver.quit();
    }
}
