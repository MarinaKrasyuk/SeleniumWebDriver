
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class UserTest extends BaseTest {
    private static WebDriver driver;
    private static WebDriverWait wait;


    @Test
    public void waitUser(){
        driver=BaseTest.driver;
        wait=BaseTest.wait;
        driver.get("https://demo.seleniumeasy.com/dynamic-data-loading-demo.html");
        WebElement button = driver.findElement(By.cssSelector("#save"));
        button.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#loading")));
        Assertions.assertTrue(driver.findElement(By.cssSelector("#loading>img")).isDisplayed());
    }

}

