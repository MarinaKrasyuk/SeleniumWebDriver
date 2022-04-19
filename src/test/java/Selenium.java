
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

public class Selenium {
    private static WebDriver driver;
    private static WebDriverWait wait;
    @BeforeEach
    void   init(){
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
        driver= new ChromeDriver();
        wait = new WebDriverWait(driver,Duration.ofSeconds(5));
  }
  public void InitialPage()
  {
      driver.get("https://mail.yandex.com/");
      WebElement loginButton = driver.findElement(By.xpath("//*[@class='control button2 button2_view_classic button2_size_mail-big button2_theme_mail-white button2_type_link HeadBanner-Button HeadBanner-Button-Enter with-shadow']"));
      loginButton.click();
  }
  public void LoginPage() {
      WebElement loginField = driver.findElement(By.id("passp-field-login"));
      loginField.sendKeys("marinakrasyuk21@yandex.com");
      WebElement loginButton = driver.findElement(By.xpath("//*[@id='passp:sign-in']"));
      loginButton.click();
  }
    public void PasswordPage()  {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("passwd")));
        WebElement passwordField = driver.findElement(By.name("passwd"));
        passwordField.sendKeys("vbkfyf06");
        WebElement loginButton = driver.findElement(By.id("passp:sign-in"));
        loginButton.click();
    }
  @Test
  public void LoginTest() {
        InitialPage();
        LoginPage();
        PasswordPage();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='#tabs/relevant']")));
        Assertions.assertTrue(driver.findElement(By.xpath("//a[@href='#tabs/relevant']")).isDisplayed());

  }
  @AfterEach
  void cleanUp(){
        driver.quit();
  }
}
