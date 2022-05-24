package data;

import com.issoft.education.test.BaseTest;
import data.Employer;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class EmployersTable extends BaseTest {

    private WebElement tableEl;


    public EmployersTable(WebDriver driver, WebElement tableEl) {
        this.driver = driver;
        this.tableEl=tableEl;
    }

    public void setEntries() throws InterruptedException {
        WebElement entries = driver.findElement(By.xpath("//*[@name='example_length']"));
        entries.click();
        Thread.sleep(1000);
        entries.sendKeys(Keys.ENTER);
    }
    public  List<Employer> listFilter(List<Employer> table){
        List<Employer> listAge=new ArrayList<Employer>();
        for (int i = 0; i < table.size(); i++) {
            String age=table.get(i).getAge();
            String salaryStr=table.get(i).getSalary();
            String salary=salaryStr.substring(1,salaryStr.length()-2).replace(",","");
            if (Integer.parseInt(age)>50 && Integer.parseInt(salary)<=100000){
                listAge.add(table.get(i));
            }
        }
        return listAge;
    }

    public List<Employer> getTable(){
        List<Employer> result = new ArrayList<Employer>();
        By by =By.tagName("tr");
        List<WebElement> tr = tableEl.findElements(by);
        for (int i = 0; i < tr.size(); i++) {
            result.add(i, createTable(tr.get(i)));
        }
        return result;
    }
    private Employer createTable (WebElement tr){
        By by =By.tagName("td");
        List<WebElement> tds = tr.findElements(by);
        Employer result = new Employer();
        result.setName(tds.get(0).getText());
        result.setPosition(tds.get(1).getText());
        result.setOffice(tds.get(2).getText());
        result.setAge(tds.get(3).getText());
        result.setStartDate(tds.get(4).getText());
        result.setSalary(tds.get(5).getText());
        return result;
    }
    public List<Employer> buildTable(){
        //get rows 1-10
        List<Employer> table=getTable();
        //get rows 11-32

        while (isVisible(By.xpath("//*[@class='paginate_button next']"))){
            WebElement nextButton=driver.findElement(By.cssSelector("#example_next"));
            nextButton.click();
            List<Employer> tableNext =getTable();
            table.addAll(tableNext);
        }
        return table;
    }
    public static boolean isVisible(By by) {
        try {
            WebElement btn=driver.findElement(by);
            return true;
        }
        catch (Exception  e) {
            return false;
        }
    }
    public static void println(List<Employer> list){
        for (int i = 0; i < list.size(); i++) {
            list.get(i).println();
        }
    }
}
