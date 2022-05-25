package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StartPage {
    private static WebDriver driver;
    private static WebDriverWait wait;
    private final By login= By.cssSelector(".button2_theme_mail-white");


    public StartPage(WebDriver driver, WebDriverWait wait) {
        this.driver=driver;
        this.wait=wait;
    }

    public LoginPage clickLoginPage() throws InterruptedException {
        clickLoginButton();
        return new LoginPage(driver,wait);
    }

    private void clickLoginButton() throws InterruptedException {
        Thread.sleep(10000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(login));
        WebElement loginButton=driver.findElement(login);
        loginButton.click();
    }
}
