package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;
    private static WebDriverWait wait;
    private final By loginField = By.id("passp-field-login");
    private final By signInButton = By.xpath("//*[@id='passp:sign-in']");


    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public PasswordPage clickPasswordPage(String login) {
        clickLoginButton(login);
        return new PasswordPage(driver, wait);
    }

    private void clickLoginButton(String login) {
        driver.findElement(loginField).sendKeys(login);
        driver.findElement(signInButton).click();

    }

}
