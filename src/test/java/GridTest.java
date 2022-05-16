import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import java.util.List;

public class GridTest extends BaseTest {
    private static WebDriver driver;

    @Test
    public void gridTest() throws InterruptedException {
        driver=BaseTest.driver;
        driver.get("https://demo.seleniumeasy.com/table-sort-search-demo.html");
        WebElement tableEl=driver.findElement(By.xpath("//table/tbody"));
        EmployersTable additional=new EmployersTable(driver,tableEl);
        additional.setEntries();
        List<Employer> table=additional.buildTable(); //getting all table
        List<Employer> listResult=additional.listFilter(table); //getting selection by age and salary
        additional.println(listResult);

    }

    }

