package page_factory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PFExitPage {
    private static WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//*[@id='passp:sign-in1']")//uncorrect xpath
    WebElement signInButton;


    public PFExitPage(WebDriver driver,WebDriverWait wait) {
        this.driver=driver;
        this.wait=wait;
        PageFactory.initElements(driver,this);
    }
    public boolean isLoginPresent() {
        wait.until(ExpectedConditions.visibilityOf(signInButton));
        return signInButton.isDisplayed();
    }
}
