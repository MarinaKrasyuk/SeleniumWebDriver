import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
    @Description(value ="Alert Box Test")
    public void alertBoxTest(){
        WebElement alertElement = driver.findElement(By.cssSelector("[onclick='myAlertFunction()']"));
        alertElement.click();
        Alert alert=wait.until(ExpectedConditions.alertIsPresent());
        String textAlert=alert.getText();
        System.out.println(textAlert);

        alert.accept();

    }
    @Test
    public void confirmBoxDismissTest(){
        WebElement confirmElement = driver.findElement(By.cssSelector("[onclick='myConfirmFunction()']"));
        confirmElement.click();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert= driver.switchTo().alert();
        String textAlert=alert.getText();
        System.out.println(textAlert);

        alert.dismiss();

    }
    @Test
    public void confirmBoxAcceptTest(){
        WebElement confirmElement = driver.findElement(By.cssSelector("[onclick='myConfirmFunction()']"));
        confirmElement.click();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert= driver.switchTo().alert();
        String textAlert=alert.getText();
        System.out.println(textAlert);

        alert.accept();

    }
    @Test
    public void promptBoxTest(){
        WebElement promptElement = driver.findElement(By.cssSelector("[onclick='myPromptFunction()']"));
        promptElement.click();

        Alert alert=wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys("TEST");

        alert.accept();

    }

    @AfterEach
    void cleanUp(){
      driver.quit();
    }
}
