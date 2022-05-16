
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DownloadTest extends BaseTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @Test
    public void main() throws InterruptedException {
        driver=BaseTest.driver;
        wait=BaseTest.wait;
        driver.get("https://demo.seleniumeasy.com/bootstrap-download-progress-demo.html");
        WebElement downloadButton = driver.findElement(By.cssSelector("#cricle-btn"));
        downloadButton.click();
        while (!isVisible(By.xpath("//div[@class='slice clipauto']"),driver)){//after 50% and more class='slice clipauto'

        }
        driver.navigate().refresh();
        Thread.sleep(1000);
        WebElement percent = driver.findElement(By.cssSelector(".percenttext"));
        Assertions.assertTrue(percent.getText().equals("0%"));
    }
    public static boolean isVisible(By by,WebDriver driver) {
        try {
            WebElement element=driver.findElement(by);
            return true;
        }
        catch (Exception  e) {
            return false;
        }
    }
}
