package mail;

import com.issoft.education.test.BaseTest;
import constant.ConstantURL;
import data.MailClass;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import page_factory.PFExitPage;
import page_factory.PFMailPage;
import utils.RunnerExtension;

@ExtendWith(RunnerExtension.class)
public class PFLogoutTest extends BaseTest {
    private static PFMailPage mailPage;

    @Description("Page Factory: Logout Test")
    @AllureId("#104")
    @Flaky
    @ParameterizedTest
    @CsvSource(value = {"testqaqa.qa, Kira3008"})
    public void logoutTest(String login,String password) throws Exception {
        driver.get(ConstantURL.MAILLINK);
        mailPage= MailClass.logInPF(driver,wait,login,password);
        PFExitPage exitPage=mailPage.clickExitPage();
        Assertions.assertTrue(exitPage.isLoginPresent());


    }


}
