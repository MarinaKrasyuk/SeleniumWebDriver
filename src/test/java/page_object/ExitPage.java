package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ExitPage {
    private static WebDriver driver;
    private WebDriverWait wait;
    private final By signInButton=By.xpath("//*[@id='passp:sign-in']");

    public ExitPage(WebDriver driver,WebDriverWait wait) {
        this.driver=driver;
        this.wait=wait;
    }
    public boolean isLoginPresent() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(signInButton));
        return driver.findElement(signInButton).isDisplayed();
    }
}
