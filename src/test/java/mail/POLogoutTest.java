package mail;
import com.issoft.education.test.BaseTest;
import constant.ConstantURL;
import data.MailClass;
import io.qameta.allure.Allure;
import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import io.qameta.allure.Flaky;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import page_object.*;
import utils.Utils;

public class POLogoutTest extends BaseTest {
    private static MailPage mailPage;
    @Description("Page Object: Logout Test")
    @AllureId("#101")
    @Flaky
    @ParameterizedTest
    @CsvSource(value = {"testqaqa.qa, CFStest"})
    public void logoutTest(String login,String password) throws Exception {
        driver.get(ConstantURL.MAILLINK);
        mailPage=MailClass.logInPO(driver,wait,login,password);
        ExitPage exitPage=mailPage.clickExitPage();
        Utils.saveScreenshotPNG(driver);
        Allure.description("Test is failed! Test was running on Сhrome v.102.0. ");
        Assertions.assertTrue(exitPage.isLoginPresent());
    }


}
