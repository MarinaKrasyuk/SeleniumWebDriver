import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ByClassTest  {
    private WebDriver driver;
    private static WebDriverWait wait;
    private By idLocator;
    private By xpathLocator;
    private By nameLocator;
    private By cssLocator;

    public ByClassTest(WebDriver driver,WebDriverWait wait) {
        this.driver= driver;
        this.wait = wait;
    }
    public void loginButtonInitclick(String css){
        cssLocator=By.cssSelector(css);
        WebElement  loginButtonInit=driver.findElement(cssLocator);
        loginButtonInit.click();
    }
    public void loginButtonClick(String xpath){
        xpathLocator=By.xpath(xpath);
        WebElement  loginButton=driver.findElement(xpathLocator);
        loginButton.click();
    }
    public void inputLogin(String id){
        idLocator=By.id(id);
        WebElement loginField = driver.findElement(idLocator);
        loginField.sendKeys("marinakrasyuk21@yandex.com");
    }
    public void inputPassword(String name){
        nameLocator=By.name(name);
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameLocator));
        WebElement passwordField = driver.findElement(nameLocator);
        passwordField.sendKeys("vbkfyf06");
}

}
