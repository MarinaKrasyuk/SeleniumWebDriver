package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StartPage {
    private static WebDriver driver;
    private WebElement loginbutton;
    private static StartPage instanceOfStartPage;
    private static WebDriverWait wait;

    private StartPage(WebDriver driver,WebDriverWait wait) {
        this.driver=driver;
        this.wait=wait;
    }
    public static StartPage getInstanceOfStartPage(WebDriver driver, WebDriverWait wait)
    {
        if (instanceOfStartPage == null)
            instanceOfStartPage = new StartPage(driver,wait);

        return instanceOfStartPage;
    }
    public LoginPage clickLoginPage(){
        clickLoginButton();
        LoginPage loginPage=LoginPage.getInstanceOfLoginPage(driver,wait);
        return loginPage;
    }

    private void clickLoginButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".button2_theme_mail-white")));
        loginbutton=driver.findElement(By.cssSelector(".button2_theme_mail-white"));
        loginbutton.click();
    }
}
