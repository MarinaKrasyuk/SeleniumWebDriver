package com.issoft.education.test;
import constant.ConstantURL;
import data.Employer;
import data.EmployersTable;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import java.util.List;

public class GridTest extends BaseTest {

    @Test
    public void gridTest() throws InterruptedException {

        driver.get(ConstantURL.DEMOLINK+"/table-sort-search-demo.html");
        WebElement tableEl=driver.findElement(By.xpath("//table/tbody"));
        EmployersTable additional=new EmployersTable(driver,tableEl);
        additional.setEntries();
        List<Employer> table=additional.buildTable(); //getting all table
        List<Employer> listResult=additional.listFilter(table); //getting selection by age and salary
        additional.println(listResult);

    }

    }

