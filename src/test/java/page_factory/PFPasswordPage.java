package page_factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PFPasswordPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "#passp-field-passwd")
    WebElement fieldPwd;
    @FindBy(xpath = "//*[@id='passp:sign-in']")
    WebElement signInButton;



    public PFPasswordPage(WebDriver driver,WebDriverWait wait) {
        this.driver=driver;
        this.wait=wait;
        PageFactory.initElements(driver,this);
    }

    public PFMailPage clickMailPage(String pwd){
        clickLoginButton(pwd);
        return new PFMailPage(driver,wait);
    }
    private void clickLoginButton(String pwd) {
        wait.until(ExpectedConditions.visibilityOf(fieldPwd));
        fieldPwd.sendKeys(pwd);
        signInButton.click();
    }
}
