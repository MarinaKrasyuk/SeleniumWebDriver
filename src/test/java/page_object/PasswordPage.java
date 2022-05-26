package page_object;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PasswordPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private final By fieldPwd=By.cssSelector("#passp-field-passwd");
    private final By signInButton=By.xpath("//*[@id='passp:sign-in']");


    public PasswordPage(WebDriver driver,WebDriverWait wait) {
        this.driver=driver;
        this.wait=wait;
        PageFactory.initElements(driver,this);
    }

    public MailPage clickMailPage(String pwd){
        clickLoginButton(pwd);
        return new MailPage(driver,wait);
    }
    private void clickLoginButton(String pwd) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(fieldPwd));
        driver.findElement(fieldPwd).sendKeys(pwd);
        driver.findElement(signInButton).click();
    }
}
