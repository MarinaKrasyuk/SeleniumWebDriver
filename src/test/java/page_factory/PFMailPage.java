package page_factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page_object.ExitPage;

public class PFMailPage {
    private static WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath ="//*[@data-count='{\"name\":\"user\"}']" )
    WebElement nameIcon;
    @FindBy(xpath ="(//*[@class='menu__group'])/*[last()]" )
    WebElement logoutButton;


    public PFMailPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver,this);
    }

    public boolean isIconPresent() {
        wait.until(ExpectedConditions.visibilityOf(nameIcon));
        return nameIcon.isDisplayed();

    }

    public PFExitPage clickExitPage() {
        clickLogoutButton();
        return new PFExitPage(driver, wait);
    }

    private void clickLogoutButton() {
        wait.until(ExpectedConditions.visibilityOf(nameIcon));
        nameIcon.click();
        logoutButton.click();

    }

}
