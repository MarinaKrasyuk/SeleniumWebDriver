
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertsTest extends BaseTest{

    private WebDriver driver;
    private  WebDriverWait wait;


    @Test
    public void alertBoxTest(){
        driver=BaseTest.driver;
        driver.get("https://demo.seleniumeasy.com/javascript-alert-box-demo.html");
        wait = BaseTest.wait;
        WebElement alertElement = driver.findElement(By.cssSelector("[onclick='myAlertFunction()']"));
        alertElement.click();
        Alert alert=wait.until(ExpectedConditions.alertIsPresent());
        String textAlert=alert.getText();
        alert.accept();
        Assertions.assertTrue(textAlert.equals("I am an alert box!"));

    }
    @Test
    public void confirmBoxDismissTest(){
        driver=BaseTest.driver;
        wait=BaseTest.wait;
        driver.get("https://demo.seleniumeasy.com/javascript-alert-box-demo.html");
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
        driver=BaseTest.driver;
        driver.get("https://demo.seleniumeasy.com/javascript-alert-box-demo.html");
        wait = BaseTest.wait;
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
        driver=BaseTest.driver;
        driver.get("https://demo.seleniumeasy.com/javascript-alert-box-demo.html");
        wait = BaseTest.wait;
        WebElement promptElement = driver.findElement(By.cssSelector("[onclick='myPromptFunction()']"));
        promptElement.click();
        Alert alert=wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys("TEST");
        alert.accept();
        Assertions.assertTrue(driver.findElement(By.cssSelector("#prompt-demo")).isDisplayed());

    }

}
