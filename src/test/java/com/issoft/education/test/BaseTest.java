package com.issoft.education.test;

import data.Driver;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {
    public static WebDriver driver;
    public static WebDriverWait wait;


    @BeforeEach
    public  void init(){
        driver= Driver.getDriver();
        wait=new WebDriverWait(driver, Duration.ofSeconds(15));

    }
    @AfterEach
    void  cleanUp(){
       Driver.driverClose();
    }
}
