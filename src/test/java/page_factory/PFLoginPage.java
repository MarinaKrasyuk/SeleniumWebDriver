package page_factory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PFLoginPage {
    private WebDriver driver;
    private static WebDriverWait wait;

    @FindBy(id="passp-field-login")
    WebElement loginField;
    @FindBy(xpath ="//*[@id='passp:sign-in']" )
    WebElement signInButton;



    public PFLoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver,this);
    }

    public PFPasswordPage clickPasswordPage(String login) {
        clickLoginButton(login);
        return new PFPasswordPage(driver, wait);
    }

    private void clickLoginButton(String login) {
        loginField.sendKeys(login);
        signInButton.click();

    }
}
