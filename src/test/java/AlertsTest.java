import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertsTest {

    private WebDriver driver;
    private  WebDriverWait wait;

    @BeforeEach
    public  void init(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://demo.seleniumeasy.com/javascript-alert-box-demo.html");
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    @Test
    public void alertBoxTest(){
        WebElement alertElement = driver.findElement(By.cssSelector("[onclick='myAlertFunction()']"));
        alertElement.click();
        Alert alert=wait.until(ExpectedConditions.alertIsPresent());
        String textAlert=alert.getText();
        alert.accept();
        Assertions.assertTrue(textAlert.equals("I am an alert box!"));

    }
    @Test
    public void confirmBoxDismissTest(){
        WebElement confirmElement = driver.findElement(By.cssSelector("[onclick='myConfirmFunction()']"));
        confirmElement.click();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert= driver.switchTo().alert();
        alert.dismiss();
        String text=driver.findElement(By.cssSelector("#confirm-demo")).getText();
        Assertions.assertTrue(text.equals("You pressed Cancel!"));

    }
    @Test
    public void confirmBoxAcceptTest(){
        WebElement confirmElement = driver.findElement(By.cssSelector("[onclick='myConfirmFunction()']"));
        confirmElement.click();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert= driver.switchTo().alert();
        alert.accept();
        String text=driver.findElement(By.cssSelector("#confirm-demo")).getText();
        Assertions.assertTrue(text.equals("You pressed OK!"));

    }
    @Test
    public void promptBoxTest(){
        WebElement promptElement = driver.findElement(By.cssSelector("[onclick='myPromptFunction()']"));
        promptElement.click();
        Alert alert=wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys("TEST");
        alert.accept();
        Assertions.assertTrue(driver.findElement(By.cssSelector("#prompt-demo")).isDisplayed());

    }

    @AfterEach
    void cleanUp(){

        driver.quit();
    }
}
