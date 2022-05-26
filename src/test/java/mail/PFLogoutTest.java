package mail;

import com.issoft.education.test.BaseTest;
import constant.ConstantURL;
import data.MailClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import page_factory.PFExitPage;
import page_factory.PFMailPage;
import page_object.*;


public class PFLogoutTest extends BaseTest {
    private static PFMailPage mailPage;

    @ParameterizedTest
    @CsvSource(value = {"testqaqa.qa, CFStest"})
    public void logoutTest(String login,String password) throws Exception {
        driver.get(ConstantURL.MAILLINK);
        mailPage= MailClass.logInPF(driver,wait,login,password);
        PFExitPage exitPage=mailPage.clickExitPage();
        Assertions.assertTrue(exitPage.isLoginPresent());
    }
}
