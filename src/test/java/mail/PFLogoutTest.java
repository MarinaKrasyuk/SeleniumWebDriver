package mail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import page_object.*;

import java.time.Duration;

public class PFLogoutTest {
    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeEach
    void   init(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver= new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://mail.yandex.com/");
    }


    @ParameterizedTest
    @CsvSource(value = {"testqaqa.qa, CFStest"})
    public void logoutTest(String login,String password){
        MailPage mailPage=logIn(login,password);
        ExitPage exitPage=mailPage.clickExitPage();
        Assertions.assertTrue(exitPage.isLoginPresent());
    }

    private MailPage logIn(String login,String password){
        StartPage startPage= StartPage.getInstanceOfStartPage(driver,wait);
        LoginPage loginPage=startPage.clickLoginPage();
        PasswordPage passwordPage=loginPage.clickPasswordPage(login);
        MailPage mailPage= passwordPage.clickMailPage(password);
        return mailPage;
    }
    @AfterEach
    void cleanUp(){
        driver.quit();}
}
