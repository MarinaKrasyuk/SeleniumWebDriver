package mail;
import com.issoft.education.test.BaseTest;
import constant.ConstantURL;
import data.MailClass;
import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import page_object.*;


public class POLoginTest extends BaseTest {

    private static MailPage mailPage;

    @Description("Page Object: Login Test")
    @AllureId("#102")
    @Feature("Log in")
    @ParameterizedTest
    @CsvSource(value = {"testqaqa.qa, Kira3008"})
    public void loginTest(String login,String password) throws Exception {
        driver.get(ConstantURL.MAILLINK);
        mailPage=MailClass.logInPO(driver,wait,login,password);
        Assertions.assertTrue(mailPage.isIconPresent());

    }


}
