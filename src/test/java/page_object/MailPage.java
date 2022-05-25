package page_object;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailPage {
    private static WebDriver driver;
    private WebDriverWait wait;
    private final By nameIcon=By.xpath("//*[@data-count='{\"name\":\"user\"}']");
    private final By logoutButton=By.xpath("(//*[@class='menu__group'])/*[last()]");


    public MailPage(WebDriver driver,WebDriverWait wait) {
        this.driver=driver;
        this.wait=wait;
    }

    public boolean isIconPresent(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameIcon));
        WebElement name=driver.findElement(nameIcon);
        if (name.isDisplayed())
            return true;
        else
            return false;
    }

    public ExitPage clickExitPage(){
        clickLogoutButton();
        return new ExitPage(driver,wait);
    }

    private void clickLogoutButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameIcon));
        WebElement name=driver.findElement(nameIcon);
        name.click();
        WebElement logout = driver.findElement(logoutButton);
        logout.click();
    }

}
