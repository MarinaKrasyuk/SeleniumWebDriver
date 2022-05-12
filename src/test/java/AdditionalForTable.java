import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class AdditionalForTable {
    private static WebDriver driver;
    private WebElement tableEl;


    public AdditionalForTable(WebDriver driver,WebElement tableEl) {
        this.driver = driver;
        this.tableEl=tableEl;
    }

    public  List<TableClass> listSort(List<TableClass> table){
        List<TableClass> listAge=new ArrayList<TableClass>();
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

    public List<TableClass> getTable(){
        List<TableClass> result = new ArrayList<TableClass>();
        By by =By.tagName("tr");
        List<WebElement> tr = tableEl.findElements(by);
        for (int i = 0; i < tr.size(); i++) {
            result.add(i, createTable(tr.get(i)));
        }
        return result;
    }
    private  TableClass createTable (WebElement tr){
        By by =By.tagName("td");
        List<WebElement> tds = tr.findElements(by);
        TableClass result = new TableClass ();
        result.setName(tds.get(0).getText());
        result.setPosition(tds.get(1).getText());
        result.setOffice(tds.get(2).getText());
        result.setAge(tds.get(3).getText());
        result.setStartDate(tds.get(4).getText());
        result.setSalary(tds.get(5).getText());
        return result;
    }
    public List<TableClass> buildTable(){
        //get rows 1-10
        List<TableClass> table=getTable();
        //get rows 11-32

        while (isVisible(By.xpath("//*[@class='paginate_button next']"))){
            WebElement nextButton=driver.findElement(By.cssSelector("#example_next"));
            nextButton.click();
            List<TableClass> tableNext =getTable();
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
    public static void println(List<TableClass> list){
        for (int i = 0; i < list.size(); i++) {
            list.get(i).println();
        }
    }
}
