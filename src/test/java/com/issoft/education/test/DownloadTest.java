package com.issoft.education.test;
import constant.ConstantURL;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class DownloadTest extends BaseTest {


    @Test
    public void main() throws InterruptedException {
        driver.get(ConstantURL.DOWNLOAD_PAGE);
        WebElement downloadButton = driver.findElement(By.cssSelector("#cricle-btn"));
        downloadButton.click();
        while (!isVisible(By.xpath("//div[@class='slice clipauto']"),driver)){//after 50% and more class='slice clipauto'

        }
        driver.navigate().refresh();
        Thread.sleep(1000);
        WebElement percent = driver.findElement(By.cssSelector(".percenttext"));
        Assertions.assertTrue(percent.getText().equals("0%"));
    }
    public static boolean isVisible(By by,WebDriver driver) {
        try {
            WebElement element=driver.findElement(by);
            return true;
        }
        catch (Exception  e) {
            return false;
        }
    }
}
