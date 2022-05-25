package data;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import page_object.LoginPage;
import page_object.MailPage;
import page_object.PasswordPage;
import page_object.StartPage;

import java.io.File;

public class MailClass {

    public static MailPage logIn(WebDriver driver, WebDriverWait wait,String login, String password) throws Exception {
        StartPage startPage= new StartPage(driver,wait);
        takeSnapShot(driver, "./ScreenShot_Folder/Test_Login.png") ;
        LoginPage loginPage=startPage.clickLoginPage();
        PasswordPage passwordPage=loginPage.clickPasswordPage(login);
        MailPage mailPage= passwordPage.clickMailPage(password);
        return mailPage;
    }

    public static void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception{

        TakesScreenshot scrShot =((TakesScreenshot)webdriver);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(SrcFile, new File (fileWithPath));

    }
}
