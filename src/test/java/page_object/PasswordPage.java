package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.PrintsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PasswordPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private static PasswordPage instanceOfPasswordPage;
    private WebElement passwordInput;
    private WebElement loginButton;

    private PasswordPage(WebDriver driver,WebDriverWait wait) {
        this.driver=driver;
        this.wait=wait;
        PageFactory.initElements(driver,this);
    }
    public static PasswordPage getInstanceOfPasswordPage(WebDriver driver,WebDriverWait wait){
        if (instanceOfPasswordPage == null)
            instanceOfPasswordPage = new PasswordPage(driver,wait);

        return instanceOfPasswordPage;
    }
    public MailPage clickMailPage(String pwd){
        clickLoginButton(pwd);
        MailPage mailPage=MailPage.getInstanceOfMailPage(driver,wait);
        return mailPage;
    }
    private void clickLoginButton(String pwd) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#passp-field-passwd")));
        passwordInput=driver.findElement(By.cssSelector("#passp-field-passwd"));
        passwordInput.sendKeys(pwd);
        loginButton=driver.findElement(By.xpath("//*[@id='passp:sign-in']"));
        loginButton.click();
    }
}
