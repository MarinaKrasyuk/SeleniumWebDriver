package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ExitPage {
    private static WebDriver driver;
    private static ExitPage instanceOfExitPage;
    private WebDriverWait wait;
    private WebElement loginButton;

    public ExitPage(WebDriver driver,WebDriverWait wait) {
        this.driver=driver;
        this.wait=wait;
        PageFactory.initElements(driver,this);
    }
    public static ExitPage getInstanceOfExitPage(WebDriver driver,WebDriverWait wait){
        if (instanceOfExitPage == null)
            instanceOfExitPage = new ExitPage(driver,wait);

        return instanceOfExitPage;
    }
    public boolean isLoginPresent(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='passp:sign-in']")));
        loginButton=driver.findElement(By.xpath("//*[@id='passp:sign-in']"));
        if (loginButton.isDisplayed())
            return true;
        else
            return false;
    }
}
