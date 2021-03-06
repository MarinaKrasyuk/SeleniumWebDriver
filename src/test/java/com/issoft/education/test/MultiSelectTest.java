package com.issoft.education.test;

import constant.ConstantURL;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


import java.util.List;

public class MultiSelectTest extends BaseTest {
    private Select select;
    private final By MULTI_SELECT = By.xpath("//*[@name='States']");

    @Test
    public void multiSelectAction() {
        System.out.println("Start");
        driver.get(ConstantURL.SELECT_DROPDOWN_PAGE);
        WebElement multiselect = driver.findElement(MULTI_SELECT);
        select = new Select(multiselect);
        List<WebElement> options = multiselect.findElements(By.tagName("option"));
        select.selectByIndex(2);
        select.selectByIndex(4);
        select.selectByIndex(6);
        List<WebElement> selectedList = select.getAllSelectedOptions();
        Assertions.assertTrue(options.get(2).getText().equals(selectedList.get(0).getText()));
        Assertions.assertTrue(options.get(4).getText().equals(selectedList.get(1).getText()));
        Assertions.assertTrue(options.get(6).getText().equals(selectedList.get(2).getText()));

    }
}
