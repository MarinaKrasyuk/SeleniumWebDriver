package com.issoft.education.test;

import com.codeborne.selenide.Configuration;
import data.Driver;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.time.Duration;


public class BaseTest {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeEach
    public  void init() throws MalformedURLException {
        driver= Driver.getDriver();
        wait=new WebDriverWait(driver, Duration.ofSeconds(15));
    }
    @AfterEach
    public void  cleanUp(){
       Driver.driverClose();
    }
}
