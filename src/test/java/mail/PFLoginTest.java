package mail;

import com.issoft.education.test.BaseTest;
import constant.ConstantURL;
import data.MailClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import page_factory.PFMailPage;
import page_object.*;

import java.time.Duration;

public class PFLoginTest extends BaseTest {

    private static PFMailPage mailPage;

    @ParameterizedTest
    @CsvSource(value = {"testqaqa.qa, CFStest"})
    public void loginTest(String login,String password) throws Exception {
        driver.get(ConstantURL.MAILLINK);
        mailPage= MailClass.logInPF(driver,wait,login,password);
        Assertions.assertTrue(mailPage.isIconPresent());

    }

}
