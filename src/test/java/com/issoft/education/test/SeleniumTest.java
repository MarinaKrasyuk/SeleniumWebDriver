package com.issoft.education.test;

import constant.ConstantURL;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SeleniumTest extends BaseTest {
    private static ByClassTest byObject;

  private void initialPage()
  {
      String css=".button2_theme_mail-white";
      byObject.loginButtonInitclick(css);
  }
  private void loginPage(String login) {
        String id="passp-field-login";
        byObject.inputLogin(id,login);
        String xpath= "//*[@id='passp:sign-in']";
        byObject.loginButtonClick(xpath);
  }
    private void passwordPage(String pwd)  {
        String name="passwd";
        byObject.inputPassword(name,pwd);
        String xpath= "//*[@id='passp:sign-in']";
        byObject.loginButtonClick(xpath);
    }
    @ParameterizedTest
    @CsvSource(value = {
            "marinakrasyuk21@yandex.com, Kira300815!",
            "testqaqa.qa, CFStest"})
    public void loginTest(String login,String password) throws InterruptedException {
        driver.get(ConstantURL.MAILLINK);
        byObject=new ByClassTest(driver,wait);
        initialPage();
        loginPage(login);
        Thread.sleep(1000); //imlicit waiter
        passwordPage(password);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-count='{\"name\":\"user\"}']")));
        Assertions.assertTrue(driver.findElement(By.xpath("//a[@href='#tabs/relevant']")).isDisplayed());

  }

}