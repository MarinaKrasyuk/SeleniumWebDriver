package com.issoft.education.test;
import constant.ConstantURL;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;



public class UserTest extends BaseTest {

    @Test
    public void waitUser(){
        driver.get(ConstantURL.USER_LOADING_PAGE);
        WebElement button = driver.findElement(By.cssSelector("#save"));
        button.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#loading")));
        Assertions.assertTrue(driver.findElement(By.cssSelector("#loading>img")).isDisplayed());
    }

}

