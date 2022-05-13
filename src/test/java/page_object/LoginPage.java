package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;
    private WebElement loginInput;
    private WebElement loginButton;
    private static LoginPage instanceOfLoginPage;
    private static WebDriverWait wait;

    private LoginPage(WebDriver driver,WebDriverWait wait) {
        this.driver=driver;
        this.wait=wait;
    }
    public static LoginPage getInstanceOfLoginPage(WebDriver driver,WebDriverWait wait){
        if (instanceOfLoginPage == null)
            instanceOfLoginPage = new LoginPage(driver,wait);

        return instanceOfLoginPage;
    }
    public PasswordPage clickPasswordPage(String login){
        clickLoginButton(login);
        PasswordPage passwordPage=PasswordPage.getInstanceOfPasswordPage(driver,wait);
        return passwordPage;
    }
    private void clickLoginButton(String login) {
       loginInput=driver.findElement(By.id("passp-field-login"));
       loginInput.sendKeys(login);
       loginButton=driver.findElement(By.xpath("//*[@id='passp:sign-in']"));
       loginButton.click();
    }

}
