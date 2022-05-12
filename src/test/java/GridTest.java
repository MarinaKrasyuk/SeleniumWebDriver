import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class GridTest {
    private static WebDriver driver;
    @BeforeEach
    public void init(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://demo.seleniumeasy.com/table-sort-search-demo.html");

    }
    @Test
    public void gridTest() throws InterruptedException {
        WebElement entries = driver.findElement(By.xpath("//*[@name='example_length']"));
        entries.click();
        Thread.sleep(1000);
        entries.sendKeys(Keys.ENTER);
        WebElement tableEl=driver.findElement(By.xpath("//table/tbody"));
        AdditionalForTable additional=new AdditionalForTable(driver,tableEl);

        List<TableClass> table=additional.buildTable(); //getting all table
        List<TableClass> listResult=additional.listSort(table); //getting selection by age and salary
        additional.println(listResult);

    }
    @AfterEach
    void cleanUp(){
        driver.quit();
    }
    }

