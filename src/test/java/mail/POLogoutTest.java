package mail;
import com.issoft.education.test.BaseTest;
import constant.ConstantURL;
import data.MailClass;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import page_object.*;

public class POLogoutTest extends BaseTest {
    private static MailPage mailPage;

    @ParameterizedTest
    @CsvSource(value = {"testqaqa.qa, CFStest"})
    public void logoutTest(String login,String password) throws Exception {
        driver.get(ConstantURL.MAILLINK);
        mailPage=MailClass.logInPO(driver,wait,login,password);
        ExitPage exitPage=mailPage.clickExitPage();
        Assertions.assertTrue(exitPage.isLoginPresent());
    }


}
