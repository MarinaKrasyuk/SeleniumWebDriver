package data;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import page_factory.PFLoginPage;
import page_factory.PFMailPage;
import page_factory.PFPasswordPage;
import page_factory.PFStartPage;
import page_object.LoginPage;
import page_object.MailPage;
import page_object.PasswordPage;
import page_object.StartPage;
import utils.Utils;

import java.io.File;

public class MailClass {

    public static MailPage logInPO(WebDriver driver, WebDriverWait wait,String login, String password) throws Exception {
        StartPage startPage= new StartPage(driver,wait);
        Utils.takeSnapShot(driver);
        LoginPage loginPage=startPage.clickLoginPage();
        PasswordPage passwordPage=loginPage.clickPasswordPage(login);
        MailPage mailPage= passwordPage.clickMailPage(password);
        return mailPage;
    }


    public static PFMailPage logInPF(WebDriver driver, WebDriverWait wait,String login, String password) throws Exception {
        PFStartPage startPage= new PFStartPage(driver,wait);
        Utils.takeSnapShot(driver);
        PFLoginPage loginPage=startPage.clickLoginPage();
        PFPasswordPage passwordPage=loginPage.clickPasswordPage(login);
        PFMailPage mailPage= passwordPage.clickMailPage(password);
        return mailPage;
    }

}
