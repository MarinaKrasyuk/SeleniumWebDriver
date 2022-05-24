package mail;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import page_object.*;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.time.Duration;


public class POLoginTest {
    private static WebDriver driver;
    private static WebDriverWait wait;
    private static MailPage mailPage;



    @BeforeEach
    void   init(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver= new ChromeDriver();
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.get("https://mail.yandex.com/");
    }

    @ParameterizedTest
    @CsvSource(value = {"testqaqa.qa, CFStest"})
    public void loginTest(String login,String password) throws Exception {
        logIn(login,password);
        Assertions.assertTrue(mailPage.isIconPresent());

    }
    private void logIn(String login,String password) throws Exception {
        StartPage startPage= StartPage.getInstanceOfStartPage(driver,wait);
        takeSnapShot(driver, "./ScreenShot_Folder/Test_Login.png") ;
        LoginPage loginPage=startPage.clickLoginPage();
        PasswordPage passwordPage=loginPage.clickPasswordPage(login);
        mailPage= passwordPage.clickMailPage(password);
    }
    public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{

        TakesScreenshot scrShot =((TakesScreenshot)webdriver);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(SrcFile, new File (fileWithPath));

    }
    @AfterEach
    void cleanUp(){
        driver.quit();
    }
}
