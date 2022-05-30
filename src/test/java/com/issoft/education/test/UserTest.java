package com.issoft.education.test;
import constant.ConstantURL;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.RunnerExtension;


@ExtendWith(RunnerExtension.class)
public class UserTest extends BaseTest {

    @Test
    public void waitUser(){
        driver.get(ConstantURL.USER_LOADING_PAGE);
        driver.findElement(By.cssSelector("#save")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#loading")));
        Assertions.assertTrue(driver.findElement(By.cssSelector("#loading>img")).isDisplayed());
    }

}

