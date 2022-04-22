
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

public class SeleniumTest {
    private static WebDriver driver;
    private static WebDriverWait wait;
    private static ByClassTest byObject;

    @BeforeEach
    void   init(){
      System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
      driver= new ChromeDriver();
      wait = new WebDriverWait(driver,Duration.ofSeconds(5));
      driver.get("https://mail.yandex.com/");
      byObject=new ByClassTest(driver,wait);

  }
  private void initialPage()
  {
      String css=".button2_theme_mail-white";
      byObject.loginButtonInitclick(css);
  }
  private void loginPage() {
        String id="passp-field-login";
        byObject.inputLogin(id);
        String xpath= "//*[@id='passp:sign-in']";
        byObject.loginButtonClick(xpath);
  }
    private void passwordPage()  {
        String name="passwd";
        byObject.inputPassword(name);
        String xpath= "//*[@id='passp:sign-in']";
        byObject.loginButtonClick(xpath);
    }
  @Test
  public void loginTest() {
        initialPage();
        loginPage();
        passwordPage();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='#tabs/relevant']")));
        Assertions.assertTrue(driver.findElement(By.xpath("//a[@href='#tabs/relevant']")).isDisplayed());

  }
  @AfterEach
  void cleanUp(){
        driver.quit();
  }
}
