package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class MailPage {
    private static WebDriver driver;
    private static MailPage instanceOfMailPage;
    private WebDriverWait wait;
    private WebElement name;

    private MailPage(WebDriver driver,WebDriverWait wait) {
        this.driver=driver;
        this.wait=wait;
        PageFactory.initElements(driver,this);
    }
    public static MailPage getInstanceOfMailPage(WebDriver driver,WebDriverWait wait){
        if (instanceOfMailPage == null)
            instanceOfMailPage = new MailPage(driver,wait);

        return instanceOfMailPage;
    }
    public boolean isIconPresent(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-count='{\"name\":\"user\"}']")));
        name=driver.findElement(By.xpath("//*[@data-count='{\"name\":\"user\"}']"));
        if (name.isDisplayed())
            return true;
        else
            return false;
    }
    public ExitPage clickExitPage(){
        clickLogoutButton();
        ExitPage exitPage=ExitPage.getInstanceOfExitPage(driver,wait);
        return exitPage;
    }
    private void clickLogoutButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-count='{\"name\":\"user\"}']")));
        name=driver.findElement(By.xpath("//*[@data-count='{\"name\":\"user\"}']"));
        name.click();
        WebElement logout = driver.findElement(By.xpath("(//*[@class='menu__group'])/*[last()]"));
        logout.click();
    }

}
