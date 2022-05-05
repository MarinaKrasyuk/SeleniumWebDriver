import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


import java.util.List;

public class MultiSelectClass {
    private   WebDriver driver;
    private  Select select;
    private final By MULTI_SELECT=By.xpath("//*[@name='States']");

    @BeforeEach
    public  void init(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://demo.seleniumeasy.com/basic-select-dropdown-demo.html");
    }
    @Test
    public void multiSelectAction() throws InterruptedException {
        WebElement multiselect = driver.findElement(MULTI_SELECT);
        select=new Select(multiselect);
        Actions builder = new Actions(driver);

        List<WebElement> options = multiselect.findElements(By.tagName("option"));
        Action multipleSelect =
                builder.keyDown(Keys.CONTROL).click(options.get(1)).click(options.get(3)).click(options.get(5)).build();

        multipleSelect.perform();
        Assertions.assertTrue(options.get(1).isSelected());
        Assertions.assertTrue(options.get(3).isSelected());
        Assertions.assertTrue(options.get(5).isSelected());

    }
    @AfterEach
    void cleanUp(){
        driver.quit();
    }
}
