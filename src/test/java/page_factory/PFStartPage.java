package page_factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PFStartPage {
    private static WebDriver driver;
    private static WebDriverWait wait;

    @FindBy(css=".button2_theme_mail-white")
    WebElement loginButton;

    public PFStartPage(WebDriver driver, WebDriverWait wait) {
        this.driver=driver;
        this.wait=wait;
        PageFactory.initElements(driver,this);
    }



    public PFLoginPage clickLoginPage()  {
        clickLoginButton();
        return new PFLoginPage(driver,wait);
    }

    private void clickLoginButton()  {
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        loginButton.click();

    }
}
