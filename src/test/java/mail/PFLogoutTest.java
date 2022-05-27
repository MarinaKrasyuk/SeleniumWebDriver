package mail;

import com.issoft.education.test.BaseTest;
import constant.ConstantURL;
import data.MailClass;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import page_factory.PFExitPage;
import page_factory.PFMailPage;
import page_object.*;
import utils.Utils;


public class PFLogoutTest extends BaseTest {
    private static PFMailPage mailPage;

    @Description("Page Factory: Logout Test")
    @AllureId("#104")
    @Flaky
    @ParameterizedTest
    @CsvSource(value = {"testqaqa.qa, CFStest"})
    public void logoutTest(String login,String password) throws Exception {
        driver.get(ConstantURL.MAILLINK);
        mailPage= MailClass.logInPF(driver,wait,login,password);
        PFExitPage exitPage=mailPage.clickExitPage();
        Utils.saveScreenshotPNG(driver);
        Allure.description("Test is failed! Test was running on Сhrome v.102.0. ");
        Assertions.assertTrue(exitPage.isLoginPresent());


    }
   /* @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG () {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }*/

}
