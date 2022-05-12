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

public class UserTest  {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void init(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver=new ChromeDriver();
        wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://demo.seleniumeasy.com/dynamic-data-loading-demo.html");
    }
    @Test
    public void waitUser(){
        WebElement button = driver.findElement(By.cssSelector("#save"));
        button.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#loading")));
        Assertions.assertTrue(driver.findElement(By.cssSelector("#loading")).isDisplayed());
    }
    @AfterEach
    void cleanUp(){
        driver.quit();
    }
}

